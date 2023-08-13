package cupliquids;

public class Cup {
    private Liquid liquid;
    private static final int MAX_VOLUME = 600;

    public Cup() {
    }

    public Cup(Liquid liquid) {
        this.liquid = liquid;
        setNameLiquid(liquid);
        setVolume(liquid);

    }

    public String getNameLiquid() {
        return liquid.getName();
    }

    public void setNameLiquid(Liquid liquid) {
        if (liquid.getName().equalsIgnoreCase("water") || liquid.getName().equalsIgnoreCase("milk") ||
                liquid.getName().equalsIgnoreCase("tea")) {
            this.liquid.setName(liquid.getName());
        } else {
            System.err.println("Unsuported liquid type.");
        }

    }

    public int getMaxVolume() {
        return MAX_VOLUME;
    }

    public int getVolume() {
        return liquid.getVolume();
    }

    public void setVolume(Liquid liquid) {
        if (liquid.getVolume() > 0 && liquid.getVolume() <= getMaxVolume()) {
            this.liquid.setVolume(liquid.getVolume());
        } else {
            System.err.println(this.getClass().getSimpleName() + " volume must be between 0.." + getMaxVolume());
        }
    }

    public String toString() {
        return liquid.getVolume() + "ml of " + liquid.getName();
    }
}
