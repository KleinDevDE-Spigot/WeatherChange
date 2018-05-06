package de.maxcron.xylit.WeatherChange.Commands;

import de.maxcron.xylit.WeatherChange.Tools.Config;
import de.maxcron.xylit.WeatherChange.main;
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
public class Weather implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("weather")){
            if (sender instanceof Player){
                if (sender.hasPermission(main.cfg.getString("PermissionWeather"))){
                    if (args.length == 0){

                    } else if (args.length == 1){

                    } else if (args.length == 2){

                    } else if (args.length == 3){

                    } else if (args.length == 4){

                    }
                } else sender.sendMessage(main.cfg.getString("MessageNoPermission").replaceAll("%prefix%", main.cfg.getString("MessagePrefix")).replaceAll("&", "§"));
            } else sender.sendMessage(main.cfg.getString("MessageSenderNotPlayer").replaceAll("&", "§").replaceAll("%prefix", main.cfg.getString("MessagePrefix")));
        }
        return false;
    }
}
