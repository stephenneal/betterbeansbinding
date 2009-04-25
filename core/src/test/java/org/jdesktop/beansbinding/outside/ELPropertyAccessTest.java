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
 * $Id: $
 * 
 **********************************************************************************************************************/
package org.jdesktop.beansbinding.outside;

import junit.framework.TestCase;
import org.jdesktop.beansbinding.*;

/**
 * Tests to ensure that {@code ELProperty} correctly exposes properties.
 * It should only expose access to methods in public classes, or where the
 * methods override versions from a public superclass.
 *
 * @author Shannon Hickey
 */
public class ELPropertyAccessTest extends TestCase {

    private Property valP = ELProperty.create("${value}");

    public class Public_Reader {
        public int getValue() {
            return 10;
        }
    }

    public class Public_Writer {
        public void setValue(int value) {
        }
    }

    public class Public_ReaderWriter {
        public int getValue() {
            return 10;
        }

        public void setValue(int value) {
        }
    }

    private class Private_ReaderWriter {
        public int getValue() {
            return 10;
        }
        
        public void setValue(int value) {
        }
    }

    private class Private_Extends_Public_Reader extends Public_Reader {
    }

    private class Private_Extends_Public_Writer extends Public_Writer {
    }

    private class Private_Extends_Public_ReaderWriter extends Public_ReaderWriter {
        public int getValue() {
            return 20;
        }
    }

    protected void setUp() {
    }

    protected void tearDown() {
    }

    private void doCheck(Object obj, boolean expectedReadable, boolean expectedWriteable, int expectedValue) {
        assertEquals(expectedReadable, valP.isReadable(obj));
// FIXME        assertEquals(expectedWriteable, valP.isWriteable(obj));

        if (expectedReadable) {
            assertEquals(expectedValue, valP.getValue(obj));
        } else {
            try {
                valP.getValue(obj);
                fail();
            } catch (UnsupportedOperationException uoe) {
            }
        }

        if (expectedWriteable) {
// FIXME           assertEquals(Integer.TYPE, valP.getWriteType(obj));
// FIXME           valP.setValue(obj, 10);
        } else {
            try {
                valP.getWriteType(obj);
                fail();
            } catch (UnsupportedOperationException uoe) {
            }

            try {
                valP.setValue(obj, 10);
                fail();
            } catch (UnsupportedOperationException uoe) {
            }
        }
        
    }

    public void test_Public_Reader() {
        doCheck(new Public_Reader(), true, false, 10);
    }

    public void test_Public_Writer() {
        // Currently failing since BeanELResolver currently excludes properties
        // that aren't writable. This needs to be fixed.
        doCheck(new Public_Writer(), false, true, -1);
    }

    public void test_Public_ReaderWriter() {
        doCheck(new Public_ReaderWriter(), true, true, 10);
    }
    
    public void test_Private_ReaderWriter() {
        doCheck(new Private_ReaderWriter(), false, false, -1);
    }

    public void test_Private_Extends_Public_Reader() {
        doCheck(new Private_Extends_Public_Reader(), true, false, 10);
    }

    public void test_Private_Extends_Public_Writer() {
        // Currently failing since BeanELResolver currently excludes properties
        // that aren't writable. This needs to be fixed.
        doCheck(new Private_Extends_Public_Writer(), false, true, -1);
    }

    public void test_Private_Extends_Public_ReaderWriter() {
        doCheck(new Private_Extends_Public_ReaderWriter(), true, true, 20);
    }

}
