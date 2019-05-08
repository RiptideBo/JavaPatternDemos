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
        Coffee small_sugar_cf = new SmallCoffee(10,new Sugar());
        Coffee large_black_sugar_cf = new LargeCoffee(15, new BlackSugar());

        small_sugar_cf.addAdditions();
        large_black_sugar_cf.addAdditions();

        small_sugar_cf.sell_coffee();
        large_black_sugar_cf.sell_coffee();
    }


}



abstract class Coffee{
    protected int price;
    protected Additions added;

    public Coffee(int price_,Additions added_){
        price = price_;
        added = added_;
    }
    public void sell_coffee(){
        System.out.println(this.price);
    };

    public abstract void addAdditions();
}

class LargeCoffee extends Coffee{
    public LargeCoffee(int price_, Additions added_) {
        super(price_, added_);
    }
    @Override
    public void addAdditions() {
        // 大杯咖啡加 2倍的钱
        added.add_something();
        this.price +=  (2 * added.getPrice());
    }
}

class SmallCoffee extends Coffee{

    public SmallCoffee(int price_, Additions added_) {
        super(price_, added_);
    }

    @Override
    public void addAdditions() {
        added.add_something();
        this.price += added.getPrice();
    }
}


interface Additions{
    void add_something();
    int getPrice();
}


class Sugar implements Additions{

    @Override
    public void add_something() {
        System.out.println("add sugar");
    }

    @Override
    public int getPrice() {
        return 2;
    }
}

class BlackSugar implements Additions{

    @Override
    public void add_something() {
        System.out.println("add black Sugar");
    }
    @Override
    public int getPrice() {
        return 5;
    }
}
