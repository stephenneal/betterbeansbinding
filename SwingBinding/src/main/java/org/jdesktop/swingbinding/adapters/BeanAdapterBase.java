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
 * $Id: BeanAdapterBase.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.adapters;

import java.beans.*;


/**
 * @author Shannon Hickey
 */
public class BeanAdapterBase {
    protected final String property;
    private PropertyChangeSupport support;

    protected BeanAdapterBase(String property) {
        assert property != null;
        this.property = property.intern();
    }

    protected void listeningStarted() {
    }

    protected void listeningStopped() {
    }

    protected final boolean isListening() {
        return (support == null) ? false
                                 : (support.getPropertyChangeListeners().length > 0);
    }

    public final void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener == null) {
            return;
        }

        boolean wasListening = isListening();

        if (support == null) {
            support = new PropertyChangeSupport(this);
        }

        support.addPropertyChangeListener(listener);

        if (!wasListening) {
            listeningStarted();
        }
    }

    public final void removePropertyChangeListener(
        PropertyChangeListener listener) {
        if ((listener == null) || (support == null)) {
            return;
        }

        boolean wasListening = isListening();
        support.removePropertyChangeListener(listener);

        if (wasListening && !isListening()) {
            listeningStopped();
        }
    }

    public final PropertyChangeListener[] getPropertyChangeListeners() {
        if (support == null) {
            return new PropertyChangeListener[0];
        }

        return support.getPropertyChangeListeners();
    }

    public final void addPropertyChangeListener(String property,
        PropertyChangeListener listener) {
        if ((listener == null) || (property == null) ||
                (property.intern() != this.property)) {
            return;
        }

        boolean wasListening = isListening();

        if (support == null) {
            support = new PropertyChangeSupport(this);
        }

        support.addPropertyChangeListener(property, listener);

        if (!wasListening) {
            listeningStarted();
        }
    }

    public final void removePropertyChangeListener(String property,
        PropertyChangeListener listener) {
        if ((listener == null) || (support == null) || (property == null) ||
                (property.intern() != this.property)) {
            return;
        }

        boolean wasListening = isListening();
        support.removePropertyChangeListener(property, listener);

        if (wasListening && !isListening()) {
            listeningStopped();
        }
    }

    public final PropertyChangeListener[] getPropertyChangeListeners(
        String property) {
        if ((support == null) || (property == null) ||
                (property.intern() != this.property)) {
            return new PropertyChangeListener[0];
        }

        return support.getPropertyChangeListeners(property);
    }

    protected final void firePropertyChange(Object oldValue, Object newValue) {
        if (support == null) {
            return;
        }

        support.firePropertyChange(property, oldValue, newValue);
    }
}
