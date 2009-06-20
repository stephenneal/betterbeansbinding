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
 * $Id: Person.java 104 2009-06-20 17:53:55Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.mock;

import java.beans.PropertyChangeSupport;

/***********************************************************************************************************************
 *
 * @author Contributed by Steve Jorgensen from bbb-users
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class Person {

    private String name;
    private String zip;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Person(String name, String zip) {
        this.name = name;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String old = this.name;
        this.name = name;
        pcs.firePropertyChange("name", old, name);
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        String old = this.zip;
        this.zip = zip;
        pcs.firePropertyChange("zip", old, zip);
    }
}
