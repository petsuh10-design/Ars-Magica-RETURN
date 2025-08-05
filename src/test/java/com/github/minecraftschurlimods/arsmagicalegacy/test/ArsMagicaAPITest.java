package com.arsmagica2.arsmagica2return.test;

import com.arsmagica2.arsmagica2return.ArsMagicaAPIImpl;
import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import net.minecraft.gametest.framework.GameTest;
import net.minecraftforge.testframework.annotation.ForEachTest;
import net.minecraftforge.testframework.annotation.TestHolder;
import net.minecraftforge.testframework.gametest.EmptyTemplate;
import net.minecraftforge.testframework.gametest.ExtendedGameTestHelper;

@ForEachTest(groups = ArsMagicaAPI.MOD_ID + ".api")
public class ArsMagicaAPITest {
    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Test that the implementation of the ArsMagicaAPI is available and of the correct class")
    public static void testApiNotDummy(ExtendedGameTestHelper helper) {
        helper.assertTrue(ArsMagicaAPI.get().getClass() == ArsMagicaAPIImpl.class, "Wrong Implementation of ArsMagicaAPI!");
        helper.succeed();
    }
}
