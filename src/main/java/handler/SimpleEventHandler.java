package handler;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.RayTraceResult;

public class SimpleEventHandler implements Listener {
    @EventHandler
    public void lightingEventHandler(PlayerInteractEntityEvent ass) {
        Player player = ass.getPlayer();



    }
    public static void  sendinglightingFromPlayer(Player player){
        if(!player.isSneaking())return;
        RayTraceResult result = player.getWorld().rayTraceEntities(player.getEyeLocation().add(player.getLocation().getDirection()), player.getEyeLocation().getDirection(), 5);

        if(result==null)return;

        Entity entity = result.getHitEntity();

        if (entity instanceof LivingEntity && entity!= player) {
            World world = entity.getWorld();
            Location location = entity.getLocation();
            world.strikeLightning(location);
        }

    }
}


