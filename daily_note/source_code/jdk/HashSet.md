#### 定义

```java
public class HashSet<E> extends AbstractSet<E> 
    implements Set<E>, Cloneable, java.io.Serializable {
    ...
}
```

#### 属性

```java
//序列化id
static final long serialVersionUID = -5024744406713321676L;
//存储元素
private transient HashMap<E,Object> map;
//存储元素时放入HashMap的假的key值
private static final Object PRESENT = new Object();
```

#### 构造器

```java
//空构造器，HashMap使用默认的容量（16）和负载因子（0.75）
public HashSet() {
    map = new HashMap<>();
}
//使用已有容器初始化
public HashSet(Collection<? extends E> c) {
    map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
    addAll(c);
}
//指定容量和负载因子
public HashSet(int initialCapacity, float loadFactor) {
    map = new HashMap<>(initialCapacity, loadFactor);
}
//指定容量
public HashSet(int initialCapacity) {
    map = new HashMap<>(initialCapacity);
}
```

#### 方法

```java
//迭代器
public Iterator<E> iterator() {
    return map.keySet().iterator();
}
//大小
public int size() {
    return map.size();
}
//是否为空
public boolean isEmpty() {
    return map.isEmpty();
}
//是否包含元素
public boolean contains(Object o) {
    return map.containsKey(o);
}
//添加
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}
//移除
public boolean remove(Object o) {
    return map.remove(o)==PRESENT;
}
//清空
public void clear() {
    map.clear();
}
```

