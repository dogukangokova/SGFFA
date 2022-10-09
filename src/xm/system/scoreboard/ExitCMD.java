package xm.system.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import xm.system.scoreboard.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExitCMD
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("specexit")) {
      if (p.hasPermission("Main.use"))
      {
        if (!Main.spectator.contains(p))
        {
          p.sendMessage(Main.prefix + Main.notspec);
        }
        else if (Main.spectator.contains(p))
        {
          Main.spectator.remove(p);
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.showPlayer(p);
          }
          Location locc = (Location)SpectateCMD.loc.get(p);
          p.setGameMode(GameMode.SURVIVAL);
          p.setAllowFlight(false);
          p.setFlying(false);
          p.sendMessage(Main.prefix + Main.exitspec);
          p.teleport(locc);
        }
      }
      else {
        p.sendMessage(Main.prefix + Main.noperm);
      }
    }
    return false;
  }
}
