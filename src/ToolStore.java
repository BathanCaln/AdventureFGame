public class ToolStore extends NormalLoc {
    ToolStore(Player player) {
        super(player, "Store");
    }
    public boolean getLocation() {
        System.out.println();
        System.out.println("===============================");
        System.out.println();
        System.out.println("Your Current Money: " + player.getMoney() );
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Which your choice? :");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:

                break;
        }

        return true;
    }
    public int armorMenu() {
        System.out.println();
        System.out.println("1. Steel Vest        < Price: 20 -- Blocking: 1 >");
        System.out.println("2. Belief in Allah   < Price: 5  -- Blocking: 99>");
        System.out.println("3. A durable body    < Price: 50 -- Blocking: 9 >");
        System.out.println("4. Exit");
        System.out.print("Which your choice? :");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }
    public void buyArmor(int itemID){
        int blocking = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                blocking = 1;
                price = 20;
                aName = "Steel Vest";
                break;
            case 2:
                blocking = 99;
                price = 5;
                aName = "Belief Allah";
                break;
            case 3:
                blocking = 9;
                price = 50;
                aName = "Fist";
                break;
            case 4:
                System.out.println("Checking Out...");
                break;
            default:
                System.out.println("Invalid Operation !");
        }
        if (price > 0) {
            if (player.getMoney() >= price){
                player.getInv().setArmor(blocking);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought the "+ aName +", your before blocking:"  + player.getInv().getArmor() + ", your new blocking: " + player.getInv().getArmor() +"\n");
                System.out.println("Your the remaining money : " + player.getMoney());
            }else {
                System.out.println("You don't have enough money :(");
            }
        }
    }
    public int weaponMenu() {
        System.out.println("1. Flamethrower < Price: 25 -- Damage: 7 >");
        System.out.println("2. Blank Gun    < Price: 15 -- Damage: 3 >");
        System.out.println("3. Iron Fist    < Price: 5  -- Damage: 1 >");
        System.out.println("4. Exit");
        System.out.print("Which your choice? :");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }
    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 7;
                price = 25;
                wName = "Flamethrower";
                break;
            case 2:
                damage = 3;
                price = 15;
                wName = "Blank Gun";
                break;
            case 3:
                damage = 1;
                price = 5;
                wName = "Fist";
                break;
            case 4:
                System.out.println("Checking Out...");
                break;
            default:
                System.out.println("Invalid Operation !");
        }
        if (price > 0) {
            if (player.getMoney() >= price){
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought the "+ wName +", your before damage:"  + player.getDamage() + ", your new damage: " + player.getTotalDamage() +"\n");
                System.out.println("Your the remaining money : " + player.getMoney());
            }else {
                System.out.println("You don't have enough money :(");
            }
        }
    }
}



