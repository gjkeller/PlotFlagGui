/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import com.github.intellectualsites.plotsquared.plot.flag.GameModeFlag;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.itsgjk.plotflaggui.util.ItemUtil;
import com.sk89q.worldedit.world.gamemode.GameMode;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GamemodeFlagSelector extends FlagSelector {
    private static final ItemStack creative = ItemUtil.createItem(ChatColor.translateAlternateColorCodes('&', "&eCreative"), Material.BEDROCK,
            1);
    private static final ItemStack survival = ItemUtil.createItem(ChatColor.translateAlternateColorCodes('&', "&eSurvival"), Material.GRASS_BLOCK,
            1);
    private static final ItemStack adventure = ItemUtil.createItem(ChatColor.translateAlternateColorCodes('&', "&eAdventure"), Material.DIAMOND_SWORD,
            1);
    private static final ItemStack spectator = ItemUtil.createItem(ChatColor.translateAlternateColorCodes('&', "&eSpectator"), Material.BARRIER,
            1);

    public GamemodeFlagSelector(ItemStack topItem, GameModeFlag flag, Plot p) {
        super(topItem, parse(flag) , flag);
    }

    @Override
    public void clicked(Plot p) {
        GameModeFlag flag = (GameModeFlag)this.flag;

        GameMode newMode;
        switch(p.getFlag())

        p.setFlag(flag, );

        bottomItem = (parse(isTrue));
    }

    private static ItemStack parse(GameModeFlag flag){

    }
}
