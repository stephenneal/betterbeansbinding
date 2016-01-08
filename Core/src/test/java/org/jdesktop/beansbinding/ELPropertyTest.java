package org.jdesktop.beansbinding;

import static org.junit.Assert.assertEquals;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.List;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.junit.Test;

public class ELPropertyTest {

    @Test
    public void testDetach() throws Exception {

        BoundObject sourceObject = new BoundObject();
        BoundObject targetObject = new BoundObject();

        ELProperty<Object, Object> prop = ELProperty.create("${watchedValue}");
        AutoBinding<Object, Object, Object, Object> binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
                sourceObject, prop, targetObject, BeanProperty.create("watchedValue"));

        binding.bind();

        // Our source object now knows it's being watched
        assertEquals(1, sourceObject.changeSupport.getPropertyChangeListeners().length);
        // The listeners map in PropertyHelper has now been created
        assertEquals(1, prop.getPropertyStateListeners(sourceObject).length);

        binding.unbind();

        // Source object no longer watched
        assertEquals(0, sourceObject.changeSupport.getPropertyChangeListeners().length);
        // The listeners map in PropertyHelper now has no values for our source
        // object
        assertEquals(0, prop.getPropertyStateListeners(sourceObject).length);

        // Have to use reflection to check the keys of the listeners map
        Field listenersField = prop.getClass().getSuperclass().getDeclaredField("listeners");
        listenersField.setAccessible(true);
        Object listeners = listenersField.get(prop);
        IdentityHashMap<?, List<PropertyStateListener>> map = (IdentityHashMap<?, List<PropertyStateListener>>) listeners;

        // Show the listeners map's keys
        System.out.println(map.keySet());
        // As per ticket #57 by mikhail.maximov, the map still has a reference
        // to our source object
        assertEquals(0, map.size());
    }

    public class BoundObject {
        public PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

        private String watchedValue = "default";

        public String getWatchedValue() {
            return watchedValue;
        }

        public void setWatchedValue(String watchedValue) {
            String oldWatchedValue = this.watchedValue;
            this.watchedValue = watchedValue;
            changeSupport.firePropertyChange("watchedValue", oldWatchedValue, watchedValue);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.removePropertyChangeListener(listener);
        }
    }
}