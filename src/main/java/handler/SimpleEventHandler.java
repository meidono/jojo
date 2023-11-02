package handler;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.net.http.WebSocket;

public class SimpleEventHandler implements Listener {
    @EventHandler
public void handleBlockBreakEvent(BlockBreakEvent ass) {
if (ass.getBlock().getType() == Material.DIAMOND_ORE){
    ass.setCancelled(true);
    ass.getBlock().setType(Material.AIR);
        }
    }

}
