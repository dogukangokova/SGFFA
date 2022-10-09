package xm.system.scoreboard;


import java.util.Arrays;
import java.util.List;
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

import ru.tehkode.permissions.bukkit.PermissionsEx;



public class Deneme2
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  StringBuilder str;
	  Player p = (Player) sender;
	  World world= Bukkit.getWorld("Turbulans");
	 if(cmd.getName().equalsIgnoreCase("test")) {
		
		 p.sendMessage(""+Main.loginno.get(p.getUniqueId()));
		 p.sendMessage("Sayac="+CountDown.sayac);
		 
        
      	int sa = 0;
      	while(sa <=Bukkit.getOnlinePlayers().size()) {
      		sa++;
      		deneme();
      	}
      	
          
              }
          
  


		return false;
}
  
  public static void deneme() {
	  List<Location> Locations = Arrays.asList(new Location[] {
              new Location(Bukkit.getWorld("Turbulans"),1058, 53, -55,-128,1),
              new Location(Bukkit.getWorld("Turbulans"),1058, 53, -55,-128,1),
              new Location(Bukkit.getWorld("Turbulans"),1062, 53, -50,-142,-2),
              new Location(Bukkit.getWorld("Turbulans"),1058, 53, -55,-128,1),
              new Location(Bukkit.getWorld("Turbulans"),1062, 53, -50,-142,-2) });
	  for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
          
          Player player = Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()])[i]; // not sure if this is the best way, not too familiar with getOnlinePlayers();
          
        	  player.teleport(Locations.get(Main.loginno.get(player.getUniqueId())));
          }
  }
  
}
