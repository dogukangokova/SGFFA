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



public class ForceStart
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  Player p = (Player) sender;
	  World world= Bukkit.getWorld("Turbulans");
	 if(cmd.getName().equalsIgnoreCase("forcestart")) {
		 if (p.hasPermission("gfsg.forcestart"))
	      {
	        if (args.length == 0)
	        {
	          p.sendMessage(Main.prefix + "§c/forcestart <LiveGame>");
	        }
	        else if (args.length == 1)
	        {
	           if (args[0].equalsIgnoreCase("LiveGame"))
	          {
	            Bukkit.broadcastMessage(Main.prefix + "§fThe segment has been changed to §aLiveGame §fby "+p.getDisplayName()+"§8.");  
        		GameState.setState(GameState.LiveGame);
        		CountDown.minutes=5;
        		CountDown.seconds=0;
	          }
		 
		 
  }
	
  
}
}
	return false;
  }
}
