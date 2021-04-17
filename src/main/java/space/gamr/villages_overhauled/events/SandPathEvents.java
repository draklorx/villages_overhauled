package space.gamr.villages_overhauled.events;

import net.minecraft.block.Blocks;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

@EventBusSubscriber(modid = VillagesOverhauled.MOD_ID, bus = Bus.FORGE)
public class SandPathEvents {

    @SubscribeEvent
    public static void onBlockInteractedWithTool(final BlockEvent.BlockToolInteractEvent event) {
        if (
            event.getToolType().equals(ToolType.SHOVEL)
            && event.getState().getBlock() == Blocks.SAND
        ) {
            event.setFinalState(ModBlocks.SAND_PATH.get().getDefaultState());
        }
    }

}
