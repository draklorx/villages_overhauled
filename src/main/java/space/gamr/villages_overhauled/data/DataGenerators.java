package space.gamr.villages_overhauled.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.data.client.ModBlockStateProvider;
import space.gamr.villages_overhauled.data.client.ModItemModelProvider;

@Mod.EventBusSubscriber(modid = VillagesOverhauled.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
        gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
    }
}