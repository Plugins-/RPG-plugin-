package two.HDMinecraftnerd.Deepstream.rpg.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconCommands {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("money")){
			boolean hasAccount = Accounting.containsKey(player, Economy.accounts);
			if(!hasAccount){
				int startingBalance = LoadSettings.startingBalance;
				Accounting.write(player, startingBalance, Economy.accounts);
			}else if(args.length < 1){
				int balance = Accounting.getBalance(player, Economy.accounts);
				player.sendMessage(ChatColor.GOLD + "[RPG-Econ] You have currently got " + balance + " " + LoadSettings.currency);
			}
		}else if(cmd.getName().equalsIgnoreCase("pay")){
			if(args.length == 2){
				Player reciver = Bukkit.getPlayer(args[0]);
				if(reciver == null){
					player.sendMessage(ChatColor.RED + "[RPG-Econ] That reciver doesn't exist.");
				}else{
					boolean hasAccount = Accounting.containsKey(player, Economy.accounts);
					if(!hasAccount){
						int startingBalance = LoadSettings.startingBalance;
						Accounting.write(player, startingBalance, Economy.accounts);
					}else{
						boolean reciverHasAccount = Accounting.containsKey(reciver, Economy.accounts);
						if(!reciverHasAccount){
							int startingBalance = LoadSettings.startingBalance;
							Accounting.write(reciver, startingBalance, Economy.accounts);
						}else{
							int amount = Integer.parseInt(args[1]);
							int balance = Accounting.getBalance(player, Economy.accounts);
							int recBalance = Accounting.getBalance(reciver, Economy.accounts);
							if(amount > 0){
								if(amount >= balance){
									Accounting.write(player, balance - amount, Economy.accounts);
									Accounting.write(reciver, recBalance + amount, Economy.accounts);
									player.sendMessage(ChatColor.GOLD + "[RPG-Econ] " + ChatColor.GREEN + "Successfully transfered " + amount + " " + LoadSettings.currency + " to " + reciver.getName());
									reciver.sendMessage(ChatColor.GOLD + "[RPG-Econ] " + ChatColor.GREEN + "Successfully transfered " + amount + " " + LoadSettings.currency + " from " + player.getName());
								}
							}
						}
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "[RPG-Econ] Unknown syntax! { Usage: /pay <reciver> <amount> }");
			}
		}
		return true;
	}
	
}
