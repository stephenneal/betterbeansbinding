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
 * $Id: FunctionMapperFactory.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el.impl.lang;

import java.lang.reflect.Method;

import org.jdesktop.el.FunctionMapper;

/**
 * @author Jacob Hookom [jacob@hookom.net]
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: fabriziogiudici $
 */
public class FunctionMapperFactory extends FunctionMapper {

    protected FunctionMapperImpl memento = null;
    protected FunctionMapper target;
    
    public FunctionMapperFactory(FunctionMapper mapper) {
        if (mapper == null) {
            throw new NullPointerException("FunctionMapper target cannot be null");
        }
        this.target = mapper;
    }
   
    
    /* (non-Javadoc)
     * @see javax.el.FunctionMapper#resolveFunction(java.lang.String, java.lang.String)
     */
    public Method resolveFunction(String prefix, String localName) {
        if (this.memento == null) {
            this.memento = new FunctionMapperImpl();
        }
        Method m = this.target.resolveFunction(prefix, localName);
        if (m != null) {
            this.memento.addFunction(prefix, localName, m);
        }
        return m;
    }
    
    public FunctionMapper create() {
        return this.memento;
    }

}
