/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.files;

import com.itsgjk.plotflaggui.PlotFlagGui;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class ConfigManager {
    private PlotFlagGui plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;
    private String configName;

    public ConfigManager(PlotFlagGui plugin, String configName){
        this.plugin = plugin;
        this.configName = configName;
        saveDefaultConfig(); //saves/initializes config
    }

    public void reloadConfig(){
        if(this.configFile == null){
            this.configFile = new File(this.plugin.getDataFolder(), configName);
        }

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource(configName);
        if(defaultStream!=null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig(){
        if(this.dataConfig==null) reloadConfig();

        return this.dataConfig;
    }

    public void saveConfig(){
        if(this.dataConfig == null || this.configFile == null) return;

        try{
            getConfig().save(this.configFile);
        }
        catch(IOException ex){
            plugin.getLogger().log(Level.SEVERE, "Could not save to config " + this.configFile, ex);
        }
    }

    public void saveDefaultConfig(){
        if(this.configFile==null){
            this.configFile = new File(plugin.getDataFolder(), configName);
        }

        if(!this.configFile.exists()){
            this.plugin.saveResource(configName, false);
        }
    }
}
