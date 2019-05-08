package JavaPatternDemos;

/**
 * ChainofResponsibility,责任链
 *
 * 重要的式链式结构，一级一级的处理
 *
 * 对比命令模式，命名模式更加简单一点，COR就是多了链式结构，
 * 客户端可以更简单，同时也可以处理更加复杂的情况。
 *
 */
public class CORTest {

    public static void main(String[] args) {

        CORRequest req = new CORRequest();

        CORHandler timehandler = new CORTimeHandler();
        CORHandler loghandler = new CORLoggerHandler();
        timehandler.setNextHandler(loghandler);

        timehandler.handle(req);
    }

}

class CORRequest{
    private String level;
    private String type;

    public String getType() {
        return type;
    }
    public String getLevel() {
        return level;
    }
}


abstract class CORHandler{
    protected CORHandler nextHandler;

    public CORHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(CORHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handle(CORRequest req);
}


class CORTimeHandler extends CORHandler{

    @Override
    public void handle(CORRequest req) {
        if(req.getLevel() == "LEVEL_1"){
            // 处理reqeust
        }
        else{
            // 下一个继续处理
            nextHandler.handle(req);
        }

    }
}

class CORLoggerHandler extends CORHandler{

    @Override
    public void handle(CORRequest req) {
        if(req.getLevel() == "LEAVL_2"){
            // 处理
        }
        else{
            nextHandler.handle(req);
        }
    }
}
