package xm.system.scoreboard;


import xm.system.scoreboard.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRespawnListener
  implements Listener
{
  public static Main plugin;
  
  public PlayerRespawnListener(Main plugin)
  {
    setPlugin(plugin);
  }
  
  public Main getPlugin()
  {
    return plugin;
  }
  
  public void setPlugin(Main plugin)
  {
    plugin = plugin;
  }
  
 

  
  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent e) {

	  	Player p = e.getPlayer();
	  	World world=Bukkit.getWorld("mg");
	  	Location loc = new Location(world , 23, 84, 33);
	  	
	  	e.setRespawnLocation(loc);
	  	
	  	p.teleport(loc);
	  	p.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	  	ItemStack sword = new ItemStack(Material.WOOD_SWORD);
	  	ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
	  	p.getInventory().setItem(0,sword);
	  	p.getInventory().setItem(1,pearl);
              
  }
}

