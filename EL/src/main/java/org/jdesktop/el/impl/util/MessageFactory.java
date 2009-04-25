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
 * $Id: MessageFactory.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el.impl.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author Jacob Hookom [jacob@hookom.net]
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: fabriziogiudici $
 */
public final class MessageFactory {

    protected final static ResourceBundle bundle = ResourceBundle
            .getBundle("org.jdesktop.el.impl.Messages");
    /**
     * 
     */
    public MessageFactory() {
        super();
    }
    
    public static String get(final String key) {
        return bundle.getString(key);
    }

    public static String get(final String key, final Object obj0) {
        return getArray(key, new Object[] { obj0 });
    }

    public static String get(final String key, final Object obj0,
            final Object obj1) {
        return getArray(key, new Object[] { obj0, obj1 });
    }

    public static String get(final String key, final Object obj0,
            final Object obj1, final Object obj2) {
        return getArray(key, new Object[] { obj0, obj1, obj2 });
    }

    public static String get(final String key, final Object obj0,
            final Object obj1, final Object obj2, final Object obj3) {
        return getArray(key, new Object[] { obj0, obj1, obj2, obj3 });
    }

    public static String get(final String key, final Object obj0,
            final Object obj1, final Object obj2, final Object obj3,
            final Object obj4) {
        return getArray(key, new Object[] { obj0, obj1, obj2, obj3, obj4 });
    }

    public static String getArray(final String key, final Object[] objA) {
        return MessageFormat.format(bundle.getString(key), objA);
    }

}
