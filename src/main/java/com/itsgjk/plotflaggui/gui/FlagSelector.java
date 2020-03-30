/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import com.github.intellectualsites.plotsquared.plot.flag.Flag;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import org.bukkit.inventory.ItemStack;

public abstract class FlagSelector {
    ItemStack topItem;
    ItemStack bottomItem;
    Flag flag;

    public FlagSelector(ItemStack topItem, ItemStack bottomItem, Flag flag) {
        this.topItem = topItem;
        this.bottomItem = bottomItem;
        this.flag = flag;
    }

    public abstract void clicked(Plot p);

    public ItemStack getTopItem() {
        return topItem;
    }

    public void setTopItem(ItemStack topItem) {
        this.topItem = topItem;
    }

    public ItemStack getBottomItem() {
        return bottomItem;
    }

    public void setBottomItem(ItemStack bottomItem) {
        this.bottomItem = bottomItem;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
