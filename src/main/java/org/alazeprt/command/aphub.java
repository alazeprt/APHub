package org.alazeprt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class aphub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0){
            if(commandSender.hasPermission("aphub.player.help")){
                commandSender.sendMessage("§cAPHub help");
                commandSender.sendMessage("§e/sethub §6- Set hub");
                commandSender.sendMessage("§e/setlobby §6- Set lobby");
                commandSender.sendMessage("§e/hub §6- Teleport to hub");
                commandSender.sendMessage("§e/lobby §6- Teleport to lobby");
            } else{
                commandSender.sendMessage("§cYou don't have permission to do this!");
            }
        } else if(strings.length == 1 && strings[0].equals("help")){
            if(commandSender.hasPermission("aphub.player.help")){
                commandSender.sendMessage("§cAPHub help");
                commandSender.sendMessage("§e/sethub §6- Set hub");
                commandSender.sendMessage("§e/setlobby §6- Set lobby");
                commandSender.sendMessage("§e/hub §6- Teleport to hub");
                commandSender.sendMessage("§e/lobby §6- Teleport to lobby");
            } else{
                commandSender.sendMessage("§cYou don't have permission to do this!");
            }
        } else{
            if(commandSender.hasPermission("aphub.player.help")){
                commandSender.sendMessage("§cUnknown Command! Type /aphub to view help");
            } else{
                commandSender.sendMessage("§cYou don't have permission to do this!");
            }
        }
        return false;
    }
}
