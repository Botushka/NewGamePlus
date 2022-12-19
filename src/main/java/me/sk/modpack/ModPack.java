package me.sk.modpack;
import me.sk.modpack.Abilities.Strenght;
import me.sk.modpack.Commands.EatAndHealCommand;
import me.sk.modpack.Commands.GodListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ModPack extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new EatAndHealCommand());
        getCommand("eat").setExecutor(new EatAndHealCommand());
        getCommand("god").setExecutor(new EatAndHealCommand());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Strenght(), this);
        getServer().getPluginManager().registerEvents(new GodListener(), this);
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
