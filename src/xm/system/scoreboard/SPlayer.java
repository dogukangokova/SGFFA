package xm.system.scoreboard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class SPlayer
{
  private String player;
  private ScoreB sb;
  
  
  public SPlayer(String player)
  {
	   Date date = new Date();
	   SimpleDateFormat dateformat = new SimpleDateFormat("dd MM yyyy");
	   
	   Date e = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm");
	   sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	   

String aylar[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
Calendar simdi=Calendar.getInstance();

	   
	   Date clock = new Date();
	   SimpleDateFormat clockformat = new SimpleDateFormat("hh:mm a z");
	   
    this.player = player;
    this.sb = new ScoreB();
    this.sb.setSlot(DisplaySlot.SIDEBAR);
    if(CountDown.minutes<=0) {
    	if(CountDown.seconds<10){
        	this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c0"+CountDown.minutes+":0"+CountDown.seconds);
        	
        }
		else if(CountDown.seconds>10) {
			this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c0"+CountDown.minutes+":"+CountDown.seconds);
		}
	}else if(CountDown.minutes>0) {
		if(CountDown.seconds<10){
        	this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c"+CountDown.minutes+":0"+CountDown.seconds);
        	
        }
		else if(CountDown.seconds>10) {
			this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c"+CountDown.minutes+":"+CountDown.seconds);
		}
	}
    
    
    
    this.sb.addLine(14, "§7§l» §fYou");
    this.sb.addLine(13, getPlayer().getName());
    this.sb.addLine(12, "§c");
    this.sb.addLine(11, "§7§l» §fTime");
    this.sb.addLine(10, "§e"+ simdi.get(Calendar.DATE)+" "+aylar[simdi.get(Calendar.MONTH)]+" "+simdi.get(Calendar.YEAR));
    this.sb.addLine(9, "§e"+clockformat.format(clock));
    this.sb.addLine(8, "§7"+sdf.format(e)+"Z");
    this.sb.addLine(7, "§a");
    this.sb.addLine(6, "§7§l» §fServer");
    this.sb.addLine(5, "§6EU§8: §eSGFFA");
    this.sb.addLine(4, "§2");
    this.sb.addLine(3, "§7§l» §fPlayers");
    this.sb.addLine(2, "§fPlaying: "+Main.player.size());
    this.sb.addLine(1, "§fWatching: "+Main.spectator.size());
    this.sb.addLine(0, "§b§lGFGamer.net");
  }
  
  public synchronized void updateScoreboard()
  {
	
	  
	   Date date = new Date();
	   SimpleDateFormat dateformat = new SimpleDateFormat("dd MM yyyy");
	   
	   Date e = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm");
	   sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	   

String aylar[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
Calendar simdi=Calendar.getInstance();

	   
	   Date clock = new Date();
	   SimpleDateFormat clockformat = new SimpleDateFormat("hh:mm a z");
	  
    if (!this.sb.hasBoard(getPlayer())) {
      this.sb.setForPlayer(getPlayer());
    }
    
    if(CountDown.minutes<=0) {
    	if(CountDown.seconds<10){
        	this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c0"+CountDown.minutes+":0"+CountDown.seconds);
        	
        }
		else if(CountDown.seconds>10) {
			this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c0"+CountDown.minutes+":"+CountDown.seconds);
		}
	}else if(CountDown.minutes>0) {
		if(CountDown.seconds<10){
        	this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c"+CountDown.minutes+":0"+CountDown.seconds);
        	
        }
		else if(CountDown.seconds>10) {
			this.sb.setName("§a"+String.valueOf(GameState.statee)+" §c"+CountDown.minutes+":"+CountDown.seconds);
		}
	}
    this.sb.updateLine(14, "§7§l» §fYou");
    this.sb.updateLine(13, getPlayer().getName());
    this.sb.updateLine(12, "§c");
    this.sb.updateLine(11, "§7§l» §fTime");
    this.sb.updateLine(10, "§e"+ simdi.get(Calendar.DATE)+" "+aylar[simdi.get(Calendar.MONTH)]+" "+simdi.get(Calendar.YEAR));
    this.sb.updateLine(9, "§e"+clockformat.format(clock));
    this.sb.updateLine(8, "§7"+sdf.format(e)+"Z");
    this.sb.updateLine(7, "§a");
    this.sb.updateLine(6, "§7§l» §fServer");
    this.sb.updateLine(5, "§6EU§8: §eSGFFA");
    this.sb.updateLine(4, "§2");
    this.sb.updateLine(3, "§7§l» §fPlayers");
    this.sb.updateLine(2, "§fPlaying: "+Main.player.size());
    this.sb.updateLine(1, "§fWatching: "+Main.spectator.size());
    this.sb.updateLine(0, "§b§lGFGamer.net");
  }
  
  public Player getPlayer()
  {
    return Bukkit.getPlayer(this.player);
  }
}