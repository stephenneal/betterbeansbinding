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
 * $Id: ElementsProperty.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding;

import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.PropertyHelper;
import org.jdesktop.beansbinding.PropertyStateEvent;

import java.util.*;


/**
 * @author Shannon Hickey
 */
class ElementsProperty<TS> extends PropertyHelper<TS, List> {
    private boolean accessible;
    private List list;

    ElementsProperty() {
        super(true);
    }

    public Class<List> getWriteType(TS source) {
        if (!accessible) {
            throw new UnsupportedOperationException("Unwriteable");
        }

        return (Class<List>) List.class;
    }

    public List getValue(TS source) {
        if (!accessible) {
            throw new UnsupportedOperationException("Unreadable");
        }

        return list;
    }

    private void setValue0(TS source, List list, boolean ignore) {
        if (!accessible) {
            throw new UnsupportedOperationException("Unwriteable");
        }

        if (this.list == list) {
            return;
        }

        List old = this.list;
        this.list = list;

        PropertyStateEvent pse = new ElementsPropertyStateEvent(this, null,
                true, old, list, false, true, ignore);
        firePropertyStateChange(pse);
    }

    public void setValue(TS source, List list) {
        setValue0(source, list, false);
    }

    void setValueAndIgnore(TS source, List list) {
        setValue0(source, list, true);
    }

    public boolean isReadable(TS source) {
        return accessible;
    }

    public boolean isWriteable(TS source) {
        return accessible;
    }

    public String toString() {
        return "elements";
    }

    void setAccessible(boolean accessible) {
        if (this.accessible == accessible) {
            return;
        }

        this.accessible = accessible;

        PropertyStateEvent pse;

        if (accessible) {
            pse = new ElementsPropertyStateEvent(this, null, true,
                    PropertyStateEvent.UNREADABLE, null, true, true, true);
        } else {
            Object old = list;
            list = null;
            pse = new ElementsPropertyStateEvent(this, null, true, old,
                    PropertyStateEvent.UNREADABLE, true, false, true);
        }

        firePropertyStateChange(pse);
    }

    boolean isAccessible() {
        return accessible;
    }

    class ElementsPropertyStateEvent extends PropertyStateEvent {
        private boolean ignore;

        public ElementsPropertyStateEvent(Property sourceProperty,
            Object sourceObject, boolean valueChanged, Object oldValue,
            Object newValue, boolean writeableChanged, boolean isWriteable) {
            this(sourceProperty, sourceObject, valueChanged, oldValue,
                newValue, writeableChanged, isWriteable, false);
        }

        public ElementsPropertyStateEvent(Property sourceProperty,
            Object sourceObject, boolean valueChanged, Object oldValue,
            Object newValue, boolean writeableChanged, boolean isWriteable,
            boolean ignore) {
            super(sourceProperty, sourceObject, valueChanged, oldValue,
                newValue, writeableChanged, isWriteable);

            this.ignore = ignore;
        }

        boolean shouldIgnore() {
            return ignore;
        }
    }
}
