package xm.system.scoreboard;

import xm.system.scoreboard.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import xm.system.scoreboard.MySQL;



public class CColor
  implements CommandExecutor
{

	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("chatcolor")) {
	      if (p.hasPermission("xkmbg.chatcolor"))
	      {
	        if (args.length == 0)
	        {
	          p.sendMessage(Main.prefix + "§fYou have the following options§8:");
	          p.sendMessage(Main.prefix + "§c&c, §e&e, §b&b, §a&a, §3&3, §fOFF§8.");
	          p.sendMessage(Main.prefix + "§f/chatcolor <ColorCode:OFF>");
	        }
	        else if (args.length == 1)
	        {
	          if (args[0].equalsIgnoreCase("&c"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now §cRed§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&c");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&c");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else if (args[0].equalsIgnoreCase("&e"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now §eYellow§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&e");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&e");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else if (args[0].equalsIgnoreCase("&b"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now §bAqua§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&b");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&b");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else if (args[0].equalsIgnoreCase("&a"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now §aGreen§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&a");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&a");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else if (args[0].equalsIgnoreCase("&3"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now §3Cyan§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&3");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&3");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else if (args[0].equalsIgnoreCase("OFF"))
	          {
	            p.sendMessage(Main.prefix + "§fYour chatcolor is now OFF§8.");
	            Main.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&r");
	            Main.plugin.saveConfig();
	            try {
					MySQL.setColor(p, "&f");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          else
	          {
	            p.sendMessage(Main.prefix + "§fInvalid option§8: §7" + args[0] + "§8.");
	          }
	        }
	        else
	        {
	          p.sendMessage(Main.prefix + "§fYou have the following options§8:");
	          p.sendMessage(Main.prefix + "§c&c, §e&e, §b&b, §a&a, §3&3, §fOFF§8.");
	          p.sendMessage(Main.prefix + "§f/chatcolor <ColorCode:OFF>");
	        }
	      }
	      else {
	        p.sendMessage(Main.prefix + Main.noperm);
	      }
	    }
	    return false;
	  }
	}
