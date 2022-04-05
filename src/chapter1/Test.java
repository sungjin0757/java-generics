package chapter1;

import java.util.Collections;

public class Test {
    class Test1{
        Object item;

        public void setItem(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return item;
        }
    }

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

    public void Test(){
        Test2<Integer> test2=new Test2<>();
        //에러
        test2.setItem("1");
    }
}
