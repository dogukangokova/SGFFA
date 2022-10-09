package xm.system.scoreboard;


import xm.system.scoreboard.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinListener
  implements Listener
{
  public static Main plugin;
  
  public JoinListener(Main plugin)
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
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    for (Player vanished : Main.vanish) {
      p.hidePlayer(vanished);
    }
    p.getInventory().clear();
    p.resetMaxHealth();
    Main.player.add(p);
   if(!Main.loginno.containsKey(p.getUniqueId())) {
	 	Main.login++;
		 Main.loginno.put(p.getUniqueId(), Main.login);
   }
   
   
   for (Player spectators : Main.spectator) {
     p.hidePlayer(spectators);
   }
   
  
  }

  @EventHandler
  public void onJoin2(PlayerJoinEvent e)
  {
	  Player p = e.getPlayer();
	  
    
   
    		if(PermissionsEx.getUser(p).inGroup("Owner")) {
    			if(p.hasPermission("rank.owner")) {
    				String name = "§4§l"+p.getName();
    				p.setDisplayName("§4§l"+p.getName());
    				p.setPlayerListName(name);
    				
    			}
    			}
    		else if(PermissionsEx.getUser(p).inGroup("Admin")) {
    			if(p.hasPermission("rank.admin")) {
    				String name = "§4§l"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("Developer")) {
    		if(p.getName().length() == 9 && p.hasPermission("rank.developer")) {
    			String name = p.getName();
    			char ch[];
    			ch=name.toCharArray();
    			final String isim[] = {"§4§l"+String.valueOf(ch[0]),"§c§l"+String.valueOf(ch[1]),"§6§l"+String.valueOf(ch[2]),"§e§l"+String.valueOf(ch[3]),"§a§l"+String.valueOf(ch[4]),"§2§l"+String.valueOf(ch[5]),"§b§l"+String.valueOf(ch[6]),"§3§l"+String.valueOf(ch[7]),"§9§l"+String.valueOf(ch[8])};
    			p.setDisplayName(isim[0]+isim[1]+isim[2]+isim[3]+isim[4]+isim[5]+isim[6]+isim[7]+isim[8]);
    	     
    			p.setPlayerListName(isim[0]+isim[1]+isim[2]+isim[3]+isim[4]+isim[5]+isim[6]+isim[7]+isim[8]);
    	    
    			
    		}
    		else if (p.getName().length() == 8) {
    			String name = p.getName();
    			char ch[];
    			ch=name.toCharArray();
    			final String isim[] = {"§4§l"+String.valueOf(ch[0]),"§c§l"+String.valueOf(ch[1]),"§6§l"+String.valueOf(ch[2]),"§e§l"+String.valueOf(ch[3]),"§a§l"+String.valueOf(ch[4]),"§2§l"+String.valueOf(ch[5]),"§b§l"+String.valueOf(ch[6]),"§3§l"+String.valueOf(ch[7])};
    			p.setDisplayName(isim[0]+isim[1]+isim[2]+isim[3]+isim[4]+isim[5]+isim[6]+isim[7]);
    			p.setPlayerListName(isim[0]+isim[1]+isim[2]+isim[3]+isim[4]+isim[5]+isim[6]+isim[7]);
    		 }
    		}
    		else if(PermissionsEx.getUser(p).inGroup("SrMod")) {
    			if(p.hasPermission("rank.seniormoderator")) {
    				String name = "§4"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("Mod")) {
    			if(p.hasPermission("rank.moderator")) {
    				String name = "§c"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("VIP")) {
    			if(p.hasPermission("rank.vip")) {
    				String name = "§5"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("MapMaker")) {
    			if(p.hasPermission("rank.friend")) {
    				String name = "§d"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("Quantum")) {
    			if(p.hasPermission("rank.quantum")) {
    				String name = "§a"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("Platinum")) {
    			if(p.hasPermission("rank.platinum")) {
    				String name = "§b"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("Diamond")) {
    			if(p.hasPermission("rank.diamond")) {
    				String name = "§3"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}else if(PermissionsEx.getUser(p).inGroup("Gold")) {
    			if(p.hasPermission("rank.gold")) {
    				String name = "§6"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		else if(PermissionsEx.getUser(p).inGroup("default")) {
    			if(p.hasPermission("rank.regular")) {
    				String name = "§2"+p.getName();
    				p.setDisplayName(name);
    				p.setPlayerListName(name);
    				
    			}
    		}
    		
    		e.setJoinMessage(p.getDisplayName()+" §6has joined§8.");
    		p.getInventory().clear();
    		p.resetMaxHealth();
  }
  
}

