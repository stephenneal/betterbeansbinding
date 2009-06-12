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
 * $Id: AbstractColumnBinding.java 66 2009-06-12 14:40:51Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.impl;

import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Property;

/**
 * @author Shannon Hickey
 */
public abstract class AbstractColumnBinding extends Binding {

    private int column;

    public AbstractColumnBinding(int column, Property columnSource,
            Property columnTarget, String name) {
        super(null, columnSource, null, columnTarget, name);
        this.column = column;
        setManaged(true);
    }

    public final int getColumn() {
        return column;
    }

    protected final void setColumn(int column) {
        this.column = column;
    }

    public void bindImpl() {
    }

    public void unbindImpl() {
    }
}
