package space.gamr.villages_overhauled.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VillagesOverhauled.MOD_ID, existingFileHelper);
    }

    private void registerBlockModel(String name) {
        withExistingParent(name, modLoc("block/" + name));
    }

    @Override
    protected void registerModels() {
        registerBlockModel(ModBlocks.COBBLED_SANDSTONE.getId().getPath());
        registerBlockModel(ModBlocks.SAND_PATH.getId().getPath());
    }

}