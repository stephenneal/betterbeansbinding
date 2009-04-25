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
 * $Id: EvaluationContext.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el.impl.lang;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.jdesktop.el.ELContext;
import org.jdesktop.el.ELResolver;
import org.jdesktop.el.Expression;
import org.jdesktop.el.FunctionMapper;
import org.jdesktop.el.VariableMapper;

public final class EvaluationContext extends ELContext {

    private final ELContext elContext;

    private final FunctionMapper fnMapper;

    private final VariableMapper varMapper;

    private final Expression expression;

    private final Set<Expression.ResolvedProperty> currentIdentifierProperties;
    private final Set<Expression.ResolvedProperty> resolvedProperties;

    public EvaluationContext(ELContext elContext, FunctionMapper fnMapper,
            VariableMapper varMapper, Expression expression) {
        this(elContext, fnMapper, varMapper, expression, false);
    }

    public EvaluationContext(ELContext elContext, FunctionMapper fnMapper,
            VariableMapper varMapper, Expression expression, boolean trackResolvedProperties) {
        this.elContext = elContext;
        this.fnMapper = fnMapper;
        this.varMapper = varMapper;
        this.expression = expression;
        if (trackResolvedProperties) {
            resolvedProperties = new LinkedHashSet<Expression.ResolvedProperty>(1);
            currentIdentifierProperties = new LinkedHashSet<Expression.ResolvedProperty>(1);
        } else {
            resolvedProperties = null;
            currentIdentifierProperties = null;
        }
    }
    
    public ELContext getELContext() {
        return this.elContext;
    }

    public FunctionMapper getFunctionMapper() {
        return this.fnMapper;
    }

    public VariableMapper getVariableMapper() {
        return this.varMapper;
    }

    public Expression getExpression() {
        return expression;
    }
    
    public Object getContext(Class key) {
        return this.elContext.getContext(key);
    }

    public ELResolver getELResolver() {
        return this.elContext.getELResolver();
    }

    public boolean isPropertyResolved() {
        return this.elContext.isPropertyResolved();
    }

    public void putContext(Class key, Object contextObject) {
        this.elContext.putContext(key, contextObject);
    }

    public void setPropertyResolved(boolean resolved) {
        this.elContext.setPropertyResolved(resolved);
    }

    public void clearResolvedProperties() {
        if (resolvedProperties == null) {
            return;
        }

        resolvedProperties.clear();
    }

    public void resolvedIdentifier(Object base, Object property) {
        if (base == null || property == null || resolvedProperties == null) {
            return;
        }

        resolvedProperties.addAll(currentIdentifierProperties);
        currentIdentifierProperties.clear();
        Expression.ResolvedProperty prop = new Expression.ResolvedProperty(base, property);
        resolvedProperties.remove(prop);
        currentIdentifierProperties.add(prop);
    }

    public void resolvedProperty(Object base, Object property) {
        if (base == null || property == null || resolvedProperties == null) {
            return;
        }

        Expression.ResolvedProperty prop = new Expression.ResolvedProperty(base, property);
        resolvedProperties.remove(prop);
        currentIdentifierProperties.add(prop);
    }

    public List<Expression.ResolvedProperty> getResolvedProperties() {
        if (resolvedProperties == null) {
            return null;
        }

        resolvedProperties.addAll(currentIdentifierProperties);
        return new ArrayList<Expression.ResolvedProperty>(resolvedProperties);
    }
    
}
