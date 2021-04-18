package space.gamr.villages_overhauled.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import space.gamr.villages_overhauled.VillagesOverhauled;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, VillagesOverhauled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(Tags.Blocks.SANDSTONE, Tags.Items.SANDSTONE);
    }
}
