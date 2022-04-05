## Generics
***

### 🎯 수행목적

자바 제네릭에 관하여 Study

***

### 🔍 References

Java의 정석.

***

### 🚀 Generics 란?

다양한 타입의 객체들을 다루는 메소드나 Collection 클래스에 `컴파일` 시의 타입체크를 해주는 기능.

객체의 타입을 `컴파일` 시에 체크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어듭니다.

타입 안정성을 높인다는 뜻은 저장된 객체를 꺼내올 때 다른 타입으로 잘못 형변환 되는 것을 막는 것을 뜻합니다.

또한, 객체를 꺼낼 때마다 타입체크와 형변환의 과정을 생략할 수 있습니다.

### 🚀 Generics 클래스 선언

```java
    /// 일반 클래스 선언
    class Test1{
        Object item;

        public void setItem(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return item;
        }
    }
    
    ///제네릭 클래스 선언
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

제네릭 클래스 선언에서 보실 수 있다시피 클래스 이름 뒤에 <T>와 같이 정의해주면 됩니다.

T는 큰 의미를 갖고있는 것이 아니라 상황에 맞게 의미있는 문자를 활용하시면 됩니다.

이제 `제네릭` 클래스인 `Test2`를 만들어 보도록 합시다.

```java
Test2<Integer> test2=new Test2<>();
//에러
test2.setItem("1");
```
위와 같이 객체를 생성할 때는 참조변수와 생성자에 사용될 실제 타입을 넣어주시면 됩니다.

>**용어**
> Test2<T> 에서 T는 타입 매개변수라고 불립니다.
> 타입 매개변수와 타입을 지정하는 것을 '제네릭 타입 호출'이라고 부릅니다.
> 지정된 타입을 매개변수화된 타입이라고 부릅니다.
> 컴파일 후 Test2<T>는 이들의 원시 타입인 'Test2'로 바뀝니다. 제네릭 타입이 제거된다는 것을 뜻합니다.
> 

**주의점**

제네릭 클래스의 `Test2`의 static멤버에 타입 변수 T를 사용할 수 없습니다.

static멤버는 매개변수화된 타입의 종류와 관계없이 동일한 것이어야 하기 때문입니다.

또한, 제네릭 타입의 배열을 생성하지 못합니다. 제네릭 배열 타입의 참조변수를 선언하는 것은 가능합니다.
```java
//에러
class Test2<T>{
    T item;
    T[] elements;

    //에러
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

제네릭 배열을 생성할 수 없는 이유는 `new`연산자 때문입니다. `new`연산자는 컴파일 시점에 `타입 T`가 정확히 무엇인지를 알고 있어야 합니다.

컴파일 하는 시점에서 `T`가 어떤 타입인지 알 수 없습니다. `instanceof`연산자또한 마찬가지로 사용할 수 없게 됩니다.

***

### 🚀 Generics 클래스의 객체 생성과 사용

아래 코드는 에러 상황과 정상 상황의 코드를 담고 있습니다.

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
        //에러 (타입변수의 타입이 일치해야함)
        Test<Integer> test1=new ArrayList<String>();

        //상속 - 에러 (똑같은 타입이 무조건 와야함)
        Test<Parent> test2=new Test<Child>();

        //정상 가동
        Test<Child> test3=new Test<Child>();

        //에러 만들어진 타입변수와 일치해야함.
        test3.addItem(1);

        //정상 가동
        test3.addItem(new Child());
    }
}
```

***

### 🚀 와일드 카드

아래와 같은 코드가 있다고 가정합시다.

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
        
        //정상 가동
        Chef.makePizza(ac);
        //에러
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

`Chef`클래스는 제네릭 클래스가 아닌데다가, `static`메소드에는 타입 변수 `T`를 매개변수로 활용하지 못합니다.
따라서, 위와 같이 `T`를 `AmericaCheese`로 지정해주는 것과 같은 방식을 활용해야합니다.

위의 `main` 클래스에서 에러난 상황처럼 `whiteCheese` 타입의 제네릭 클래스를 매개변수로 하는 메소드를 만드려면 다음과 같이
`Overloading`을 활용해야할까요??

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
안타깝게도, 타입 변수만으로는 `Overloading`이 성립되지 않는다고 합니다. 이유는 즉, 제네릭 타입은 컴파일러가 컴파일할 때만 사용하고
제거해 버리기 때문입니다.

이럴때, 사용하기 위해 고안된 것이 바로 `와일드카드` 입니다. 

사용법부터 알아봅시다.
1. `<? extends T>` : 와일드카드의 상한제한. T와 그 자손들만 가능.
2. `<? super T>` : 와일드카드의 하한 제한. T와 그 조상들만 가능
3. `<?>` : 제약 X. 모든 타입이 가능

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
        //정상 가동
        Chef.makePizza(ac);
        //에러 해결
        Chef.makePizza(wc);
    }
}
```

이제, 이런 식으로 해결가능하게 되었습니다.
더 이상 컴파일러는 와일드 카드로서 문제를 삼지 않게 될 것입니다.

***

### 🚀 Generics Method

메소드의 선언부에 제네릭 타입이 선언된 메소드를 제네릭 메소드라고 합니다.
에를 들면 `Collection` 프레임웤의 `sort`와 같은 경우를 말합니다.

```java
public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
```
이와 같은 경우르 뜻하죠. 

위에서 만들었던 `makePizza`를 제네릭 메소드로 만들어 봅시다.

```java
class Chef{
    static Pizza makePizza(Cheese<? extends CheeseType> cheese){
        return new Pizza();
    }
    
    //제네릭 메소드
    static <T extends CheeseType> Pizza makePizza2(Cheese<T> cheese){
        return new Pizza();
    }
}
```

지금 이 타입 변수 `T`는 메소드에서만 사용하는 것을 뜻합니다. 예를 들어 `Chef`클래스가 제네릭으로 선언되었다 하더라도, 클래스의 타입변수와 메소드의 타입변수는
서로 다름을 의미합니다.

제네릭 메소드를 호출할 때는
```java
Chef.<AmericaCheese>makePizza(ac);

//컴파일러에서 자동 추정
Chef.makePizza(ac);

//타입변수를 생략할 수 없는 경우 클래스의 이름을 꼭 써줘야함.
<AmericaCheese>makePizza(ac); //에러
```

제네릭 메소드를 사용하는 이유는 매개변수의 타입이 복잡할 때 빛을 내게 되어있습니다.

예를 들어

```java
public static void print(List<? extends Type> list1,List<? extends Type> list2);
```
를
```java
public static <T extends Type> void print(List<T> list1,List<T> list2);
```

이런 식으로 말이죠.

좀 더 복잡하게 사용 가능한 예로는 `Comparable`을 구현한 클래스를 예를 들 수 있습니다!
```java
public static <T extends Comparable<? super T>> void sort(List<T> list);
```

이말은 즉, `Comparable`을 구현한 클래스이어야 하며 그 클래스를 타입으로 하는 `List`를 매개변수로 받겠다는 것을 뜻합니다.

***

### 🚀 제네릭 타입의 형변환

가능한 예와 불가능한 예를 코드로 보여드리겠습니다.

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

        // 논 제네릭 타입간의 형변환은 항상가능.
        test=(Test) test2; //정상
        test2=(Test<Object>) test; //정상

        Test<Object> test3=null;
        Test<String> test4=null;

        //불가능한 상황. 이는 Test<Object> test=new Test<String>(); 과 같은 상황을 뜻함.
        test4=(Test<String>) test3;
        test3=(Test<Object>) test4;

        //와일드 카드를 통해 정상 형변환 - 다형성 실현
        Test<? extends Object> test5=new Test<String>();

        Test<? extends Type1> test6=null;
        Test<Type2> test7=(Test<Type2>) test6; //정상 가동, but 대입될 수 있는 타입이 여러개이고 이 타입을 제외한 다른 타입은 형변환 될 수 없기 때문에 경고문

        Test<? extends Object> test8=null;
        Test<? extends String> test9=null;

        //두 가지 경우는 미확정 타입으로 형변환하는 것이라고 경고.
        test8=(Test<? extends Object>) test9; //정상
        test9=(Test<? extends String>) test8; //정상
    }
}

```

***

### 🚀 제네릭 타입의 제거
컴파일러는 `Generic` 타입을 이용해서 소스파일을 체크하고, 필요한 곳에 형변환은 넣어줍니다.
그리고 `Generic`타입을 제거합니다.

즉, 컴파일된 파일에는 `Generic`에 대한 정보가 없게 되는 것입니다.

이와 같은 동작을 하는 이유는 `Genenric`이 도입되기 이전의 소스 코드와의 호환성을 유지하기 위해서라고 합니다.

제거의 자세한 과정은 너무 복잡하기 때문에 간략히 설명한 것으로 넘어가도록 하겠습니다!

***
### <span style="color:lightpink; font-weight:bold;">이상으로 마치겠습니다. 🙋🏻‍♂️</span>