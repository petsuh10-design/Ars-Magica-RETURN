package com.arsmagica2.arsmagica2return.data;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import net.minecraft.data.PackOutput;
import net.minecraftforge.neoforge.common.data.LanguageProvider;

abstract class AMLanguageProvider extends LanguageProvider {
    AMLanguageProvider(PackOutput output, String locale) {
        super(output, ArsMagicaAPI.MOD_ID, locale);
    }
}
