package Turing;
import java.util.Random;
import java.util.Scanner;

class ShipBattleGame {

    public static void main(String[] args) {
        int[][] map = new int[10][10]; // 10x10 matrix for the map
        int[][] hits = new int[10][10]; // To track hits
        int[] shipSizes = {5, 4, 3, 3, 2, 2}; // Ship sizes
        Random random = new Random();

        // Place ships on the map
        for (int size : shipSizes) {
            placeShip(map, size, random);
        }        // User gameplay
        Scanner scanner = new Scanner(System.in);
        int bombsLeft = 25;
        int shipsLeft = shipSizes.length;

        System.out.println("Game starts! You have 25 bombs. Enter coordinates as x y (0-9).");

        while (bombsLeft > 0 && shipsLeft > 0) {
            // Display the number of bombs and ships left
            System.out.println("Bombs left: " + bombsLeft + ", Ships left: " + shipsLeft);
            System.out.print("Enter coordinates (x y): ");

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Check if the coordinates are valid
            if (x < 0 || x >= 10 || y < 0 || y >= 10) {
                System.out.println("Invalid coordinates. Try again.");
                continue;
            }

            // Check the result of the bomb
            if (hits[x][y] == 1) {
                System.out.println("Already targeted. Try a different coordinate.");
            } else if (map[x][y] == 0) {
                System.out.println("Not damaged. No ship at this location.");
            } else {
                // Mark the hit
                hits[x][y] = 1;
                if (isShipDestroyed(map, hits, map[x][y])) {
                    System.out.println("Destroyed! Ship " + map[x][y] + " is completely destroyed.");
                    shipsLeft--;
                } else {
                    System.out.println("Damaged. Ship " + map[x][y] + " is hit but not destroyed.");
                }
            }

            bombsLeft--; // Decrease bombs
        }

        // Game result
        if (shipsLeft == 0) {
            System.out.println("Congratulations! You win. All ships are destroyed.");
        } else {
            System.out.println("Defeat. You are out of bombs. Ships remaining: " + shipsLeft);
        }
    }

    // Function to place a ship on the map
    private static void placeShip(int[][] map, int size, Random random) {
        boolean placed = false;

        while (!placed) {
            int direction = random.nextInt(2); // 0 for horizontal, 1 for vertical
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (canPlaceShip(map, size, x, y, direction)) {
                for (int i = 0; i < size; i++) {
                    if (direction == 0) { // Horizontal
                        map[x][y + i] = size;
                    } else { // Vertical
                        map[x + i][y] = size;
                    }
                }
                placed = true;
            }
        }
    }

    // Function to check if a ship can be placed
    private static boolean canPlaceShip(int[][] map, int size, int x, int y, int direction) {
        for (int i = 0; i < size; i++) {
            int nx = direction == 0 ? x : x + i;
            int ny = direction == 0 ? y + i : y;

            if (nx >= 10 || ny >= 10 || map[nx][ny] != 0 || !isSafe(map, nx, ny)) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a cell is safe (not touching other ships)
    private static boolean isSafe(int[][] map, int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && map[nx][ny] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to check if a ship is completely destroyed
    private static boolean isShipDestroyed(int[][] map, int[][] hits, int shipId) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == shipId && hits[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
