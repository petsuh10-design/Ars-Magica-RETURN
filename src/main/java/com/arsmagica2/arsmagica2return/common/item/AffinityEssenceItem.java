package com.arsmagica2.arsmagica2return.common.item;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.affinity.IAffinityItem;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AffinityEssenceItem extends Item implements IAffinityItem {
    public AffinityEssenceItem(Properties properties) {
        super(properties);
    }

    @Override
    public String getDescriptionId(ItemStack pStack) {
        ResourceLocation affinity = ArsMagicaAPI.get().getAffinityHelper().getAffinityForStack(pStack).getId();
        return Util.makeDescriptionId(super.getDescriptionId(pStack), affinity);
    }
}
