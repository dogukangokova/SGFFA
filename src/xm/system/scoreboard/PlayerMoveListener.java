package xm.system.scoreboard;


import xm.system.scoreboard.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener
  implements Listener
{
  public static Main plugin;
  
  public PlayerMoveListener(Main plugin)
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
  public void onMove(PlayerMoveEvent e)
  {
	  Player p = e.getPlayer();
      
  }
}

