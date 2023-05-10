import java.util.Scanner;

public class Player {
    private int damage,healthy,money,ReHealthy;
    private String name,CharName;
    Inventory inv;
    Scanner scan = new Scanner(System.in);

    public void selectChar() {
        switch (charMenu()) {
            case 1 : // if you chooce 1 your character is Elon Musk
                initPlayer("Elon Musk",2,18,99);
                break;
            case 2 : // if you chooce 2 your character is Polat Alemdar
                initPlayer("Polat Alemdar",10,99,5);
                break;
            case 3 : // if you chooce 2 your character is Bruce Lee
                initPlayer("Bruce Lee",99,24,10);
                break;
            default:// if you don't chooce your character be Bruce Lee
                initPlayer("Bruce Lee",99,24,10);
                break;
        }
        System.out.println("Your Character is: " + getCharName() + " --> "+ " Damage: " + getDamage() +"\tHealth: "+ getHealthy() +"\t Money: " + getMoney() );
    }
    public int charMenu() {
        System.out.println("^_^ Please select a character ^_^");
        System.out.println("1-) Elon Musk \t\t Damage: 2 \t\t Health: 18 \t\t Money: 99");
        System.out.println("2-) Polat Alemdar \t Damage: 10 \t Health: 99 \t\t Money: 5");
        System.out.println("3-) Bruce Lee \t\t Damage: 99 \t Health: 24 \t\t Money: 10");
        System.out.print("Which your choice ? ");
        int charId = scan.nextInt();

        while (charId < 1 || charId >3) {
            System.out.print("Can you entered valid character! : ");
            charId = scan.nextInt();
        }

        return charId;
    }
    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }
    public void initPlayer(String cName,int dmg, int hlth, int mny){
        setCharName(cName);
        setDamage(dmg);
        setHealthy(hlth);
        setMoney(mny);
        setReHealthy(hlth);
    }
    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }
    public Inventory getInv() {
        return inv;
    }
    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    public String getCharName() {
        return CharName;
    }
    public int getDamage() {
        return damage;
    }
    public int getHealthy() {
        return healthy;
    }

    public int getReHealthy() {
        return ReHealthy;
    }

    public void setReHealthy(int reHealthy) {
        ReHealthy = reHealthy;
    }

    public int getMoney() {
        return money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setCharName(String charName) {
        CharName = charName;
    }
}
