package xm.system.scoreboard;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;



public class Deneme
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  Player p = (Player) sender;
	  World world= Bukkit.getWorld("Turbulans");
	 if(cmd.getName().equalsIgnoreCase("deneme")) {
		 for(Player all: Bukkit.getOnlinePlayers()) {
			 InteractListener.fillChests(all);
			 InteractListener.filltier1Chests(all);
		 }
		 Bukkit.broadcastMessage(Main.prefix+"§3Sponsors have refilled the chests!");
		 Bukkit.broadcastMessage(Main.prefix+"§fThe tributes have passed:");
		 Main.login++;
		 Main.loginno.put(p.getUniqueId(), Main.login);
  }
	return false;
  
}
}
