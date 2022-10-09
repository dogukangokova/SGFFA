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

public class PlayerDeathListener
  implements Listener
{
  public static Main plugin;
  
  public PlayerDeathListener(Main plugin)
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
  public void onDeath(PlayerDeathEvent e)
  {
	  Player p = e.getEntity().getPlayer();
	  Player k = e.getEntity().getKiller();
	  Bukkit.getWorld("mg").strikeLightningEffect(p.getLocation());
      Bukkit.broadcastMessage(Main.prefix+"§aOnly §8[§6"+Main.player.size()+"§8] §atributes remain!");
      Bukkit.broadcastMessage(Main.prefix+"§aThere are §8[§6"+Main.spectator.size()+"§8] §aspectators watching the game!");
      Bukkit.broadcastMessage("§6A cannon can be heard in distance§8.");
  	
  	World world=Bukkit.getWorld("mg");
  	Location loc = new Location(world , 23, 84, 33);
  	p.teleport(loc);
  	p.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
  	ItemStack sword = new ItemStack(Material.WOOD_SWORD);
  	ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
  	p.getInventory().setItem(0,sword);
  	p.getInventory().setItem(1,pearl);
   
      if (Main.plugin.getConfig().getBoolean("DisableRespawnScreen")) {
        p.spigot().respawn();
      }
      
  }
  
  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent e) {

	  Player p = e.getPlayer();
	  World world=Bukkit.getWorld("mg");
	  	Location loc = new Location(world , 23, 84, 33);
	  	p.teleport(loc);
	  	p.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	  	ItemStack sword = new ItemStack(Material.WOOD_SWORD);
	  	ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
	  	p.getInventory().setItem(0,sword);
	  	p.getInventory().setItem(1,pearl);
              
  }
}

