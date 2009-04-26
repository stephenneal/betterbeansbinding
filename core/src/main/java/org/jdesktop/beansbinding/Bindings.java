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
 * $Id: Bindings.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;


/**
 * A factory class for creating instances of the concrete {@code Binding}
 * implementations provided by this package.
 *
 * @author Shannon Hickey
 */
public class Bindings {
    private Bindings() {
    }

    /**
     * Creates an instance of {@code AutoBinding} that binds a source object to a property of a target object.
     * The {@code AutoBinding's} source property is set to an instance of {@code ObjectProperty} so that the
     * source object is used directly, rather than some property of the source object.
     *
     * @param strategy the update strategy for the binding
     * @param sourceObject the source object
     * @param targetObject the target object
     * @param targetProperty the target property
     * @return an {@code AutoBinding} that binds the source object to the target property of the target object
     * @throws IllegalArgumentException if the update strategy or target property is {@code null}
     */
    public static <SS, TS, TV> AutoBinding<SS, SS, TS, TV> createAutoBinding(
        AutoBinding.UpdateStrategy strategy, SS sourceObject, TS targetObject,
        Property<TS, TV> targetProperty) {
        return new AutoBinding<SS, SS, TS, TV>(strategy, sourceObject,
            ObjectProperty.<SS>create(), targetObject, targetProperty, null);
    }

    /**
     * Creates a named instance of {@code AutoBinding} that binds a source object to a property of a target object.
     * The {@code AutoBinding's} source property is set to an instance of {@code ObjectProperty} so that the
     * source object is used directly, rather than some property of the source object.
     *
     * @param strategy the update strategy for the binding
     * @param sourceObject the source object
     * @param targetObject the target object
     * @param targetProperty the target property
     * @param name a name for the binding
     * @return an {@code AutoBinding} that binds the source object to the target property of the target object
     * @throws IllegalArgumentException if the update strategy or target property is {@code null}
     */
    public static <SS, TS, TV> AutoBinding<SS, SS, TS, TV> createAutoBinding(
        AutoBinding.UpdateStrategy strategy, SS sourceObject, TS targetObject,
        Property<TS, TV> targetProperty, String name) {
        return new AutoBinding<SS, SS, TS, TV>(strategy, sourceObject,
            ObjectProperty.<SS>create(), targetObject, targetProperty, name);
    }

    /**
     * Creates an instance of {@code AutoBinding} that binds a property of a source object to a property of a target object.
     *
     * @param strategy the update strategy for the binding
     * @param sourceObject the source object
     * @param sourceProperty the source property
     * @param targetObject the target object
     * @param targetProperty the target property
     * @return an {@code AutoBinding} that binds the source object to the target property of the target object
     * @throws IllegalArgumentException if the update strategy, source property or target property is {@code null}
     */
    public static <SS, SV, TS, TV> AutoBinding<SS, SV, TS, TV> createAutoBinding(
        AutoBinding.UpdateStrategy strategy, SS sourceObject,
        Property<SS, SV> sourceProperty, TS targetObject,
        Property<TS, TV> targetProperty) {
        return new AutoBinding<SS, SV, TS, TV>(strategy, sourceObject,
            sourceProperty, targetObject, targetProperty, null);
    }

    /**
     * Creates a named instance of {@code AutoBinding} that binds a property of a source object to a property of a target object.
     *
     * @param strategy the update strategy for the binding
     * @param sourceObject the source object
     * @param sourceProperty the source property
     * @param targetObject the target object
     * @param targetProperty the target property
     * @param name a name for the binding
     * @return an {@code AutoBinding} that binds the source object to the target property of the target object
     * @throws IllegalArgumentException if the update strategy, source property or target property is {@code null}
     */
    public static <SS, SV, TS, TV> AutoBinding<SS, SV, TS, TV> createAutoBinding(
        AutoBinding.UpdateStrategy strategy, SS sourceObject,
        Property<SS, SV> sourceProperty, TS targetObject,
        Property<TS, TV> targetProperty, String name) {
        return new AutoBinding<SS, SV, TS, TV>(strategy, sourceObject,
            sourceProperty, targetObject, targetProperty, name);
    }
}
