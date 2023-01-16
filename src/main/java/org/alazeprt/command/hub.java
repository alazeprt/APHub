package org.alazeprt.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class hub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("aphub.player.hub")){
            if(commandSender.getName().equals("CONSOLE")){
                commandSender.sendMessage("§cThis command can only be executed by players!");
            } else{
                Player p = (Player) commandSender;
                File config = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "data.yml");
                FileConfiguration configuration = YamlConfiguration.loadConfiguration(config);
                String world = configuration.getString("hub.world").toString();
                double x = configuration.getDouble("hub.x");
                double y = configuration.getDouble("hub.y");
                double z = configuration.getDouble("hub.z");
                p.teleport(new Location(Bukkit.getWorld(world), x, y, z));
                commandSender.sendMessage("§aSuccessfully teleport to the hub!");
            }
        } else{
            commandSender.sendMessage("§cYou don't have permission to do this!");
        }
        return false;
    }
}
