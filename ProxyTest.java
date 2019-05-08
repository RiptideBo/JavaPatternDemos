package JavaPatternDemos;


/**
 * 代理  和  装饰器
 * 代理: 一般只是该对象，同时可能会新增功能
 * 装饰器：一般是接口实现，只是对接口的方法进行拓展
 *
 */
public class ProxyTest {
    public static void main(String[] args) {

        AppleP apple1 = new AppleP();
        AppleProxy app = new AppleProxy(apple1);
        app.eat();
        app.cook();

        AppleP apple2 = new AppleP();
        ProductP appledp = new ProductDecoratorClean(new ProductDecoratorLogger(apple2));
        appledp.eat();
    }
}



interface ProductP{
    void eat();
}

class AppleP implements ProductP{
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}



class AppleProxy implements ProductP{
    private AppleP prod;

    public AppleProxy(AppleP oneapple){
        prod = oneapple;
    }

    @Override
    public void eat() {
        System.out.println("this is a poxy");
        prod.eat();
    }

    // 还可以有新的功能
    public void cook(){
        System.out.println("cooking apple");
    }

}



// -----------------------------------
//          下面是装饰器
// -----------------------------------

class ProductDecoratorLogger implements ProductP{
    private ProductP aProd;

    public ProductDecoratorLogger(ProductP aprod_){
        aProd = aprod_;
    }

    @Override
    public void eat() {
        System.out.println("log: eating apple");
        aProd.eat();
    }
}

class ProductDecoratorClean implements ProductP{
    private ProductP aProd;

    public ProductDecoratorClean(ProductP aprod_){
        aProd = aprod_;
    }

    @Override
    public void eat() {
        System.out.println("clean before eating");
        aProd.eat();
    }
}


