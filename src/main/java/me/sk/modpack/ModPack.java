package me.sk.modpack;
import me.sk.modpack.Abilities.ToolAbilities;
import me.sk.modpack.Commands.EatAndHealCommand;
import me.sk.modpack.Commands.GodListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModPack extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new EatAndHealCommand());
        getCommand("eat").setExecutor(new EatAndHealCommand());
        getCommand("god").setExecutor(new EatAndHealCommand());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ToolAbilities(), this);
        getServer().getPluginManager().registerEvents(new GodListener(), this);
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
