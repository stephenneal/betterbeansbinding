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
 * $Id: JTableBindingInteractiveTest.java 105 2009-06-20 18:33:06Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding;

//import com.sun.jdi.event.EventQueue;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;
import org.jdesktop.swingbinding.mock.Person;
import org.junit.Test;

/***********************************************************************************************************************
 *
 * @author Contributed by Steve Jorgensen from bbb-users
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class JTableBindingInteractiveTest {

    private JFrame frame;

    @Test
    public void testFrame1() throws Exception {
        EventQueue.invokeAndWait(new Runnable() {

            public void run() {
                frame = createFrame1();
                frame.setVisible(true);
            }
        });

        while (frame.isVisible()) {
            Thread.sleep(500);
        }
    }

    private JFrame createFrame1() {
        BindingGroup bindingGroup = new BindingGroup();

        JFrame frame = new JFrame();
        frame.setTitle("Demo Frame");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ObservableList<Person> list =
                ObservableCollections.observableListHelper(new ArrayList<Person>()).getObservableList();

        JScrollPane tableScroll = new JScrollPane();
        JTable table = new JTable();
        JTableBinding tableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, list, table);

        ColumnBinding columnBinding;
        columnBinding = tableBinding.addColumnBinding(ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);

        columnBinding = tableBinding.addColumnBinding(ELProperty.create("${zip}"));
        columnBinding.setColumnName("Zip");
        columnBinding.setColumnClass(String.class);

        bindingGroup.addBinding(tableBinding);
        tableBinding.bind();

        tableScroll.setViewportView(table);

        frame.getContentPane().add(tableScroll, java.awt.BorderLayout.CENTER);

        JPanel formPanel = new JPanel();

        JTextField textField = new JTextField();
        textField.setColumns(20);
        Binding textFieldBinding = Bindings.createAutoBinding(
                AutoBinding.UpdateStrategy.READ_WRITE,
                table, ELProperty.create("${selectedElement.name}"),
                textField, BeanProperty.create("text"));
        bindingGroup.addBinding(textFieldBinding);
        formPanel.add(textField);
        frame.getContentPane().add(formPanel, java.awt.BorderLayout.SOUTH);

        textField = new JTextField();
        textField.setColumns(10);
        textFieldBinding = Bindings.createAutoBinding(
                AutoBinding.UpdateStrategy.READ_WRITE,
                table, ELProperty.create("${selectedElement.zip}"),
                textField, BeanProperty.create("text"));
        bindingGroup.addBinding(textFieldBinding);
        formPanel.add(textField);

        bindingGroup.bind();

        frame.pack();

        list.add(new Person("Jane Doe", "98765"));
        list.add(new Person("Bob Smith", "91234"));

        return frame;
    }
}




