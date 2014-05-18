package two.HDMinecraftnerd.Deepstream.rpg.economy;


public class LoadSettings {
	static int startingBalance;
	static String currency;
	
	public static void loadSettings(){
		String propertiesFile = Economy.dir + "EconomySettings.properties";
		PluginProperties properties = new PluginProperties(propertiesFile);
		properties.load();

		startingBalance = properties.getInteger("Starting-balance", 1000);
		currency = properties.getString("Currency", "Coins");
		properties.save("--->RPG-plugin Main Economy Settings<---", propertiesFile);
	}
	
}
