/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.gui;

import com.itsgjk.plotflaggui.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GuiPage {

    private static ArrayList<GuiPage> guis;
    private HashMap<Player, Inventory> inventories;
    private String name;
    private int size;
    private GuiPage previousGui;

    public GuiPage(String name, int size, GuiPage previousGui){
        for(GuiPage gui : guis){
            if(gui.getName().equals(name)) throw new IllegalArgumentException("Multiple GUIs made with the same name");
        }

        this.name = name;
        this.size = size;
        this.previousGui = previousGui;
        guis.add(this);
    }

    public void showToPlayer(Player p){
        Inventory inv = createInventory();
        p.openInventory(createInventory());
        inventories.put(p, inv);
    }

    public void registerClick(Player p, ItemStack item){
        //Check things like permission, item, etc before passing down to child class
        if(item==null||item.getType()==Material.AIR) {
            playBadSound(p);
            return;
        }
        else if(item.getType()==Material.BARRIER){
            if(item.getItemMeta()!=null){
                if(item.getItemMeta().getDisplayName().contains("Previous")){
                    previousGui.showToPlayer(p);
                    return;
                }
                else if(item.getItemMeta().getDisplayName().contains("Exit")){
                    p.closeInventory();
                    return;
                }
            }
        }

        clicked(p, item);
    }

    public abstract Inventory rebuildInventory(Inventory inv);

    public Inventory createInventory(){
        rebuildInventory(Bukkit.createInventory(null, size, name));
    }

    public void playBadSound(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.5F, 1F);
    }

    public void playClickSound(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_TRIPWIRE_ATTACH, 0.5F, 1.5F);
    }

    public abstract void clicked(Player p, ItemStack item);

    private void setBackButton(){
        ItemStack backButton;
        if(previousGui==null){
            backButton = ItemUtil.createItem("&eExit", Material.BARRIER, "&7Leave the GUI.");
        }
        else{
            backButton = ItemUtil.createItem("&ePrevious", Material.BARRIER, "&7Go to the previous page.");
        }

        inv.setItem(0, backButton);
    }

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

    @Nullable
    public static GuiPage getGui(String name){
        for(GuiPage gui : guis){
            if(gui.getName().equals(name)) return gui;
        }

        return null;
    }
}
