package com.arsmagica2.arsmagica2return.common.spell;

import com.arsmagica2.arsmagica2return.Config;
import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.affinity.Affinity;
import com.arsmagica2.arsmagica2return.api.spell.ISpellDataManager;
import com.arsmagica2.arsmagica2return.api.spell.ISpellIngredient;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPart;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPartData;
import com.arsmagica2.arsmagica2return.api.util.ItemFilter;
import com.github.minecraftschurlimods.codeclib.CodecDataManager;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.neoforge.common.util.Lazy;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public final class SpellDataManager extends CodecDataManager<ISpellPartData> implements ISpellDataManager {
    private static final Lazy<SpellDataManager> INSTANCE = Lazy.concurrentOf(SpellDataManager::new);

    private SpellDataManager() {
        super(ArsMagicaAPI.MOD_ID, "spell_parts", SpellPartData.CODEC, LoggerFactory.getLogger(SpellDataManager.class));
    }

    /**
     * @return The only instance of this class.
     */
    public static SpellDataManager instance() {
        return INSTANCE.get();
    }

    @Override
    public ISpellPartData getDataForPart(ISpellPart part) {
        return get(part.getId());
    }

    private record SpellPartData(List<ISpellIngredient> recipe, Map<Affinity, Float> affinityShifts, List<ItemFilter> reagents, float manaCost, Supplier<Float> burnout) implements ISpellPartData {
        public static final Codec<ISpellPartData> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                ISpellIngredient.CODEC.listOf().fieldOf("recipe").forGetter(ISpellPartData::recipe),
                Codec.unboundedMap(ArsMagicaAPI.get().getAffinityRegistry().byNameCodec(), Codec.FLOAT).fieldOf("affinities").forGetter(ISpellPartData::affinityShifts),
                ItemFilter.CODEC.listOf().fieldOf("reagents").forGetter(ISpellPartData::reagents),
                Codec.FLOAT.fieldOf("manaCost").forGetter(ISpellPartData::manaCost),
                ExtraCodecs.strictOptionalField(Codec.FLOAT, "burnout").forGetter(iSpellPartData -> Optional.of(iSpellPartData.getBurnout()))
        ).apply(inst, (recipe, affinities, reagents, manaCost, burnout) -> new SpellPartData(recipe, affinities, reagents, manaCost, burnout.<Supplier<Float>>map(v -> (() -> v)).orElse(() -> (float) (manaCost * Config.SERVER.BURNOUT_RATIO.get())))));

        @Override
        public Set<Affinity> affinities() {
            return affinityShifts().keySet();
        }

        @Override
        public float getBurnout() {
            return burnout().get();
        }
    }
}
