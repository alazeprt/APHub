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
    File config = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "message.yml");
    FileConfiguration configuration = YamlConfiguration.loadConfiguration(config);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("aphub.player.hub")){
            if(commandSender.getName().equals("CONSOLE")){
                commandSender.sendMessage(configuration.getString("console.only_player").replace("&","§"));
            } else{
                Player p = (Player) commandSender;
                File config2 = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "data.yml");
                FileConfiguration configuration2 = YamlConfiguration.loadConfiguration(config2);
                String world = "";
                double x = 0;
                double y = 0;
                double z = 0;
                try{
                    world = configuration2.getString("hub.world").toString();
                    x = configuration2.getDouble("hub.x");
                    y = configuration2.getDouble("hub.y");
                    z = configuration2.getDouble("hub.z");
                } catch (NullPointerException nullPointerException){
                    commandSender.sendMessage(configuration.getString("player.hub_not_found").replace("&","§"));
                }
                if(!world.equals("")){
                    p.teleport(new Location(Bukkit.getWorld(world), x, y, z));
                    commandSender.sendMessage(configuration.getString("player.teleport_successfully").replace("&","§"));
                }
            }
        } else{
            commandSender.sendMessage(configuration.getString("player.no_permission").replace("&","§"));
        }
        return false;
    }
}
