package com.arsmagica2.arsmagica2return.data;

import com.arsmagica2.arsmagica2return.api.AMTags;
import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.data.ObeliskFuelProvider;
import com.arsmagica2.arsmagica2return.api.etherium.ObeliskFuel;
import com.arsmagica2.arsmagica2return.common.init.AMItems;
import net.minecraft.world.item.crafting.Ingredient;

class AMObeliskFuelProvider extends ObeliskFuelProvider {
    AMObeliskFuelProvider() {
        super(ArsMagicaAPI.MOD_ID);
    }

    @Override
    public void generate() {
        add("vinteum_dust", new ObeliskFuel(Ingredient.of(AMTags.Items.DUSTS_VINTEUM), 200, 1));
        add("vinteum_block", new ObeliskFuel(Ingredient.of(AMTags.Items.STORAGE_BLOCKS_VINTEUM), 900, 2));
        add("liquid_essence_bucket", new ObeliskFuel(Ingredient.of(AMItems.LIQUID_ESSENCE_BUCKET.get()), 1000, 2));
    }
}
