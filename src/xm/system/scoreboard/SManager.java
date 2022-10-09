package xm.system.scoreboard;


import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;

public class SManager
{
  private static ConcurrentHashMap<UUID, SPlayer> players = new ConcurrentHashMap();
  
  public static ConcurrentHashMap<UUID, SPlayer> getPlayers()
  {
    return players;
  }
  
  public static void onEnable()
  {
    for (Player player :Bukkit.getOnlinePlayers())
    {
      players.put(player.getUniqueId(), new SPlayer(player.getName()));
      player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
    {
      public void run()
      {
        for (SPlayer player : SManager.players.values()) {
          player.updateScoreboard();
        }
      }
    }, 0L, 20L);
  }
}
