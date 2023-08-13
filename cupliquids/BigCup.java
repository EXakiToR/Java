package cupliquids;

public class BigCup extends Cup{

    public BigCup(Liquid liquid) {
        super(liquid);

    }
    

    @Override
    public int getMaxVolume() {
        return 1000;
    }
}
