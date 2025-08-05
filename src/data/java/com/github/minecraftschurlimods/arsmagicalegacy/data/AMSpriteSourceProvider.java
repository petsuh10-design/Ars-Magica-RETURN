package com.arsmagica2.arsmagica2return.data;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.SkillIconAtlas;
import com.arsmagica2.arsmagica2return.client.SpellIconAtlas;
import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SpriteSourceProvider;

import java.util.concurrent.CompletableFuture;

class AMSpriteSourceProvider extends SpriteSourceProvider {
    AMSpriteSourceProvider(PackOutput output, ExistingFileHelper existingFileHelper, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ArsMagicaAPI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void gather() {
        atlas(SpellIconAtlas.SPELL_ICON_ATLAS_INFO).addSource(new DirectoryLister("icon/spell", ""));
        atlas(SkillIconAtlas.SKILL_ICON_ATLAS_INFO).addSource(new DirectoryLister("icon/skill", ""));
    }
}
