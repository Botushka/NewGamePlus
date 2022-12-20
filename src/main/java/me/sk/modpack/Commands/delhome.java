package me.sk.modpack.Commands;

import me.sk.modpack.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delhome implements CommandExecutor {

    private Main plugin;

    public delhome(Main plugin){
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
