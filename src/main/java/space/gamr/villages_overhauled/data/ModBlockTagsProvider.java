package space.gamr.villages_overhauled.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, VillagesOverhauled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(Tags.Blocks.SANDSTONE).add(ModBlocks.COBBLED_SANDSTONE.get());
    }
}
