/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.commands;

import com.itsgjk.plotflaggui.PlotFlagGui;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class Command implements TabCompleter {
    PlotFlagGui plugin;
    String command, description, permission;
    List<String> aliases;

    Command(PlotFlagGui plugin, String command, String[] aliases, String description, String permission){
        this.plugin = plugin;
        this.command = command;
        this.aliases = Arrays.asList(aliases);
        this.description = description;
        this.permission = permission;
    }

    public abstract boolean execute(CommandSender sender, String[] args, String label, String fullCommand, boolean isConsole);

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }
}
