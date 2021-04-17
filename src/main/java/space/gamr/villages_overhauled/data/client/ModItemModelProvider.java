package space.gamr.villages_overhauled.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import space.gamr.villages_overhauled.VillagesOverhauled;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VillagesOverhauled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("cobbled_sandstone", modLoc("block/cobbled_sandstone"));
        withExistingParent("sand_path", modLoc("block/sand_path"));
    }

}