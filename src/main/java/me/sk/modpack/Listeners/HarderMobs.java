package me.sk.modpack.Listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



public class HarderMobs implements Listener {
    PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE ,1);
    PotionEffect poisonSpider = new PotionEffect(PotionEffectType.POISON, 10 ,1);
    @EventHandler
    public void onSpawnSkeleton(CreatureSpawnEvent e){
        if(e.getEntityType() == EntityType.SKELETON){
            Skeleton skeleton = (Skeleton) e.getEntity();
            skeleton.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            skeleton.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            ItemStack powerbow = new ItemStack(Material.BOW);
            powerbow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
            skeleton.getEquipment().setItemInMainHand(powerbow);
        }
    }
    @EventHandler
    public void onSpawnZombie(CreatureSpawnEvent e){
        if(e.getEntityType() == EntityType.ZOMBIE){
            Zombie zombie = (Zombie) e.getEntity();
            zombie.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            zombie.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
            zombie.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_AXE));
            zombie.addPotionEffect(speed);
        }
    }

    @EventHandler
    public void onSpiderHit(EntityDamageByEntityEvent e){
        if((e.getDamager() instanceof Spider) && (e.getEntity() instanceof Player)){
            Player target = (Player) e.getEntity();
            target.addPotionEffect(poisonSpider);
        }
    }

}
