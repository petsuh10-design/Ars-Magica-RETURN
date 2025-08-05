package com.arsmagica2.arsmagica2return.common.effect;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.magic.IManaHelper;
import com.arsmagica2.arsmagica2return.common.init.AMAttributes;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class InstantManaEffect extends InstantenousMobEffect {
    public InstantManaEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x00ffff);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        IManaHelper manaHelper = ArsMagicaAPI.get().getManaHelper();
        if (pLivingEntity.getAttributes().hasAttribute(AMAttributes.MAX_MANA.value())) {
            manaHelper.increaseMana(pLivingEntity, manaHelper.getMaxMana(pLivingEntity) / 5 * pAmplifier);
        }
    }
}
