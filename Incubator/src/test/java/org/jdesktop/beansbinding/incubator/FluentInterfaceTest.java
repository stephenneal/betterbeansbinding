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
 * $Id: FluentInterfaceTest.java 109 2009-06-20 19:25:35Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding.incubator;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AutoBinding;
import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ;
import org.jdesktop.beansbinding.Binding;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class BindingBuilder {
    private Object source;
    private Object target;
    
    @CheckForNull
    private AutoBinding.UpdateStrategy strategy;

    @Nonnull
    public static BindingBuilder create() {
        return new BindingBuilder();
    }

    @Nonnull
    public Binding strategy (final @Nonnull AutoBinding.UpdateStrategy strategy) {
//    public BindingBuilder strategy (final @Nonnull AutoBinding.UpdateStrategy strategy) {
        this.strategy = strategy;
//        return this;
        return null; // TODO: Binding.create(...)
    }

    @Nonnull
    public BindingBuilder source (final @Nonnull Object source) {
        this.source = source;
        return this;
    }

    @Nonnull
    public BindingBuilder target (final @Nonnull Object target) {
        this.target = target;
        return this;
    }

    @Nonnull
    public BindingBuilder property (final @Nonnull String property) {
        // TODO
        return this;
    }

//    @Nonnull
//    public Binding build() {
//        return null; // TODO
//    }
}

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class FluentInterfaceTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    // See http://kenai.com/jira/browse/BETTERBEANSBINDING-43
    public void test1() {
        JTable table = new JTable();
        // Would be added to Bindings.
        Binding binding = BindingBuilder.create().source(table).property("...").
                                                  target(table).property("...").strategy(READ);
/*
 *         Binding textFieldBinding = Bindings.createAutoBinding(
                AutoBinding.UpdateStrategy.READ_WRITE,
                table, ELProperty.create("${selectedElement.name}"),
                textField, BeanProperty.create("text"));

 */
    }
}
