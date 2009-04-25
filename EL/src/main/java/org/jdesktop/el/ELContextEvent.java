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
 * $Id: ELContextEvent.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;

/**
 * An event which indicates that an {@link ELContext} has been created.
 * The source object is the ELContext that was created.
 *
 * @see ELContext
 * @see ELContextListener
 * @since JSP 2.1
 */
public class ELContextEvent extends java.util.EventObject {

    /**
     * Constructs an ELContextEvent object to indicate that an 
     * <code>ELContext</code> has been created.
     *
     * @param source the <code>ELContext</code> that was created.
     */
    public ELContextEvent(ELContext source) {
        super(source);
    }

    /**
     * Returns the <code>ELContext</code> that was created.
     * This is a type-safe equivalent of the {@link #getSource} method.
     *
     * @return the ELContext that was created.
     */
    public ELContext getELContext() {
        return (ELContext) getSource();
    }
}
