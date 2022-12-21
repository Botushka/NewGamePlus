package me.sk.modpack;
import me.sk.modpack.Abilities.BlockAbilities;
import me.sk.modpack.Abilities.ToolAbilities;
import me.sk.modpack.Commands.EatAndHealCommand;
import me.sk.modpack.Listeners.GodListener;
import me.sk.modpack.Listeners.HarderMobs;
import me.sk.modpack.Commands.delhome;
import me.sk.modpack.Commands.home;
import me.sk.modpack.Commands.setHome;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        loadConfig();
        new home(this);
        new setHome(this);
        new delhome(this);
        getCommand("heal").setExecutor(new EatAndHealCommand());
        getCommand("eat").setExecutor(new EatAndHealCommand());
        getCommand("god").setExecutor(new EatAndHealCommand());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ToolAbilities(), this);
        getServer().getPluginManager().registerEvents(new GodListener(), this);
        getServer().getPluginManager().registerEvents(new HarderMobs(), this);
        getServer().getPluginManager().registerEvents(new BlockAbilities(), this);
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
