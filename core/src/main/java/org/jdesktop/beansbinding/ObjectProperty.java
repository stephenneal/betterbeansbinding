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
 * $Id: ObjectProperty.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import static org.jdesktop.beansbinding.PropertyStateEvent.UNREADABLE;

/**
 * An immutable, read-only, {@code Property} implementation whose {@code getValue}
 * method returns the source object that it is given. This class is useful when
 * you want to configure a {@code Binding} to use its source object directly,
 * rather than some property of the source object. For example:
 * <p>
 * <pre><code>
 *    new SomeBindingClass(sourceObject, ObjectProperty.create(), targetObject, targetProperty);
 * </code></pre>
 * <p>
 * Explicitly using {@code ObjectProperty} isn't necessary when creating {@code Bindings}
 * from this package or the {@code SwingBindings} package, as the set of static creation
 * methods include versions that handle this for you.
 *
 * @param <S> the type of source object that this {@code Property} operates on
 *            and therefore the type of value that it represents
 *
 * @author Shannon Hickey
 */
public final class ObjectProperty<S> extends Property<S, S> {
    private ObjectProperty() {
    }

    /**
     * Creates an instance of {@code ObjectProperty}.
     */
    public static <S> ObjectProperty<S> create() {
        return new ObjectProperty<S>();
    }

    /**
     * Throws {@code UnsupportedOperationException}; {@code ObjectProperty} is never writeable.
     *
     * @param source {@inheritDoc}
     * @return never returns; always throws {@code UnsupportedOperationException}; {@code ObjectProperty} is never writeable
     * @throws UnsupportedOperationException always; {@code ObjectProperty} is never writeable
     * @see #isWriteable
     */
    public Class<?extends S> getWriteType(S source) {
        throw new UnsupportedOperationException("Unwriteable");
    }

    /**
     * Returns the source object passed to the method.
     *
     * @return the value of the {@code source} argument
     * @see #isReadable
     */
    public S getValue(S source) {
        return source;
    }

    /**
     * Throws {@code UnsupportedOperationException}; {@code ObjectProperty} is never writeable.
     *
     * @param source {@inheritDoc}
     * @throws UnsupportedOperationException always; {@code ObjectProperty} is never writeable
     * @see #isWriteable
     * @see #getWriteType
     */
    public void setValue(S source, S value) {
        throw new UnsupportedOperationException("Unwriteable");
    }

    /**
     * Returns {@code true}; {@code ObjectProperty} is always readable.
     *
     * @return {@code true}; {@code ObjectPropert} is always readable
     * @see #isWriteable
     */
    public boolean isReadable(Object source) {
        return true;
    }

    /**
     * Returns {@code false}; {@code ObjectProperty} is never writeable.
     *
     * @return {@code false}; {@code ObjectPropert} is never writeable
     * @see #isReadable
     */
    public boolean isWriteable(Object source) {
        return false;
    }

    /**
     * Returns a string representation of the {@code ObjectProperty}. This
     * method is intended to be used for debugging purposes only, and
     * the content and format of the returned string may vary between
     * implementations. The returned string may be empty but may not
     * be {@code null}.
     *
     * @return a string representation of this {@code ObjectProperty}
     */
    public String toString() {
        return getClass().getName();
    }

    /**
     * Does nothing; the state of an {@code ObjectProperty} never changes so
     * listeners aren't useful.
     */
    public void addPropertyStateListener(S source,
        PropertyStateListener listener) {
    }

    /**
     * Does nothing; the state of an {@code ObjectProperty} never changes so
     * listeners aren't useful.
     *
     * @see #addPropertyStateListener
     */
    public void removePropertyStateListener(S source,
        PropertyStateListener listener) {
    }

    /**
     * Returns an empty array; the state of an {@code ObjectProperty} never changes
     * so listeners aren't useful.
     *
     * @return an empty array
     * @see #addPropertyStateListener
     */
    public PropertyStateListener[] getPropertyStateListeners(S source) {
        return new PropertyStateListener[0];
    }
}
