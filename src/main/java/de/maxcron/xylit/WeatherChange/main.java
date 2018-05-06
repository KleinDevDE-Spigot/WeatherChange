package de.maxcron.xylit.WeatherChange;

import de.maxcron.xylit.WeatherChange.Tools.Config;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ===============================
 * SpigotPublic - WeatherChange
 * Created by Xylit
 * 2017
 * ==============================
 */
public class main extends JavaPlugin {
    public static Plugin plugin;
    public static FileConfiguration cfg;
    public static String lang = "en";

    public void onEnable(){
        plugin = this;
        cfg = getConfig();
        Config.copy("lang.yml");
        lang = Config.load("lang.yml");
        preSetup();
    }

    private void preSetup(){

    }

    private void checkLanguage(){
        lang = Config.load("config.yml").getString("language");
        if (Config.load("lang.yml").get(lang) != null) {
            System.out.print("[OreStats] Setting Language to '" + lang + "'");
        } else {
            System.out.print("[OreStats] " + ChatColor.RED + "No Language Configuration found for '" + lang + "'");
            lang = "en";
        }
    }
}
