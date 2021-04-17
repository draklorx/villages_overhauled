package space.gamr.villages_overhauled.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, VillagesOverhauled.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.COBBLED_SANDSTONE.get());
        String sandPathPath = ModBlocks.SAND_PATH.getId().getPath();
        simpleBlock(
                ModBlocks.SAND_PATH.get(),
                models().cubeBottomTop(
                        sandPathPath,
                        new ResourceLocation(VillagesOverhauled.MOD_ID, "block/" + sandPathPath + "_side"),
                        new ResourceLocation(VillagesOverhauled.MOD_ID, "block/" + sandPathPath + "_bottom"),
                        new ResourceLocation(VillagesOverhauled.MOD_ID, "block/" + sandPathPath + "_top")
                )
        );
    }
}
