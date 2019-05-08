package JavaPatternDemos;

/**
 *
 * 策略模式
 *
 * 旨在对策略进行管理,封装
 * 状态的改变，或者说策略的选择一般是主观设置
 *
 *
 */

public class StrategyTest {
    public static void main(String[] args) {
    }
}



class SContext{
    private int num1 = 1;
}

class SResult{
    private int num2 = 0;
}

class StrategyManager{
    private SContext curContext;
    private SResult curResult;
    private Strategy curStrategy;

    public void setCurStrategy(Strategy curStrategy) {
        this.curStrategy = curStrategy;
    }

    public void run(){
        this.curStrategy.do_strategy(curContext);
    }
}



interface Strategy{
    // 也可以用继承
    public void do_strategy(SContext scont);
}

class GoodStrategy implements Strategy{
    @Override
    public void do_strategy(SContext scont) {
        // do something , get results
    }
}

class BadStrategy implements Strategy{
    @Override
    public void do_strategy(SContext scont) {
        // do something , get results
    }
}
