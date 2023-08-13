package cupliquids;

public class SmallCup extends Cup{

    public SmallCup(Liquid liquid) {
        super(liquid);

    }
    

    @Override
    public int getMaxVolume() {
        return 250;
    }

}
