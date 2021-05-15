package Testing;

import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class M3UPlayer {
	public static void main(String[] args) {        
	    Player player = null;
	    try {
	    	URLConnection urlConnection = new URL ( "http://online.hitfm.ua/HitFM" ).openConnection ();
	    	urlConnection.connect ();
	    	
	        player = new Player(urlConnection.getInputStream ());
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }

	    try {
	        player.play();
	    } catch (JavaLayerException e) {
	        System.out.println(e.getMessage());
	    }   
	}
}
