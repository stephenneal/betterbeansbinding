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
 * $Id: Example.java 121 2009-07-09 10:48:11Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding.swingexamples.example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import org.jdesktop.beansbinding.swingexamples.example.jlist.JListExample;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class Example {

    protected final String displayName;
    protected final JComponent component;

    public static List<Example> findAll() {
        final List<Example> result = new ArrayList<Example>();

        result.add(new JListExample()); // FIXME: lookup META-INF/services
        
        return result;
    }

    protected Example(final String displayName, final JComponent component) {
        this.displayName = displayName;
        this.component = component;
    }


    public JComponent getComponent() {
        return component;
    }

    public String getDisplayName() {
        return displayName;
    }
}
