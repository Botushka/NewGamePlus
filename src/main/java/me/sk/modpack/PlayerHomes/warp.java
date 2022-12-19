package me.sk.modpack.PlayerHomes;

import me.sk.modpack.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warp implements CommandExecutor {

    private Main plugin;

    public warp(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("home").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Player only command!");
            return false;
        }
        Player p = (Player) commandSender;
        if(strings.length == 0){
            p.sendMessage("Please specify which home you want to teleport to!");
            return false;
        }
        String name = strings[0].toLowerCase();
        if(plugin.getConfig().get(name) == null){
            p.sendMessage("No home with that name!");
            return false;
        }
        Location loc;
        Double x = plugin.getConfig().getDouble(name + ".x");
        Double y = plugin.getConfig().getDouble(name + ".y");
        Double z = plugin.getConfig().getDouble(name + ".z");
        float yaw = (float) plugin.getConfig().getDouble(name + ".yaw");
        float pitch = (float) plugin.getConfig().getDouble(name + ".pitch");
        String world = plugin.getConfig().getString(name + ".world");
        loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        p.teleport(loc);
        p.sendMessage("You've been teleported to " + name);
        return true;
    }
}
