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
 * $Id: AbstractButtonAdapterProvider.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.adapters;

import org.jdesktop.beansbinding.ext.BeanAdapterProvider;

import java.awt.event.*;

import java.beans.*;

import javax.swing.*;


/**
 * @author Shannon Hickey
 */
public final class AbstractButtonAdapterProvider implements BeanAdapterProvider {
    private static final String SELECTED_P = "selected";

    public boolean providesAdapter(Class<?> type, String property) {
        return AbstractButton.class.isAssignableFrom(type) &&
        (property.intern() == SELECTED_P);
    }

    public Object createAdapter(Object source, String property) {
        if (!providesAdapter(source.getClass(), property)) {
            throw new IllegalArgumentException();
        }

        return new Adapter((AbstractButton) source);
    }

    public Class<?> getAdapterClass(Class<?> type) {
        return AbstractButton.class.isAssignableFrom(type)
        ? AbstractButtonAdapterProvider.Adapter.class : null;
    }

    public static final class Adapter extends BeanAdapterBase {
        private AbstractButton button;
        private Handler handler;
        private boolean cachedSelected;

        private Adapter(AbstractButton button) {
            super(SELECTED_P);
            this.button = button;
        }

        public boolean isSelected() {
            return button.isSelected();
        }

        public void setSelected(boolean selected) {
            button.setSelected(selected);
        }

        protected void listeningStarted() {
            handler = new Handler();
            cachedSelected = isSelected();
            button.addItemListener(handler);
            button.addPropertyChangeListener("model", handler);
        }

        protected void listeningStopped() {
            button.removeItemListener(handler);
            button.removePropertyChangeListener("model", handler);
            handler = null;
        }

        private class Handler implements ItemListener, PropertyChangeListener {
            private void buttonSelectedChanged() {
                boolean oldSelected = cachedSelected;
                cachedSelected = isSelected();
                firePropertyChange(oldSelected, cachedSelected);
            }

            public void itemStateChanged(ItemEvent ie) {
                buttonSelectedChanged();
            }

            public void propertyChange(PropertyChangeEvent pe) {
                buttonSelectedChanged();
            }
        }
    }
}
