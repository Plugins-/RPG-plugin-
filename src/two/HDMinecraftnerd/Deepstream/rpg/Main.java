package two.HDMinecraftnerd.Deepstream.rpg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import two.HDMinecraftnerd.Deepstream.rpg.economy.Economy;
import two.HDMinecraftnerd.Deepstream.rpg.event.ClassSelectorEvent;
import two.HDMinecraftnerd.Deepstream.rpg.event.ItemUseEvent;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new ClassSelectorEvent(this);
		new ItemUseEvent(this);
		new Economy(this);
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
