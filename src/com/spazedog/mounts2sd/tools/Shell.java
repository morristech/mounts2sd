/*
 * This file is part of the Mounts2SD Project: https://github.com/spazedog/mounts2sd
 *  
 * Copyright (c) 2013 Daniel Bergløv
 *
 * Mounts2SD is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Mounts2SD is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Mounts2SD. If not, see <http://www.gnu.org/licenses/>
 */

package com.spazedog.mounts2sd.tools;

import com.spazedog.lib.rootfw.RootFW;

public class Shell {
	/** 
     * This is a static placeholder for the shell connection.
	 * From here we can reuse the same connection from everywhere in the app
	 * without having it reconnect and spam the user with superuser toasts.
	 */
	public static RootFW connection = new RootFW(true);

    static {
        /* Make sure that either our busybox or the ROM's has first priority above possible existing /sbin */
        try {
        	connection.shell.execute("PATH=/data/local:/system/xbin:$PATH");
        	
        } catch(Throwable e) {}
    }
}
