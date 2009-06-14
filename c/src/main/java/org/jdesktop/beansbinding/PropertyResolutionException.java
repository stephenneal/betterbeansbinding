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
 * $Id: PropertyResolutionException.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;


/**
 * {@code PropertyResolutionExceptions} can be thrown at various points in
 * the life cycle of a {@code Property}. Any time a {@code Property}
 * encounters an exception in resolving a property, a
 * {@code PropertyResolutionException} can be thrown. For example, if a
 * {@code BeanProperty} encounters an exception while trying to resolve
 * the "foo" property of an object via reflection, the exception is
 * wrapped in a {@code PropertyResolutionException} and is re-thrown.
 *
 * @author Shannon Hickey
 * @author Scott Violet
 */
public class PropertyResolutionException extends RuntimeException {
    /**
     * Creates a {@code PropertyResolutionException} with the given message.
     *
     * @param message the exception's message
     */
    public PropertyResolutionException(String message) {
        super(message);
    }

    /**
     * Creates a {@code PropertyResolutionException} with the given message
     * and cause.
     *
     * @param message the exception's message
     * @param reason the original exception that caused this exception
     *        to be thrown
     */
    public PropertyResolutionException(String message, Exception reason) {
        super(message, reason);
    }
}
