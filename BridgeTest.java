package JavaPatternDemos;


/**
 * 桥接模式
 *
 * 对于多维的概念，例如咖啡有大杯，小杯， 可以加糖，不加糖
 *
 * 使用桥模式在结构上衔接，实现组合
 *
 * 例如
 * 大杯加糖，价格 = 大杯咖啡 + 2倍糖价格
 * 小杯加糖： 价格 = 小杯咖啡 + 1倍糖价格
 *
 *
 */
public class BridgeTest {

    public static void main(String[] args) {
        Coffee small_sugar = new SmallCoffee(10,new Sugar());
        Coffee large_black_sugar = new LargeCoffee(15, new BlackSugar());

        small_sugar.addAdditions();
        large_black_sugar.addAdditions();

        small_sugar.sellCoffee();
        large_black_sugar.sellCoffee();
    }


}



abstract class Coffee{
    protected int price;
    protected Additions addition;

    public Coffee(int mPrice,Additions mAddition){
        price = mPrice;
        addition = mAddition;
    }
    public void sellCoffee(){
        System.out.println(this.price);
    };

    public abstract void addAdditions();
}

class LargeCoffee extends Coffee{
    public LargeCoffee(int mPrice, Additions mAddition) {
        super(mPrice, mAddition);
    }
    @Override
    public void addAdditions() {
        // 大杯咖啡加 2倍的钱
        addition.adding();
        this.price +=  (2 * addition.getPrice());
    }
}

class SmallCoffee extends Coffee{

    public SmallCoffee(int mPrice, Additions mAddition) {
        super(mPrice, mAddition);
    }

    @Override
    public void addAdditions() {
        addition.adding();
        this.price += addition.getPrice();
    }
}


interface Additions{
    void adding();
    int getPrice();
}


class Sugar implements Additions{

    @Override
    public void adding() {
        System.out.println("add sugar");
    }

    @Override
    public int getPrice() {
        return 2;
    }
}

class BlackSugar implements Additions{

    @Override
    public void adding() {
        System.out.println("add black Sugar");
    }
    @Override
    public int getPrice() {
        return 5;
    }
}
