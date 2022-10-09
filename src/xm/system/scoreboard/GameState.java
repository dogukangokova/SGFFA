package xm.system.scoreboard;



public enum GameState
{
  LiveGame;
  
	  public static GameState statee;
	  
	  private GameState() {}
	  
	  public static GameState getState()
	  {
	    return statee;
	  }
	  
	  public static void setState(GameState state)
	  {
	    statee = state;
	  }
	  
	  public static boolean isStates(GameState... states)
	  {
	    for (GameState s : states) {
	      if (getState() == s) {
	        return true;
	      }
	    }
	    return false;
	  }
}