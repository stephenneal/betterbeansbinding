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
 * $Id: ObservableList.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.observablecollections;

import java.util.List;


/**
 * A {@code List} that notifies listeners of changes.
 *
 * @author sky
 */
public interface ObservableList<E> extends List<E> {
    /**
     * Adds a listener that is notified when the list changes.
     *
     * @param listener the listener to add
     */
    public void addObservableListListener(ObservableListListener listener);

    /**
     * Removes a listener.
     *
     * @param listener the listener to remove
     */
    public void removeObservableListListener(ObservableListListener listener);

    /**
     * Returns {@code true} if this list sends out notification when
     * the properties of an element change. This method may be used
     * to determine if a listener needs to be installed on each of
     * the elements of the list.
     *
     * @return {@code true} if this list sends out notification when
     *         the properties of an element change
     */
    public boolean supportsElementPropertyChanged();
}
