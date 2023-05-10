public  abstract class BattleLoc extends  Location {
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }
    @Override
    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println();
        System.out.println("You are currently in the "+ this.getName() + " area.");
        System.out.println("Do be careful, there are " + obsCount + " " + obstacle.getName() + " here");
        System.out.print("<F>ight or <G>et Away : ");
        String selCase = scan.nextLine();
        selCase.toUpperCase();
        if (selCase.equals("F")) {
            if (combat(obsCount)) {
                System.out.println("You have defeated all the enemies in the "+ this.getName() + " area");
                if (this.award.equals("Ufo") && player.getInv().isUfo() == false ) {
                    System.out.println(this.award + " You have won");
                    player.getInv().setUfo(true);
                } else if (this.award.equals("Freedom") && player.getInv().isFreedom() == false ) {
                    System.out.println(this.award + " You have won");
                    player.getInv().setFreedom(true);
                } else if (this.award.equals("Respect") && player.getInv().isRespect() == false ) {
                    System.out.println(this.award + " You have won");
                    player.getInv().setRespect(true);
                }
                return true;
            }
            if (player.getHealthy() <= 0 ) {
                System.out.println("You are dead");
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while ((player.getHealthy() > 0) && (obstacle.getHealth() > 0)) {
                System.out.print("<S>hot or <R>un Away : ");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();

                if(selCase.equals("S")) {
                    System.out.println("You Shot");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("It's the "+ obstacle.getName()+"'s"+" turn");
                        System.out.println(obstacle.getName() + " hit you");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else {
                    break;
                }
            }
            if ((obstacle.getHealth() < player.getHealthy()) && (obstacle.getHealth() <= 0) ) {
                System.out.println("You have defeated the enemy ! ");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Current Money : " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }else {
                return false;
            }
            System.out.println("==================");
        }
        return true;
    }
    public void playerStats() {
        System.out.println("\n----------");
        System.out.println("Player Stats\n---------- ");
        System.out.println("Health: " + player.getHealthy());
        System.out.println("Damage: "+ player.getTotalDamage());
        System.out.println("Current Money: " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Weapon: " + player.getInv().getwName() );
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Armor: " + player.getInv().getaName() );
        }
    }
    public void enemyStats() {
        System.out.println("\n----------");
        System.out.println("The Stats of " + obstacle.getName() +"\n---------- ");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Awards: " + obstacle.getAward());
    }
    public void afterHit() {
        System.out.println("The health of the player: " + player.getHealthy());
        System.out.println("The health of the " + obstacle.getName()+" :"+ " " +obstacle.getHealth());
        System.out.println();
    }
}

