package de.bergtiger.piglingTrade;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

/**
 * @author Bergtiger
 */
public class Trade implements Listener {

	@EventHandler
	public void trade(EntityDropItemEvent e) {
		if(e.getEntityType().equals(EntityType.PIGLIN)) {
			e.setCancelled(true);
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), getItemOptimiert());
		}
	}
	
	/**
	 * Get ItemStack with probability of 1.16.1.
	 * https://minecraft.gamepedia.com/Bartering
	 * @return ItemStack
	 */
	private ItemStack getItemOptimiert() {
		int value = (int)(Math.random() * 459);
		System.out.println("value: " + value);
		if(value < 99) {
			// Quarz and below
			if(value < 39) {
				// Water Bottle and below
				if(value < 21) {
					// Splash Potion of Fire Resistance
					if(value < 5) {
						// Enchanted Book (Soul Speed 1-3)
						// amount 1
						// w 5
						ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
						EnchantmentStorageMeta meta = (EnchantmentStorageMeta)item.getItemMeta();
						meta.addStoredEnchant(Enchantment.SOUL_SPEED, (int)(Math.random() * 3 + 1), true);
						item.setItemMeta(meta);
						return item;
					} else if(value < 13) {
						// Iron Boots (Soul Speed 1-3)
						// amount 1
						// w 13
						ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
						item.addEnchantment(Enchantment.SOUL_SPEED, (int)(Math.random() * 3 + 1));
						return item;
					} else {
						// Splash Potion of Fire Resistance
						// amount 1
						// w 21
						ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
						PotionMeta meta = (PotionMeta)item.getItemMeta();
						meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 1), true);
						item.setItemMeta(meta);
						return item;
					}
				} else {
					// Potion of Fire Resistance
					if(value < 29) {
						// Potion of Fire Resistance
						// amount 1
						// w 29
						ItemStack item = new ItemStack(Material.POTION, 1);
						PotionMeta meta = (PotionMeta)item.getItemMeta();
						meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 1), true);
						item.setItemMeta(meta);
						return item;
					} else {
						// Water Bottle
						// amount 1
						// w 39
						ItemStack item = new ItemStack(Material.POTION, 1);
						PotionMeta meta = (PotionMeta)item.getItemMeta();
						meta.setBasePotionData(new PotionData(PotionType.WATER));
						item.setItemMeta(meta);
						return item;
					}
				}
			} else {
				// Iron Nugget and above
				if(value < 59) {
					// Ender Pearl and below
					if(value < 49) {
						// Iron Nugget
						// amount 10 - 36
						// w 49
						return new ItemStack(Material.IRON_NUGGET, (int)(Math.random() * 27 + 10));
					} else {
						// Ender Pearl
						// amount 2 - 4
						// w 59
						return new ItemStack(Material.ENDER_PEARL, (int)(Math.random() * 3 + 2));
					}
				} else {
					// String and above
					if(value < 79) {
						// String
						// amount 3 - 9
						// w 79
						return new ItemStack(Material.STRING, (int)(Math.random() * 7 + 3));
					} else {
						// Nether Quarz
						// amount 5 - 12
						// w 99
						return new ItemStack(Material.QUARTZ, (int)(Math.random() * 8 + 5));
					}
				}
			}
		} else {
			// Obsidian and above
			if(value < 299) {
				// Soul Sand and below
				if(value < 219) {
					// fire charge and below
					if(value < 139) {
						// Obsidian
						// amount 1
						// w 139
						return new ItemStack(Material.OBSIDIAN, 1);
					} else if(value < 179) {
						// Crying Obsidian
						// amount 1 - 3
						// w 179
						return new ItemStack(Material.CRYING_OBSIDIAN, (int)(Math.random() * 3 + 1));
					} else {
						// Fire Charge
						// amount 1
						// w 219
						return new ItemStack(Material.FIRE_CHARGE, 1);
					}
				} else {
					// leather and above
					if(value < 259) {
						// Leather
						// amount 2 - 4
						// w 259
						return new ItemStack(Material.LEATHER, (int)(Math.random() * 3 + 2));
					} else {
						// Soul Sand
						// amount 2 - 8
						// w 299
						return new ItemStack(Material.SOUL_SAND, (int)(Math.random() * 7 + 2));
					}
				}
			} else {
				// Nether Brick and above
				if(value < 379) {
					// Spectral Arrow and below
					if(value < 339) {
						// Nether Brick
						// amount 2 - 8
						// w 339
						return new ItemStack(Material.NETHER_BRICK, (int)(Math.random() * 7 + 2));
					} else {
						// Spectral Arrow
						// amount 6 - 12
						// w 379
						return new ItemStack(Material.SPECTRAL_ARROW, (int)(Math.random() * 7 + 6));
					}
				} else {
					// Gravel and above
					if(value < 419) {
						// Gravel
						// amount 8 - 16
						// w 419
						return new ItemStack(Material.GRAVEL, (int)(Math.random() * 9 + 8));
					} else {
						// Blackstone
						// amount 8 - 16
						// w 459
						return new ItemStack(Material.BLACKSTONE, (int)(Math.random() * 9 + 8));
					}
				}
			}
		}
	}
}
