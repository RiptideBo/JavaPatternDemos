package JavaPatternDemos;


/**
 * 创造模式
 *
 * 关注于复杂产品的创造过程，不同的Builder创造不同属性的产品
 */
public class BuilderTest {
    public static void main(String[] args) {
        HouseBuilding bder = new Builder();  // 只需要换施工队就行
        BuildManager bmanager = new BuildManager(bder);
        House hs = bmanager.make();
    }
}


class Roof{
    Roof(){}
    Roof(String desc_){this.desc = desc_;}

    private String desc  =  "roof";

    public String getDesc() {
        return desc;
    }
}

class Floor{
    Floor(){}
    Floor(String mdesc){this.desc = mdesc;}

    private String desc = "floor";

    public String getDesc() {
        return desc;
    }
}


class House{
    private Roof mRoof;
    private Floor mFloor;

    public void setmRoof(Roof mRoof) {
        this.mRoof = mRoof;
    }

    public void setmFloor(Floor mFloor) {
        this.mFloor = mFloor;
    }

    public Roof getmRoof() {
        return mRoof;
    }

    public Floor getmFloor() {
        return mFloor;
    }

}


interface HouseBuilding{
    void build_floor();
    void build_roof();
    public House build();
}

class Builder implements HouseBuilding{

    private House mHouse = new House();

    @Override
    public void build_floor() {
        Floor fl = new Floor();
        mHouse.setmFloor(fl);
    }

    @Override
    public void build_roof() {
        Roof rf = new Roof();
        mHouse.setmRoof(rf);
    }

    public House build(){
        return mHouse;
    }
}

class BuildManager {
    private HouseBuilding bd;
    BuildManager(HouseBuilding mbd){
        bd = mbd;
        // 在这里控制逻辑
    }

    public House make(){
        bd.build_floor();
        bd.build_roof();
        return bd.build();
    }

}


