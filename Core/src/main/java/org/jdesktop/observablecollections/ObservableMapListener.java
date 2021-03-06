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
 * $Id$
 *
 **********************************************************************************************************************/
package org.jdesktop.observablecollections;


/**
 * Notification types from an {@code ObservableMap}.
 *
 * @author sky
 */
public interface ObservableMapListener {
    /**
     * Notification that the value of an existing key has changed.
     *
     * @param map the {@code ObservableMap} that changed
     * @param key the key
     * @param lastValue the previous value
     */
    public void mapKeyValueChanged(ObservableMap map, Object key,
        Object lastValue);

    /**
     * Notification that a key has been added.
     *
     * @param map the {@code ObservableMap} that changed
     * @param key the key
     */
    public void mapKeyAdded(ObservableMap map, Object key);

    /**
     * Notification that a key has been removed
     *
     * @param map the {@code ObservableMap} that changed
     * @param key the key
     * @param value value for key before key was removed
     */
    public void mapKeyRemoved(ObservableMap map, Object key, Object value);

    // PENDING: should we special case clear?
}
