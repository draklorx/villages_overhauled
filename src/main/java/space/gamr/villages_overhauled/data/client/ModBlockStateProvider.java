package space.gamr.villages_overhauled.data.client;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, VillagesOverhauled.MOD_ID, exFileHelper);
    }

    private ResourceLocation mcBlockLoc(Block block) {
        return mcLoc(ModelProvider.BLOCK_FOLDER + "/" + block.getRegistryName().getPath());
    }

    private ResourceLocation modBlockLoc(RegistryObject<Block> block, String suffix) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + modBlockPath(block) + suffix);
    }

    private String modBlockPath(RegistryObject<Block> block) {
        return block.get().getRegistryName().getPath();
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.COBBLED_SANDSTONE.get());

        simpleBlock(
                ModBlocks.SAND_PATH.get(),
                models().getBuilder(modBlockPath(ModBlocks.SAND_PATH))
                        .parent(models().getExistingFile(mcLoc(ModelProvider.BLOCK_FOLDER + "/" + ModelProvider.BLOCK_FOLDER)))
                        .texture("side", modBlockLoc(ModBlocks.SAND_PATH, "_side"))
                        .texture("top", modBlockLoc(ModBlocks.SAND_PATH, "_top"))
                        .texture("bottom", mcBlockLoc(Blocks.SAND))
                        .texture("particle", mcBlockLoc(Blocks.SAND))
                        .element()
                        .from(0.0F,0.0F,0.0F)
                        .to(16.0F, 15.0F,16.0F)
                        .face(Direction.NORTH).end()
                        .face(Direction.SOUTH).end()
                        .face(Direction.WEST).end()
                        .face(Direction.EAST).end()
                        .faces((dir, face) -> face.texture("#side").cullface(dir))
                        .face(Direction.DOWN).texture("#bottom").cullface(Direction.DOWN).end()
                        .face(Direction.UP).texture("#top").end()
                        .end()
        );
    }
}

