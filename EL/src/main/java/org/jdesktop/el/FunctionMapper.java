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
 * $Id: FunctionMapper.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;

/**
 * The interface to a map between EL function names and methods.
 *
 * <p>A <code>FunctionMapper</code> maps <code>${prefix:name()}</code> 
 * style functions to a static method that can execute that function.</p>
 *
 * @since JSP 2.1
 */
public abstract class FunctionMapper {
    
  /**
   * Resolves the specified prefix and local name into a 
   * <code>java.lang.Method</code>.
   *
   * <p>Returns <code>null</code> if no function could be found that matches
   * the given prefix and local name.</p>
   * 
   * @param prefix the prefix of the function, or "" if no prefix.
   *     For example, <code>"fn"</code> in <code>${fn:method()}</code>, or
   *     <code>""</code> in <code>${method()}</code>.
   * @param localName the short name of the function. For example,
   *     <code>"method"</code> in <code>${fn:method()}</code>.
   * @return the static method to invoke, or <code>null</code> if no
   *     match was found.
   */
  public abstract java.lang.reflect.Method resolveFunction(String prefix, 
      String localName);
  
}
