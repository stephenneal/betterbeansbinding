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
 * $Id: JTextComponentAdapterProvider.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.swingbinding.adapters;

import org.jdesktop.beansbinding.ext.BeanAdapterProvider;

import java.awt.event.*;

import java.beans.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


/**
 * @author Shannon Hickey
 */
public final class JTextComponentAdapterProvider implements BeanAdapterProvider {
    private static final String PROPERTY_BASE = "text";
    private static final String ON_ACTION_OR_FOCUS_LOST = PROPERTY_BASE +
        "_ON_ACTION_OR_FOCUS_LOST";
    private static final String ON_FOCUS_LOST = PROPERTY_BASE +
        "_ON_FOCUS_LOST";

    public boolean providesAdapter(Class<?> type, String property) {
        if (!JTextComponent.class.isAssignableFrom(type)) {
            return false;
        }

        property = property.intern();

        return (property == PROPERTY_BASE) ||
        (property == ON_ACTION_OR_FOCUS_LOST) || (property == ON_FOCUS_LOST);
    }

    public Object createAdapter(Object source, String property) {
        if (!providesAdapter(source.getClass(), property)) {
            throw new IllegalArgumentException();
        }

        return new Adapter((JTextComponent) source, property);
    }

    public Class<?> getAdapterClass(Class<?> type) {
        return JTextComponent.class.isAssignableFrom(type)
        ? JTextComponentAdapterProvider.Adapter.class : null;
    }

    public final class Adapter extends BeanAdapterBase {
        private JTextComponent component;
        private Document document;
        private boolean inDocumentListener;
        private boolean installedFilter;
        private String cachedText;
        private Handler handler;

        private Adapter(JTextComponent component, String property) {
            super(property);
            this.component = component;
        }

        public String getText() {
            return component.getText();
        }

        public String getText_ON_ACTION_OR_FOCUS_LOST() {
            return getText();
        }

        public String getText_ON_FOCUS_LOST() {
            return getText();
        }

        public void setText(String text) {
            component.setText(text);
            component.setCaretPosition(0);
            cachedText = text;
        }

        public void setText_ON_ACTION_OR_FOCUS_LOST(String text) {
            setText(text);
        }

        public void setText_ON_FOCUS_LOST(String text) {
            setText(text);
        }

        protected void listeningStarted() {
            cachedText = component.getText();
            handler = new Handler();
            component.addPropertyChangeListener("document", handler);

            if (property != PROPERTY_BASE) {
                component.addFocusListener(handler);
            }

            if ((property == ON_ACTION_OR_FOCUS_LOST) &&
                    component instanceof JTextField) {
                ((JTextField) component).addActionListener(handler);
            }

            document = component.getDocument();
            installDocumentListener();
        }

        protected void listeningStopped() {
            cachedText = null;
            component.removePropertyChangeListener("document", handler);

            if (property != PROPERTY_BASE) {
                component.removeFocusListener(handler);
            }

            if ((property == ON_ACTION_OR_FOCUS_LOST) &&
                    (component instanceof JTextField)) {
                ((JTextField) component).removeActionListener(handler);
            }

            uninstallDocumentListener();
            document = null;
            handler = null;
        }

        private void installDocumentListener() {
            if (property != PROPERTY_BASE) {
                return;
            }

            boolean useDocumentFilter = !(component instanceof JFormattedTextField);

            if (useDocumentFilter && (document instanceof AbstractDocument) &&
                    (((AbstractDocument) document).getDocumentFilter() == null)) {
                ((AbstractDocument) document).setDocumentFilter(handler);
                installedFilter = true;
            } else {
                document.addDocumentListener(handler);
                installedFilter = false;
            }
        }

        private void uninstallDocumentListener() {
            if (property != PROPERTY_BASE) {
                return;
            }

            if (installedFilter) {
                AbstractDocument ad = (AbstractDocument) document;

                if (ad.getDocumentFilter() == handler) {
                    ad.setDocumentFilter(null);
                }
            } else {
                document.removeDocumentListener(handler);
            }
        }

        private class Handler extends DocumentFilter implements ActionListener,
            DocumentListener, FocusListener, PropertyChangeListener {
            private void updateText() {
                Object oldText = cachedText;
                cachedText = getText();
                firePropertyChange(oldText, cachedText);
            }

            private void documentTextChanged() {
                try {
                    inDocumentListener = true;
                    textChanged();
                } finally {
                    inDocumentListener = false;
                }
            }

            private void textChanged() {
                updateText();
            }

            public void propertyChange(PropertyChangeEvent pce) {
                uninstallDocumentListener();
                document = component.getDocument();
                installDocumentListener();
                updateText();
            }

            public void actionPerformed(ActionEvent e) {
                updateText();
            }

            public void focusLost(FocusEvent e) {
                if (!e.isTemporary()) {
                    updateText();
                }
            }

            public void insertUpdate(DocumentEvent e) {
                documentTextChanged();
            }

            public void removeUpdate(DocumentEvent e) {
                documentTextChanged();
            }

            public void replace(DocumentFilter.FilterBypass fb, int offset,
                int length, String text, AttributeSet attrs)
                throws BadLocationException {
                super.replace(fb, offset, length, text, attrs);
                textChanged();
            }

            public void insertString(DocumentFilter.FilterBypass fb,
                int offset, String string, AttributeSet attr)
                throws BadLocationException {
                super.insertString(fb, offset, string, attr);
                textChanged();
            }

            public void remove(DocumentFilter.FilterBypass fb, int offset,
                int length) throws BadLocationException {
                super.remove(fb, offset, length);
                textChanged();
            }

            public void focusGained(FocusEvent e) {
            }

            public void changedUpdate(DocumentEvent e) {
            }
        }
    }
}
