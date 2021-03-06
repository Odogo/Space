package me.odogo.galactical.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.odogo.galactical.Core;

public class Galactical implements Listener, CommandExecutor {

	private Core plugin = Core.getPlugin(Core.class);
	private final String prefix = plugin.prefix;

	private String[] helpCommands = {
			ChatColor.YELLOW + "/galactical help" + ChatColor.LIGHT_PURPLE + " | " + ChatColor.GRAY + "Shows this list",
			ChatColor.YELLOW + "/galactical gui" + ChatColor.LIGHT_PURPLE + " | " + ChatColor.GRAY + "Opens a user friendly GUI for easy access",
			ChatColor.YELLOW + "/galactical stats <player>" + ChatColor.LIGHT_PURPLE + " | " + ChatColor.GRAY + "Shows the stats of another player",
			ChatColor.YELLOW + "/galactical radio [<on/off>] [<player>]" + ChatColor.LIGHT_PURPLE + " | " + ChatColor.GRAY + "Turns on the radio, this will change all messages you send in chat will be on the radiom, if enabled.",
	};

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("galactical")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;

				if(args.length <= 0) {

					player.sendMessage(prefix + ChatColor.GOLD + "Galactical was created by Odogo.");
					player.sendMessage(ChatColor.GOLD + "© All rights reserved.");
					player.sendMessage(ChatColor.GREEN + "Use '/galatical help' for the list of commands.");

				} else if(args.length == 1) {

					if(args[0].equalsIgnoreCase("help")) {
						player.sendMessage(helpCommands);
					} else if(args[0].equalsIgnoreCase("gui")) {
						//TODO Will make a method of setting the view of the GUI, later.
					} else if(args[0].equalsIgnoreCase("stats")) {
						//Requires the file-per-player system.
					} else if(args[0].equalsIgnoreCase("radio")) {
						//Requires the file-per-player system.
					}

				}

			} else {
				sender.sendMessage(prefix + ChatColor.RED + "Console cannot use command until a later update.");
			}
		}

		return true;
	}
}
