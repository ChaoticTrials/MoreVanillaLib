package de.melanx.morevanillalib;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.SheetedDecalTextureGenerator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.melanx.morevanillalib.api.ranged.BlockBreaker;
import de.melanx.morevanillalib.api.ranged.RangeItem;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.BlockDestructionProgress;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.DrawSelectionEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Iterator;

// This class is taken from TinkersConstruct and was adjusted to fit my requirements
// https://github.com/SlimeKnights/TinkersConstruct/blob/bb807ef6934cceee1edca23fbfd828edcae6f976/src/main/java/slimeknights/tconstruct/tools/client/ToolRenderEvents.java
public class ClientEventListener {

    @SubscribeEvent
    public void renderBlockHighlights(DrawSelectionEvent.HighlightBlock event) {
        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        Player player = mc.player;
        if (level == null || player == null) {
            return;
        }

        ItemStack tool = player.getMainHandItem();
        if (tool.isEmpty() || !(tool.getItem() instanceof RangeItem)) {
            return;
        }

        // must be targeting a block
        HitResult result = mc.hitResult;
        if (result == null || result.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockHitResult blockTrace = event.getTarget();
        BlockPos origin = blockTrace.getBlockPos();
        BlockState state = level.getBlockState(origin);
        if (!state.is(((DiggerItem) tool.getItem()).blocks)) {
            return;
        }

        Iterator<BlockPos> breakBlocks = BlockBreaker.getBreakBlocks(level, player, player.isShiftKeyDown() ? 0 : 1, EnchantmentHelper.getEnchantmentLevel(ModContent.powerOfTheDepth, player), origin).iterator();
        if (!breakBlocks.hasNext()) {
            return;
        }

        // set up renderer
        LevelRenderer worldRender = event.getLevelRenderer();
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource.BufferSource buffers = worldRender.renderBuffers.bufferSource();
        VertexConsumer vertexBuilder = buffers.getBuffer(RenderType.lines());
        poseStack.pushPose();

        // start drawing
        Camera renderInfo = mc.gameRenderer.getMainCamera();
        Entity viewEntity = renderInfo.getEntity();
        Vec3 vector3d = renderInfo.getPosition();
        double x = vector3d.x();
        double y = vector3d.y();
        double z = vector3d.z();
        do {
            BlockPos pos = breakBlocks.next();
            if (level.getWorldBorder().isWithinBounds(pos)) {
                worldRender.renderHitOutline(poseStack, vertexBuilder, viewEntity, x, y, z, pos, level.getBlockState(pos));
            }
        } while (breakBlocks.hasNext());
        poseStack.popPose();
        buffers.endBatch();
    }

    @SubscribeEvent
    public void renderBlockDamageProgress(RenderLevelLastEvent event) {
        // validate required variables are set
        Minecraft mc = Minecraft.getInstance();
        MultiPlayerGameMode controller = mc.gameMode;
        if (controller == null || !controller.isDestroying()) {
            return;
        }
        Level level = mc.level;
        Player player = mc.player;
        if (level == null || player == null) {
            return;
        }

        ItemStack tool = player.getMainHandItem();
        if (tool.isEmpty() || !(tool.getItem() instanceof RangeItem)) {
            return;
        }

        // must be targeting a block
        HitResult result = mc.hitResult;
        if (result == null || result.getType() != HitResult.Type.BLOCK) {
            return;
        }

        // find breaking progress
        BlockHitResult blockTrace = (BlockHitResult) result;
        BlockPos origin = blockTrace.getBlockPos();
        BlockDestructionProgress progress = null;
        for (Int2ObjectMap.Entry<BlockDestructionProgress> entry : mc.levelRenderer.destroyingBlocks.int2ObjectEntrySet()) {
            if (entry.getValue().getPos().equals(origin)) {
                progress = entry.getValue();
                break;
            }
        }
        if (progress == null) {
            return;
        }

        // determine extra blocks to highlight
        BlockState state = level.getBlockState(origin);
        if (!state.is(((DiggerItem) tool.getItem()).blocks)) {
            return;
        }

        Iterator<BlockPos> breakBlocks = BlockBreaker.getBreakBlocks(level, player, player.isShiftKeyDown() ? 0 : 1, EnchantmentHelper.getEnchantmentLevel(ModContent.powerOfTheDepth, player), origin).iterator();
        if (!breakBlocks.hasNext()) {
            return;
        }

        // set up buffers
        PoseStack matrices = event.getPoseStack();
        matrices.pushPose();
        MultiBufferSource.BufferSource vertices = event.getLevelRenderer().renderBuffers.crumblingBufferSource();
        VertexConsumer vertexBuilder = vertices.getBuffer(ModelBakery.DESTROY_TYPES.get(progress.getProgress()));

        // finally, render the blocks
        Camera renderInfo = mc.gameRenderer.getMainCamera();
        double x = renderInfo.getPosition().x;
        double y = renderInfo.getPosition().y;
        double z = renderInfo.getPosition().z;
        BlockRenderDispatcher dispatcher = mc.getBlockRenderer();
        do {
            BlockPos pos = breakBlocks.next();
            matrices.pushPose();
            matrices.translate(pos.getX() - x, pos.getY() - y, pos.getZ() - z);
            PoseStack.Pose entry = matrices.last();
            VertexConsumer blockBuilder = new SheetedDecalTextureGenerator(vertexBuilder, entry.pose(), entry.normal());
            dispatcher.renderBreakingTexture(level.getBlockState(pos), pos, level, matrices, blockBuilder);
            matrices.popPose();
        } while (breakBlocks.hasNext());

        // finish rendering
        matrices.popPose();
        vertices.endBatch();
    }
}
