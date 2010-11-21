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
package org.jdesktop.swingbinding.mock;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class MockBean {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public static final String PROP_PROPERTY1 = "property1";
    public static final String PROP_PROPERTY2 = "property2";
    public static final String PROP_PROPERTY3 = "property3";

    protected int property1;
    protected double property2;
    protected String property3;

    public MockBean (int property1, double property2, String property3) {
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        String oldProperty3 = this.property3;
        this.property3 = property3;
        propertyChangeSupport.firePropertyChange(PROP_PROPERTY3, oldProperty3, property3);
    }

    public double getProperty2() {
        return property2;
    }

    public void setProperty2(double property2) {
        double oldProperty2 = this.property2;
        this.property2 = property2;
        propertyChangeSupport.firePropertyChange(PROP_PROPERTY2, oldProperty2, property2);
    }

    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        int oldProperty1 = this.property1;
        this.property1 = property1;
        propertyChangeSupport.firePropertyChange(PROP_PROPERTY1, oldProperty1, property1);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
