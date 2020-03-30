/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.itsgjk.plotflaggui.util;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class PlotUtil {
    @Nullable
    public static Plot getPlot(Location location){
        int x = (int)location.getX();
        int y = (int)location.getY();
        int z = (int)location.getZ();
        com.github.intellectualsites.plotsquared.plot.object.Location loc = new com.github.intellectualsites.plotsquared.plot.object.Location(location.getWorld().getName(), x, y, z);
        Plot plot;
        try{
            plot = Plot.getPlot(loc);
        }
        catch(Exception ex){
            return null;
        }

        if(plot.getOwners()==null) return null;

        return plot;
    }
}
