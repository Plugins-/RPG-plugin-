package two.HDMinecraftnerd.Deepstream.rpg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import two.HDMinecraftnerd.Deepstream.rpg.event.InventoryEvent;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new InventoryEvent(this);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Commands cmd = new Commands();
		return cmd.onCommand(sender, command, label, args);
	}
	
}
