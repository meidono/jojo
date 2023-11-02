package com.github.meidono.test;

import handler.SimpleEventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
     getServer().getPluginManager().registerEvents(new SimpleEventHandler(),this);   // Plugin startup logic

    }

    @Override

    public void onDisable() {
        // Plugin shutdown logic
    }
}
