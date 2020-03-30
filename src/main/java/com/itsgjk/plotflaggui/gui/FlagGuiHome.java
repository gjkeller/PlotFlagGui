/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FlagGuiHome extends GuiPage {
    public FlagGuiHome() {
        super("Plot Flags", 2*9, null);
    }

    @Override
    public void clicked(Player p, ItemStack item) {

    }
}
