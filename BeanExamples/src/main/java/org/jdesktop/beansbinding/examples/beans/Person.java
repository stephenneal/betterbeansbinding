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
 * $Id: Person.java 126 2009-07-09 12:28:41Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding.examples.beans;

import java.beans.PropertyChangeSupport;

/***********************************************************************************************************************
 *
 * @author Contributed by Steve Jorgensen from bbb-users
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public final class Person {

    private String firstName;
    private String lastName;
    private String zip;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Person(final String firstName, final String lastName, final String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        String old = this.zip;
        this.zip = zip;
        pcs.firePropertyChange("zip", old, zip);
    }
}
