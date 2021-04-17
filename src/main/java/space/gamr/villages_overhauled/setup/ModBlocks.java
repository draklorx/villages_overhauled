package space.gamr.villages_overhauled.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import space.gamr.villages_overhauled.blocks.SandPathBlock;

import java.util.function.Supplier;

public class ModBlocks {
    static void register() {}

    public static final RegistryObject<Block> SAND_PATH = register(
        "sand_path", () -> new SandPathBlock(
            AbstractBlock.Properties.create(Material.SAND)
            .hardnessAndResistance(0.55F)
            .sound(SoundType.SAND)
            .harvestTool(ToolType.SHOVEL)
        )
    );

    public static final RegistryObject<Block> COBBLED_SANDSTONE = register(
            "cobbled_sandstone", () -> new Block(
                    AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                            .setRequiresTool()
                            .hardnessAndResistance(0.8F)
                            .sound(SoundType.STONE)
                            .harvestTool(ToolType.PICKAXE)
            )
    );

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return ret;
    }
}
