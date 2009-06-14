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
 * $Id: TempELContext.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import org.jdesktop.beansbinding.ext.BeanAdapterFactory;

import org.jdesktop.el.BeanELResolver;
import org.jdesktop.el.CompositeELResolver;
import org.jdesktop.el.ELContext;
import org.jdesktop.el.ELResolver;
import org.jdesktop.el.FunctionMapper;
import org.jdesktop.el.MapELResolver;
import org.jdesktop.el.VariableMapper;
import org.jdesktop.el.impl.lang.FunctionMapperImpl;
import org.jdesktop.el.impl.lang.VariableMapperImpl;

import java.beans.*;

import java.util.*;


/**
 * This class is temporary. Moving forward, we'll instead have a factory for
 * configuring this.
 *
 * @author Shannon Hickey
 */
class TempELContext extends ELContext {
    private final CompositeELResolver resolver;
    private final VariableMapper variableMapper = new VariableMapperImpl();
    private final FunctionMapper functionMapper = new FunctionMapperImpl();

    public TempELContext() {
        resolver = new CompositeELResolver();
        // PENDING(shannonh) - EL also has an ArrayELResolver. Should that be added too?
        resolver.add(new MapELResolver());
        resolver.add(new BeanDelegateELResolver());
    }

    public ELResolver getELResolver() {
        return resolver;
    }

    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    public VariableMapper getVariableMapper() {
        return variableMapper;
    }

    private class BeanDelegateELResolver extends BeanELResolver {
        public Iterator<FeatureDescriptor> getFeatureDescriptors(
            ELContext context, Object base) {
            Iterator<FeatureDescriptor> superDescriptors = super.getFeatureDescriptors(context,
                    base);

            if (base != null) {
                List<PropertyDescriptor> pds = BeanAdapterFactory.getAdapterPropertyDescriptors(base.getClass());

                if (pds.size() > 0) {
                    Map<String, FeatureDescriptor> fdMap = new HashMap<String, FeatureDescriptor>();

                    while (superDescriptors.hasNext()) {
                        FeatureDescriptor fd = superDescriptors.next();
                        fdMap.put(fd.getName(), fd);
                    }

                    for (PropertyDescriptor pd : pds) {
                        if (pd.getPropertyType() != null) {
                            pd.setValue("type", pd.getPropertyType());
                            pd.setValue("resolvableAtDesignTime", Boolean.TRUE);
                            fdMap.put(pd.getName(), pd);
                        }
                    }

                    return fdMap.values().iterator();
                }
            }

            return superDescriptors;
        }

        private Object baseOrAdapter(Object base, Object property) {
            if ((base != null) && property instanceof String) {
                Object adapter = BeanAdapterFactory.getAdapter(base,
                        (String) property);

                if (adapter != null) {
                    return adapter;
                }
            }

            return base;
        }

        public void setValue(ELContext context, Object base, Object property,
            Object val) {
            super.setValue(context, baseOrAdapter(base, property), property, val);
        }

        public boolean isReadOnly(ELContext context, Object base,
            Object property) {
            return super.isReadOnly(context, baseOrAdapter(base, property),
                property);
        }

        public Object getValue(ELContext context, Object base, Object property) {
            return super.getValue(context, baseOrAdapter(base, property),
                property);
        }

        public Class<?> getType(ELContext context, Object base, Object property) {
            return super.getType(context, baseOrAdapter(base, property),
                property);
        }
    }
}
