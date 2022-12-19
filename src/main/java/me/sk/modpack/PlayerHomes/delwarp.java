package me.sk.modpack.PlayerHomes;

import me.sk.modpack.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delwarp implements CommandExecutor {

    private Main plugin;

    public delwarp(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("delhome").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players command");
            return false;
        }
        Player p = (Player) commandSender;
        if(!p.hasPermission("delhome")){
            p.sendMessage("You don't have permission to use this command!");
            return false;
        }
        if (strings.length == 0){
            p.sendMessage("Provide name of the home you want to delete!");
            return false;
        }
        String name = strings[0].toLowerCase();
        if (plugin.getConfig().get(name) == null){
            p.sendMessage("There is no home with this name!");
            return false;
        }
        plugin.getConfig().set(name, null);
        plugin.saveConfig();
        p.sendMessage("Home " + name + " has been deleted");
        return true;
    }
}
