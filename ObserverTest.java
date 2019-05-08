package JavaPatternDemos;

import java.util.ArrayList;

/**
 *
 * 观察者模式
 *
 * 被观察者和观察者，是 1对多的关系
 *
 * 当然，观察者对象可以由很多，被观察者对象也可以由不同类型
 *
 * 感觉还是很强大的，适用广
 *
 *
 *
 *
 */
public class ObserverTest {
}


abstract class MyObserver{
    public abstract void update();
    public abstract void update(MyObservable myobserverable);

}

abstract class MyObservable{
    protected ArrayList<MyObserver> observers;

    public void addObserver(MyObserver newOb){
        observers.add(newOb);
    }
    public void removeObserver(MyObserver rmOb){
        observers.remove(rmOb);
    }
    public abstract void notifyObs();

}

/**
 * 黄金用户
 */
class GoldOb extends MyObserver{
    private String name;
    @Override
    public void update() {
        // do something
    }

    public void update(MyObservable obs){
        // do shomething
    }
}

/**
 * 白银用户
 */
class SilverOb extends MyObserver{
    private String name;
    @Override
    public void update() {
        // do something
    }
    @Override
    public void update(MyObservable myobserverable) {
        // do somthing
    }
}




class ObserverableUser extends MyObservable{
    private String name;

    @Override
    public void notifyObs() {
        // 灵活控制不同权限.通知内容等

        for(MyObserver each: this.observers){
            if(each instanceof GoldOb){
                each.update(this);
            }
            else{
                // 普通用户仅仅更新
                each.update();
            }
        }
    }
}
