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
 * $Id: BindingListener.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import java.util.EventListener;


/**
 * {@code BindingListeners} are registered on {@code Bindings} or {@code BindingGroups}
 * to listen for changes to the state of {@code Bindings}
 *
 * @see Binding
 * @see BindingGroup
 *
 * @author Shannon Hickey
 */
public interface BindingListener extends EventListener {
    /**
     * Notification that a {@code Binding} has been bound.
     *
     * @param binding the {@code Binding}
     */
    public void bindingBecameBound(Binding binding);

    /**
     * Notification that a {@code Binding} has been unbound.
     *
     * @param binding the {@code Binding}
     */
    public void bindingBecameUnbound(Binding binding);

    /**
     * Notification that the {@code Binding} attempted to sync the source and
     * target, but the sync failed.
     *
     * @param binding the {@code Binding}
     * @param failure the reason the sync failed
     */
    public void syncFailed(Binding binding, Binding.SyncFailure failure);

    /**
     * Notification that the source and target of a {@code Binding} have
     * been made in sync.
     *
     * @param binding the {@code Binding}
     */
    public void synced(Binding binding);

    /**
     * Notification that the source property of a {@code Binding} has fired
     * a {@code PropertyStateEvent} for the {@code Binding's} source object.
     *
     * @param binding the {@code Binding}
     */
    public void sourceChanged(Binding binding, PropertyStateEvent event);

    /**
     * Notification that the target property of a {@code Binding} has fired
     * a {@code PropertyStateEvent} for the {@code Binding's} target object.
     *
     * @param binding the {@code Binding}
     */
    public void targetChanged(Binding binding, PropertyStateEvent event);
}
