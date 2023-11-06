package com.github.meidono.test;

import command.lightingCommand;
import handler.SimpleEventHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Test extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
     //getServer().getPluginManager().registerEvents(new SimpleEventHandler(),this);   // Plugin startup logic
     //getServer().getPluginCommand("lighting").setExecutor(new lightingCommand());
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () ->
        {
            List<? extends Player> lox = Bukkit.getOnlinePlayers().stream().toList();
            lox.forEach(SimpleEventHandler::sendinglightingFromPlayer);
        }, 0L, 1L);
    }

    @Override

    public void onDisable() {
        // Plugin shutdown logic
    }
}
