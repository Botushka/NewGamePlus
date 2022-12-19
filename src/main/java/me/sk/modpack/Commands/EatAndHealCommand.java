package me.sk.modpack.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.ArrayList;

public  class EatAndHealCommand implements CommandExecutor {

    public static ArrayList<String> godPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /**
         Implementing Eat command below;
         */

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("eat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command");
            }
            if (!sender.hasPermission("eat.use")) {
                player.sendMessage("You dont have permission for this command");
            }
            player.setFoodLevel(20);
            player.sendMessage("You have been fed!");
            return true;

        }
        /**
         Implementing Heal command below;
         */
        if (label.equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command");
            }
            if (!player.hasPermission("heal.use")) {
                sender.sendMessage("You dont have permission to use this command!");
            }
            player.setHealth(20.0);
            player.sendMessage("You have been healed");
        }

        /**
         Implementing God command below; God command listener can be found in GodListener file
         */
        if (label.equalsIgnoreCase("god")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command");
            }
            if (!player.hasPermission("god.use")) {
                sender.sendMessage("You dont have permission to use this command!");
            }
            if (args.length == 0 && sender instanceof Player) {
                if (godPlayers.contains(player.getName())) {
                    godPlayers.remove(player.getName());
                    player.sendMessage("God mode removed");
                } else {
                    godPlayers.add(player.getName());
                    player.sendMessage("God mode enabled");
                    player.setFoodLevel(20);
                }

            }



        }

        return true;
    }


}

