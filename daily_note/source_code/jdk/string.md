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

使用字节数组创建字符串，涉及到编码问题，不指定时java会使用默认编码ISO-8859-1

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

#### 其他方法

```java
//返回字符串长度
public int length()
//返回字符串是否为空
public boolean isEmpty()    
//返回特定位置字符
public char charAt(int index)
//获取字节数组，同样涉及到编码问题，不指定使用默认编码ISO-8859-1
public byte[] getBytes(String charsetName)
public byte[] getBytes(Charset charset)    
public byte[] getBytes()
//判断两字符串是否相等
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}    
//其他比较相关方法
public boolean contentEquals(StringBuffer sb)
public boolean contentEquals(CharSequence cs)    
public boolean equalsIgnoreCase(String anotherString)    
public int compareTo(String anotherString) {
    int len1 = value.length;
    int len2 = anotherString.value.length;
    int lim = Math.min(len1, len2);
    char v1[] = value;
    char v2[] = anotherString.value;

    int k = 0;
    while (k < lim) {
        char c1 = v1[k];
        char c2 = v2[k];
        if (c1 != c2) {
            return c1 - c2;
        }
        k++;
    }
    return len1 - len2;
}  
public int compareToIgnoreCase(String str)
//局部匹配    
public boolean regionMatches(int toffset, String other, int ooffset, int len)   
public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)    
public boolean startsWith(String prefix, int toffset)    
public boolean startsWith(String prefix)    
public boolean endsWith(String suffix)    
//哈希值    
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
//返回内容位置
public int indexOf(int ch)    
public int indexOf(int ch, int fromIndex)
public int lastIndexOf(int ch)
public int lastIndexOf(int ch, int fromIndex)
public int indexOf(String str)
public int indexOf(String str, int fromIndex)
static int indexOf(char[] source, int sourceOffset, int sourceCount, String target, int fromIndex)
static int indexOf(char[] source, int sourceOffset, int sourceCount, char[] target, int targetOffset, int targetCount, int fromIndex)
public int lastIndexOf(String str)
public int lastIndexOf(String str, int fromIndex)
//返回子串，复制一个新数组返回，不共享，避免内存泄露
public String substring(int beginIndex)
public String substring(int beginIndex, int endIndex)
public CharSequence subSequence(int beginIndex, int endIndex)
//拼接字符串
public String concat(String str)
//替换    
public String replace(char oldChar, char newChar)
public String replaceFirst(String regex, String replacement)    
public String replaceAll(String regex, String replacement)      
//正则匹配    
public boolean matches(String regex)    
//是否包含    
public boolean contains(CharSequence s)    
//拆分    
public String[] split(String regex, int limit)    
public String[] split(String regex)    
//字符串拼接，使用StringJoiner实现    
public static String join(CharSequence delimiter, CharSequence... elements)    
public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)  
//大小写转换    
public String toLowerCase(Locale locale)    
public String toLowerCase()    
public String toUpperCase(Locale locale)    
public String toUpperCase()    
//去空格
public String trim()
//如果对象池中已经包含这一个相等的字符串对象则返回对象池中的实例，否则添加字符串到对象池并返回该字符串的引用
public native String intern()    
    String str1 = new String("hello word");
    String str2 = new String("hello word");
    System.out.println(str1 == str1.intern());//false
    System.out.println(str2 == str2.intern());//false
    System.out.println(str1.intern() == str2.intern());//true

valueOf和copyValueOf方法本质上相同
String.valueOf和Integer.toString本质相同，前者调用后者实现
String重载“+”运算符，使用StringBuilder的append()和toString()方法实现
    
String st1 = "hello";
String st2 = "hello";
System.out.println(st1 == st2); //true 都指向字符串常量池内容   
    
String s = new String("hollis");    
若常量池中已经存在”hollis”，则直接引用，也就是此时只会创建一个对象，如果常量池中不存在”hollis”，则先创建后引用，也就是有两个 
```

