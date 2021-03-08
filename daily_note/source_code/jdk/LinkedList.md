#### 定义

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    ...
}
```

#### 属性

```java
//大小
transient int size = 0;
//第一个节点
transient Node<E> first;
//最后一个节点
transient Node<E> last;
```

#### 内部类

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```

#### 构造器

###### 空构造器

```java
public LinkedList() {
}
```

###### 通过已有集合构造

```java
public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
public boolean addAll(Collection<? extends E> c) {
    return addAll(size, c);
}
public boolean addAll(Collection<? extends E> c) {
    return addAll(size, c);
}
public boolean addAll(int index, Collection<? extends E> c) {
    //检查index是否越界
    checkPositionIndex(index);

    Object[] a = c.toArray();
    int numNew = a.length;
    //没有新增元素时直接返回
    if (numNew == 0)
        return false;

    //前一个节点和后一个节点
    Node<E> pred, succ;
    if (index == size) {
        //最后一个节点增加，前一个设置为旧的最后一个节点，后一个为null
        succ = null;
        pred = last;
    } else {
        //不是最后一个节点，后一个为原index位置节点，前一个为原index位置节点
        succ = node(index);
        pred = succ.prev;
    }

    //循环放入每一个元素
    for (Object o : a) {
        @SuppressWarnings("unchecked") E e = (E) o;
        Node<E> newNode = new Node<>(pred, e, null);
        //放置到第一个时，设置头节点
        if (pred == null)
            first = newNode;
        else
            //否则设置前一个节点的后一个节点是自己
            pred.next = newNode;
        //下一个节点的前一个设置为自己
        pred = newNode;
    }

    if (succ == null) {
        //后一个节点为空时，自己就是最后一个
        last = pred;
    } else {
        //否则前一个的后一个是自己，后一个的前一个是自己
        pred.next = succ;
        succ.prev = pred;
    }

    size += numNew;
    modCount++;
    return true;
}
private void checkPositionIndex(int index) {
    if (!isPositionIndex(index))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
private boolean isPositionIndex(int index) {
    return index >= 0 && index <= size;
}
```

#### 方法

```java
//获取最后一个元素
public E getLast() {
    final Node<E> l = last;
    if (l == null)
        throw new NoSuchElementException();
    return l.item;
}

//去掉最后一个元素
public E removeLast() {
    final Node<E> l = last;
    if (l == null)
        throw new NoSuchElementException();
    return unlinkLast(l);
}

//第一个位置放入新元素
public void addFirst(E e) {
    linkFirst(e);
}
private void linkFirst(E e) {
    final Node<E> f = first;
    final Node<E> newNode = new Node<>(null, e, f);
    first = newNode;
    if (f == null)
        last = newNode;
    else
        f.prev = newNode;
    size++;
    modCount++;
}

//最后一个位置放入新元素
public void addLast(E e) {
    linkLast(e);
}

//是否包含元素
public boolean contains(Object o) {
    return indexOf(o) != -1;
}

//返回元素位置
public int indexOf(Object o) {
    int index = 0;
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null)
                return index;
            index++;
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item))
                return index;
            index++;
        }
    }
    return -1;
}

//元素个数
public int size() {
    return size;
}

//添加元素
public boolean add(E e) {
    linkLast(e);
    return true;
}

//移除元素
public boolean remove(Object o) {
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                unlink(x);
                return true;
            }
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
    }
    return false;
}

//清空
public void clear() {
    for (Node<E> x = first; x != null; ) {
        Node<E> next = x.next;
        x.item = null;
        x.next = null;
        x.prev = null;
        x = next;
    }
    first = last = null;
    size = 0;
    modCount++;
}

//获取某个位置元素
public E get(int index) {
    checkElementIndex(index);
    return node(index).item;
}
Node<E> node(int index) {
    // assert isElementIndex(index);
	
    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}

//某个位置赋值
public E set(int index, E element) {
    checkElementIndex(index);
    Node<E> x = node(index);
    E oldVal = x.item;
    x.item = element;
    return oldVal;
}

//某个位置添加元素
public void add(int index, E element) {
    checkPositionIndex(index);

    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}

//某个位置移除元素
public E remove(int index) {
    checkElementIndex(index);
    return unlink(node(index));
}

//最后一次出现的位置
public int lastIndexOf(Object o) {
    int index = size;
    if (o == null) {
        for (Node<E> x = last; x != null; x = x.prev) {
            index--;
            if (x.item == null)
                return index;
        }
    } else {
        for (Node<E> x = last; x != null; x = x.prev) {
            index--;
            if (o.equals(x.item))
                return index;
        }
    }
    return -1;
}

//返回第一个元素的值
public E peek() {
    final Node<E> f = first;
    return (f == null) ? null : f.item;
}
public E element() {
    return getFirst();
}
public E getFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return f.item;
}

//返回第一个元素并移除
public E poll() {
    final Node<E> f = first;
    return (f == null) ? null : unlinkFirst(f);
}
public E remove() {
    return removeFirst();
}
public E removeFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
}
private E unlinkFirst(Node<E> f) {
    // assert f == first && f != null;
    final E element = f.item;
    final Node<E> next = f.next;
    f.item = null;
    f.next = null; // help GC
    first = next;
    if (next == null)
        last = null;
    else
        next.prev = null;
    size--;
    modCount++;
    return element;
}
```

