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
 * $Id: MethodInfo.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;

/**
 * Holds information about a method that a {@link MethodExpression} 
 * evaluated to.
 *
 * @since JSP 2.1
 */
public class MethodInfo {
    
    /** 
     * Creates a new instance of <code>MethodInfo</code> with the given
     * information.
     *
     * @param name The name of the method
     * @param returnType The return type of the method
     * @param paramTypes The types of each of the method's parameters
     */
    public MethodInfo(String name, Class<?> returnType, Class<?>[] paramTypes) {
        this.name = name;
        this.returnType = returnType;
        this.paramTypes = paramTypes;
    }

    /**
     * Returns the name of the method
     *
     * @return the name of the method
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the return type of the method
     *
     * @return the return type of the method
     */
    public Class<?> getReturnType() {
        return this.returnType;
    }
    
    /**
     * Returns the parameter types of the method
     *
     * @return the parameter types of the method
     */
    public Class<?>[] getParamTypes() {
        return this.paramTypes;
    }
    
    private String name;
    private Class<?> returnType;
    private Class<?>[] paramTypes;
}
