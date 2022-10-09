package xm.system.scoreboard;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationData
{
  public static File file = new File("plugins/GFGamerSG/data.yml");
  public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  
  public static void saveCfg()
  {
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  		 
  
  public static void setLocation(String name, int amount)
  {
    cfg.set(name + ".bounty", Integer.valueOf(amount));
    saveCfg();
  }
  
  

  
  

}
