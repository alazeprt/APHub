package org.alazeprt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class aphub implements CommandExecutor {
    File config = new File(org.alazeprt.APHub.getProvidingPlugin(org.alazeprt.APHub.class).getDataFolder(), "message.yml");
    FileConfiguration configuration = YamlConfiguration.loadConfiguration(config);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0){
            if(commandSender.hasPermission("aphub.player.help")){
                List<?> list = configuration.getList("player.help");
                int i = 0;
                for(Object object : list){
                    commandSender.sendMessage(object.toString().replace("&","§"));
                }
            } else{
                commandSender.sendMessage(configuration.getString("player.no_permission").replace("&","§"));
            }
        } else if(strings.length == 1 && strings[0].equals("help")){
            if(commandSender.hasPermission("aphub.player.help")){
                List<?> list = configuration.getList("player.help");
                int i = 0;
                for(Object object : list){
                    commandSender.sendMessage(object.toString().replace("&","§"));
                }
            } else{
                commandSender.sendMessage(configuration.getString("player.no_permission").replace("&","§"));
            }
        } else{
            if(commandSender.hasPermission("aphub.player.help")){
                commandSender.sendMessage(configuration.getString("player.unknown_command").replace("&","§"));
            } else{
                commandSender.sendMessage(configuration.getString("player.no_permission").replace("&","§"));
            }
        }
        return false;
    }
}
