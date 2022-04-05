package chapter3;

class Chef{
    static Pizza makePizza(Cheese<? extends CheeseType> cheese){
        return new Pizza();
    }

    //제네릭 메소드
    static <T extends CheeseType> Pizza makePizza2(Cheese<T> cheese){
        return new Pizza();
    }
}
class Cheese<T>{

}

class CheeseType{

}

class AmericaCheese extends CheeseType{

}
class WhiteCheese extends CheeseType{

}

class Pizza{

}
public class Main {

    public static void main(String[] args){
        Cheese<AmericaCheese> ac=new Cheese<>();
        Cheese<WhiteCheese> wc=new Cheese<>();

        //정상 가동
        Chef.makePizza(ac);
        //에러 해결
        Chef.makePizza(wc);
    }
}
