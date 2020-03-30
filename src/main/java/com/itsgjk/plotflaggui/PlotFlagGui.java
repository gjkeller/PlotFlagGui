/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui;

import com.itsgjk.plotflaggui.commands.Command;
import com.itsgjk.plotflaggui.files.LocaleManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class PlotFlagGui extends JavaPlugin {

    private static PlotFlagGui instance;
    ArrayList<Command> commands;
    LocaleManager localeManager;

    @Override
    public void onEnable() {
        getLogger().info("Loading PlotFlagGui");
        instance = this;
        this.localeManager = new LocaleManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args){
        for(Command c : commands){
            if(c.getCommand().equalsIgnoreCase(label)||c.getAliases().contains(label)){
                c.execute(sender, args,label, convert(args), !(sender instanceof Player));
            }
        }

        return true;
    }

    private String convert(String[] args){
        if(args.length==0) return "";
        StringBuilder sb = new StringBuilder();
        for(String s : args){
            sb.append(s);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1).toString();
    }

    public LocaleManager getLocaleManager() {
        return localeManager;
    }

    public static PlotFlagGui getInstance() {
        return instance;
    }
}
