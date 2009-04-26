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
 * $Id: ObservableListListener.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.observablecollections;

import java.util.EventListener;
import java.util.List;


/**
 * Notification types from an {@code ObservableList}.
 *
 * @author sky
 */
public interface ObservableListListener extends EventListener {
    /**
     * Notification that elements have been added to the list.
     *
     * @param list the {@code ObservableList} that has changed
     * @param index the index the elements were added to
     * @param length the number of elements that were added
     */
    public void listElementsAdded(ObservableList list, int index, int length);

    /**
     * Notification that elements have been removed from the list.
     *
     * @param list the {@code ObservableList} that has changed
     * @param index the starting index the elements were removed from
     * @param oldElements a list containing the elements that were removed.
     */
    public void listElementsRemoved(ObservableList list, int index,
        List oldElements);

    /**
     * Notification that an element has been replaced by another in the list.
     *
     * @param list the {@code ObservableList} that has changed
     * @param index the index of the element that was replaced
     * @param oldElement the element at the index before the change
     */
    public void listElementReplaced(ObservableList list, int index,
        Object oldElement);

    /**
     * Notification than a property of an element in this list has changed.
     * Not all {@code ObservableLists} support this notification. Only
     * observable lists that return {@code true} from
     * {@code supportsElementPropertyChanged} send this notification.
     *
     * @param list the {@code ObservableList} that has changed
     * @param index the index of the element that changed
     */
    public void listElementPropertyChanged(ObservableList list, int index);
}
