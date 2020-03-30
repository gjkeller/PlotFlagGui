/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.util;

import com.itsgjk.plotflaggui.PlotFlagGui;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Checks {
    public static boolean checkConsole(CommandSender sender){
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot run this command in console!");
            return false;
        }
        return true;
    }

    public static boolean checkPermission(CommandSender sender, String permission){
        if(sender instanceof Player){
            if(sender.hasPermission(permission)||sender.isOp()){
                return true;
            }
            else{
                sender.sendMessage(PlotFlagGui.getInstance().getLocaleManager().getMessage("no-permission"));
                return false;
            }
        }
        else{
            return true;
        }
    }
}
