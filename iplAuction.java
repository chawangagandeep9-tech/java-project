import java.util.*;

public class iplAuction {
    static class Player {
        String name;
        String role;
        int basePrice;

        Player(String name, String role, int basePrice) {
            this.name = name;
            this.role = role;
            this.basePrice = basePrice;
        }
    }

    static class Team {
        String name;
        int purse;
        ArrayList<Player> players = new ArrayList<>();

        Team(String name, int purse) {
            this.name = name;
            this.purse = purse;
        }

        void buyPlayer(Player player, int price) {
            purse -= price;
            players.add(player);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Teams
        Team[] teams = {
            new Team("CSK", 100),
            new Team("RR", 100),
            new Team("MI", 100),
            new Team("KKR", 100)
        };

        // Players
        Player[] players = {
            new Player("MS Dhoni", "Batsman", 10),
            new Player("Rohit Sharma", "Batsman", 10),
            new Player("Jasprit Bumrah", "Bowler", 8),
            new Player("Ravindra Jadeja", "All-Rounder", 8),
            new Player("Rishabh Pant", "Wicket Keeper", 8)
        };

        System.out.println("=================================");
        System.out.println("       IPL PLAYER AUCTION");
        System.out.println("=================================");

        for (Player player : players) {
            System.out.println("\nPlayer: " + player.name);
            System.out.println("Role: " + player.role);
            System.out.println("Base Price: ₹" + player.basePrice + " Crore");

            int highestBid = player.basePrice;
            Team winningTeam = null;

            while (true) {
                System.out.println("\nCurrent Highest Bid: ₹" + highestBid + " Crore");
                System.out.println("Teams:");

                for (int i = 0; i < teams.length; i++) {
                    System.out.println((i + 1) + ". "
                            + teams[i].name
                            + " (Purse: ₹"
                            + teams[i].purse + " Cr)");
                }

                System.out.println("0. End bidding");
                System.out.print("Select team: ");
                int choice = sc.nextInt();

                if (choice == 0) {
                    break;
                }

                if (choice < 1 || choice > teams.length) {
                    System.out.println("Invalid team!");
                    continue;
                }

                Team team = teams[choice - 1];
                System.out.print("Enter bid (₹ Crore): ");
                int bid = sc.nextInt();

                if (bid <= highestBid) {
                    System.out.println("Bid must be higher than ₹" + highestBid + " Cr.");
                } else if (bid > team.purse) {
                    System.out.println("Insufficient purse!");
                } else {
                    highestBid = bid;
                    winningTeam = team;
                    System.out.println(team.name + " bids ₹" + bid + " Crore!");
                }
            }

            if (winningTeam != null) {
                winningTeam.buyPlayer(player, highestBid);

                System.out.println("\n*** SOLD ***");
                System.out.println(player.name + " → " + winningTeam.name);
                System.out.println("Sold for ₹" + highestBid + " Crore");
            } else {
                System.out.println("\n*** UNSOLD ***");
                System.out.println(player.name + " was not sold.");
            }
        }

        // Final result
        System.out.println("\n=================================");
        System.out.println("       FINAL AUCTION RESULT");
        System.out.println("=================================");

        for (Team team : teams) {
            System.out.println("\nTeam: " + team.name);
            System.out.println("Remaining Purse: ₹" + team.purse + " Crore");
            System.out.println("Players:");

            if (team.players.isEmpty()) {
                System.out.println("No players bought.");
            } else {
                for (Player player : team.players) {
                    System.out.println("- " + player.name + " (" + player.role + ")");
                }
            }
        }

        sc.close();
    }
}
