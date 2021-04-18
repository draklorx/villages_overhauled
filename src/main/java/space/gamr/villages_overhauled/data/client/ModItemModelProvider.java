package space.gamr.villages_overhauled.data.client;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VillagesOverhauled.MOD_ID, existingFileHelper);
    }

    private void registerBlockModel(RegistryObject<Block> block) {
        String path = block.getId().getPath();
        withExistingParent(path, modLoc(ModelProvider.BLOCK_FOLDER + "/" + path));
    }

    @Override
    protected void registerModels() {
        registerBlockModel(ModBlocks.COBBLED_SANDSTONE);
        registerBlockModel(ModBlocks.SAND_PATH);
    }

}