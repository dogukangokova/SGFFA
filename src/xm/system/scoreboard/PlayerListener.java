package xm.system.scoreboard;

import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerListener
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void onJoin(PlayerJoinEvent e)
  {
	Player p = e.getPlayer();
	p.getInventory().clear();
	p.getInventory().setArmorContents(null);
	World world=Bukkit.getWorld("mg");
	Location loc = new Location(world , 23, 84, 33);
	p.teleport(loc);
	p.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	ItemStack sword = new ItemStack(Material.WOOD_SWORD);
	ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
	p.getInventory().setItem(0,sword);
	p.getInventory().setItem(1,pearl);
    SManager.getPlayers().put(e.getPlayer().getUniqueId(), new SPlayer(e.getPlayer().getName()));
    p.sendMessage("         §3§lWelcome to SGFFA Server         ");
    p.sendMessage(Main.prefix+"§cThis game mode is played out by gathering from the chests rather than being ready for the difference from the normal ffa mode.");
    p.sendMessage(Main.prefix+"§cYou can type §8[§e/info§8] §cif you want a little game introduction.");
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerChangeWorld(PlayerChangedWorldEvent e)
  {
    e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onKick(PlayerKickEvent e)
  {
    SManager.getPlayers().remove(e.getPlayer().getUniqueId());
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onQuit(PlayerQuitEvent e)
  {Player p = e.getPlayer();
    SManager.getPlayers().remove(e.getPlayer().getUniqueId());
    e.setQuitMessage(p.getDisplayName()+" §6has left§8.");
    Main.player.remove(p);
    Main.spectator.remove(p);
  }

  @EventHandler(priority = EventPriority.HIGH)
  public void onFallDamage(EntityDamageEvent event){
      if(event.getEntity() instanceof Player){
          Player player = (Player)event.getEntity();
          if(event.getCause()== DamageCause.FALL){
              event.setCancelled(true);
          }
      }
  }
  
  
}
