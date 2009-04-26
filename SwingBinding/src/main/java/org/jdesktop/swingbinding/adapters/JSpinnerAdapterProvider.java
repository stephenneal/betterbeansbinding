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
 * $Id: JSpinnerAdapterProvider.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.adapters;

import org.jdesktop.beansbinding.ext.BeanAdapterProvider;

import java.beans.*;

import javax.swing.*;
import javax.swing.event.*;


/**
 * @author Shannon Hickey
 */
public final class JSpinnerAdapterProvider implements BeanAdapterProvider {
    private static final String VALUE_P = "value";

    public boolean providesAdapter(Class<?> type, String property) {
        return JSpinner.class.isAssignableFrom(type) && (property == VALUE_P);
    }

    public Object createAdapter(Object source, String property) {
        if (!providesAdapter(source.getClass(), property)) {
            throw new IllegalArgumentException();
        }

        return new Adapter((JSpinner) source);
    }

    public Class<?> getAdapterClass(Class<?> type) {
        return JSpinner.class.isAssignableFrom(type)
        ? JSpinnerAdapterProvider.Adapter.class : null;
    }

    public static final class Adapter extends BeanAdapterBase {
        private JSpinner spinner;
        private Handler handler;
        private Object cachedValue;

        private Adapter(JSpinner spinner) {
            super(VALUE_P);
            this.spinner = spinner;
        }

        public Object getValue() {
            return spinner.getValue();
        }

        public void setValue(Object value) {
            spinner.setValue(value);
        }

        protected void listeningStarted() {
            handler = new Handler();
            cachedValue = getValue();
            spinner.addChangeListener(handler);
            spinner.addPropertyChangeListener("model", handler);
        }

        protected void listeningStopped() {
            spinner.removeChangeListener(handler);
            spinner.removePropertyChangeListener("model", handler);
            handler = null;
        }

        private class Handler implements ChangeListener, PropertyChangeListener {
            private void spinnerValueChanged() {
                Object oldValue = cachedValue;
                cachedValue = getValue();
                firePropertyChange(oldValue, cachedValue);
            }

            public void stateChanged(ChangeEvent ce) {
                spinnerValueChanged();
            }

            public void propertyChange(PropertyChangeEvent pe) {
                spinnerValueChanged();
            }
        }
    }
}
