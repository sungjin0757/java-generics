## Generics
***

### π― μνλͺ©μ 

μλ° μ λ€λ¦­μ κ΄νμ¬ Study

***

### π References

Javaμ μ μ.

***

### π Generics λ?

λ€μν νμμ κ°μ²΄λ€μ λ€λ£¨λ λ©μλλ Collection ν΄λμ€μ `μ»΄νμΌ` μμ νμμ²΄ν¬λ₯Ό ν΄μ£Όλ κΈ°λ₯.

κ°μ²΄μ νμμ `μ»΄νμΌ` μμ μ²΄ν¬νκΈ° λλ¬Έμ κ°μ²΄μ νμ μμ μ±μ λμ΄κ³  νλ³νμ λ²κ±°λ‘μμ΄ μ€μ΄λ­λλ€.

νμ μμ μ±μ λμΈλ€λ λ»μ μ μ₯λ κ°μ²΄λ₯Ό κΊΌλ΄μ¬ λ λ€λ₯Έ νμμΌλ‘ μλͺ» νλ³ν λλ κ²μ λ§λ κ²μ λ»ν©λλ€.

λν, κ°μ²΄λ₯Ό κΊΌλΌ λλ§λ€ νμμ²΄ν¬μ νλ³νμ κ³Όμ μ μλ΅ν  μ μμ΅λλ€.

### π Generics ν΄λμ€ μ μΈ

```java
    /// μΌλ° ν΄λμ€ μ μΈ
    class Test1{
        Object item;

        public void setItem(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return item;
        }
    }
    
    ///μ λ€λ¦­ ν΄λμ€ μ μΈ
    class Test2<T>{
        T item;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
```

μ λ€λ¦­ ν΄λμ€ μ μΈμμ λ³΄μ€ μ μλ€μνΌ ν΄λμ€ μ΄λ¦ λ€μ <T>μ κ°μ΄ μ μν΄μ£Όλ©΄ λ©λλ€.

Tλ ν° μλ―Έλ₯Ό κ°κ³ μλ κ²μ΄ μλλΌ μν©μ λ§κ² μλ―Έμλ λ¬Έμλ₯Ό νμ©νμλ©΄ λ©λλ€.

μ΄μ  `μ λ€λ¦­` ν΄λμ€μΈ `Test2`λ₯Ό λ§λ€μ΄ λ³΄λλ‘ ν©μλ€.

```java
Test2<Integer> test2=new Test2<>();
//μλ¬
test2.setItem("1");
```
μμ κ°μ΄ κ°μ²΄λ₯Ό μμ±ν  λλ μ°Έμ‘°λ³μμ μμ±μμ μ¬μ©λ  μ€μ  νμμ λ£μ΄μ£Όμλ©΄ λ©λλ€.

>**μ©μ΄**
> Test2<T> μμ Tλ νμ λ§€κ°λ³μλΌκ³  λΆλ¦½λλ€.
> νμ λ§€κ°λ³μμ νμμ μ§μ νλ κ²μ 'μ λ€λ¦­ νμ νΈμΆ'μ΄λΌκ³  λΆλ¦λλ€.
> μ§μ λ νμμ λ§€κ°λ³μνλ νμμ΄λΌκ³  λΆλ¦λλ€.
> μ»΄νμΌ ν Test2<T>λ μ΄λ€μ μμ νμμΈ 'Test2'λ‘ λ°λλλ€. μ λ€λ¦­ νμμ΄ μ κ±°λλ€λ κ²μ λ»ν©λλ€.
> 

**μ£Όμμ **

μ λ€λ¦­ ν΄λμ€μ `Test2`μ staticλ©€λ²μ νμ λ³μ Tλ₯Ό μ¬μ©ν  μ μμ΅λλ€.

staticλ©€λ²λ λ§€κ°λ³μνλ νμμ μ’λ₯μ κ΄κ³μμ΄ λμΌν κ²μ΄μ΄μΌ νκΈ° λλ¬Έμλλ€.

λν, μ λ€λ¦­ νμμ λ°°μ΄μ μμ±νμ§ λͺ»ν©λλ€. μ λ€λ¦­ λ°°μ΄ νμμ μ°Έμ‘°λ³μλ₯Ό μ μΈνλ κ²μ κ°λ₯ν©λλ€.
```java
//μλ¬
class Test2<T>{
    T item;
    T[] elements;

    //μλ¬
    T[] getElements(){
        T[] temp=new T[elements.length];

        return temp;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}
```

μ λ€λ¦­ λ°°μ΄μ μμ±ν  μ μλ μ΄μ λ `new`μ°μ°μ λλ¬Έμλλ€. `new`μ°μ°μλ μ»΄νμΌ μμ μ `νμ T`κ° μ νν λ¬΄μμΈμ§λ₯Ό μκ³  μμ΄μΌ ν©λλ€.

μ»΄νμΌ νλ μμ μμ `T`κ° μ΄λ€ νμμΈμ§ μ μ μμ΅λλ€. `instanceof`μ°μ°μλν λ§μ°¬κ°μ§λ‘ μ¬μ©ν  μ μκ² λ©λλ€.

***

### π Generics ν΄λμ€μ κ°μ²΄ μμ±κ³Ό μ¬μ©

μλ μ½λλ μλ¬ μν©κ³Ό μ μ μν©μ μ½λλ₯Ό λ΄κ³  μμ΅λλ€.

```java
class Test<T>{
    List<T> list=new ArrayList<>();

    void addItem(T item){
        list.add(item);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

class Parent{

}

class Child extends Parent{

}
public class Main {
    public static void main(String[] args){
        //μλ¬ (νμλ³μμ νμμ΄ μΌμΉν΄μΌν¨)
        Test<Integer> test1=new ArrayList<String>();

        //μμ - μλ¬ (λκ°μ νμμ΄ λ¬΄μ‘°κ±΄ μμΌν¨)
        Test<Parent> test2=new Test<Child>();

        //μ μ κ°λ
        Test<Child> test3=new Test<Child>();

        //μλ¬ λ§λ€μ΄μ§ νμλ³μμ μΌμΉν΄μΌν¨.
        test3.addItem(1);

        //μ μ κ°λ
        test3.addItem(new Child());
    }
}
```

***

### π μμΌλ μΉ΄λ

μλμ κ°μ μ½λκ° μλ€κ³  κ°μ ν©μλ€.

```java
class Chef{
    static Pizza makePizza(Cheese<AmericaCheese> cheese){
        return new Pizza();
    }
}
class Cheese<T>{

}

class AmericaCheese{

}
class WhiteCheese{

}

class Pizza{

}
public class Main {

    public static void main(String[] args){
        Cheese<AmericaCheese> ac=new Cheese<>();
        Cheese<WhiteCheese> wc=new Cheese<>();
        
        //μ μ κ°λ
        Chef.makePizza(ac);
        //μλ¬
        Chef.makePizza(wc);
    }
}

```

```java
class Chef{
    static Pizza makePizza(Cheese<AmericaCheese> cheese){
        return new Pizza();
    }
}
```

`Chef`ν΄λμ€λ μ λ€λ¦­ ν΄λμ€κ° μλλ°λ€κ°, `static`λ©μλμλ νμ λ³μ `T`λ₯Ό λ§€κ°λ³μλ‘ νμ©νμ§ λͺ»ν©λλ€.
λ°λΌμ, μμ κ°μ΄ `T`λ₯Ό `AmericaCheese`λ‘ μ§μ ν΄μ£Όλ κ²κ³Ό κ°μ λ°©μμ νμ©ν΄μΌν©λλ€.

μμ `main` ν΄λμ€μμ μλ¬λ μν©μ²λΌ `whiteCheese` νμμ μ λ€λ¦­ ν΄λμ€λ₯Ό λ§€κ°λ³μλ‘ νλ λ©μλλ₯Ό λ§λλ €λ©΄ λ€μκ³Ό κ°μ΄
`Overloading`μ νμ©ν΄μΌν κΉμ??

```java
class Chef{
    static Pizza makePizza(Cheese<AmericaCheese> cheese){
        return new Pizza();
    }
    static Pizza makePizza(Cheese<WhiteCheese> cheese){
        return new Pizza();
    }
}
```
μνκΉκ²λ, νμ λ³μλ§μΌλ‘λ `Overloading`μ΄ μ±λ¦½λμ§ μλλ€κ³  ν©λλ€. μ΄μ λ μ¦, μ λ€λ¦­ νμμ μ»΄νμΌλ¬κ° μ»΄νμΌν  λλ§ μ¬μ©νκ³ 
μ κ±°ν΄ λ²λ¦¬κΈ° λλ¬Έμλλ€.

μ΄λ΄λ, μ¬μ©νκΈ° μν΄ κ³ μλ κ²μ΄ λ°λ‘ `μμΌλμΉ΄λ` μλλ€. 

μ¬μ©λ²λΆν° μμλ΄μλ€.
1. `<? extends T>` : μμΌλμΉ΄λμ μνμ ν. Tμ κ·Έ μμλ€λ§ κ°λ₯.
2. `<? super T>` : μμΌλμΉ΄λμ νν μ ν. Tμ κ·Έ μ‘°μλ€λ§ κ°λ₯
3. `<?>` : μ μ½ X. λͺ¨λ  νμμ΄ κ°λ₯

```java
import java.util.Collections;

class Chef {
    static Pizza makePizza(Cheese<? extends CheeseType> cheese) {
        return new Pizza();
    }
}

class Cheese<T> {

}

class CheeseType {

}

class AmericaCheese extends CheeseType {

}

class WhiteCheese extends CheeseType {

}

class Pizza {

}

public class Main {

    public static void main(String[] args) {
        Cheese<AmericaCheese> ac = new Cheese<>();
        Cheese<WhiteCheese> wc = new Cheese<>();
        Collections
        //μ μ κ°λ
        Chef.makePizza(ac);
        //μλ¬ ν΄κ²°
        Chef.makePizza(wc);
    }
}
```

μ΄μ , μ΄λ° μμΌλ‘ ν΄κ²°κ°λ₯νκ² λμμ΅λλ€.
λ μ΄μ μ»΄νμΌλ¬λ μμΌλ μΉ΄λλ‘μ λ¬Έμ λ₯Ό μΌμ§ μκ² λ  κ²μλλ€.

***

### π Generics Method

λ©μλμ μ μΈλΆμ μ λ€λ¦­ νμμ΄ μ μΈλ λ©μλλ₯Ό μ λ€λ¦­ λ©μλλΌκ³  ν©λλ€.
μλ₯Ό λ€λ©΄ `Collection` νλ μμ€μ `sort`μ κ°μ κ²½μ°λ₯Ό λ§ν©λλ€.

```java
public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
```
μ΄μ κ°μ κ²½μ°λ₯΄ λ»νμ£ . 

μμμ λ§λ€μλ `makePizza`λ₯Ό μ λ€λ¦­ λ©μλλ‘ λ§λ€μ΄ λ΄μλ€.

```java
class Chef{
    static Pizza makePizza(Cheese<? extends CheeseType> cheese){
        return new Pizza();
    }
    
    //μ λ€λ¦­ λ©μλ
    static <T extends CheeseType> Pizza makePizza2(Cheese<T> cheese){
        return new Pizza();
    }
}
```

μ§κΈ μ΄ νμ λ³μ `T`λ λ©μλμμλ§ μ¬μ©νλ κ²μ λ»ν©λλ€. μλ₯Ό λ€μ΄ `Chef`ν΄λμ€κ° μ λ€λ¦­μΌλ‘ μ μΈλμλ€ νλλΌλ, ν΄λμ€μ νμλ³μμ λ©μλμ νμλ³μλ
μλ‘ λ€λ¦μ μλ―Έν©λλ€.

μ λ€λ¦­ λ©μλλ₯Ό νΈμΆν  λλ
```java
Chef.<AmericaCheese>makePizza(ac);

//μ»΄νμΌλ¬μμ μλ μΆμ 
Chef.makePizza(ac);

//νμλ³μλ₯Ό μλ΅ν  μ μλ κ²½μ° ν΄λμ€μ μ΄λ¦μ κΌ­ μ¨μ€μΌν¨.
<AmericaCheese>makePizza(ac); //μλ¬
```

μ λ€λ¦­ λ©μλλ₯Ό μ¬μ©νλ μ΄μ λ λ§€κ°λ³μμ νμμ΄ λ³΅μ‘ν  λ λΉμ λ΄κ² λμ΄μμ΅λλ€.

μλ₯Ό λ€μ΄

```java
public static void print(List<? extends Type> list1,List<? extends Type> list2);
```
λ₯Ό
```java
public static <T extends Type> void print(List<T> list1,List<T> list2);
```

μ΄λ° μμΌλ‘ λ§μ΄μ£ .

μ’ λ λ³΅μ‘νκ² μ¬μ© κ°λ₯ν μλ‘λ `Comparable`μ κ΅¬νν ν΄λμ€λ₯Ό μλ₯Ό λ€ μ μμ΅λλ€!
```java
public static <T extends Comparable<? super T>> void sort(List<T> list);
```

μ΄λ§μ μ¦, `Comparable`μ κ΅¬νν ν΄λμ€μ΄μ΄μΌ νλ©° κ·Έ ν΄λμ€λ₯Ό νμμΌλ‘ νλ `List`λ₯Ό λ§€κ°λ³μλ‘ λ°κ² λ€λ κ²μ λ»ν©λλ€.

***

### π μ λ€λ¦­ νμμ νλ³ν

κ°λ₯ν μμ λΆκ°λ₯ν μλ₯Ό μ½λλ‘ λ³΄μ¬λλ¦¬κ² μ΅λλ€.

```java
class Test<T>{

}
class Type1{

}
class Type2 extends Type1{

}
public class Main {
    public static void main(String[] args){
        Test test=null;
        Test<Object> test2=null;

        // λΌ μ λ€λ¦­ νμκ°μ νλ³νμ ν­μκ°λ₯.
        test=(Test) test2; //μ μ
        test2=(Test<Object>) test; //μ μ

        Test<Object> test3=null;
        Test<String> test4=null;

        //λΆκ°λ₯ν μν©. μ΄λ Test<Object> test=new Test<String>(); κ³Ό κ°μ μν©μ λ»ν¨.
        test4=(Test<String>) test3;
        test3=(Test<Object>) test4;

        //μμΌλ μΉ΄λλ₯Ό ν΅ν΄ μ μ νλ³ν - λ€νμ± μ€ν
        Test<? extends Object> test5=new Test<String>();

        Test<? extends Type1> test6=null;
        Test<Type2> test7=(Test<Type2>) test6; //μ μ κ°λ, but λμλ  μ μλ νμμ΄ μ¬λ¬κ°μ΄κ³  μ΄ νμμ μ μΈν λ€λ₯Έ νμμ νλ³ν λ  μ μκΈ° λλ¬Έμ κ²½κ³ λ¬Έ

        Test<? extends Object> test8=null;
        Test<? extends String> test9=null;

        //λ κ°μ§ κ²½μ°λ λ―Ένμ  νμμΌλ‘ νλ³ννλ κ²μ΄λΌκ³  κ²½κ³ .
        test8=(Test<? extends Object>) test9; //μ μ
        test9=(Test<? extends String>) test8; //μ μ
    }
}

```

***

### π μ λ€λ¦­ νμμ μ κ±°
μ»΄νμΌλ¬λ `Generic` νμμ μ΄μ©ν΄μ μμ€νμΌμ μ²΄ν¬νκ³ , νμν κ³³μ νλ³νμ λ£μ΄μ€λλ€.
κ·Έλ¦¬κ³  `Generic`νμμ μ κ±°ν©λλ€.

μ¦, μ»΄νμΌλ νμΌμλ `Generic`μ λν μ λ³΄κ° μκ² λλ κ²μλλ€.

μ΄μ κ°μ λμμ νλ μ΄μ λ `Genenric`μ΄ λμλκΈ° μ΄μ μ μμ€ μ½λμμ νΈνμ±μ μ μ§νκΈ° μν΄μλΌκ³  ν©λλ€.

μ κ±°μ μμΈν κ³Όμ μ λλ¬΄ λ³΅μ‘νκΈ° λλ¬Έμ κ°λ΅ν μ€λͺν κ²μΌλ‘ λμ΄κ°λλ‘ νκ² μ΅λλ€!

***
### <span style="color:lightpink; font-weight:bold;">μ΄μμΌλ‘ λ§μΉκ² μ΅λλ€. ππ»ββοΈ</span>