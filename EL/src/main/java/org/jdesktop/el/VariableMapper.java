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
 * $Id: VariableMapper.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;

/**
 * The interface to a map between EL variables and the EL expressions
 * they are associated with.
 *
 * @since JSP 2.1
 */

public abstract class VariableMapper {
    
    /**
     * @param variable The variable name
     * @return the ValueExpression assigned to the variable,
     *         null if there is no previous assignment to this variable.
     */
    public abstract ValueExpression resolveVariable(
            String variable);
    
    /**
     * Assign a ValueExpression to an EL variable, replacing
     * any previously assignment to the same variable.
     * The assignment for the variable is removed if
     * the expression is <code>null</code>.
     *
     * @param variable The variable name
     * @param expression The ValueExpression to be assigned
     *        to the variable.
     * @return The previous ValueExpression assigned to this variable,
     *         null if there is no previouse assignment to this variable.
     */
    public abstract ValueExpression setVariable(
            String variable,
            ValueExpression expression);
}
