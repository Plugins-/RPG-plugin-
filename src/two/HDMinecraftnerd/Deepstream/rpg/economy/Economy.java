package two.HDMinecraftnerd.Deepstream.rpg.economy;

import java.io.File;
import java.io.IOException;

import two.HDMinecraftnerd.Deepstream.rpg.Main;

public class Economy {

	public static String dir = "RPG-plugin/";
	public static File accounts = new File(dir + "Accounts.rpg");

	public Economy(Main plugin){
		new PlayerListener(plugin);
		new File(dir).mkdir();
		if(!accounts.exists()){
			try{
				accounts.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		LoadSettings.loadSettings();
	}
}
