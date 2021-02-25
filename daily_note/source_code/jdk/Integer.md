#### 定义

```java
public final class Integer extends Number implements Comparable<Integer> {
    ...
}
```

- final类，不能被继承
- 继承Number类，Number类实现序列化接口，提供intValue()，longValue()，floatValue()，doubleValue()，byteValue()，shortValue()方法
- 实现Comparable接口

#### 属性

- 私有属性

```java
//储存Integer数值，final类型，不能改变
//对已有的Integer对象重新赋值会调用Integer.valueOf()方法指向已有的对象或重新创建对象
private final int value;
//序列化
private static final long serialVersionUID = 1360826667806852920L;
```

- 公共属性

```java
//int最小值，-2的31次方
public static final int MIN_VALUE = 0x80000000;
//int最大值，2的31次方
public static final int MAX_VALUE = 0x7fffffff;
//表示基本类型int的Class实例
public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
//用来以二进制补码形式表示int值的比特位数
public static final int SIZE = 32;
//用来以二进制补码形式表示int值的字节数
public static final int BYTES = SIZE / Byte.SIZE;
```

#### 方法

- 构造方法

```java
public Integer(int value)
public Integer(String s)
```

- 内部类

```java
//静态私有类，Integer类加载时初始化Integer缓存，默认最小-128，最大127，可以显式指定java.lang.Integer.IntegerCache.high属性    
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}   
```

- 哈希值

```java
public int hashCode()
public static int hashCode(int value)
```

- 比较

```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
public int compareTo(Integer anotherInteger)
public static int compare(int x, int y)
public static int compareUnsigned(int x, int y)
```

- 运算

```java
public static int sum(int a, int b)
public static int max(int a, int b)    
public static int min(int a, int b)
public static int divideUnsigned(int dividend, int divisor)    
public static int remainderUnsigned(int dividend, int divisor)  
```

- 类型转化

```java
//强转，如 return (long)value
public byte byteValue()
public short shortValue()
public int intValue()
public long longValue()
public float floatValue()
public double doubleValue()
public static long toUnsignedLong(int x)  
```

- String转int

```java
public static int parseInt(String s, int radix)    
public static int parseInt(String s)
public static int parseUnsignedInt(String s, int radix)    
public static int parseUnsignedInt(String s)
```

- int转String

```java
public static String toString(int i, int radix)
public static String toUnsignedString(int i, int radix)    
public static String toHexString(int i)    
public static String toOctalString(int i)    
public static String toBinaryString(int i)
//使用了乘法+位移代替除法，除法效率低
public static String toString(int i)
public String toString()
```

- String转Integer

```java
public static Integer getInteger(String nm)    
public static Integer getInteger(String nm, int val)    
public static Integer getInteger(String nm, Integer val)    
public static Integer decode(String nm)
public static Integer valueOf(String s, int radix)    
public static Integer valueOf(String s)
//InterCache中有时返回已存在对象，否则新建
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
} 
```

```java
System.out.println(new Integer(10) == new Integer(10));//false
System.out.println(new Integer(1000) == new Integer(1000));//false
System.out.println(Integer.valueOf(10) == Integer.valueOf(10));//true
System.out.println(Integer.valueOf(1000) == Integer.valueOf(1000));//false
```