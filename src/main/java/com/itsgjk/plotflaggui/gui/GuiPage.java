/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class GuiPage {

    private static ArrayList<GuiPage> guis;
    private String name;
    private int size;

    public GuiPage(String name, int size){
        this.name = name;
        this.size = size;
        guis.add(this);
    }

    public abstract void showToPlayer(Player p);

    public void registerClick(Player p, ItemStack item){
        //Check things like permission, item, etc before passing down to child class
        clicked(p, item);
    }

    public abstract void clicked(Player p, ItemStack item);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
