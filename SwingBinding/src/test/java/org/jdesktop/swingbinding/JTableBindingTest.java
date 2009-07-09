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
 * $Id: JTableBindingTest.java 124 2009-07-09 12:11:43Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding;

import javax.swing.table.TableColumnModel;
import org.jdesktop.swingbinding.mock.MockBean;
import org.jdesktop.swingbinding.mock.IntegerTableCellRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.mock.DoubleTableCellRenderer;
import org.jdesktop.swingbinding.mock.SpinnerTableCellEditor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fritz
 */
public class JTableBindingTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetRendererSetEditor() throws InterruptedException {
        final List<MockBean> beans = new ArrayList<MockBean>();
        beans.add(new MockBean(1, 11.1, "First row"));
        beans.add(new MockBean(2, 22.2, "Second row"));
        beans.add(new MockBean(3, 33.3, "Third row"));
        beans.add(new MockBean(4, 44.4, "Fourth row"));

        final IntegerTableCellRenderer integerTableCellRenderer = new IntegerTableCellRenderer();
        final DoubleTableCellRenderer doubleTableCellRenderer = new DoubleTableCellRenderer();
        final SpinnerTableCellEditor spinnerTableCellEditor = new SpinnerTableCellEditor();

        final JTable table = new JTable();
        final JTableBinding binding = SwingBindings.createJTableBinding(UpdateStrategy.READ, beans, table);
        
        binding.addColumnBinding(BeanProperty.create(MockBean.PROP_PROPERTY1)).
                setColumnName("property1").
                setEditable(true).
                setEditor(spinnerTableCellEditor).
                setRenderer(integerTableCellRenderer);

        binding.addColumnBinding(BeanProperty.create(MockBean.PROP_PROPERTY2)).
                setColumnName("property2").
                setRenderer(doubleTableCellRenderer);

        binding.addColumnBinding(BeanProperty.create(MockBean.PROP_PROPERTY3)).
                setColumnName("property3");
        
        binding.bind();

        assertEquals(3, table.getColumnCount());
        
        final TableColumnModel columnModel = table.getColumnModel();

        assertSame(integerTableCellRenderer, columnModel.getColumn(0).getCellRenderer());
        assertSame(doubleTableCellRenderer, columnModel.getColumn(1).getCellRenderer());
        assertNull(columnModel.getColumn(2).getCellRenderer());
        
        assertSame(spinnerTableCellEditor, columnModel.getColumn(0).getCellEditor());
        assertNull(columnModel.getColumn(1).getCellEditor());
        assertNull(columnModel.getColumn(2).getCellEditor());

//        final JFrame frame = new JFrame("Test");
//        final Container contentPane = frame.getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
//        contentPane.add(new JLabel("Test"), BorderLayout.NORTH);
//        frame.setSize(680, 480);
//        frame.setVisible(true);
//
//        Thread.sleep(60000);
    }
}
