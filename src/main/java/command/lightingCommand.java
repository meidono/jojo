package command;

import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class lightingCommand implements CommandExecutor {

    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

           // RayTraceResult result = player.getWorld().rayTrace(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5, FluidCollisionMode.NEVER, true, 0.0, entity -> entity instanceof LivingEntity);
            RayTraceResult result = player.getWorld().rayTraceEntities(player.getEyeLocation().add(player.getLocation().getDirection()), player.getEyeLocation().getDirection(), 5);

            if (result != null && result.getHitEntity() instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) result.getHitEntity();
                World world = livingEntity.getWorld();
                Location location = livingEntity.getLocation();
                world.strikeLightningEffect(location);
            }
        }

        return true;
    }
}