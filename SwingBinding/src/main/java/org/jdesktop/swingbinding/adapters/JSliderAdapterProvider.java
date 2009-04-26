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
 * $Id: JSliderAdapterProvider.java 60 2009-04-26 20:47:20Z fabriziogiudici $
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
public final class JSliderAdapterProvider implements BeanAdapterProvider {
    private static final String PROPERTY_BASE = "value";
    private static final String IGNORE_ADJUSTING = PROPERTY_BASE +
        "_IGNORE_ADJUSTING";

    public boolean providesAdapter(Class<?> type, String property) {
        if (!JSlider.class.isAssignableFrom(type)) {
            return false;
        }

        property = property.intern();

        return (property == PROPERTY_BASE) || (property == IGNORE_ADJUSTING);
    }

    public Object createAdapter(Object source, String property) {
        if (!providesAdapter(source.getClass(), property)) {
            throw new IllegalArgumentException();
        }

        return new Adapter((JSlider) source, property);
    }

    public Class<?> getAdapterClass(Class<?> type) {
        return JSlider.class.isAssignableFrom(type)
        ? JSliderAdapterProvider.Adapter.class : null;
    }

    public static final class Adapter extends BeanAdapterBase {
        private JSlider slider;
        private Handler handler;
        private int cachedValue;

        private Adapter(JSlider slider, String property) {
            super(property);
            this.slider = slider;
        }

        public int getValue() {
            return slider.getValue();
        }

        public int getValue_IGNORE_ADJUSTING() {
            return getValue();
        }

        public void setValue(int value) {
            slider.setValue(value);
        }

        public void setValue_IGNORE_ADJUSTING(int value) {
            setValue(value);
        }

        protected void listeningStarted() {
            handler = new Handler();
            cachedValue = getValue();
            slider.addChangeListener(handler);
            slider.addPropertyChangeListener("model", handler);
        }

        protected void listeningStopped() {
            slider.removeChangeListener(handler);
            slider.removePropertyChangeListener("model", handler);
            handler = null;
        }

        private class Handler implements ChangeListener, PropertyChangeListener {
            private void sliderValueChanged() {
                int oldValue = cachedValue;
                cachedValue = getValue();
                firePropertyChange(oldValue, cachedValue);
            }

            public void stateChanged(ChangeEvent ce) {
                if ((property == IGNORE_ADJUSTING) &&
                        slider.getValueIsAdjusting()) {
                    return;
                }

                sliderValueChanged();
            }

            public void propertyChange(PropertyChangeEvent pe) {
                sliderValueChanged();
            }
        }
    }
}
