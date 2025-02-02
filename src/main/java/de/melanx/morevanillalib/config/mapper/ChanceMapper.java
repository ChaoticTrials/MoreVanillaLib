package de.melanx.morevanillalib.config.mapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import de.melanx.morevanillalib.config.Chance;
import org.moddingx.libx.annotation.config.RegisterMapper;
import org.moddingx.libx.config.gui.ConfigEditor;
import org.moddingx.libx.config.gui.InputProperties;
import org.moddingx.libx.config.mapper.ValueMapper;
import org.moddingx.libx.config.validator.ValidatorInfo;

import java.util.Objects;

@RegisterMapper
public class ChanceMapper implements ValueMapper<Chance, JsonElement> {

    private static final InputProperties<Chance> INPUT = new InputProperties<>() {
        @Override
        public Chance defaultValue() {
            return Chance.of(0);
        }

        @Override
        public Chance valueOf(String str) {
            return Chance.of(Double.parseDouble(str));
        }

        @Override
        public boolean canInputChar(char chr) {
            return Character.isDigit(chr) || chr == '.';
        }

        @Override
        public boolean isValid(String str) {
            return !str.isBlank() && str.chars().filter(chr -> chr == '.').count() <= 1 && !str.equals(".") && Double.parseDouble(str) >= 0 && Double.parseDouble(str) <= 1;
        }

        @Override
        public String toString(Chance value) {
            return Objects.toString(value.getChance());
        }
    };

    @Override
    public Class<Chance> type() {
        return Chance.class;
    }

    @Override
    public Class<JsonElement> element() {
        return JsonElement.class;
    }

    @Override
    public Chance fromJson(JsonElement json) {
        return Chance.of(json.getAsDouble());
    }

    @Override
    public JsonElement toJson(Chance value) {
        return new JsonPrimitive(value.getChance());
    }

    @Override
    public ConfigEditor<Chance> createEditor(ValidatorInfo<?> validator) {
        return ConfigEditor.input(INPUT);
    }
}
