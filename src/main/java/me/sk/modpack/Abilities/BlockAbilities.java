package me.sk.modpack.Abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockAbilities implements Listener {

    PotionEffect Speed = new PotionEffect(PotionEffectType.SPEED, 50, 4);
    PotionEffect Jump = new PotionEffect(PotionEffectType.JUMP, 50, 4);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {


        Player player = event.getPlayer();
        Location location = player.getLocation();
        Block block = location.getBlock().getRelative(BlockFace.DOWN);

        if (block.getType() == Material.EMERALD_BLOCK) {
            player.addPotionEffect(Speed);

        }
        if (block.getType() == Material.REDSTONE_BLOCK) {
            player.addPotionEffect(Jump);

        }
    }
}