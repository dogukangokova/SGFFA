package xm.system.scoreboard;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import xm.system.scoreboard.Main;


public class MySQL {
	 
	public static String host= "localhost";
	public static String port = "3306";
	public static String database= "server";
	public static String username= "dogukanhd";
	public static String password= "123";
	
	public static boolean containsplayer;

	public static HashMap<Player, String> mod = new HashMap<Player,String>();
	
	public static ResultSet rss;
	public static PreparedStatement pss;
	public static Connection con;
	
	public static boolean isConnected() {
		
		return con != null;
	}
	
	public static void connect () {
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://"+ host + ":"+ port + "/"+ database + "?autoReconnect=true", username, password);
				Bukkit.getConsoleSender().sendMessage(Main.prefix+"§aSuccessfully connected to MySQL.");				
			
			}catch(SQLException e) {
				Bukkit.getConsoleSender().sendMessage(Main.prefix+"§cFailed to connect to MySQL.");
			}
		}
	}
	public static void disconnect () {
		
			try {
				con.close();;
				Bukkit.getConsoleSender().sendMessage(Main.prefix+"§aSuccessfully disconnected to MySQL.");				
			
			}catch(SQLException e) {
				Bukkit.getConsoleSender().sendMessage(Main.prefix+"§cFailed to disconnect to MySQL.");
			}
		
	}
	
	public static PreparedStatement getStatement(String sql) {
		if(isConnected()) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void setOnline(String server, int online) throws Exception{
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable(){
			   public void run(){
		    int online1 = Bukkit.getOnlinePlayers().size();
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE online SET player='"+online1+"'");
			ps.executeUpdate();
			}catch(SQLException e) {
				System.out.println("§c"+e);
			}
			   }
		   },0, 20 * 10);
		
		
		
			
	}
	public static void setColor(Player p, String color) throws Exception{
		
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE chatcolor SET chatcolor='"+color+"' WHERE playername='"+p.getName()+"'");
			ps.executeUpdate();
			}catch(SQLException e) {
				System.out.println("§c"+e);
			}
			   
	}
	
	
	public static String getColor(Player p){
		try {
		
			PreparedStatement ps = con.prepareStatement("SELECT chatcolor FROM chatcolor WHERE playername=?");
		ps.setString(1, p.getName());
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			
			return result.getString("chatcolor");
		}
		
		}catch(SQLException e) {
			System.out.println("§c"+e);
		}
		return "";
	
		
		
		
		
		   
}
	
	
	
	
	public static void insertColor(Player p) throws Exception{
		System.out.println("sa");
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO chatcolor (uuid, playername, chatcolor) VALUES('"+p.getUniqueId()+"'"+",'"+p.getName()+"','&f')");
		ps.execute();
		}catch(SQLException e) {
			System.out.println("§c"+e);
		}
		   }
	

	public static void insertBoard(Player p) throws Exception{
		

		    int online1 = Bukkit.getOnlinePlayers().size();
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO scoreboard  VALUES('"+p.getUniqueId()+"'"+",'"+p.getName()+"','maximize')");
			ps.execute();
			}catch(SQLException e) {
				System.out.println("§c"+e);
			}
			   }
	
	
	public static void updateBoard(Player p,String mode) throws Exception{
		

	    int online1 = Bukkit.getOnlinePlayers().size();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE scoreboard SET mode='"+mode+"' WHERE player='"+p.getName()+"'");
		ps.execute();
		}catch(SQLException e) {
			System.out.println("§c"+e);
		}
		   }
	
	public static boolean getBoard(Player p) throws Exception{
	
		String modee;
		try {
			
			rss = pss.executeQuery();
			
			
			 Bukkit.dispatchCommand(p, "sidebar "+mod.get(p));
		}catch(SQLException e) {
			System.out.println("§c"+e);
		}
		return false;
		   }
	
	public static ResultSet getResult(String sql) {
		if(isConnected()) {
			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = getStatement(sql);
				rs = ps.executeQuery();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
}

