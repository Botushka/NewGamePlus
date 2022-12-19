package me.sk.modpack;
import me.sk.modpack.Abilities.ToolAbilities;
import me.sk.modpack.Commands.EatAndHealCommand;
import me.sk.modpack.Commands.GodListener;
import me.sk.modpack.PlayerHomes.delwarp;
import me.sk.modpack.PlayerHomes.setWarp;
import me.sk.modpack.PlayerHomes.warp;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        loadConfig();
        new warp(this);
        new setWarp(this);
        new delwarp(this);
        getCommand("heal").setExecutor(new EatAndHealCommand());
        getCommand("eat").setExecutor(new EatAndHealCommand());
        getCommand("god").setExecutor(new EatAndHealCommand());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ToolAbilities(), this);
        getServer().getPluginManager().registerEvents(new GodListener(), this);
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
