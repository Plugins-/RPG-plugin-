package two.HDMinecraftnerd.Deepstream.rpg.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import two.HDMinecraftnerd.Deepstream.rpg.Main;

public class ClassSelectorEvent implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	private Inventory inv;
	private String invName = "Class Selector";
	
	public ClassSelectorEvent(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		inv = Bukkit.createInventory(null, 9, invName);
	}
	
	private void gui(){
		ItemStack mageIS = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta mageMeta = mageIS.getItemMeta();
		
		mageMeta.setDisplayName(ChatColor.DARK_PURPLE + "Mage");
		mageIS.setItemMeta(mageMeta);
		
		inv.setItem(4, mageIS);
		
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player player = (Player)e.getPlayer();
		
		if(e.getItem().containsEnchantment(Enchantment.DURABILITY) && e.getMaterial().equals(Material.PAPER)){
			gui();
			player.openInventory(inv);
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player player = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equals(invName)){
			switch(e.getCurrentItem().getType()){
			case ENCHANTED_BOOK:
				player.closeInventory();
				player.sendMessage(ChatColor.GOLD + "[RPG-Plugin] You've selected Mage!");
				break;
			default:
				player.sendMessage(ChatColor.RED + "[RPG-Plugin] You didn't select anything there :(");
				break;
			}
		}
	}
	
	@EventHandler
	public void onInventoryClicked(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		if(player.getInventory().getItemInHand().getType().equals(Material.NAME_TAG)){
			ItemStack nt = player.getInventory().getItemInHand();
			ItemMeta ntMeta = nt.getItemMeta();
			ntMeta.setDisplayName(ntMeta.getDisplayName().replace("¤", "§"));
			nt.setItemMeta(ntMeta);
			player.setItemInHand(nt);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		
		ItemStack paperIS = new ItemStack(Material.PAPER);
		ItemMeta paperMeta = paperIS.getItemMeta();
		
		paperMeta.setDisplayName(ChatColor.AQUA + "Class Selector");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.LIGHT_PURPLE + "Use this item to select your class");
		paperMeta.setLore(lore);
		paperMeta.addEnchant(Enchantment.DURABILITY, 0, false);
		paperIS.setItemMeta(paperMeta);
		
		if(!player.getInventory().contains(paperIS)){
			player.getInventory().addItem(paperIS);
		}
		
	}
	
}
