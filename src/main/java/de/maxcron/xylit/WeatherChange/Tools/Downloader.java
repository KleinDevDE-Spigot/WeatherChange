package de.maxcron.xylit.WeatherChange.Tools;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


public class Downloader {

    public static boolean updateDownload(String url, CommandSender p) {
        boolean success = false;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        String pluginPath = "plugins/WeatherChange-LATEST.jar";
        URLConnection uc;

        if(url != null) {
            try {
                p.sendMessage("§8[§9Updater§8] §fDownloading Update...");
                URL site = new URL(url);
                uc = site.openConnection();
                uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                uc.addRequestProperty("ServerID", Bukkit.getServerId());
                uc.addRequestProperty("ServerName", Bukkit.getServerName());
                uc.connect();
                bis =  new BufferedInputStream(uc.getInputStream());
                fos = new FileOutputStream(pluginPath);

                int count = -1;
                int read;
                while((read = bis.read()) != -1) {
                    fos.write((byte)read);
                    count++;
                }

                p.sendMessage("§8[§9Updater§8] §fUpdate downloaded §e(" + count / 1024 + "KB)");
                p.sendMessage("§8[§9Update§8] §fPlease Reload the Server to apply changes");
                success = true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return success;
    }


}