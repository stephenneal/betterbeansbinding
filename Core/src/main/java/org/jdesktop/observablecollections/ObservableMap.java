/***********************************************************************************************************************
 *
 * BetterBeansBinding - keeping JavaBeans in sync
 * ==============================================
 *
 * Copyright (C) 2009 by Tidalwave s.a.s. (http://www.tidalwave.it)
 * http://betterbeansbinding.kenai.com
 *
 * This is derived work from BeansBinding: http://beansbinding.dev.java.net
 * BeansBinding is copyrighted (C) by Sun Microsystems, Inc.
 *
 ***********************************************************************************************************************
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 ***********************************************************************************************************************
 *
 * $Id: ObservableMap.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.observablecollections;

import java.util.Map;


/**
 * A {@code Map} that notifies listeners of changes to the {@code Map}.
 *
 * @author sky
 */
public interface ObservableMap<K, V> extends Map<K, V> {
    /**
     * Adds a listener to this observable map.
     *
     * @param listener the listener to add
     */
    public void addObservableMapListener(ObservableMapListener listener);

    /**
     * Removes a listener from this observable map.
     *
     * @param listener the listener to remove
     */
    public void removeObservableMapListener(ObservableMapListener listener);
}
