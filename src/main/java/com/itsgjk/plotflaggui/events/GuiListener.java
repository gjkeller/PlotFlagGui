/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.events;

import com.itsgjk.plotflaggui.PlotFlagGui;
import com.itsgjk.plotflaggui.gui.GuiPage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiListener implements Listener {
    PlotFlagGui plugin;

    public GuiListener(PlotFlagGui plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGuiClick(InventoryClickEvent e){
        GuiPage gui = GuiPage.getGui(e.getView().getTitle());
        if(gui!=null&&e.getWhoClicked() instanceof Player){
            gui.registerClick((Player)e.getWhoClicked(), e.getCurrentItem());
        }
    }
}
