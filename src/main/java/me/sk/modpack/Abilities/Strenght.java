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

public class Strenght implements Listener{

        Map<String, Long> cooldown = new HashMap<>();
        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0);

        @EventHandler
        public void onRight(PlayerInteractEvent e) {
            Player player = e.getPlayer();
            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
                if (e.getAction().equals(Action.LEFT_CLICK_AIR) == e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    {
                        if (player.hasPermission("invs")) {
                            if (cooldown.containsKey(player.getName())) {

                                if (cooldown.get(player.getName()) > System.currentTimeMillis()) {
                                    long timeleft = (cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                    player.sendMessage(ChatColor.GOLD + "Ability will be ready in " + timeleft);
                                    return;
                                }
                            }

                            cooldown.put(player.getName(), System.currentTimeMillis() + (100 * 1000));
                            player.addPotionEffect(effect);
                        }
                    }

                }


            } else e.setCancelled(false);

        }
    }

