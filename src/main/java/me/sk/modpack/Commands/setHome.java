package me.sk.modpack.Commands;

import me.sk.modpack.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHome implements CommandExecutor {

    private Main plugin;

    public setHome(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("sethome").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Console not allowed to use this command");
            return false;
        }
       Player p = (Player) commandSender;

        if (strings.length == 0){
             p.sendMessage("Give home a specific name");
             return false;
        }
        String name = strings[0].toLowerCase();
        if(plugin.getConfig().get(name) != null){
            p.sendMessage("There is already a home with that name");
            return false;
        }
        Location loc = p.getLocation();
        plugin.getConfig().set(name + ".world", loc.getWorld().getName());
        plugin.getConfig().set(name + ".x", loc.getX());
        plugin.getConfig().set(name + ".y", loc.getY());
        plugin.getConfig().set(name + ".z", loc.getZ());
        plugin.getConfig().set(name + ".pitch", loc.getPitch());
        plugin.getConfig().set(name + ".yaw", loc.getYaw());
        plugin.saveConfig();
        p.sendMessage("You set up a new home: " + name);
        return true;
    }
}
