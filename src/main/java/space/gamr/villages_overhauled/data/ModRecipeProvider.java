package space.gamr.villages_overhauled.data;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import space.gamr.villages_overhauled.VillagesOverhauled;
import space.gamr.villages_overhauled.setup.ModBlocks;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.COBBLED_SANDSTONE.get()), Items.SANDSTONE, 0.1F, 200)
        .addCriterion("has_item", hasItem(ModBlocks.COBBLED_SANDSTONE.get()))
        .build(consumer, new ResourceLocation(VillagesOverhauled.MOD_ID, "sandstone_smelting"));
    }
}
