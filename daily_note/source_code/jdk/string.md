#### 定义

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
        ...
    }
```
- 被final修饰，不能被继承
- 实现序列化接口，支持序列化和反序列化

#### 属性

```java
private final char value[];
```
- 字符数组，用于存放字符串内容
- 被final修饰，一旦创建无法进行修改
- 字符串创建之后修改赋值，只是将其指向了其他字符串，并不是对其内容进行修改

---

```java
private int hash;
```
存放字符串哈希值

```java
private static final long serialVersionUID = -6849794470754667710L;

private static final ObjectStreamField[] serialPersistentFields =
    new ObjectStreamField[0];
```

序列化相关

#### 构造方法

```java
public String() {
    this.value = "".value;
}
```

空构造器，string是不可变的，因此不建议使用该方法，会产生无用对象

```java
public String(String original) {
    this.value = original.value;
    this.hash = original.hash;
}
```

将源字符串的内容和哈希值直接赋值给目标字符串。因为string是不可变的，所以改变源字符串不会影响到目标字符串

```java
public String(char value[]) {
    this.value = Arrays.copyOf(value, value.length);
}

public String(char value[], int offset, int count) {
    if (offset < 0) {
        throw new StringIndexOutOfBoundsException(offset);
    }
    if (count <= 0) {
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        if (offset <= value.length) {
            this.value = "".value;
            return;
        }
    }
    // Note: offset or count might be near -1>>>1.
    if (offset > value.length - count) {
        throw new StringIndexOutOfBoundsException(offset + count);
    }
    this.value = Arrays.copyOfRange(value, offset, offset+count);
}
```

使用字符数组创建字符串，会调用Arrays相关方法把内容复制一份，因此新旧字符串互不影响

```java
public String(int[] codePoints, int offset, int count)
```

使用unicode编码数组创建字符串

```java

public String(byte bytes[], int offset, int length, String charsetName)
public String(byte bytes[], int offset, int length, Charset charset)    
public String(byte bytes[], String charsetName)    
public String(byte bytes[], Charset charset)
public String(byte bytes[], int offset, int length)
public String(byte bytes[])
```

使用字节数组创建字符串，涉及到编码问题，不指定时java会使用默认编码

```java
public String(StringBuffer buffer)
public String(StringBuilder builder)
```

使用StringBuffer和StringBuilder创建字符串，一般用不到该构造器，使用toString方法

```java
String(char[] value, boolean share) {
    this.value = value;
}
```

share参数只允许传true，为了区分**String(char[] value)**方法，区别是使用该构造器创建的字符串会和原数据共享同一个数组。不是公有的方法，公有会破坏字符串不可变的特性。优点是速度快，节约内存。

