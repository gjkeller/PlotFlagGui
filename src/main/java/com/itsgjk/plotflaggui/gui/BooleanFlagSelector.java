/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import com.github.intellectualsites.plotsquared.plot.flag.BooleanFlag;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.itsgjk.plotflaggui.PlotFlagGui;
import com.itsgjk.plotflaggui.util.ItemUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BooleanFlagSelector extends FlagSelector{

    private static final ItemStack off = ItemUtil.createItem(PlotFlagGui.getInstance().getLocaleManager().getMessage("false"), Material.RED_WOOL,
            1);
    private static final ItemStack on = ItemUtil.createItem(PlotFlagGui.getInstance().getLocaleManager().getMessage("true"), Material.LIME_WOOL,
            1);

    public BooleanFlagSelector(ItemStack topItem, BooleanFlag flag, Plot p) {
        super(topItem, parse(flag.isTrue(p)) , flag);
    }

    @Override
    public void clicked(Plot p) {
        BooleanFlag flag = (BooleanFlag)this.flag;
        boolean isTrue = !flag.isTrue(p);

        p.setFlag(flag, isTrue);

        bottomItem = (parse(isTrue));
    }

    private static ItemStack parse(boolean flag){
        if(flag){
            return on;
        }
        else{
            return off;
        }
    }
}
