package com.badbones69.crazycrates.paper.commands.crates.types.player;

import com.badbones69.crazycrates.paper.tasks.menus.CrateMainMenu;
import com.badbones69.crazycrates.paper.api.enums.Messages;
import com.badbones69.crazycrates.paper.commands.crates.types.BaseCommand;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotations.Command;
import org.bukkit.entity.Player;
import com.badbones69.crazycrates.core.config.impl.ConfigKeys;

public class CommandHelp extends BaseCommand {
    @Command("help")
    @Permission(value = "crazycrates.help")
    public void help(Player player) {
        if (this.config.getProperty(ConfigKeys.enable_crate_menu)) {
            new CrateMainMenu(
                    player,
                    this.config.getProperty(ConfigKeys.inventory_name),
                    this.config.getProperty(ConfigKeys.inventory_rows)
            ).open();

            return;
        }

        if (player.hasPermission("crazycrates.admin")) {
            // this has to use sendRichMessage as it is a list.
            Messages.admin_help.sendRichMessage(player);

            return;
        }

        // this has to use sendRichMessage as it is a list.
        Messages.help.sendRichMessage(player);
    }
}