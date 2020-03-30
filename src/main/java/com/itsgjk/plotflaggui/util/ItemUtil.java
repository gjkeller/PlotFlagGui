/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemUtil {
    public static ItemStack createItem(String name, Material material, int amount, String... lore){
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        for(int i = 0; i < lore.length; i++){
            String current = lore[i];
            lore[i] = ChatColor.translateAlternateColorCodes('&', "&r" + current);
        }

        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(String name, Material material, String... lore){
        return createItem(name, material, 1, lore);
    }
}
