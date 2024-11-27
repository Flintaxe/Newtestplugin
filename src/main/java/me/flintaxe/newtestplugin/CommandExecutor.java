package me.flintaxe.newtestplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static org.bukkit.Bukkit.getLogger;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (command.getName().equalsIgnoreCase("getBlessed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = player.getLocation();

                // CROSS---------------------
                location.setZ(location.getZ()+ 4.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));
                location.setY(location.getY()+ 1.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));
                location.setY(location.getY()+ 1.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));
                location.setX(location.getX()+ 1.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));
                location.setX(location.getX()- 2.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));
                location.setX(location.getX()+ 1.0);
                location.setY(location.getY()+ 1.0);
                location.getBlock().setType(getRandomBlock(Material.COBBLESTONE));

                // FLOOR
                location.set(player.getX() - 3.0, player.getY() - 1.0, player.getZ() - 3.0);
                for (int x = 0; x<=4; x++) {
                    location.setX(location.getX()+ 1.0);
                    location.setZ(player.getZ()+ 1.0);
                    for (int z = 0; z<=4; z++) {
                        location.setZ(location.getZ()+ 1.0);
                        location.getBlock().setType(getRandomBlock(Material.STONE_BRICKS));
                    }
                }


                player.sendMessage(ChatColor.YELLOW + "Bless you :)");
            } else getLogger().info("command must be run by a player");

            return true;
        }
        return false;
    }
    private Material getRandomBlock(@NotNull Material material) {
        switch (material) {
            case COBBLESTONE:
                switch (new Random().nextInt(2)) {
                    case 0: return Material.COBBLESTONE;
                    case 1: return Material.MOSSY_COBBLESTONE;
                }
            case STONE_BRICKS:
                switch (new Random().nextInt(3)) {
                    case 0: return Material.STONE_BRICKS;
                    case 1: return Material.MOSSY_STONE_BRICKS;
                    case 2: return Material.CRACKED_STONE_BRICKS;
                    //case 3: return Material.AIR; find a way to let the block not change
                }
            case COBBLESTONE_WALL:
                switch (new Random().nextInt(2)) {
                    case 0: return Material.COBBLESTONE_WALL;
                    case 1: return Material.MOSSY_COBBLESTONE_WALL;
                }
            default: return material;
        }
    }
}
