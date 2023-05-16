package dev.jb0s.blockgameenhanced;

import dev.jb0s.blockgameenhanced.manager.config.modules.ModConfig;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockgameEnhanced implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("blockgameenhanced");

    @Getter
    private static boolean modmenuPresent = false;

    @Getter
    private static ModConfig config;

    @Override
    public void onInitialize() {
        // Cloth Config
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        // Detect if the ModMenu mod is present.
        if(FabricLoader.getInstance().isModLoaded("modmenu")) {
            modmenuPresent = true;
        }
    }
}
