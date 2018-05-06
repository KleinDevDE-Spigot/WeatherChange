package de.maxcron.xylit.WeatherChange.Tools;

import de.maxcron.xylit.WeatherChange.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.*;

/**
 * ========================
 * Produced by Xylit
 * 2017
 * ========================
 */
public class Config {
    static File cfile;
    static FileConfiguration config;

    public static void create(String FileName) {
        File df = new File(main.plugin.getDataFolder().getPath());
        cfile = new File(df, File.separator + FileName);
        if (!df.exists()) df.mkdir();
        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
            } catch(Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error creating " + cfile.getName() + "!");
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static FileConfiguration load(String FileName) {
        File df = new File(main.plugin.getDataFolder().getPath());
        cfile = new File(df, File.separator + FileName);
        config = YamlConfiguration.loadConfiguration(cfile);
        return config;
    }
    public static void save(String FileName) {
        File df = new File(main.plugin.getDataFolder().getPath());
        cfile = new File(df, File.separator + FileName);
        try {
            config.save(cfile);
        } catch(Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error saving " + cfile.getName() + "!");
        }
    }
    public static boolean exist(String FileName){
        File df = new File(main.plugin.getDataFolder().getPath());
        cfile = new File(df, File.separator + FileName);
        return (cfile.exists());
    }

    public static void copy(String File){
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        try {
            String pluginPath = main.plugin.getDataFolder() + java.io.File.separator + File;
            bis = new BufferedInputStream(main.plugin.getResource(File));
            fos = new FileOutputStream(pluginPath);

            int count = -1;
            int read;
            while ((read = bis.read()) != -1) {
                fos.write((byte) read);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }

        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
            }
        }
    }

    public static String getMessage(Player p, String message){
        return load("lang.yml").getString(main.lang + "." + message).replaceAll("&", "§").replaceAll("%player%", p.getName());
    }
}
