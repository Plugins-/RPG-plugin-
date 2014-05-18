package two.HDMinecraftnerd.Deepstream.rpg.economy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import two.HDMinecraftnerd.Deepstream.rpg.Main;

public class PlayerListener implements Listener{

	public PlayerListener(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		int startingBalance = LoadSettings.startingBalance;
		boolean hasAccount = Accounting.containsKey(player, Economy.accounts);
		if(!hasAccount){
			Accounting.write(player, startingBalance, Economy.accounts);
		}
	}
	
}
