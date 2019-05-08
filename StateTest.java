package JavaPatternDemos;

/**
 * State
 * 状态的具体动作被隐藏，
 * 状态的改变通常是非人为的
 *
 * 下面实现红蓝两种状态相互转化,可以更加复杂，感觉还是很实用的,
 *
 * 特别对于状态优先，状态之间转化关系明确的情况
 */

public class StateTest {
    public static void main(String[] args) {

        Context cont = new Context(new StateBlue());

        for (int i = 0; i <5 ; i++) {
            cont.operate();
        }
    }
}


class Context {

    private State state = null;
    public Context(State init_state){
        state = init_state;
    }

    public void operate(){
        state.handler_state(this);
    }

    public void setState(State newState){
        this.state =  newState;
    }

}


abstract class State{
    public abstract void handler_state(Context cont);
}

class StateBlue  extends State{

    @Override
    public void handler_state(Context cont) {
        // od something and change
        System.out.println("this is state blue");
        State nextState = new StateRed();
        cont.setState(nextState);
    }
}

class StateRed extends State{
    @Override
    public void handler_state(Context cont) {
        System.out.println("this is stae red");
        // do somthing
        State nexState = new StateBlue();
        cont.setState(nexState);
    }
}



