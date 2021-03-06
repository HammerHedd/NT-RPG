package cz.neumimto.rpg.gui;

import cz.neumimto.core.ioc.IoC;
import cz.neumimto.rpg.NtRpgPlugin;
import cz.neumimto.rpg.commands.InfoCommand;
import cz.neumimto.rpg.configuration.Localization;
import cz.neumimto.rpg.inventory.data.InventoryItemMenuData;
import cz.neumimto.rpg.inventory.data.NKeys;
import cz.neumimto.rpg.players.groups.ConfigClass;
import cz.neumimto.rpg.players.groups.PlayerGroup;
import cz.neumimto.rpg.players.groups.PlayerGroupType;
import cz.neumimto.rpg.players.groups.Race;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ja on 29.12.2016.
 */
public class GuiHelper {

	
	private static NtRpgPlugin plugin;
	
	static {
		plugin = IoC.get().build(NtRpgPlugin.class);
	}
	
	public static Inventory createPlayerGroupView(PlayerGroup group) {
		Inventory.Builder builder = Inventory.builder();
		Inventory i = builder.of(InventoryArchetypes.DOUBLE_CHEST).build(plugin);
		i.query(new SlotPos(2, 2)).offer(createWeaponCommand(group));
		i.query(new SlotPos(3, 2)).offer(createArmorCommand(group));
		i.query(new SlotPos(2, 3)).offer(createAttributesCommand(group));
		i.query(new SlotPos(0, 0)).offer(createDescriptionItem(group.getDescription()));
		i.query(new SlotPos(2, 4)).offer(createInitialAttributesCommand(group));
		return i;
	}

	public static ItemStack createAttributesCommand(PlayerGroup group) {
		ItemStack i = ItemStack.of(ItemTypes.BOOK, 1);
		i.offer(NKeys.MENU_INVENTORY, true);
		i.offer(Keys.DISPLAY_NAME, Text.of(Localization.ATTRIBUTES, TextColors.DARK_RED));
		String cc = IoC.get().build(InfoCommand.class).getAliases().iterator().next();
		i.offer(new InventoryItemMenuData(cc+" attributes-initial " + group.getName()));
		return i;
	}

	public static ItemStack createDescriptionItem(String description) {
		ItemStack i = ItemStack.of(ItemTypes.PAPER, 1);
		i.offer(NKeys.MENU_INVENTORY, true);
		i.offer(Keys.DISPLAY_NAME, Text.of(""));
		i.offer(Keys.ITEM_LORE, Arrays.asList(Text.of(description, TextColors.GRAY)));
		return i;
	}

	public static ItemStack createArmorCommand(PlayerGroup group) {
		ItemStack i = ItemStack.of(ItemTypes.DIAMOND_SWORD, 1);
		i.offer(NKeys.MENU_INVENTORY, true);
		i.offer(Keys.DISPLAY_NAME, Text.of(Localization.WEAPONS, TextColors.DARK_RED));
		i.offer(Keys.ITEM_LORE, Arrays.asList(Text.of(Localization.WEAPONS_MENU_HELP, TextColors.GRAY)));
		i.offer(new InventoryItemMenuData("show armor " + group.getName()));
		return i;
	}

	public static ItemStack createWeaponCommand(PlayerGroup group) {
		ItemStack i = ItemStack.of(ItemTypes.DIAMOND_CHESTPLATE, 1);
		i.offer(NKeys.MENU_INVENTORY, true);
		i.offer(Keys.DISPLAY_NAME, Text.of(Localization.ARMOR, TextColors.DARK_RED));
		i.offer(Keys.ITEM_LORE, Arrays.asList(Text.of(Localization.ARMOR_MENU_HELP, TextColors.GRAY)));
		i.offer(new InventoryItemMenuData("show weapons " + group.getName()));
		return i;
	}

	public static List<Text> getItemLore(String s) {
		String[] a = s.split("\\n");
		List<Text> t = new ArrayList<>();
		for (String s1 : a) {
			t.add(Text.builder(s1).color(TextColors.GOLD).style(TextStyles.ITALIC).build());
		}
		return t;
	}

	public static ItemStack back(String command, String displayName) {
		ItemStack of = ItemStack.of(ItemTypes.PAPER, 1);
		of.offer(Keys.DISPLAY_NAME, Text.of(displayName, TextColors.WHITE));
		of.offer(new InventoryItemMenuData(command));
		return of;
	}

	public static ItemStack back(PlayerGroup g) {
		ItemStack of = ItemStack.of(ItemTypes.PAPER, 1);
		String l = "class";
		if (g.getPlayerGroupType() == PlayerGroupType.RACE) {
			l = "race";
		}
		of.offer(Keys.DISPLAY_NAME, Text.of(Localization.BACK, TextColors.WHITE));
		String c = IoC.get().build(InfoCommand.class).getAliases().get(0);
		of.offer(new InventoryItemMenuData(c + " " + l + " " + g.getName()));
		return of;
	}


	public static ItemStack createInitialAttributesCommand(PlayerGroup group) {
		ItemStack of = ItemStack.of(ItemTypes.BOOK, 1);
		of.offer(new InventoryItemMenuData("show attributes-initial " + group.getName()));
		return of;
	}
	
}
