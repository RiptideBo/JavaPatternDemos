package JavaPatternDemos;

import java.util.ArrayList;

/**
 * 访问者模式
 *
 * 将对不同对象的操作封装到访问者类中，避免对被访问对象类造成污染
 * 但是原对象需要向访问者暴露较多的元素，因为修改操作都交给了访问者
 *
 * 适用与被访问对象的变动是少的（不会在后来新增啥的）
 * 同时访问者也可以设置多个不同的角色，权限等,这一点的话也有点像   观察者的主动模式
 *
 * 观察者是被动的接受通知， 操作在被观察者中，当然也可以写在观察者中，这样就暴露信息了。
 * 而访问者是主动的访问，  操作在访问者中
 *
 *
 */
public class VisitorTest {
    public static void main(String[] args) {
        MyVisitor one_visitor = new Visitorimpl();
        MyVisitor gold_visitor = new GoldVisitor();

        AllVisited all_land = new AllVisited();

        all_land.accept(one_visitor);
        all_land.accept(gold_visitor);
    }
}


interface MyVisitor{
    // 所有的实际操作应该在  访问者中实现，避免对被访问者的类进行修改
    void visit(EastVisited east);
    void visit(WestVisited west);
}

interface Visited{
    void accept(MyVisitor visitor);
}

class Visitorimpl implements MyVisitor{
    @Override
    public void visit(EastVisited east) {
        System.out.println("visit East ");
    }

    @Override
    public void visit(WestVisited west) {
        System.out.println("visit west ");
    }
}

class GoldVisitor implements MyVisitor{

    @Override
    public void visit(EastVisited east) {
        System.out.println("Badass visited east");
    }

    @Override
    public void visit(WestVisited west) {
        System.out.println("Badass visited west");
    }
}



class EastVisited implements Visited{
    @Override
    public void accept(MyVisitor visitor) {
        visitor.visit(this);
    }
}

class WestVisited implements Visited{

    @Override
    public void accept(MyVisitor visitor) {
        visitor.visit(this);
    }
}

class AllVisited implements Visited{
    private ArrayList<Visited> allComponents;

    public AllVisited(){
        allComponents = new ArrayList<Visited>(10);
        allComponents.add(new EastVisited());
        allComponents.add(new WestVisited());
    }

    @Override
    public void accept(MyVisitor visitor) {
        for(Visited each : allComponents)
        {
            each.accept(visitor);
        }
    }
}




