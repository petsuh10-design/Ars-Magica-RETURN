package com.arsmagica2.arsmagica2return.compat.theoneprobe;

import com.arsmagica2.arsmagica2return.compat.CompatManager;
import com.arsmagica2.arsmagica2return.compat.ICompatHandler;
import mcjty.theoneprobe.api.ITheOneProbe;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;

import java.util.function.Function;
import java.util.function.Supplier;

@CompatManager.ModCompat("theoneprobe")
public class TOPCompat implements ICompatHandler {
    @Override
    public void imcEnqueue(final InterModEnqueueEvent event) {
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", (Supplier<Function<ITheOneProbe, Void>>) (() -> api -> {
            api.registerProvider(new EtheriumProbeInfoProvider());
            api.registerProvider(new AltarProbeInfoProvider());
            return null;
        }));
    }
}
