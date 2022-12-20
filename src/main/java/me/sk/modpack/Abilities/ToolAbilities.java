package me.sk.modpack.Abilities;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;
import java.util.Map;

public class ToolAbilities implements Listener{

        Map<String, Long> cooldownStrenght = new HashMap<>();
        Map<String, Long> cooldownSpeed = new HashMap<>();
        PotionEffect strenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0);
        PotionEffect Speed = new PotionEffect(PotionEffectType.FAST_DIGGING, 500, 1);

    /**
     Strenght ability for diamond sword
     */
        @EventHandler
        public void onRightSword(PlayerInteractEvent e) {
            Player player = e.getPlayer();
            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
                if (e.getAction().equals(Action.LEFT_CLICK_AIR) == e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    {
                        if (!(player.hasPermission("tools.abilities"))) {return;}
                        if (cooldownStrenght.containsKey(player.getName())) {
                            if (cooldownStrenght.get(player.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldownStrenght.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                player.sendMessage(ChatColor.GOLD + "Ability will be ready in " + timeleft);
                                return;
                                }
                            }
                        cooldownStrenght.put(player.getName(), System.currentTimeMillis() + (50 * 1000));
                        player.addPotionEffect(strenght);
                    }
                }
            } else e.setCancelled(false);
        }
    /**
     Faster cutting ability for diamond axe
     */
    @EventHandler
    public void onRightSpeed(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if ((player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE) ||
                (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE) ||
                (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL)){
            if (e.getAction().equals(Action.LEFT_CLICK_AIR) == e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                {
                    if (!(player.hasPermission("tools.abilities"))){return;}
                    if (cooldownSpeed.containsKey(player.getName())) {
                        if (cooldownSpeed.get(player.getName()) > System.currentTimeMillis()) {
                            long timeleft = (cooldownSpeed.get(player.getName()) - System.currentTimeMillis()) / 1000;
                            player.sendMessage(ChatColor.GOLD + "Ability will be ready in " + timeleft);
                                return;
                            }
                        }
                        cooldownSpeed.put(player.getName(), System.currentTimeMillis() + (50 * 1000));
                        player.addPotionEffect(Speed);
                }
            }
        } else e.setCancelled(false);
    }
}

