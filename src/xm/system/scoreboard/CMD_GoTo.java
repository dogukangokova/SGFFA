package xm.system.scoreboard;


import java.util.ArrayList;
import xm.system.scoreboard.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CMD_GoTo
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("goto"))
    {
      if (p.hasPermission("xkmbg.goto"))
      {
        if (args.length == 0)
        {
          p.sendMessage(Main.prefix + "§fUsage: /goto <player>");
          return true;
        }
        Main.vanish.remove(p);
        Main.vanish.add(p);
        for (Player all : Bukkit.getOnlinePlayers()) {
          all.hidePlayer(p);
        }
        Player t = Bukkit.getPlayer(args[0]);
        String gotomsg = Main.plugin.getConfig().getString("Messages.goToMessage").replace('&', '§').replace("%target%", t.getName());
        p.teleport(t.getLocation());
        p.sendMessage(Main.prefix + gotomsg);
        
        return true;
      }
      p.sendMessage(Main.prefix + Main.noperm);
    }
    if (cmd.getName().equalsIgnoreCase("exit")) {
      if (p.hasPermission("xkmbg.exit"))
      {
        String exitmsg = Main.plugin.getConfig().getString("Messages.ExitMessage").replace('&', '§');
        Main.vanish.remove(p);
        p.sendMessage(Main.prefix + exitmsg);
        for (Player all : Bukkit.getOnlinePlayers()) {
          all.showPlayer(p);
        }
        World world=Bukkit.getWorld("mg");
    	Location loc = new Location(world , 23, 84, 33);
    	p.teleport(loc);
      }
      else
      {
        p.sendMessage(Main.prefix + Main.noperm);
      }
    }
    return false;
  }
}
