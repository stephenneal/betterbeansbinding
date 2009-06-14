#Signature file v4.0
#Version openapi-v2

CLSS public java.lang.Object
cons public Object()
meth protected java.lang.Object clone() throws java.lang.CloneNotSupportedException
meth protected void finalize() throws java.lang.Throwable
meth public boolean equals(java.lang.Object)
meth public final java.lang.Class<?> getClass()
meth public final void notify()
meth public final void notifyAll()
meth public final void wait() throws java.lang.InterruptedException
meth public final void wait(long) throws java.lang.InterruptedException
meth public final void wait(long,int) throws java.lang.InterruptedException
meth public int hashCode()
meth public java.lang.String toString()

CLSS public org.jdesktop.beansbinding.AutoBinding<%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object, %3 extends java.lang.Object>
cons protected AutoBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{org.jdesktop.beansbinding.AutoBinding%0},org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.AutoBinding%0},{org.jdesktop.beansbinding.AutoBinding%1}>,{org.jdesktop.beansbinding.AutoBinding%2},org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.AutoBinding%2},{org.jdesktop.beansbinding.AutoBinding%3}>,java.lang.String)
innr public final static !enum UpdateStrategy
meth protected java.lang.String paramString()
meth protected void bindImpl()
meth protected void sourceChangedImpl(org.jdesktop.beansbinding.PropertyStateEvent)
meth protected void targetChangedImpl(org.jdesktop.beansbinding.PropertyStateEvent)
meth protected void unbindImpl()
meth public final org.jdesktop.beansbinding.AutoBinding$UpdateStrategy getUpdateStrategy()
supr org.jdesktop.beansbinding.Binding<{org.jdesktop.beansbinding.AutoBinding%0},{org.jdesktop.beansbinding.AutoBinding%1},{org.jdesktop.beansbinding.AutoBinding%2},{org.jdesktop.beansbinding.AutoBinding%3}>
hfds strategy

CLSS public abstract org.jdesktop.beansbinding.Binding<%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object, %3 extends java.lang.Object>
cons protected Binding({org.jdesktop.beansbinding.Binding%0},org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%0},{org.jdesktop.beansbinding.Binding%1}>,{org.jdesktop.beansbinding.Binding%2},org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%2},{org.jdesktop.beansbinding.Binding%3}>,java.lang.String)
innr public final static !enum SyncFailureType
innr public final static SyncFailure
innr public final static ValueResult
meth protected abstract void bindImpl()
meth protected abstract void unbindImpl()
meth protected final org.jdesktop.beansbinding.Binding$SyncFailure refreshAndNotifyUnmanaged()
meth protected final org.jdesktop.beansbinding.Binding$SyncFailure refreshUnmanaged()
meth protected final org.jdesktop.beansbinding.Binding$SyncFailure saveAndNotifyUnmanaged()
meth protected final org.jdesktop.beansbinding.Binding$SyncFailure saveUnmanaged()
meth protected final void bindUnmanaged()
meth protected final void firePropertyChange(java.lang.String,java.lang.Object,java.lang.Object)
meth protected final void notifySyncFailed(org.jdesktop.beansbinding.Binding$SyncFailure)
meth protected final void notifySynced()
meth protected final void setManaged(boolean)
meth protected final void setSourceObjectUnmanaged({org.jdesktop.beansbinding.Binding%0})
meth protected final void setSourceProperty(org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%0},{org.jdesktop.beansbinding.Binding%1}>)
meth protected final void setTargetObjectUnmanaged({org.jdesktop.beansbinding.Binding%2})
meth protected final void setTargetProperty(org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%2},{org.jdesktop.beansbinding.Binding%3}>)
meth protected final void throwIfBound()
meth protected final void throwIfManaged()
meth protected final void throwIfUnbound()
meth protected final void unbindUnmanaged()
meth protected java.lang.String paramString()
meth protected void sourceChangedImpl(org.jdesktop.beansbinding.PropertyStateEvent)
meth protected void targetChangedImpl(org.jdesktop.beansbinding.PropertyStateEvent)
meth public final boolean isBound()
meth public final boolean isManaged()
meth public final boolean isSourceUnreadableValueSet()
meth public final java.beans.PropertyChangeListener[] getPropertyChangeListeners()
meth public final java.beans.PropertyChangeListener[] getPropertyChangeListeners(java.lang.String)
meth public final java.lang.String getName()
meth public final org.jdesktop.beansbinding.Binding$SyncFailure refresh()
meth public final org.jdesktop.beansbinding.Binding$SyncFailure refreshAndNotify()
meth public final org.jdesktop.beansbinding.Binding$SyncFailure save()
meth public final org.jdesktop.beansbinding.Binding$SyncFailure saveAndNotify()
meth public final org.jdesktop.beansbinding.Binding$ValueResult<{org.jdesktop.beansbinding.Binding%1}> getTargetValueForSource()
meth public final org.jdesktop.beansbinding.Binding$ValueResult<{org.jdesktop.beansbinding.Binding%3}> getSourceValueForTarget()
meth public final org.jdesktop.beansbinding.BindingListener[] getBindingListeners()
meth public final org.jdesktop.beansbinding.Converter<{org.jdesktop.beansbinding.Binding%1},{org.jdesktop.beansbinding.Binding%3}> getConverter()
meth public final org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%0},{org.jdesktop.beansbinding.Binding%1}> getSourceProperty()
meth public final org.jdesktop.beansbinding.Property<{org.jdesktop.beansbinding.Binding%2},{org.jdesktop.beansbinding.Binding%3}> getTargetProperty()
meth public final org.jdesktop.beansbinding.Validator<? super {org.jdesktop.beansbinding.Binding%1}> getValidator()
meth public final void addBindingListener(org.jdesktop.beansbinding.BindingListener)
meth public final void addPropertyChangeListener(java.beans.PropertyChangeListener)
meth public final void addPropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener)
meth public final void bind()
meth public final void removeBindingListener(org.jdesktop.beansbinding.BindingListener)
meth public final void removePropertyChangeListener(java.beans.PropertyChangeListener)
meth public final void removePropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener)
meth public final void setConverter(org.jdesktop.beansbinding.Converter<{org.jdesktop.beansbinding.Binding%1},{org.jdesktop.beansbinding.Binding%3}>)
meth public final void setSourceNullValue({org.jdesktop.beansbinding.Binding%3})
meth public final void setSourceObject({org.jdesktop.beansbinding.Binding%0})
meth public final void setSourceUnreadableValue({org.jdesktop.beansbinding.Binding%3})
meth public final void setTargetNullValue({org.jdesktop.beansbinding.Binding%1})
meth public final void setTargetObject({org.jdesktop.beansbinding.Binding%2})
meth public final void setValidator(org.jdesktop.beansbinding.Validator<? super {org.jdesktop.beansbinding.Binding%1}>)
meth public final void unbind()
meth public final void unsetSourceUnreadableValue()
meth public final {org.jdesktop.beansbinding.Binding%0} getSourceObject()
meth public final {org.jdesktop.beansbinding.Binding%1} getTargetNullValue()
meth public final {org.jdesktop.beansbinding.Binding%2} getTargetObject()
meth public final {org.jdesktop.beansbinding.Binding%3} getSourceNullValue()
meth public final {org.jdesktop.beansbinding.Binding%3} getSourceUnreadableValue()
meth public java.lang.String toString()
supr java.lang.Object
hfds changeSupport,converter,ignoreChange,isBound,isManaged,listeners,name,psl,sourceNullValue,sourceObject,sourceProperty,sourceUnreadableValue,sourceUnreadableValueSet,targetNullValue,targetObject,targetProperty,validator
hcls PSL

CLSS public abstract interface org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public abstract boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public abstract java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public abstract java.lang.Object createAdapter(java.lang.Object,java.lang.String)

CLSS public final org.jdesktop.swingbinding.JComboBoxBinding<%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object>
cons protected JComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{org.jdesktop.swingbinding.JComboBoxBinding%1},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JComboBoxBinding%1},java.util.List<{org.jdesktop.swingbinding.JComboBoxBinding%0}>>,{org.jdesktop.swingbinding.JComboBoxBinding%2},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JComboBoxBinding%2},? extends javax.swing.JComboBox>,java.lang.String)
meth protected void bindImpl()
meth protected void unbindImpl()
supr org.jdesktop.beansbinding.AutoBinding<{org.jdesktop.swingbinding.JComboBoxBinding%1},java.util.List<{org.jdesktop.swingbinding.JComboBoxBinding%0}>,{org.jdesktop.swingbinding.JComboBoxBinding%2},java.util.List>
hfds combo,comboP,elementsP,handler,model
hcls BindingComboBoxModel,Handler

CLSS public final org.jdesktop.swingbinding.JListBinding<%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object>
cons protected JListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{org.jdesktop.swingbinding.JListBinding%1},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JListBinding%1},java.util.List<{org.jdesktop.swingbinding.JListBinding%0}>>,{org.jdesktop.swingbinding.JListBinding%2},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JListBinding%2},? extends javax.swing.JList>,java.lang.String)
innr public final DetailBinding
meth protected void bindImpl()
meth protected void unbindImpl()
meth public org.jdesktop.swingbinding.JListBinding$DetailBinding getDetailBinding()
meth public org.jdesktop.swingbinding.JListBinding$DetailBinding setDetailBinding(org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JListBinding%0},?>)
meth public org.jdesktop.swingbinding.JListBinding$DetailBinding setDetailBinding(org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JListBinding%0},?>,java.lang.String)
supr org.jdesktop.beansbinding.AutoBinding<{org.jdesktop.swingbinding.JListBinding%1},java.util.List<{org.jdesktop.swingbinding.JListBinding%0}>,{org.jdesktop.swingbinding.JListBinding%2},java.util.List>
hfds DETAIL_PROPERTY,detailBinding,elementsP,handler,list,listP,model
hcls BindingListModel,Handler

CLSS public final org.jdesktop.swingbinding.JListBinding$DetailBinding
supr org.jdesktop.swingbinding.impl.AbstractColumnBinding

CLSS public final org.jdesktop.swingbinding.JTableBinding<%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object>
cons protected JTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{org.jdesktop.swingbinding.JTableBinding%1},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%1},java.util.List<{org.jdesktop.swingbinding.JTableBinding%0}>>,{org.jdesktop.swingbinding.JTableBinding%2},org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%2},? extends javax.swing.JTable>,java.lang.String)
innr public final ColumnBinding
meth protected void bindImpl()
meth protected void unbindImpl()
meth public boolean isEditable()
meth public boolean removeColumnBinding(org.jdesktop.swingbinding.JTableBinding$ColumnBinding)
meth public java.util.List<org.jdesktop.swingbinding.JTableBinding$ColumnBinding> getColumnBindings()
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding addColumnBinding(int,org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%0},?>)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding addColumnBinding(int,org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%0},?>,java.lang.String)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding addColumnBinding(org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%0},?>)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding addColumnBinding(org.jdesktop.beansbinding.Property<{org.jdesktop.swingbinding.JTableBinding%0},?>,java.lang.String)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding getColumnBinding(int)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding removeColumnBinding(int)
meth public void setEditable(boolean)
supr org.jdesktop.beansbinding.AutoBinding<{org.jdesktop.swingbinding.JTableBinding%1},java.util.List<{org.jdesktop.swingbinding.JTableBinding%0}>,{org.jdesktop.swingbinding.JTableBinding%2},java.util.List>
hfds columnBindings,editable,elementsP,handler,model,table,tableP
hcls BindingTableModel,ColumnProperty,Handler

CLSS public final org.jdesktop.swingbinding.JTableBinding$ColumnBinding
meth public boolean isEditable()
meth public java.lang.Class<?> getColumnClass()
meth public java.lang.String getColumnName()
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding setColumnClass(java.lang.Class<?>)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding setColumnName(java.lang.String)
meth public org.jdesktop.swingbinding.JTableBinding$ColumnBinding setEditable(boolean)
supr org.jdesktop.swingbinding.impl.AbstractColumnBinding
hfds columnClass,columnName,editable,editableSet,editingObject

CLSS public org.jdesktop.swingbinding.SwingBindings
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},{%%1},{%%2}> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JComboBox>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},{%%1},{%%2}> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JComboBox>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},{%%1},{%%2}> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JList>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},{%%1},{%%2}> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JList>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},{%%1},{%%2}> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JTable>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object, %2 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},{%%1},{%%2}> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,{%%2},org.jdesktop.beansbinding.Property<{%%2},? extends javax.swing.JTable>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JComboBox>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JComboBox>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},{%%1},javax.swing.JComboBox> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JComboBox)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},{%%1},javax.swing.JComboBox> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JComboBox,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JList>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JList>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},{%%1},javax.swing.JList> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JList)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},{%%1},javax.swing.JList> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JList,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JTable>)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},java.util.List<{%%0}>,{%%1}> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,{%%1},org.jdesktop.beansbinding.Property<{%%1},? extends javax.swing.JTable>,java.lang.String)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},{%%1},javax.swing.JTable> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JTable)
meth public static <%0 extends java.lang.Object, %1 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},{%%1},javax.swing.JTable> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,{%%1},org.jdesktop.beansbinding.Property<{%%1},java.util.List<{%%0}>>,javax.swing.JTable,java.lang.String)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},java.util.List<{%%0}>,javax.swing.JComboBox> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JComboBox)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JComboBoxBinding<{%%0},java.util.List<{%%0}>,javax.swing.JComboBox> createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JComboBox,java.lang.String)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},java.util.List<{%%0}>,javax.swing.JList> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JList)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JListBinding<{%%0},java.util.List<{%%0}>,javax.swing.JList> createJListBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JList,java.lang.String)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},java.util.List<{%%0}>,javax.swing.JTable> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JTable)
meth public static <%0 extends java.lang.Object> org.jdesktop.swingbinding.JTableBinding<{%%0},java.util.List<{%%0}>,javax.swing.JTable> createJTableBinding(org.jdesktop.beansbinding.AutoBinding$UpdateStrategy,java.util.List<{%%0}>,javax.swing.JTable,java.lang.String)
supr java.lang.Object

CLSS public final org.jdesktop.swingbinding.adapters.AbstractButtonAdapterProvider
cons public AbstractButtonAdapterProvider()
innr public final static Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds SELECTED_P

CLSS public final static org.jdesktop.swingbinding.adapters.AbstractButtonAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public boolean isSelected()
meth public void setSelected(boolean)
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds button,cachedSelected,handler
hcls Handler

CLSS public org.jdesktop.swingbinding.adapters.BeanAdapterBase
cons protected BeanAdapterBase(java.lang.String)
fld protected final java.lang.String property
meth protected final boolean isListening()
meth protected final void firePropertyChange(java.lang.Object,java.lang.Object)
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public final java.beans.PropertyChangeListener[] getPropertyChangeListeners()
meth public final java.beans.PropertyChangeListener[] getPropertyChangeListeners(java.lang.String)
meth public final void addPropertyChangeListener(java.beans.PropertyChangeListener)
meth public final void addPropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener)
meth public final void removePropertyChangeListener(java.beans.PropertyChangeListener)
meth public final void removePropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener)
supr java.lang.Object
hfds support

CLSS public final org.jdesktop.swingbinding.adapters.JComboBoxAdapterProvider
cons public JComboBoxAdapterProvider()
innr public final static Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds SELECTED_ITEM_P

CLSS public final static org.jdesktop.swingbinding.adapters.JComboBoxAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public java.lang.Object getSelectedItem()
meth public void setSelectedItem(java.lang.Object)
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedItem,combo,handler
hcls Handler

CLSS public final org.jdesktop.swingbinding.adapters.JListAdapterProvider
cons public JListAdapterProvider()
innr public final Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds SELECTED_ELEMENTS_IA_P,SELECTED_ELEMENTS_P,SELECTED_ELEMENT_IA_P,SELECTED_ELEMENT_P

CLSS public final org.jdesktop.swingbinding.adapters.JListAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public java.lang.Object getSelectedElement()
meth public java.lang.Object getSelectedElement_IGNORE_ADJUSTING()
meth public java.util.List<java.lang.Object> getSelectedElements()
meth public java.util.List<java.lang.Object> getSelectedElements_IGNORE_ADJUSTING()
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedElementOrElements,handler,list
hcls Handler

CLSS public final org.jdesktop.swingbinding.adapters.JSliderAdapterProvider
cons public JSliderAdapterProvider()
innr public final static Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds IGNORE_ADJUSTING,PROPERTY_BASE

CLSS public final static org.jdesktop.swingbinding.adapters.JSliderAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public int getValue()
meth public int getValue_IGNORE_ADJUSTING()
meth public void setValue(int)
meth public void setValue_IGNORE_ADJUSTING(int)
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedValue,handler,slider
hcls Handler

CLSS public final org.jdesktop.swingbinding.adapters.JSpinnerAdapterProvider
cons public JSpinnerAdapterProvider()
innr public final static Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds VALUE_P

CLSS public final static org.jdesktop.swingbinding.adapters.JSpinnerAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public java.lang.Object getValue()
meth public void setValue(java.lang.Object)
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedValue,handler,spinner
hcls Handler

CLSS public final org.jdesktop.swingbinding.adapters.JTableAdapterProvider
cons public JTableAdapterProvider()
innr public final Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds IS_JAVA_15,SELECTED_ELEMENTS_IA_P,SELECTED_ELEMENTS_P,SELECTED_ELEMENT_IA_P,SELECTED_ELEMENT_P

CLSS public final org.jdesktop.swingbinding.adapters.JTableAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public java.lang.Object getSelectedElement()
meth public java.lang.Object getSelectedElement_IGNORE_ADJUSTING()
meth public java.util.List<java.lang.Object> getSelectedElements()
meth public java.util.List<java.lang.Object> getSelectedElements_IGNORE_ADJUSTING()
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedElementOrElements,handler,table
hcls Handler

CLSS public final org.jdesktop.swingbinding.adapters.JTextComponentAdapterProvider
cons public JTextComponentAdapterProvider()
innr public final Adapter
intf org.jdesktop.beansbinding.ext.BeanAdapterProvider
meth public boolean providesAdapter(java.lang.Class<?>,java.lang.String)
meth public java.lang.Class<?> getAdapterClass(java.lang.Class<?>)
meth public java.lang.Object createAdapter(java.lang.Object,java.lang.String)
supr java.lang.Object
hfds ON_ACTION_OR_FOCUS_LOST,ON_FOCUS_LOST,PROPERTY_BASE

CLSS public final org.jdesktop.swingbinding.adapters.JTextComponentAdapterProvider$Adapter
meth protected void listeningStarted()
meth protected void listeningStopped()
meth public java.lang.String getText()
meth public java.lang.String getText_ON_ACTION_OR_FOCUS_LOST()
meth public java.lang.String getText_ON_FOCUS_LOST()
meth public void setText(java.lang.String)
meth public void setText_ON_ACTION_OR_FOCUS_LOST(java.lang.String)
meth public void setText_ON_FOCUS_LOST(java.lang.String)
supr org.jdesktop.swingbinding.adapters.BeanAdapterBase
hfds cachedText,component,document,handler,inDocumentListener,installedFilter
hcls Handler

