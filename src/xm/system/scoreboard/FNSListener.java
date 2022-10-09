package xm.system.scoreboard;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import xm.system.scoreboard.Main;

public class FNSListener implements Listener {
	  public static Main plugin;
	  
	  public FNSListener(Main plugin)
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
	  public void onClickEvent(PlayerInteractEvent event){

		  	Player p = event.getPlayer();
	  		if(p.getItemInHand().getType() == Material.FLINT_AND_STEEL){
	  				int dur=p.getItemInHand().getDurability()+16;
	  				p.getItemInHand().setDurability((short) dur);
	  		if(p.getItemInHand().getDurability()>48) {	
	  				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1f, 1f);
	  		}
	  			
	  		}
	  }


	  }

