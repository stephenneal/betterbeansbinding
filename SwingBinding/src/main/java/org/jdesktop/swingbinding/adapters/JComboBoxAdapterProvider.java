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
 * $Id: JComboBoxAdapterProvider.java 60 2009-04-26 20:47:20Z fabriziogiudici $
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
public final class JComboBoxAdapterProvider implements BeanAdapterProvider {
    private static final String SELECTED_ITEM_P = "selectedItem";

    public boolean providesAdapter(Class<?> type, String property) {
        return JComboBox.class.isAssignableFrom(type) &&
        (property.intern() == SELECTED_ITEM_P);
    }

    public Object createAdapter(Object source, String property) {
        if (!providesAdapter(source.getClass(), property)) {
            throw new IllegalArgumentException();
        }

        return new Adapter((JComboBox) source);
    }

    public Class<?> getAdapterClass(Class<?> type) {
        return JList.class.isAssignableFrom(type)
        ? JComboBoxAdapterProvider.Adapter.class : null;
    }

    public static final class Adapter extends BeanAdapterBase {
        private JComboBox combo;
        private Handler handler;
        private Object cachedItem;

        private Adapter(JComboBox combo) {
            super(SELECTED_ITEM_P);
            this.combo = combo;
        }

        public Object getSelectedItem() {
            return combo.getSelectedItem();
        }

        public void setSelectedItem(Object item) {
            combo.setSelectedItem(item);
        }

        protected void listeningStarted() {
            handler = new Handler();
            cachedItem = combo.getSelectedItem();
            combo.addActionListener(handler);
            combo.addPropertyChangeListener("model", handler);
        }

        protected void listeningStopped() {
            combo.removeActionListener(handler);
            combo.removePropertyChangeListener("model", handler);
            handler = null;
            cachedItem = null;
        }

        private class Handler implements ActionListener, PropertyChangeListener {
            private void comboSelectionChanged() {
                Object oldValue = cachedItem;
                cachedItem = getSelectedItem();
                firePropertyChange(oldValue, cachedItem);
            }

            public void actionPerformed(ActionEvent ae) {
                comboSelectionChanged();
            }

            public void propertyChange(PropertyChangeEvent pce) {
                comboSelectionChanged();
            }
        }
    }
}
