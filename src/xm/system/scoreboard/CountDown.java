package xm.system.scoreboard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;



public class CountDown {
	public static ArrayList<String> frozen = new ArrayList<String>();
        static int minutes = 4;
        static int seconds = 60;
        static int count;
        static int teleportgame;
        static int i = 0;
        static Player p;
        public static int sayac=0;
        public static void CountDown(){
                count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
                       
                        @SuppressWarnings("unused")
						@Override
                        public void run() {
                        	if(Bukkit.getOnlinePlayers().size()>=1) {
                                if(seconds > 0){
                                	seconds--;
                                	 if (String.valueOf(GameState.statee)=="LiveGame") {
                                		
                                		
                                		
                                		 if(minutes==4 && seconds==59) {
                                			
                                		}
                                		
                                		else if(minutes==4 && seconds==0) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e4�8] �cminutes until the chest refill!");
                                		}
                                		else if(minutes==3 && seconds==0) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e3�8] �cminutes until the chest refill!");
                                		}
                                		else if(minutes==2 && seconds==0) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e2�8] �cminutes until the chest refill!");
                                		}

                                		else if (minutes==0 && seconds == 58) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e60�8] �cseconds until the chest refill!");	
                                		}
                                		else if (minutes==0 && seconds == 29) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e30�8] �cseconds until the chest refill!");	
                                		}
                                		else if (minutes==0 && seconds == 14) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e15�8] �cseconds until the chest refill!");	
                                		}
                                		else if (minutes==0 && seconds == 9) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e10�8] �cseconds until the chest refill!");	
                                		}
                                		else if (minutes==0 && seconds == 5) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e5�8] �cseconds until the chest refill!");	
                                			
                                		}
                                		else if (minutes==0 && seconds == 4) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e4�8] �cseconds until the chest refill!");	
                                			
                                		}
                                		else if (minutes==0 && seconds == 3) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e3�8] �cseconds until the chest refill!");	
                                			
                                		}
                                		else if (minutes==0 && seconds == 2) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e2�8] �cseconds until the chest refill!");	
                                			
                                		}
                                		else if (minutes==0 && seconds == 1) {
                                			Bukkit.broadcastMessage(Main.prefix+"�8[�e1�8] �cseconds until the chest refill!");	
                                			
                                		}
                                		else if (minutes==0 && seconds==0) {
                                			GameState.setState(GameState.LiveGame);
                                    		minutes=5;
                                         	seconds=0;
                                         	for(Player all: Bukkit.getOnlinePlayers()) {
                               				 InteractListener.fillChests(all);
                               				 InteractListener.filltier1Chests(all);
                               			 }
                               			 Bukkit.broadcastMessage(Main.prefix+"�3Sponsors have refilled the chests!");
                               			 Bukkit.broadcastMessage(Main.prefix+"�fThe tributes have passed:");
                                         	
                                           
                                		}
                                		}
                                		
                                	
                                	
                                	
                                	}else {
                                    	minutes=minutes-1;
                                    	seconds=59;
                                    }
                                	}
                                
                                
                                
                        	
                                	
                                
                        
                               
                        }      
                        
                }, 0L, 20L);
                
        }
       
        public static void Finish(){
                GameState.setState(GameState.LiveGame);
    			minutes=0;
             	seconds=31;
             	
                
        }
        public static void PreGame() {
        	minutes=0;
         	seconds=31;
         	Bukkit.broadcastMessage(Main.prefix+"�eMap name�8: �2"+Main.mapname);
         	Bukkit.broadcastMessage(Main.prefix+"�eMap author�8: �2<none>");
         	Bukkit.broadcastMessage(Main.prefix+"�eMap link�8: �2http://bit.ly/190dGBx");
         	Bukkit.broadcastMessage(Main.prefix+"�cPlease wait �8[�e30�8] �cseconds before the games begin.");
         	Bukkit.broadcastMessage(Main.prefix+"�8[�e30�8] �cseconds until the games begin.");
         	
         	
        }
       
        
       
        
      
        
   
        
        

}
       
