package com.arsmagica2.arsmagica2return.common.spell.component;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.api.spell.ISpellModifier;
import com.arsmagica2.arsmagica2return.api.spell.SpellCastResult;
import com.arsmagica2.arsmagica2return.common.magic.rift.RiftMenu;
import com.arsmagica2.arsmagica2return.common.spell.SpellPartStats;
import com.arsmagica2.arsmagica2return.common.util.TranslationConstants;
import com.arsmagica2.arsmagica2return.server.AMPermissions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.neoforge.server.permission.PermissionAPI;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Rift extends AbstractComponent {
    public Rift() {
        super(SpellPartStats.POWER);
    }

    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, @Nullable Entity directEntity, Level level, List<ISpellModifier> modifiers, EntityHitResult target, int index, int ticksUsed) {
        if (target.getEntity() instanceof ServerPlayer sp && ArsMagicaAPI.get().getRiftHelper().getRift(sp) != null) {
            int size = Math.min(Math.round(Math.max(1, ArsMagicaAPI.get().getSpellHelper().getModifiedStat(1, SpellPartStats.POWER, modifiers, spell, caster, target, index))), PermissionAPI.getPermission(sp, AMPermissions.MAX_RIFT_SIZE));
            sp.openMenu(new SimpleMenuProvider((id, inv, player) -> RiftMenu.rift(id, inv, sp, size), Component.translatable(TranslationConstants.RIFT_TITLE)), buf -> {
                buf.writeUUID(sp.getUUID());
                buf.writeInt(size);
            });
            return SpellCastResult.SUCCESS;
        }
        return SpellCastResult.EFFECT_FAILED;
    }

    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, @Nullable Entity directEntity, Level level, List<ISpellModifier> modifiers, BlockHitResult target, int index, int ticksUsed) {
        return SpellCastResult.EFFECT_FAILED;
    }
}
