package JavaPatternDemos;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，使用java提供的Proxy对象
 */
public class DynamicProxyTest {
    public static void main(String[] args) throws  Exception{

        MyProxyImpl pObj = new MyProxyImpl();
        MyInvokeHandler myHandlder = new MyInvokeHandler(pObj);

        ProxyInterface proxyProduced = (ProxyInterface) Proxy.newProxyInstance(
                        ProxyInterface.class.getClassLoader(),
                        new Class<?>[]{ProxyInterface.class},
                        myHandlder);

        System.out.println(proxyProduced.updateName("Badass"));
    }
}


interface ProxyInterface {
    String updateName(String name_);
}

class MyProxyImpl implements ProxyInterface {
    private String name = "default";

    public String updateName(String newName){
        System.out.println(name);
        name = newName;
        return newName;
    }
}

class MyInvokeHandler implements InvocationHandler{
    private Object target = null; //这里可以只针对ProxyInterface对象

    public MyInvokeHandler(Object aTarget){
        target = aTarget;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里的proxy实际上是生成的代理对象，见下面的Name，是$proxy0
        System.out.println("this is from a handler");
        System.out.println(proxy.getClass().getName());

        Object result =  method.invoke(target,args);
        return result;
    }
}
