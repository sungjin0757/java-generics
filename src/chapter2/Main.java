package chapter2;

import java.util.ArrayList;
import java.util.List;

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
