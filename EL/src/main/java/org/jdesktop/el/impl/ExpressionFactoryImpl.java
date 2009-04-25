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
 * $Id: ExpressionFactoryImpl.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el.impl;

import org.jdesktop.el.ELContext;
import org.jdesktop.el.ExpressionFactory;
import org.jdesktop.el.MethodExpression;
import org.jdesktop.el.ValueExpression;

import org.jdesktop.el.impl.lang.ExpressionBuilder;
import org.jdesktop.el.impl.lang.ELSupport;
import org.jdesktop.el.impl.util.MessageFactory;

/**
 * @see javax.el.ExpressionFactory
 * 
 * @author Jacob Hookom [jacob@hookom.net]
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: fabriziogiudici $
 */
public class ExpressionFactoryImpl extends ExpressionFactory {

    /**
     * 
     */
    public ExpressionFactoryImpl() {
        super();
    }

    public Object coerceToType(Object obj, Class type) {
        return ELSupport.coerceToType(obj, type);
    }

    public MethodExpression createMethodExpression(ELContext context,
            String expression, Class expectedReturnType,
            Class[] expectedParamTypes) {
        if (expectedParamTypes == null) {
            throw new NullPointerException(MessageFactory
                    .get("error.method.nullParms"));
        }
        ExpressionBuilder builder = new ExpressionBuilder(expression, context);
        return builder.createMethodExpression(expectedReturnType,
                expectedParamTypes);
    }

    public ValueExpression createValueExpression(ELContext context,
            String expression, Class expectedType) {
        if (expectedType == null) {
            throw new NullPointerException(MessageFactory
                    .get("error.value.expectedType"));
        }
        ExpressionBuilder builder = new ExpressionBuilder(expression, context);
        return builder.createValueExpression(expectedType);
    }

    public ValueExpression createValueExpression(Object instance,
            Class expectedType) {
        if (expectedType == null) {
            throw new NullPointerException(MessageFactory
                    .get("error.value.expectedType"));
        }
        return new ValueExpressionLiteral(instance, expectedType);
    }
}
