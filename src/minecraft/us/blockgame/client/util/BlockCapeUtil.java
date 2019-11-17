package us.blockgame.client.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import net.minecraft.client.entity.AbstractClientPlayer;

public class BlockCapeUtil {

	 public static boolean cape(AbstractClientPlayer player) {
		 int lines = 0;
	        try {
	            URL url = new URL("http://blockgame.us/api/capes/" + player.getGameProfile().getId() + ".png");
	            URLConnection urlConnection = url.openConnection();
	            InputStream inputStream = urlConnection.getInputStream();
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            String line = null;
	            while ((line = bufferedReader.readLine()) != null) {
	                lines += 1;
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        System.out.print("Has cape? " + player + ": " + lines);
	        return lines != 0;
	    }
	
	
}
