package JavaPatternDemos;


/**
 * 创造模式
 *
 * 关注于复杂产品的创造过程，不同的Builder创造不同属性的产品
 */
public class BuilderTest {
    public static void main(String[] args) {
        HouseBuilding oneBuilder = new Builder();  // 只需要换施工队就行
        BuildManager buildMgr = new BuildManager(oneBuilder);
        House hs = buildMgr.make();
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
    Floor(String desc_){this.desc = desc_;}

    private String desc = "floor";

    public String getDesc() {
        return desc;
    }
}


class House{
    private Roof mRoof;
    private Floor mFloor;

    public void setRoof(Roof mRoof) {
        this.mRoof = mRoof;
    }

    public void setFloor(Floor mFloor) {
        this.mFloor = mFloor;
    }

    public Roof getRoof() {
        return mRoof;
    }

    public Floor getFloor() {
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
        mHouse.setFloor(fl);
    }

    @Override
    public void build_roof() {
        Roof rf = new Roof();
        mHouse.setRoof(rf);
    }

    public House build(){
        return mHouse;
    }
}

class BuildManager {
    private HouseBuilding mBuilder;
    BuildManager(HouseBuilding builder){
        mBuilder = builder;
        // 在这里控制逻辑
    }

    public House make(){
        mBuilder.build_floor();
        mBuilder.build_roof();
        return mBuilder.build();
    }

}


