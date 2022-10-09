package xm.system.scoreboard;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

	  public static Main plugin;
	  
	  public InteractListener(Main plugin)
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
	
	public static HashMap<Location, Inventory> sgchests=new HashMap<>();
	public static Location loc;
	public static HashMap<Location, Inventory> sgchestss=new HashMap<>();
	public static Location locc;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		loc = e.getClickedBlock().getLocation();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType()==Material.PISTON_BASE) {
				if(sgchests.containsKey(loc)) {
						p.openInventory(sgchests.get(loc));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 4F, 0F);
					return;
			
				} else {
			
			Random r = new Random();
			int l = r.nextInt(15);
			
			Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
			List<ItemStack> items = new ArrayList <>();
			
			for(String all : Main.plugin.getConfig().getStringList("values")) {
				int ID = 0;
				int subID = 0;
				int amount = 0;
				int chance = 0;
				
				if(all.contains(":")) {
					String[] array = all.split(":");
					ID = Integer.valueOf(array[0]);
					String a = array[1];
					a = a.substring(0, 1);
					subID = Integer.valueOf(a);
				}
				
				String[] array = all.split(", ");
				amount = Integer.valueOf(array[1]);
				chance = Integer.valueOf(array[2]);
				
				for(int i = 0; i < chance; i++) {
					items.add(new ItemStack(ID, amount, (short) subID));
				}
			}
			while (l != 0) {
				l--;
				
				Random r2 = new Random();
				
				Random r3 = new Random();
				
				int n2 = r2.nextInt(27);
				
				int n3 = r3.nextInt(items.size());
				
				inv.setItem(n2, items.get (n3));
				
			}
			
			sgchests.put(loc, inv);
			
			p.openInventory(sgchests.get(loc));
			return;
			}
			}
			
		else if(e.getClickedBlock().getType()==Material.PISTON_STICKY_BASE) {
			if(sgchestss.containsKey(loc)) {
				p.openInventory(sgchestss.get(loc));
				p.playSound(p.getLocation(), Sound.CHEST_OPEN, 4F, 0F);
			return;
	
		} else {
	
	Random r = new Random();
	int l = r.nextInt(15);
	
	Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
	List<ItemStack> items = new ArrayList <>();
	
	for(String all : Main.plugin.getConfig().getStringList("valuess")) {
		int ID = 0;
		int subID = 0;
		int amount = 0;
		int chance = 0;
		
		if(all.contains(":")) {
			String[] array = all.split(":");
			ID = Integer.valueOf(array[0]);
			String a = array[1];
			a = a.substring(0, 1);
			subID = Integer.valueOf(a);
		}
		
		String[] array = all.split(", ");
		amount = Integer.valueOf(array[1]);
		chance = Integer.valueOf(array[2]);
		
		for(int i = 0; i < chance; i++) {
			items.add(new ItemStack(ID, amount, (short) subID));
		}
	}
	while (l != 0) {
		l--;
		
		Random r2 = new Random();
		
		Random r3 = new Random();
		
		int n2 = r2.nextInt(27);
		
		int n3 = r3.nextInt(items.size());
		
		inv.setItem(n2, items.get (n3));
		
	}
	
	sgchestss.put(loc, inv);
	
	p.openInventory(sgchestss.get(loc));
	return;
	}
	}
		}
		}
	
	public static void fillChests(Player p) {
		Random r = new Random();
		int l = r.nextInt(15);
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
		List<ItemStack> items = new ArrayList <>();
		
		for(String all : Main.plugin.getConfig().getStringList("values")) {
			int ID = 0;
			int subID = 0;
			int amount = 0;
			int chance = 0;
			
			if(all.contains(":")) {
				String[] array = all.split(":");
				ID = Integer.valueOf(array[0]);
				String a = array[1];
				a = a.substring(0, 1);
				subID = Integer.valueOf(a);
			}
			
			String[] array = all.split(", ");
			amount = Integer.valueOf(array[1]);
			chance = Integer.valueOf(array[2]);
			
			for(int i = 0; i < chance; i++) {
				items.add(new ItemStack(ID, amount, (short) subID));
			}
		}
		while (l != 0) {
			l--;
			
			Random r2 = new Random();
			
			Random r3 = new Random();
			
			int n2 = r2.nextInt(27);
			
			int n3 = r3.nextInt(items.size());
			
			inv.setItem(n2, items.get (n3));
			
		}
		
		sgchests.put(loc, inv);
		
		return;
	}
	
	
	public static void filltier1Chests(Player p) {
		Random r = new Random();
		int l = r.nextInt(15);
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
		List<ItemStack> items = new ArrayList <>();
		
		for(String all : Main.plugin.getConfig().getStringList("valuess")) {
			int ID = 0;
			int subID = 0;
			int amount = 0;
			int chance = 0;
			
			if(all.contains(":")) {
				String[] array = all.split(":");
				ID = Integer.valueOf(array[0]);
				String a = array[1];
				a = a.substring(0, 1);
				subID = Integer.valueOf(a);
			}
			
			String[] array = all.split(", ");
			amount = Integer.valueOf(array[1]);
			chance = Integer.valueOf(array[2]);
			
			for(int i = 0; i < chance; i++) {
				items.add(new ItemStack(ID, amount, (short) subID));
			}
		}
		while (l != 0) {
			l--;
			
			Random r2 = new Random();
			
			Random r3 = new Random();
			
			int n2 = r2.nextInt(27);
			
			int n3 = r3.nextInt(items.size());
			
			inv.setItem(n2, items.get (n3));
			
		}
		
		sgchestss.put(locc, inv);
		
		return;
	}
	}

