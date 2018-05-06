package de.maxcron.xylit.WeatherChange.Tools;

import de.maxcron.xylit.WeatherChange.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ===============================
 * Spigot - Public - Broadcast
 * Created by Xylit
 * 2017
 * ==============================
 */
public class UpdateChecker {
    public static String prefix = "§8[§3WeatherChange§8] ";
    public static int resource = 45524;
    public static String newVersion = "";

    public static void checkUpdate(Player p) {
        System.out.print("Checking for Updates...");
        try
        {
            HttpURLConnection con = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream()
                    .write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resource)
                            .getBytes("UTF-8"));
            newVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            if (!newVersion.equalsIgnoreCase(main.plugin.getDescription().getVersion())) {
                if ((main.plugin.getConfig().getBoolean("NotifyUpdate")) &&
                        (p.hasPermission(main.plugin.getConfig().getString("PermissionNotifyUpdate")))) {
                    p.sendMessage(main.plugin.getConfig().getString("MessageNotifyUpdate").replaceAll("&", "$").replaceAll("%version%", newVersion));
                }
            } else {
                p.sendMessage(prefix + " §fYou're running the newest plugin version!");
            }
        } catch (Exception ex) {
            p.sendMessage(prefix + " §cFailed to check for updates on spigotmc.org");
        }
    }

    public static void checkUpdateonStart() {
        System.out.println(prefix + "Checking for updates...");
        try
        {
            HttpURLConnection con = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream()
                    .write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resource)
                            .getBytes("UTF-8"));
            newVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            if (!newVersion.equalsIgnoreCase(main.plugin.getDescription().getVersion())) {
                System.out.print("[WeatherChange] A new Update is available! Version " + newVersion);
            } else {
                System.out.println("[WeatherChange] You're running the newest plugin version!");
            }
        } catch (Exception ex) {
            System.err.println("[WeatherChange] " + ChatColor.RED + "Failed to check for updates on spigotmc.org");
        }
    }
}
