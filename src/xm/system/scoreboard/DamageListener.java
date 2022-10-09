package xm.system.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import xm.system.scoreboard.Main;

public class DamageListener implements Listener {
	  public static Main plugin;
	  
	  public DamageListener(Main plugin)
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
	 public void onAttack(EntityDamageByEntityEvent event)
	  {
		 
	  }
}
