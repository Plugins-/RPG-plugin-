package two.HDMinecraftnerd.Deepstream.rpg.economy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.entity.Player;

public class Accounting {

	public static boolean containsKey(Player player, File file) {
		Properties prop = new Properties();
		String playerName = player.getName();
		try{
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			if(prop.containsKey(playerName))
				return true;
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}

	public static void write(Player player, int startingBalance, File file) {
		Properties prop = new Properties();
		String startingB = (new Integer(startingBalance)).toString();
		String playerName = player.getName();
		try{
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			prop.setProperty(playerName, startingB);
			prop.store(new FileOutputStream(file), null);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static int getBalance(Player player, File file) {
		Properties prop = new Properties();
		String playerName = player.getName();
		try{
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			int balance = Integer.parseInt(prop.getProperty(playerName));
			return balance;
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}

}
