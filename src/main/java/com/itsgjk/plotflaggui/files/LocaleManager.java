/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.files;

import com.itsgjk.plotflaggui.PlotFlagGui;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class LocaleManager {

    PlotFlagGui plugin;
    ConfigManager config;
    Map<String, String> loadedLocale;

    public LocaleManager(PlotFlagGui plugin){
        this.plugin = plugin;
        this.config = new ConfigManager(plugin, "locale.yml");

        Map<String, Object> vals = config.getConfig().getDefaultSection().getValues(false);
        for(String key : vals.keySet()){
            loadedLocale.put(key, ChatColor.translateAlternateColorCodes('&', vals.get(key).toString()));
        }
    }

    public String getMessage(String path){
        return loadedLocale.get(path);
    }
}
