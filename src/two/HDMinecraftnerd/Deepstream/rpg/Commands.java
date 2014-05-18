package two.HDMinecraftnerd.Deepstream.rpg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import two.HDMinecraftnerd.Deepstream.rpg.economy.EconCommands;

public class Commands {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		EconCommands ecmd = new EconCommands();
		return ecmd.onCommand(sender, cmd, label, args);
	}
	
}
