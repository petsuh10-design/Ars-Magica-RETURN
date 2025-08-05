package com.arsmagica2.arsmagica2return;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.affinity.Affinity;
import com.arsmagica2.arsmagica2return.api.affinity.IAffinityHelper;
import com.arsmagica2.arsmagica2return.api.etherium.IEtheriumHelper;
import com.arsmagica2.arsmagica2return.api.magic.ContingencyType;
import com.arsmagica2.arsmagica2return.api.magic.IBurnoutHelper;
import com.arsmagica2.arsmagica2return.api.magic.IContingencyHelper;
import com.arsmagica2.arsmagica2return.api.magic.IMagicHelper;
import com.arsmagica2.arsmagica2return.api.magic.IManaHelper;
import com.arsmagica2.arsmagica2return.api.magic.IRiftHelper;
import com.arsmagica2.arsmagica2return.api.ritual.RitualEffect;
import com.arsmagica2.arsmagica2return.api.ritual.RitualRequirement;
import com.arsmagica2.arsmagica2return.api.ritual.RitualTrigger;
import com.arsmagica2.arsmagica2return.api.skill.ISkillHelper;
import com.arsmagica2.arsmagica2return.api.skill.SkillPoint;
import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.api.spell.ISpellDataManager;
import com.arsmagica2.arsmagica2return.api.spell.ISpellHelper;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPart;
import com.arsmagica2.arsmagica2return.api.spell.ShapeGroup;
import com.arsmagica2.arsmagica2return.api.spell.SpellIngredientType;
import com.arsmagica2.arsmagica2return.api.spell.SpellStack;
import com.arsmagica2.arsmagica2return.api.spell.SpellTransformation;
import com.arsmagica2.arsmagica2return.client.ClientHelper;
import com.arsmagica2.arsmagica2return.common.affinity.AffinityHelper;
import com.arsmagica2.arsmagica2return.common.etherium.EtheriumHelper;
import com.arsmagica2.arsmagica2return.common.init.AMRegistries;
import com.arsmagica2.arsmagica2return.common.magic.BurnoutHelper;
import com.arsmagica2.arsmagica2return.common.magic.ContingencyHelper;
import com.arsmagica2.arsmagica2return.common.magic.MagicHelper;
import com.arsmagica2.arsmagica2return.common.magic.ManaHelper;
import com.arsmagica2.arsmagica2return.common.magic.RiftHelper;
import com.arsmagica2.arsmagica2return.common.skill.SkillHelper;
import com.arsmagica2.arsmagica2return.common.spell.Spell;
import com.arsmagica2.arsmagica2return.common.spell.SpellDataManager;
import com.arsmagica2.arsmagica2return.common.spell.SpellHelper;
import com.arsmagica2.arsmagica2return.network.OpenOcculusGuiPacket;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Unmodifiable;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;
import java.util.Optional;

public final class ArsMagicaAPIImpl implements ArsMagicaAPI {

    @Override
    public ItemStack getBookStack() {
        if (ModList.get().isLoaded("patchouli")) {
            return PatchouliAPI.get().getBookStack(new ResourceLocation(ArsMagicaAPI.MOD_ID, "arcane_compendium"));
        }
        return ItemStack.EMPTY;
    }

    @Override
    public Registry<SkillPoint> getSkillPointRegistry() {
        return AMRegistries.SKILL_POINT_REGISTRY;
    }

    @Override
    public Registry<Affinity> getAffinityRegistry() {
        return AMRegistries.AFFINITY_REGISTRY;
    }

    @Override
    public Registry<ISpellPart> getSpellPartRegistry() {
        return AMRegistries.SPELL_PART_REGISTRY;
    }

    @Override
    public Registry<ContingencyType> getContingencyTypeRegistry() {
        return AMRegistries.CONTINGENCY_TYPE_REGISTRY;
    }

    @Override
    public Registry<Codec<? extends RitualTrigger>> getRitualTriggerTypeRegistry() {
        return AMRegistries.RITUAL_TRIGGER_TYPE_REGISTRY;
    }

    @Override
    public Registry<Codec<? extends RitualRequirement>> getRitualRequirementTypeRegistry() {
        return AMRegistries.RITUAL_REQUIREMENT_TYPE_REGISTRY;
    }

    @Override
    public Registry<Codec<? extends RitualEffect>> getRitualEffectTypeRegistry() {
        return AMRegistries.RITUAL_EFFECT_TYPE_REGISTRY;
    }

    @Override
    public Registry<SpellIngredientType<?>> getSpellIngredientTypeRegistry() {
        return AMRegistries.SPELL_INGREDIENT_TYPE_REGISTRY;
    }

    @Override
    public ISpellDataManager getSpellDataManager() {
        return SpellDataManager.instance();
    }

    @Unmodifiable
    @Override
    public ISkillHelper getSkillHelper() {
        return SkillHelper.instance();
    }

    @Unmodifiable
    @Override
    public IAffinityHelper getAffinityHelper() {
        return AffinityHelper.instance();
    }

    @Unmodifiable
    @Override
    public IMagicHelper getMagicHelper() {
        return MagicHelper.instance();
    }

    @Unmodifiable
    @Override
    public IManaHelper getManaHelper() {
        return ManaHelper.instance();
    }

    @Unmodifiable
    @Override
    public IBurnoutHelper getBurnoutHelper() {
        return BurnoutHelper.instance();
    }

    @Unmodifiable
    @Override
    public ISpellHelper getSpellHelper() {
        return SpellHelper.instance();
    }

    @Unmodifiable
    @Override
    public IRiftHelper getRiftHelper() {
        return RiftHelper.instance();
    }

    @Unmodifiable
    @Override
    public IEtheriumHelper getEtheriumHelper() {
        return EtheriumHelper.instance();
    }

    @Unmodifiable
    @Override
    public IContingencyHelper getContingencyHelper() {
        return ContingencyHelper.instance();
    }

    @Override
    public void openOcculusGui(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.PLAYER.with(serverPlayer).send(new OpenOcculusGuiPacket());
        } else if (player.isLocalPlayer()) {
            ClientHelper.openOcculusGui();
        }
    }

    @Override
    public void openSpellCustomizationGui(Level level, Player player, ItemStack stack) {
        if (!level.isClientSide()) return;
        ClientHelper.openSpellCustomizationGui(stack);
    }

    @Override
    public void openSpellRecipeGui(Level level, Player player, ItemStack stack) {
        if (!level.isClientSide()) return;
        ClientHelper.openSpellRecipeGui(stack, true, 0, null);
    }

    @Override
    public ISpell makeSpell(List<ShapeGroup> shapeGroups, SpellStack spellStack, CompoundTag additionalData) {
        return new Spell(shapeGroups, spellStack, additionalData);
    }

    @Override
    public ISpell makeSpell(SpellStack spellStack, ShapeGroup... shapeGroups) {
        return Spell.of(spellStack, shapeGroups);
    }

    @Override
    public Optional<BlockState> getSpellTransformationFor(BlockState block, Level level, ResourceLocation spellPart) {
        if (level.isClientSide()) return Optional.empty();
        return level.registryAccess().registryOrThrow(SpellTransformation.REGISTRY_KEY).stream().filter(spellTransformation -> spellTransformation.spellPart().equals(spellPart) && spellTransformation.from().test(block, level.random)).findFirst().map(SpellTransformation::to);
    }
}
