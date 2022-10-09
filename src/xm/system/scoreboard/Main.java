package xm.system.scoreboard;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;


import xm.system.scoreboard.MySQL;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class Main
  extends JavaPlugin implements Listener
{
	public static Main plugin;
	public static String prefix ="§8[§6GFSGFFA§8] ";
	public static String mapname;
	public static Integer login=0;
	public static HashMap<UUID,Integer> loginno = new HashMap<UUID,Integer>();
	public static ArrayList<Player> spectator = new ArrayList();
	public static ArrayList<Player> player = new ArrayList();
	public static String exitspec;
	public static String notspec;
	public static String specmsg;
	public static String invalid_arguments;
	public static String player_not_online;
  public void onEnable()
  {
	  
	 
	  
	  Main.player.clear();
	  Main.spectator.clear();
	  
	  MySQL.connect();
	  mapname="mg";
	GameState.setState(GameState.LiveGame);
	plugin = this;
    SManager.onEnable();
    
    getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    CountDown.CountDown();
    
    plugin = this;
    for (Player all : Bukkit.getOnlinePlayers()) {
      vanish.remove(all);
    }
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    getConfig().options().copyDefaults(true);
    saveDefaultConfig();
    
    getCommand("chatcolor").setExecutor(new CColor());
    getCommand("goto").setExecutor(new CMD_GoTo());
    getCommand("exit").setExecutor(new CMD_GoTo());
    getCommand("deneme").setExecutor(new Deneme());
    getCommand("test").setExecutor(new Deneme2());
    getCommand("forcestart").setExecutor(new ForceStart());
    getCommand("spectate").setExecutor(new SpectateCMD());
    getCommand("specexit").setExecutor(new ExitCMD());

    
    noperm = getConfig().getString("Messages.noPermission").replace('&', '§');
    specmsg = getConfig().getString("Messages.SpectateMessage").replace('&', '§');
    exitspec = getConfig().getString("Messages.ExitSpectator").replace('&', '§');
    invalid_arguments = getConfig().getString("Messages.InvalidArguments").replace('&', '§');
    player_not_online = getConfig().getString("Messages.PlayerNotOnline").replace('&', '§');
    notspec = getConfig().getString("Messages.NotSpectator").replace('&', '§');
    registerListeners();
  } 
  
  public static Main getPlugin()
  {
    return (Main)JavaPlugin.getPlugin(Main.class);
  }
  
  public void onDisable() {
	  MySQL.disconnect();
  }
  
  public static void serverTeleport(Player p) {

      
      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      out.writeUTF("Connect");
      out.writeUTF("Lobby-1");
      p.sendPluginMessage(Main.plugin, "BungeeCord", out.toByteArray());
	   
  }
  
  
  

  public static String noperm;
  public static String gotomsg;
  public static String usedcrash;
  public static ArrayList<Player> vanish = new ArrayList();
  public static String prefix2;
  
  
  
  private void registerListeners()
  {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new JoinListener(this), this);
    pm.registerEvents(new ChatListener(this), this);
    pm.registerEvents(new PlayerMoveListener(this), this);
    pm.registerEvents(new InteractListener(this), this);
    pm.registerEvents(new PlayerDeathListener(this), this);
    pm.registerEvents(new DamageListener(this), this);
    pm.registerEvents(new PlayerDamageListener(this), this);
    pm.registerEvents(new PlayerRespawnListener(this), this);
    pm.registerEvents(new FNSListener(this), this);
    pm.registerEvents(new SignChangeListener(this), this);
  }
  


  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    PluginManager pluginManager = plugin.getServer().getPluginManager();
    Plugin GMplugin = pluginManager.getPlugin("GroupManager");
    if (e.getMessage().contains("I??"))
    {
      if (getConfig().getBoolean("AntiCrash.enabled"))
      {
        e.setCancelled(true);
        for (Player all : Bukkit.getOnlinePlayers())
        {
          usedcrash = getConfig().getString("Messages.usedCrashCode").replace('&', '§').replace("%displayname%", p.getDisplayName()).replace("%player%", p.getName());
          all.sendMessage(prefix + usedcrash);
        }
      }
    }
    else if (!e.getMessage().equalsIgnoreCase("I??"))
    {
    		String format = Main.plugin.getConfig().getString("SpectatorChat.format").replace('&', '§').replace("{message}", e.getMessage()).replace("{player_displayname}", p.getDisplayName()).replace("{player}", p.getName());
    	    if (Main.spectator.contains(p)){
    	      if (Main.plugin.getConfig().getBoolean("SpectatorChat.enabled")) {
    	        for (Player spectators : Main.spectator)
    	        {
    	          e.setCancelled(true);
    	          spectators.sendMessage(format);
    	        }
    	      }
    	    }
    	    else {
    	
      TextComponent staff = new TextComponent(getConfig().getString("Messages.StaffPrefix").replace('&', '§'));
      staff.setColor(ChatColor.DARK_GRAY);
      
      TextComponent f = new TextComponent("[");
      f.setColor(ChatColor.DARK_GRAY);
      
      TextComponent x = new TextComponent("X");
      x.setColor(ChatColor.GOLD);
      x.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/history " + p.getName()));
      x.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "History of §a" + p.getDisplayName()).create()));
      
      TextComponent k = new TextComponent("K");
      k.setColor(ChatColor.DARK_AQUA);
      k.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/kick " + p.getName()));
      k.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Kick §a" + p.getDisplayName()).create()));
      
      TextComponent m = new TextComponent("M");
      m.setColor(ChatColor.DARK_GREEN);
      m.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + p.getName()));
      m.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Mute §a" + p.getDisplayName()).create()));
      
      TextComponent b = new TextComponent("B");
      b.setColor(ChatColor.DARK_RED);
      b.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + p.getName()));
      b.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Ban §a" + p.getDisplayName()).create()));
      
      TextComponent g = new TextComponent("G");
      g.setColor(ChatColor.DARK_PURPLE);
      g.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/goto " + p.getName()));
      g.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Goto §a" + p.getDisplayName()).create()));
      
      TextComponent s = new TextComponent("] ");
      s.setColor(ChatColor.DARK_GRAY);
      
      String message = "§f" + new StringBuilder().append(MySQL.getColor(p).toString()).toString().replaceAll("null", "").replaceAll("&", "§") + e.getMessage();
      TextComponent msg = new TextComponent(message);
      msg.setColor(ChatColor.WHITE);
      if ((GMplugin != null) && (GMplugin.isEnabled()))
      {
        TextComponent isim = new TextComponent( p.getDisplayName() + "§8: ");
        isim.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + p.getName()));
        isim.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Teleport §f" + p.getDisplayName()).create()));
        
        f.addExtra(x);
        f.addExtra(k);
        f.addExtra(m);
        f.addExtra(b);
        f.addExtra(g);
        f.addExtra(s);
        f.addExtra(isim);
        f.addExtra(msg);
        for (Player all : Bukkit.getOnlinePlayers()) {
          if (all.hasPermission("xkmbg.see"))
          {
            if (p.hasPermission("xkmbg.staff")) {
              all.spigot().sendMessage(new BaseComponent[] { staff, isim, msg });
            } else {
              all.spigot().sendMessage(f);
            }
          }
          else {
            all.sendMessage(p.getDisplayName() + "§8: §f" + new StringBuilder().append(MySQL.getColor(p).toString()).toString().replaceAll("null", "").replaceAll("&", "§") + e.getMessage());
          }
        }
      }
      else
      {
    	  
        TextComponent isim = new TextComponent("§8[§a0§8]§c"+String.valueOf(loginno.get(p.getUniqueId()))+"§8:"+p.getDisplayName() + "§8: ");
        isim.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + p.getName()));
        isim.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Teleport §f" + p.getDisplayName()).create()));
        
        f.addExtra(x);
        f.addExtra(k);
        f.addExtra(m);
        f.addExtra(b);
        f.addExtra(g);
        f.addExtra(s);
        f.addExtra(isim);
        f.addExtra(msg);
        for (Player all : Bukkit.getOnlinePlayers()) {
          if (all.hasPermission("xkmbg.see"))
          {
            if (p.hasPermission("xkmbg.staff")) {
              all.spigot().sendMessage(new BaseComponent[] { staff, isim, msg });
            } else {
              all.spigot().sendMessage(f);
            }
          }
          else {
            all.sendMessage("§8[§a0§8]§c"+loginno.get(p.getUniqueId())+"§8:"+p.getDisplayName() + "§8: §f" + new StringBuilder().append(MySQL.getColor(p).toString()).toString().replaceAll("null", "").replaceAll("&", "§") + e.getMessage());
          }
        }
      }
      e.setCancelled(true);
    }
  }
  }
}
