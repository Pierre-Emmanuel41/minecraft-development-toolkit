package fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode;

import org.bukkit.GameRule;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.impl.MinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftmanagers.EColor;
import fr.pederobien.minecraftmanagers.MessageManager.DisplayOption;
import fr.pederobien.minecraftmanagers.WorldManager;

public interface ICodeSender {

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	IMinecraftNotificationCenter getNotificationCenter();

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has
	 * been set to false, then no message is sent.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color,
			Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event((Player) sender, code, displayOption, isItalic, isBold, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has
	 * been set to false, then no message is sent.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event((Player) sender, code, displayOption, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has
	 * been set to false, then no message is sent.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event((Player) sender, code, displayOption, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has
	 * been set to false, then no message is sent.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   Used as key to get the right message in the right dictionary.
	 * @param color  The message color.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(CommandSender sender, IMinecraftMessageCode code, EColor color, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event((Player) sender, code, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has
	 * been set to false, then no message is sent.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   Used as key to get the right message in the right dictionary.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event((Player) sender, code, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method is
	 * synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has been set to false, then no
	 * message is sent. The permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color, Object... args) {
		if (WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event(code, displayOption, isItalic, isBold, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method is
	 * synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has been set to false, then no
	 * message is sent. The permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		if (WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event(code, displayOption, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method is
	 * synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has been set to false, then no
	 * message is sent. The permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		if (WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event(code, displayOption, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method is
	 * synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has been set to false, then no
	 * message is sent. The permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code  Used as key to get the right message in the right dictionary.
	 * @param color The message color.
	 * @param args  Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(IMinecraftMessageCode code, EColor color, Object... args) {
		if (WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event(code, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method is
	 * synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if the game rule has been set to false, then no
	 * message is sent. The permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code Used as key to get the right message in the right dictionary.
	 * @param args Some arguments (optional) used for dynamic messages.
	 */
	public default void sendSynchro(IMinecraftMessageCode code, Object... args) {
		if (WorldManager.OVERWORLD.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))
			send(event(code, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color,
			Object... args) {
		if (sender instanceof Player)
			send(event((Player) sender, code, displayOption, isItalic, isBold, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		if (sender instanceof Player)
			send(event((Player) sender, code, displayOption, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false.
	 * 
	 * @param sender        Generally a player, it is used to get a message in his language.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(CommandSender sender, IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		if (sender instanceof Player)
			send(event((Player) sender, code, displayOption, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   Used as key to get the right message in the right dictionary.
	 * @param color  The message color.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(CommandSender sender, IMinecraftMessageCode code, EColor color, Object... args) {
		if (sender instanceof Player)
			send(event((Player) sender, code, color, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		if (sender instanceof Player)
			send(event((Player) sender, code, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method send a
	 * message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false. The permission associate to the given
	 * code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color, Object... args) {
		send(event(code, displayOption, isItalic, isBold, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method send a
	 * message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false. The permission associate to the given
	 * code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		send(event(code, displayOption, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method send a
	 * message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false. The permission associate to the given
	 * code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		send(event(code, displayOption, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method send a
	 * message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false. The permission associate to the given
	 * code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code  Used as key to get the right message in the right dictionary.
	 * @param color The message color.
	 * @param args  Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(IMinecraftMessageCode code, EColor color, Object... args) {
		send(event(code, color, args));
	}

	/**
	 * First create an {@link IMinecraftMessageEvent} that is used to get messages into registered dictionaries. This method send a
	 * message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is set to false. The permission associate to the given
	 * code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code The code used to get the translation of the message in the player's language.
	 * @param args Some arguments (optional) used for dynamic messages.
	 */
	public default void sendNotSynchro(IMinecraftMessageCode code, Object... args) {
		send(event(code, args));
	}

	/**
	 * Get a message corresponding to the given message code.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The message associated to the specified code. If the sender is not a player, then it returns an empty string.
	 */
	public default String getMessage(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		return sender instanceof Player ? getNotificationCenter().getDictionaryContext().getMessage(event((Player) sender, code, args)) : "";
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code.
	 * 
	 * @param player        Used to get its local.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(Player player, IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color,
			Object... args) {
		return new MinecraftMessageEvent(player, code, displayOption, isItalic, isBold, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code.
	 * 
	 * @param player        Used to get its local.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(Player player, IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		return new MinecraftMessageEvent(player, code, displayOption, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code.
	 * 
	 * @param player        Used to get its local.
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(Player player, IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		return new MinecraftMessageEvent(player, code, displayOption, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code.
	 * 
	 * @param player Used to get its local.
	 * @param code   Used as key to get the right message in the right dictionary.
	 * @param color  The message color.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(Player player, IMinecraftMessageCode code, EColor color, Object... args) {
		return new MinecraftMessageEvent(player, code, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code.
	 * 
	 * @param player Used to get its local.
	 * @param code   Used as key to get the right message in the right dictionary.
	 * @param args   Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(Player player, IMinecraftMessageCode code, Object... args) {
		return new MinecraftMessageEvent(player, code, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code. The
	 * permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param isItalic      If the message should be displayed in italic.
	 * @param isBold        If the message should be displayed in bold.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(IMinecraftMessageCode code, DisplayOption displayOption, boolean isItalic, boolean isBold, EColor color, Object... args) {
		return new MinecraftMessageEvent(code, displayOption, isItalic, isBold, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code. The
	 * permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param color         The message color.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(IMinecraftMessageCode code, DisplayOption displayOption, EColor color, Object... args) {
		return new MinecraftMessageEvent(code, displayOption, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code. The
	 * permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code          Used as key to get the right message in the right dictionary.
	 * @param displayOption The place where the message should be displayed on player screen.
	 * @param args          Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(IMinecraftMessageCode code, DisplayOption displayOption, Object... args) {
		return new MinecraftMessageEvent(code, displayOption, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code. The
	 * permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code  Used as key to get the right message in the right dictionary.
	 * @param color The message color.
	 * @param args  Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(IMinecraftMessageCode code, EColor color, Object... args) {
		return new MinecraftMessageEvent(code, color, args);
	}

	/**
	 * Create a message event. This event is used to be send to a dictionary to get the translation associated to the given code. The
	 * permission associate to the given code should be different from {@link Permission#SENDER}.
	 * 
	 * @param code Used as key to get the right message in the right dictionary.
	 * @param args Some arguments (optional) used for dynamic messages.
	 * 
	 * @return A message event based on the given parameter.
	 */
	public default IMinecraftMessageEvent event(IMinecraftMessageCode code, Object... args) {
		return new MinecraftMessageEvent(code, args);
	}

	/**
	 * Send a message based on the given event.
	 * 
	 * @param event The event that contains the message to send and its modifiers (italic, bold, color).
	 */
	public default void send(IMinecraftMessageEvent event) {
		getNotificationCenter().sendMessage(event);
	}
}
