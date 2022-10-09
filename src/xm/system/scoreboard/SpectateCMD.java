package xm.system.scoreboard;


import java.util.ArrayList;
import java.util.HashMap;
import xm.system.scoreboard.ChatListener;
import xm.system.scoreboard.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SpectateCMD
  implements CommandExecutor
{
  public static HashMap<Player, Location> loc = new HashMap();
  
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("spectate")) {
    	 if ((int)p.getLocation().getY()>65)
 	    {
 	    	
 	    
      if (p.hasPermission("spectate.use"))
      {
        if (args.length == 0)
        {
          p.sendMessage(Main.prefix + "§fUsage: /spectate <player>");
        }
        else if (args.length == 1)
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t != null)
          {
            Main.player.remove(p);
            Main.spectator.add(p);
            for (PotionEffect effects : p.getActivePotionEffects()) {
              p.removePotionEffect(effects.getType());
            }
            if (Main.plugin.getConfig().getBoolean("Enable-Gamemode-3")) {
              p.setGameMode(GameMode.SPECTATOR);
            } else {
              p.setGameMode(GameMode.ADVENTURE);
            }
            for (Player all : Bukkit.getOnlinePlayers()) {
              all.hidePlayer(p);
            }
            loc.put(p, p.getLocation());
            p.setAllowFlight(true);
            p.setFlying(true);
            p.teleport(t.getLocation());
            
            p.sendMessage(Main.prefix + Main.specmsg.replace("{player}", t.getName()).replace("{player_displayname}",t.getDisplayName()));
          }
          else
          {
            p.sendMessage(Main.prefix + Main.player_not_online);
          }
        }
        else
        {
          p.sendMessage(Main.prefix + Main.invalid_arguments);
        }
      }
      else {
        p.sendMessage(Main.prefix + Main.noperm);
      }
    }else {
    	p.sendMessage(Main.prefix + "§fYou are not in spawn!");
    }
    return false;
    }
	return false;
  }
}
    	
    
 
   
