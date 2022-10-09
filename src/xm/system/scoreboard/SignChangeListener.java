package xm.system.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class SignChangeListener  implements Listener
{
	  public static Main plugin;
	  
	  public SignChangeListener(Main plugin)
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
      public void onSignChange(SignChangeEvent e) {
              if (e.getLine(0).equalsIgnoreCase("[Info]")) {
                      e.setLine(0, "§8[§aSTART§8]");
                      e.setLine(1, "§3Click here to");
                      e.setLine(2, "§3introduction tour");
              }
      }
      
      @EventHandler
      public void onPlayerInteract(PlayerInteractEvent e) {
    	  Player p = e.getPlayer();
              if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
              if (e.getClickedBlock().getState() instanceof Sign) {
                      Sign s = (Sign) e.getClickedBlock().getState();
                      if (s.getLine(0).equalsIgnoreCase("§8[§aSTART§8]")) {
                    	  World world=Bukkit.getWorld("mg");
                    	  Location loc = new Location(world , 12.700, 13, 573.500);
                    		p.teleport(loc);
                    		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Welcome\",\"color\":\"red\",\"bold\":true}"), 20, 40, 20);
                            PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"Server Introduction Tour\",\"color\":\"gray\",\"bold\":true}"), 20, 40, 20);
                            ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
                            ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
                            
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin,new Runnable() {
                            	 
                                @Override
                                public void run() {
                                	Location loc2 = new Location(world,15, 1, 340);
                                	p.teleport(loc2);
                                }
                             
                            }, 20*6);
                      }
              }
      }
}
