#### 定义

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    ...
}
```

#### 属性

```java
//序列化相关
private static final long serialVersionUID = 8683452581122892189L;
//默认容量
private static final int DEFAULT_CAPACITY = 10;
//共享的空列表实例，传入容量是0时使用
private static final Object[] EMPTY_ELEMENTDATA = {};
//共享的空列表实例，不传容量大小时默认使用,添加第一个元素时会初始化大小为默认容量
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//储存元素的数组
transient Object[] elementData;
//元素个数
private int size;
//最大数组大小，一些虚拟机下数组会保存头信息，超过该大小可能导致内存溢出
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
```

#### 构造方法

```java
//指定容量
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
//不指定容量
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

public ArrayList(Collection<? extends E> c)
```

#### 方法

##### 添加元素扩容

```java
public boolean add(E e) {
    //确保容量够用
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
private void ensureCapacityInternal(int minCapacity) {
    //不指定容量默认创建的数组，添加元素时最小容量为默认容量（10）
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }

    ensureExplicitCapacity(minCapacity);
}
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    //容量不够时扩容
    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    //先尝试扩大为旧的大小的1.5倍
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    //不满足时扩大为指定大小
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    //大于最大数组大小时变为Integer.MAX_VALUE
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ?
        Integer.MAX_VALUE :
    MAX_ARRAY_SIZE;
}
```

##### 其他方法

```java
//缩小容量为元素个数
public void trimToSize() {
    modCount++;
    if (size < elementData.length) {
        elementData = (size == 0)
            ? EMPTY_ELEMENTDATA
            : Arrays.copyOf(elementData, size);
    }
}
//返回元素个数
public int size() {
    return size;
}    
//返回是否是空数组    
public boolean isEmpty() {
    return size == 0;
}   
//是否包含某元素    
public boolean contains(Object o) {
    return indexOf(o) >= 0;
}    
//某元素出现的第一个位置    
public int indexOf(Object o) {
    if (o == null) {
        for (int i = 0; i < size; i++)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}    
//某元素出现的最后一个位置    
public int lastIndexOf(Object o) {
    if (o == null) {
        for (int i = size-1; i >= 0; i--)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = size-1; i >= 0; i--)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}    
//克隆，浅拷贝，不共用元素数组    
public Object clone() {
    try {
        ArrayList<?> v = (ArrayList<?>) super.clone();
        v.elementData = Arrays.copyOf(elementData, size);
        v.modCount = 0;
        return v;
    } catch (CloneNotSupportedException e) {
        // this shouldn't happen, since we are Cloneable
        throw new InternalError(e);
    }
}    
//转化为数组
public Object[] toArray()
public <T> T[] toArray(T[] a)    
//获取某个位置元素    
public E get(int index) {
    //范围检查
    rangeCheck(index);

    return elementData(index);
}    
E elementData(int index) {
    return (E) elementData[index];
}    
//给某个位置赋值，返回该位置旧的元素值    
public E set(int index, E element) {
    rangeCheck(index);

    E oldValue = elementData(index);
    elementData[index] = element;
    return oldValue;
}    
//某个位置添加元素    
public void add(int index, E element)   
//移除元素    
public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}    
public boolean remove(Object o)    
//清空数组    
public void clear() {
    modCount++;

    // clear to let GC do its work
    for (int i = 0; i < size; i++)
        elementData[i] = null;

    size = 0;
}    
//添加元素
public boolean addAll(Collection<? extends E> c)
public boolean addAll(int index, Collection<? extends E> c)
//移除元素
protected void removeRange(int fromIndex, int toIndex)
public boolean removeAll(Collection<?> c)
//保留元素
public boolean retainAll(Collection<?> c)
//指定位置开始的遍历器
public ListIterator<E> listIterator(int index)
//返回一个内部类SubList
public List<E> subList(int fromIndex, int toIndex)
//移除
public boolean removeIf(Predicate<? super E> filter)    
//替换    
public void replaceAll(UnaryOperator<E> operator)    
//排序    
public void sort(Comparator<? super E> c)    
    
```

##### 内部类

```java
//遍历器相关
private class Itr implements Iterator<E> {
	...
}
private class ListItr extends Itr implements ListIterator<E> {
    ...
}
//SubList子类，改变里面内容会影响原数组
private class SubList extends AbstractList<E> implements RandomAccess {
    ...
}
```

使用迭代器处理数组会检测modCount，可能抛出ConcurrentModificationException

