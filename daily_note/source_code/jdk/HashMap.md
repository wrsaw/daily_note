#### 定义

```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {
    ...
}
```

#### 属性

```java
//序列化id
private static final long serialVersionUID = 362498820763181265L;
//默认容量，16
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//最大容量
static final int MAXIMUM_CAPACITY = 1 << 30;
//默认负载因子
static final float DEFAULT_LOAD_FACTOR = 0.75f;
//key值元素数量大于该值时由连表转为树
static final int TREEIFY_THRESHOLD = 8;
//key值元素数量小于该值时由树转为连表
static final int UNTREEIFY_THRESHOLD = 6;
//key数量大于该值时进行树化
static final int MIN_TREEIFY_CAPACITY = 64;
//储存数据
transient Node<K,V>[] table;
//entrySet()的缓存
transient Set<Map.Entry<K,V>> entrySet;
//元素个数
transient int size;
//修改次数，用于快速失败
transient int modCount;
//元素个数达到多少时进行扩容，capacity * load factor
int threshold;
//负载因子
final float loadFactor;



```

#### 内部类

```java
//节点
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}
//keySet
final class KeySet extends AbstractSet<K> {
    ...
}
//Values
final class Values extends AbstractCollection<V> {
    ...
}
//EntrySet
final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
    ...
}
```

#### 构造器

###### 指定容量和负载因子

```java
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}
//返回不小于输入参数且最近的2的整数次幂的数
static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

###### 指定容量，不指定负载因子

```java
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}
```

###### 不指定容量和负载因子

```java
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
}
```

###### 通过已有Map构建

```java
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}
//设置Map大小并填充内容
final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
    int s = m.size();
    //m有元素时执行
    if (s > 0) {
        //之前为空的map时，重新设置大小
        if (table == null) { // pre-size
            float ft = ((float)s / loadFactor) + 1.0F;
            int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                     (int)ft : MAXIMUM_CAPACITY);
            if (t > threshold)
                threshold = tableSizeFor(t);
        }
        //m元素大于阈值时扩容为两倍
        else if (s > threshold)
            resize();
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            //填充内容，可能会触发扩容，涉及到连表和红黑树的转化
            putVal(hash(key), key, value, false, evict);
        }
    }
}
```

#### 其他方法

```java
//返回元素个数
public int size() {
    return size;
}
//是否为空
public boolean isEmpty() {
    return size == 0;
}
//获取元素
public V get(Object key)
//是否包含key
public boolean containsKey(Object key)
//赋值，可能触发扩容，根据阈值处理链表或红黑树
public V put(K key, V value)
public void putAll(Map<? extends K, ? extends V> m)
//移除元素
public V remove(Object key)
//清空    
public void clear() {
    Node<K,V>[] tab;
    modCount++;
    if ((tab = table) != null && size > 0) {
        size = 0;
        for (int i = 0; i < tab.length; ++i)
            tab[i] = null;
    }
}    
//是否包含value    
public boolean containsValue(Object value)    
//返回keySet    
public Set<K> keySet()    
//返回values    
public Collection<V> values()    
//返回entrySet     
public Set<Map.Entry<K,V>> entrySet()    
//获取元素，不存在返回默认值    
public V getOrDefault(Object key, V defaultValue)    
//不存在时赋值    
public V putIfAbsent(K key, V value)    
//移除元素    
public boolean remove(Object key, Object value)    
//替换    
public boolean replace(K key, V oldValue, V newValue)    
public V replace(K key, V value)    
    

```

