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

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("aphub.admin.sethub")){
            if(commandSender.getName().equals("CONSOLE")){
                commandSender.sendMessage("§cThis command can only be executed by players!");
            } else{
                Player player = (Player) commandSender;
                File config = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "data.yml");
                FileConfiguration configuration = YamlConfiguration.loadConfiguration(config);
                configuration.set("hub.world", player.getWorld().getName());
                configuration.set("hub.x", player.getLocation().getX());
                configuration.set("hub.y", player.getLocation().getY());
                configuration.set("hub.z", player.getLocation().getZ());
                try {
                    configuration.save(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder() + "./data.yml");
                } catch (IOException e) {
                    commandSender.sendMessage("§cFailed to set the hub! Error message:");
                    commandSender.sendMessage("§c" + e.getMessage());
                } finally {
                    commandSender.sendMessage("§aSuccessfully set the hub in the " + player.getWorld().getName() + ", with position X=" + String.format("%.2f", player.getLocation().getX()) + ", Y=" + String.format("%.2f", player.getLocation().getY()) + ", Z=" + String.format("%.2f", player.getLocation().getZ()));
                }
            }
        } else{
            commandSender.sendMessage("§cYou don't have permission to do this!");
        }
        return false;
    }
}
