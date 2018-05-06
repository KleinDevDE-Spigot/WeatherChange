package de.maxcron.xylit.WeatherChange.Commands;

import de.maxcron.xylit.WeatherChange.Tools.Config;
import de.maxcron.xylit.WeatherChange.main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ===============================
 * SpigotPublic - WeatherChange
 * Created by Xylit
 * 2017
 * ==============================
 */
public class Sun implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sun")){
            if (sender instanceof Player){
                if (sender.hasPermission(main.cfg.getString("PermissionSun"))){
                    World w = ((Player)sender).getWorld();
                    w.setThundering(false);
                    w.setStorm(false);
                    ((Player)sender).sendMessage(Config.getMessage(((Player)sender), "Sun").replaceAll("%prefix%", main.cfg.getString("Prefix").replaceAll("&", "§")));
                } else sender.sendMessage(Config.getMessage(((Player)sender), "NoPermission").replaceAll("%prefix%", Config.getMessage(((Player)sender), "Prefix")).replaceAll("&", "§"));
            } else sender.sendMessage(Config.getMessage(((Player)sender), "SenderNotPlayer").replaceAll("&", "§").replaceAll("%prefix", Config.getMessage(((Player)sender), "Prefix")));
        }
        return false;
    }
}
