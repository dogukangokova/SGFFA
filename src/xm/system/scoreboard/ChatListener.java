package xm.system.scoreboard;

import xm.system.scoreboard.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xm.system.scoreboard.MySQL;

public class ChatListener
  implements Listener
{
  public static Main plugin;
  
  public ChatListener(Main plugin)
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
  public void onChat(AsyncPlayerChatEvent e)
  {
	 
    Player p = e.getPlayer();
    
    
    
   
      
 
    e.setFormat(e.getPlayer().getDisplayName() + "§8: §f" + new StringBuilder().append(MySQL.getColor(p).toString()).toString().replaceAll("null", "").replaceAll("&", "§") + e.getMessage() + "§8.");
  
}
}