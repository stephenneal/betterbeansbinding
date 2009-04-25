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
 * $Id: MethodExpressionLiteral.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el.impl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.jdesktop.el.ELContext;
import org.jdesktop.el.ELException;
import org.jdesktop.el.MethodExpression;
import org.jdesktop.el.MethodInfo;

import org.jdesktop.el.impl.lang.ELSupport;
import org.jdesktop.el.impl.util.ReflectionUtil;

public class MethodExpressionLiteral extends MethodExpression implements Externalizable {

    private Class expectedType;

    private String expr;
    
    private Class[] paramTypes;
    
    public MethodExpressionLiteral() {
        // do nothing
    }
    
    public MethodExpressionLiteral(String expr, Class expectedType, Class[] paramTypes) {
        this.expr = expr;
        this.expectedType = expectedType;
        this.paramTypes = paramTypes;
    }

    public MethodInfo getMethodInfo(ELContext context) throws ELException {
        return new MethodInfo(this.expr, this.expectedType, this.paramTypes);
    }

    public Object invoke(ELContext context, Object[] params) throws ELException {
        if (this.expectedType != null) {
            return ELSupport.coerceToType(this.expr, this.expectedType);
        } else {
            return this.expr;
        }
    }

    public String getExpressionString() {
        return this.expr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MethodExpressionLiteral && this.hashCode() == obj.hashCode());
    }

    public int hashCode() {
        return this.expr.hashCode();
    }

    public boolean isLiteralText() {
        return true;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.expr = in.readUTF();
        String type = in.readUTF();
        if (!"".equals(type)) {
            this.expectedType = ReflectionUtil.forName(type);
        }
        this.paramTypes = ReflectionUtil.toTypeArray(((String[]) in
                .readObject()));
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.expr);
        out.writeUTF((this.expectedType != null) ? this.expectedType.getName()
                : "");
        out.writeObject(ReflectionUtil.toTypeNameArray(this.paramTypes));
    }
}
