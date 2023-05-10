public class Inventory {
    private boolean ufo,freedom,respect;
    private String wName,aName;
    private int damage, armor;

    public Inventory() {
        this.ufo = false;
        this.freedom = false;
        this.respect = false;
        this.wName = null;
        this.aName = null;
        this.damage = 0;
        this.armor= 0;
    }

    public String getaName() {return aName;}
    public void setaName(String aName) {this.aName = aName;}
    public int getArmor() {return armor;}
    public void setArmor(int armor) {this.armor = armor;}
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {this.damage = damage;}
    public boolean isFreedom() {
        return freedom;
    }
    public void setFreedom(boolean freedom) {
        this.freedom = freedom;
    }
    public boolean isRespect() {
        return respect;
    }
    public void setRespect(boolean respect) {
        this.respect = respect;
    }
    public boolean isUfo() {
        return ufo;
    }
    public void setUfo(boolean ufo) {
        this.ufo = ufo;
    }
    public String getwName() {
        return wName;
    }
    public void setwName(String wName) {
        this.wName = wName;
    }
}
