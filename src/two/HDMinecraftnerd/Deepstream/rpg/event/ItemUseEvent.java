package two.HDMinecraftnerd.Deepstream.rpg.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import two.HDMinecraftnerd.Deepstream.rpg.Main;

public class ItemUseEvent implements Listener{

	public ItemUseEvent(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player player = (Player)e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(player.getItemInHand().getType() == Material.NETHER_STAR){
				player.launchProjectile(WitherSkull.class);
			}
		}
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		for(int i = 0; i < 4; i++){
			e.setLine(i, e.getLine(i).replace("¤", "§"));
		}
	}
	
}
