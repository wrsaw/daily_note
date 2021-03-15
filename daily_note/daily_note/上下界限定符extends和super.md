- <? extends T>,上界通配符，泛型中的内容必须为T或T的子类。因为无法确定泛型内容具体为那个类，因此往该类型列表中添加任何元素都会报错，取出元素后可以赋给T及其父类。

- <? super T>,下界通配符，泛型中的内容必须为T或T的父类。所有T的子类都可以赋值给T或者T的父类，因为可以往该类型列表中添加T及其子类都会报错，无法判断泛型元素具体为T的哪个父类，因此无法取元素并赋值给Object以外的对象。

```java
//注释掉代码均为报错代码
public class Test {
    
    private static class Food {

    }

    private static class Fruit extends Food {

    }

    private static class Apple extends Fruit {

    }

    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<>();
        //list.add(new Food());
        //list.add(new Fruit());
        //list.add(new Apple());
        Food food = list.get(0);
        Fruit fruit = list.get(0);
        //Apple apple = list.get(0);

        List<? super Fruit> list2 = new ArrayList<>();
        //list2.add(new Food());
        list2.add(new Fruit());
        list2.add(new Apple());
        //Food food2 = list2.get(0);
        //Fruit fruit2 = list2.get(0);
        //Apple apple2 = list2.get(0);
    }
}
```

