public class SafeHouse extends NormalLoc {
    SafeHouse(Player player) {
        super(player, "Safe House");
    }
    @Override
    public boolean getLocation() {
        player.setHealthy(player.getReHealthy());
        System.out.println(" + You are healed...");
        System.out.println(" + You are safe now :) ");
        return true;
    }
}
