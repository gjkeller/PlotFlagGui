/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.commands;

import com.github.intellectualsites.plotsquared.plot.flag.Flags;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.itsgjk.plotflaggui.PlotFlagGui;
import com.itsgjk.plotflaggui.util.Checks;
import com.itsgjk.plotflaggui.util.PlotUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class FlagsCommand extends Command {

    public FlagsCommand(PlotFlagGui plugin) {
        super(plugin, "flags", new String[] {}, "Opens a GUI for the plot's flags!", "plotflaggui.flags");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args, String label, String fullCommand, boolean isConsole) {
        if(!Checks.checkConsole(sender)) return true;
        if(!Checks.checkPermission(sender, permission)) return true;

        Player player = (Player)sender;
        Plot plot = PlotUtil.getPlot(player.getLocation());

        if(plot==null){
            plugin.getLocaleManager().getMessage("not-in-plot");
            return true;
        }

        if(!plot.getOwners().contains(player.getUniqueId())||!plot.getTrusted().contains(player.getUniqueId())){
            plugin.getLocaleManager().getMessage("not-trusted-on-plot");
            return true;
        }


        plot.getFlag(Flags.BREAK.)

        return true;
    }

    private void openGui(Player p){

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }
}
