package JavaPatternDemos;


/**
 * 代理  和  装饰器
 * 代理: 一般只是该对象，同时可能会新增功能
 * 装饰器：一般是接口实现，只是对接口的方法进行拓展
 *
 */
public class ProxyTest {
    public static void main(String[] args) {

        AppleProduct apple_1 = new AppleProduct();
        AppleProxy oneProxy = new AppleProxy(apple_1);
        oneProxy.eat();
        oneProxy.cook();

        AppleProduct apple_2 = new AppleProduct();
        MyProduct oneDecorator = new ProductDecoratorClean(new ProductDecoratorLogger(apple_2));
        oneDecorator.eat();
    }
}



interface MyProduct {
    void eat();
}

class AppleProduct implements MyProduct {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}



class AppleProxy implements MyProduct {
    private AppleProduct prod;

    public AppleProxy(AppleProduct mApple){
        prod = mApple;
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

class ProductDecoratorLogger implements MyProduct {
    private MyProduct aProd;

    public ProductDecoratorLogger(MyProduct mProduct){
        aProd = mProduct;
    }

    @Override
    public void eat() {
        System.out.println("log: eating apple");
        aProd.eat();
    }
}

class ProductDecoratorClean implements MyProduct {
    private MyProduct aProd;

    public ProductDecoratorClean(MyProduct mProduct){
        aProd = mProduct;
    }

    @Override
    public void eat() {
        System.out.println("clean before eating");
        aProd.eat();
    }
}


