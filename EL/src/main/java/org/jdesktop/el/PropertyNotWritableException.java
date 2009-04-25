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
 * $Id: PropertyNotWritableException.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;


/**
 * Thrown when a property could not be written to while setting the
 * value on a {@link ValueExpression}.
 *
 * <p>For example, this could be triggered by trying to set a map value
 * on an unmodifiable map.</p>
 *
 * @since JSP 2.1
 */
public class PropertyNotWritableException extends ELException {

    //-------------------------------------
    /**
     * Creates a <code>PropertyNotWritableException</code> with no detail 
     * message.
     */
    public PropertyNotWritableException() {
        super ();
    }

    //-------------------------------------
    /**
     * Creates a <code>PropertyNotWritableException</code> with the 
     * provided detail message.
     *
     * @param pMessage the detail message
     */
    public PropertyNotWritableException(String pMessage) {
        super (pMessage);
    }

    //-------------------------------------
    /**
     * Creates a <code>PropertyNotWritableException</code> with the given root 
     * cause.
     *
     * @param exception the originating cause of this exception
     */
    public PropertyNotWritableException(Throwable exception) {
        super (exception);
    }

    //-------------------------------------
    /**
     * Creates a <code>PropertyNotWritableException</code> with the given
     * detail message and root cause.
     *
     * @param pMessage the detail message
     * @param pRootCause the originating cause of this exception
     */
    public PropertyNotWritableException(String pMessage, Throwable pRootCause) {
        super (pMessage, pRootCause);
    }

}
