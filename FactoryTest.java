package JavaPatternDemos;


/**
 * 抽象工厂方法
 *
 * 不同的工厂生成不同系列的产品
 */
public class FactoryTest {
    public static void main(String[] args) {
        BaseFactory dalian = new DalianFactory();
        BaseFactory beijing = new BeijingFactory();

        Eatable dalianEating = dalian.createEat();
        Drinkable dalianDrinking = dalian.createDrink();

        Eatable beijingEating = beijing.createEat();

        dalianEating.eat();
        beijingEating.eat();

        dalianDrinking.drink();
    }
}


interface Eatable{
    void eat();
}

class Apple implements Eatable{
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

class Banana implements Eatable{
    @Override
    public void eat() {
        System.out.println("eat Banana");
    }
}

interface Drinkable {
    void drink();
}

class Cola implements Drinkable{

    @Override
    public void drink() {
        System.out.println("Drink cola");
    }
}

abstract class BaseFactory {
    public abstract Eatable createEat();
    public abstract Drinkable createDrink();
}


/**
 * 大连工厂产苹果
 */
class DalianFactory extends BaseFactory {
    @Override
    public Eatable createEat() {
        return new Apple();
    }
    @Override
    public Drinkable createDrink() {
        return new Cola();
    }
}


/**
 * 北京工厂生产香蕉
 */
class BeijingFactory extends BaseFactory {

    @Override
    public Eatable createEat() {
        return new Banana();
    }

    @Override
    public Drinkable createDrink() {
        return new Cola();
    }
}




