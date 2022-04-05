package chapter4;

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
