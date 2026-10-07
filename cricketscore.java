import java.util.Scanner;

class Cricket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Team 1 score: ");
        int team1 = sc.nextInt();

        System.out.print("Enter Team 2 score: ");
        int team2 = sc.nextInt();

        if (team1 == 150) {
            if (team2 > 150) {
                System.out.println("Team 2 won!");
            } else if (team2 == 150) {
                System.out.println("Match tied!");
            } else {
                System.out.println("Team 1 won!");
            }
        } else {
            System.out.println("Team 1 score should be 150.");
        }
    }
}