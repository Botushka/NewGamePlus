package me.sk.modpack.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class GodListener implements Listener {

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (EatAndHealCommand.godPlayers.contains(p.getName())) {
                e.setCancelled(true);
            }else{
                e.setCancelled(false);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHunger(FoodLevelChangeEvent e){
        if (e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if (EatAndHealCommand.godPlayers.contains(p.getName())){
                e.isCancelled();
                e.setFoodLevel(20);
            }
        }
    }
}
