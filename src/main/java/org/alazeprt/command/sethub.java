package org.alazeprt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class sethub implements CommandExecutor {
    File config = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "message.yml");
    FileConfiguration configuration = YamlConfiguration.loadConfiguration(config);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("aphub.admin.sethub")){
            if(commandSender.getName().equals("CONSOLE")){
                commandSender.sendMessage(configuration.getString("console.only_player").replace("&","§"));
            } else{
                Player player = (Player) commandSender;
                File config2 = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "data.yml");
                FileConfiguration configuration2 = YamlConfiguration.loadConfiguration(config2);
                configuration2.set("hub.world", player.getWorld().getName());
                configuration2.set("hub.x", player.getLocation().getX());
                configuration2.set("hub.y", player.getLocation().getY());
                configuration2.set("hub.z", player.getLocation().getZ());
                try {
                    configuration2.save(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder() + "./data.yml");
                } catch (IOException e) {
                    commandSender.sendMessage(configuration.getString("admin.set_failed").replace("&","§"));
                    commandSender.sendMessage("§c" + e.getMessage());
                } finally {
                    commandSender.sendMessage(configuration.getString("admin.successfully_set").replace("&","§")
                            .replace("[world]",player.getWorld().getName())
                            .replace("[x]",String.format("%.2f",player.getLocation().getX()))
                            .replace("[y]",String.format("%.2f",player.getLocation().getY()))
                            .replace("[z]",String.format("%.2f",player.getLocation().getZ())));
                }
            }
        } else{
            commandSender.sendMessage(configuration.getString("player.no_permission").replace("&","§"));
        }
        return false;
    }
}
