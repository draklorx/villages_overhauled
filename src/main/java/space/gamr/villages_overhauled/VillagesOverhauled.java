package space.gamr.villages_overhauled;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import space.gamr.villages_overhauled.setup.Registration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VillagesOverhauled.MOD_ID)
public class VillagesOverhauled
{
    public static final String MOD_ID = "villages_overhauled";

    public VillagesOverhauled() {

        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
