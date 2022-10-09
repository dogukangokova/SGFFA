package xm.system.scoreboard;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreB
{
  public static final String objective = "NoFlicker";
  private Scoreboard scoreboard;
  private ConcurrentHashMap<Integer, String> storedLines = new ConcurrentHashMap();
  private Team[] teams;
  private List<ChatColor> chatMap;
  
  public ScoreB()
  {
    this.scoreboard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
    this.scoreboard.registerNewObjective("NoFlicker", "dummy");
    this.teams = new Team[16];
    
    this.chatMap = new ArrayList();
    ChatColor[] arrayOfChatColor;
    int j = (arrayOfChatColor = ChatColor.values()).length;
    for (int i = 0; i < j; i++)
    {
      ChatColor chat = arrayOfChatColor[i];
      if (this.chatMap.size() + 1 > 15) {
        break;
      }
      this.chatMap.add(chat);
    }
  }
  
  private String translateToColorCode(String msg)
  {
    return ChatColor.translateAlternateColorCodes('&', msg);
  }
  
  public boolean hasLine(int lineID)
  {
    return this.storedLines.get(Integer.valueOf(lineID)) != null;
  }
  
  public void setSlot(DisplaySlot slot)
  {
    this.scoreboard.getObjective("NoFlicker").setDisplaySlot(slot);
  }
  
  public void setName(String name)
  {
    this.scoreboard.getObjective("NoFlicker").setDisplayName(name);
  }
  
  public String getName()
  {
    return this.scoreboard.getObjective("NoFlicker").getName();
  }
  
  private String fixDuplicates(String text)
  {
    while (this.storedLines.contains(text)) {
      text = text + "§r";
    }
    return text;
  }
  
  public void addLine(int scoreValue, String name)
  {
    name = fixDuplicates(name);
    this.teams[scoreValue] = this.scoreboard.registerNewTeam(String.valueOf(scoreValue));
    int rand = new Random().nextInt(this.chatMap.size());
    String idd = ((ChatColor)this.chatMap.get(rand)).toString();
    this.teams[scoreValue].addEntry(idd);
    this.storedLines.put(Integer.valueOf(scoreValue), idd);
    this.scoreboard.getObjective("NoFlicker").getScore(idd).setScore(scoreValue);
    
    Iterator<String> iterator = Splitter.fixedLength(16).split(name).iterator();
    String prefix = (String)iterator.next();
    boolean shouldInsert = (name.length() >= 16) && (prefix.charAt(15) == '§');
    if (shouldInsert) {
      prefix = prefix.substring(0, 15);
    }
    this.teams[scoreValue].setPrefix(prefix);
    String chatcolor = ChatColor.getLastColors(prefix);
    if (name.length() > 16)
    {
      String suffix = (String)iterator.next();
      if (shouldInsert) {
        suffix = "§" + suffix;
      } else {
        suffix = chatcolor + suffix;
      }
      if (suffix.length() > 16) {
        suffix = suffix.substring(0, 16);
      }
      this.teams[scoreValue].setSuffix(suffix);
    }
    this.chatMap.remove(rand);
  }
  
  public void removeLine(int id)
  {
    if (!hasLine(id)) {
      return;
    }
    this.teams[id].unregister();
    this.teams[id] = null;
    String idd = (String)this.storedLines.get(Integer.valueOf(id));
    this.scoreboard.resetScores(idd);
    this.storedLines.remove(Integer.valueOf(id));
  }
  
  public void blankLine(int id)
  {
    if (!hasLine(id)) {
      addLine(id, " ");
    }
  }
  
  public void updateLine(int id, String newName)
  {
    if (!hasLine(id)) {
      return;
    }
    newName = fixDuplicates(newName);
    Iterator<String> iterator = Splitter.fixedLength(16).split(newName)
      .iterator();
    String prefix = (String)iterator.next();
    
    boolean shouldInsert = (newName.length() > 16) && (prefix.charAt(15) == '§');
    if (shouldInsert) {
      prefix = prefix.substring(0, 15);
    }
    this.teams[id].setPrefix(prefix);
    
    String chatcolor = ChatColor.getLastColors(prefix);
    if (newName.length() > 16)
    {
      String suffix = (String)iterator.next();
      if (shouldInsert) {
        suffix = "§" + suffix;
      } else {
        suffix = chatcolor + suffix;
      }
      if (suffix.length() > 16) {
        suffix = suffix.substring(0, 16);
      }
      this.teams[id].setSuffix(suffix);
    }
    else
    {
      this.teams[id].setSuffix("");
    }
  }
  
  public String getLine(int id)
  {
    return this.teams[id].getPrefix() + this.teams[id].getSuffix();
  }
  
  public boolean hasBoard(Player player)
  {
    return player.getScoreboard().getObjective("NoFlicker") != null;
  }
  
  public void setForPlayer(Player player)
  {
    player.setScoreboard(this.scoreboard);
  }
}

