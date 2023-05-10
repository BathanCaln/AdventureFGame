import java.util.Scanner;
public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("--> Welcome to Fake Adventure Game <--");
        System.out.println();
        System.out.print("Can you enter your name before you start in the game: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        System.out.println();
        player.selectChar();
        System.out.println();
        start();
    }
    public void start(){
        while (true) {
            System.out.println();
            System.out.println("===============================");
            System.out.println("Choose which location you will play the game in");
            System.out.println("1. Safe House --> A safe place that belongs to you,there are no enemies here! ");
            System.out.println("2. Mars --> You may encounter alien");
            System.out.println("3. The compass zone --> You may encounter police");
            System.out.println("4. Circle -->  You may encounter fighter");
            System.out.println("5. Tool Store --> You can buy weapons or armor");
            System.out.print("Which your choice ? ");
            int selLoc = scan.nextInt();

            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Can you select valid a location! : ");
                selLoc = scan.nextInt();
            }
            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Mars(player);
                    break;
                case 3:
                    location = new TheCompassZone(player);
                    break;
                case 4:
                    location = new Circle(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isUfo() && player.getInv().isRespect() && player.getInv().isFreedom()) {
                    System.out.println("Congratulations! ,You Won The Game :)");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
