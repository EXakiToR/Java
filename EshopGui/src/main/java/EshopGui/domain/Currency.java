package EshopGui.domain;

public class Currency {
    private String name;
    private String charCode;
    private int numCode;
    private float ratio;
    public Currency(String name, String charCode, int numCode, float ratio) {
        this.name = name;
        this.charCode = charCode;
        this.numCode = numCode;
        this.ratio = ratio;
    }
    public Currency(String charCode, float ratio) {
        this.charCode = charCode;
        this.ratio = ratio;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharCode() {
        return charCode;
    }
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }
    public int getNumCode() {
        return numCode;
    }
    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }
    public float getRatio() {
        return ratio;
    }
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
    
}
