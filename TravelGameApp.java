
/**
 * ============================================================
 * ✈️ TravelGameApp - Java Mini Project
 * Author: Dandiboyina Bhaskara Koteswara Rao
 * ============================================================
 *
 * 💬 Welcome to TravelGameApp!
 * TravelGameApp is a fun and interactive Java console-based project that
 * combines tour booking, mini games, discount calculation, and a
 * payment simulation — all in one experience!
 *
 * 🧭 Features:
 *  - Tour booking with multiple destinations
 *  - Mini-game challenges to earn travel discounts
 *  - Smart billing system with total cost breakdown
 *  - Banking/Payment simulation for 25% advance payment
 *
 * ▶️ Main Entry Point:
 * To compile and run this project in Command Prompt or Terminal:
 *
 *     javac TravelGameApp.java
 *     java TravelGameApp
 *
 * 💡 Tip:
 * Enjoy the ASCII-style console design, play the game, and
 * complete your booking journey through fun and logic!
 *
 * Thank you for exploring TravelGameApp —
 * where every journey begins with joy and creativity! 🌍
 * ============================================================
 */

import java.util.*;
import java.util.regex.*;

class User {
    private String username = "hello";
    private String password = "Harika@12";
    private long phoneNumber = 9876543210L;
    private String email = "user123@gmail.com";

    User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = Long.parseLong(phoneNumber);
        this.email = email;
    }

    User() {}

    void setName(String username) {
        this.username = username;
    }

    void setPass(String password) {
        this.password = password;
    }

    void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getName() {
        return username;
    }

    String getPass() {
        return password;
    }

    long getPhoneNumber() {
        return phoneNumber;
    }

    String getEmail() {
        return email;
    }
}

class GameZone {
    double discount;
    Scanner input = new Scanner(System.in);

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BRIGHT_CYAN = "\u001B[96m";
    static final String BRIGHT_GREEN = "\u001B[92m";
    static final String BRIGHT_YELLOW = "\u001B[93m";
    static final String BRIGHT_BLUE = "\u001B[94m";
    static final String BRIGHT_MAGENTA = "\u001B[95m";
    static final String BRIGHT_RED = "\u001B[91m";
    static final String BOLD = "\u001B[1m";

    double games() {
        System.out.println(CYAN + "WELCOME TO GAMES ZONE" + RESET);
        System.out.println("1. Word Guessing - " + YELLOW + "20% Discount" + RESET);
        System.out.println("2. Number Guessing - " + YELLOW + "15% Discount" + RESET);
        System.out.println("3. 2048 - " + YELLOW + "50% Discount" + RESET);
        System.out.println(BRIGHT_YELLOW + "If you want to play enter 'yes' or else enter 'no'" + RESET);

        String s = input.nextLine().trim().toLowerCase();

        if (s.equals("yes")) {
            System.out.println(BLUE + "Enter 1 for Word Guessing\nEnter 2 for Number Guessing\nEnter 3 for 2048" + RESET);
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    return wordgame() ? 20.0 : 0.0;
                case 2:
                    return numberguess() ? 15.0 : 0.0;
                case 3:
                    return game2048() ? 50.0 : 0.0;
                default:
                    System.out.println(RED + "OOPS! Game not available. Select again" + RESET);
                    return games();
            }
        } else if (s.equals("no")) {
            return 0.0;
        } else {
            System.out.println(RED + "Invalid choice! Try again." + RESET);
            return games();
        }
    }

    boolean wordgame() {
        System.out.println(CYAN + "Word Game Rules:\n" + RESET +
            "1. Words are VEHICLE BRAND NAMES\n" +
            "2. You have 5 attempts");

        System.out.println(BRIGHT_YELLOW + "Enter 1 to play or any other number to re choose the game:" + RESET);
        int choice = Integer.parseInt(input.nextLine());

        if (choice != 1) {
            games();
            return false;
        } else {
          System.out.println(BRIGHT_MAGENTA+"   ____   _   _   _____     _____    _____"+RESET);
            System.out.println(BRIGHT_MAGENTA+"  / ___| | | | | | ____|  / ___    / ____"+RESET);
            System.out.println(BRIGHT_BLUE+" | |  _  | | | | |  _|    \\___ \\   \\___  \\"+RESET);
            System.out.println(BRIGHT_YELLOW+" | |_| | | |_| | | |___   ____) |    ___) |"+RESET);
            System.out.println(BRIGHT_CYAN+"  \\____|  \\___/  |_____| |_____/    |____/"+RESET);
       
            System.out.println();
            System.out.println(YELLOW+"  _____  _   _  _____       __        __  _____   ----   ---"+RESET);
            System.out.println(GREEN+" |_   _|| | | || ____|      \\ \\      / / ||   || ||   \\ ||   \\"+RESET);
            System.out.println(RED+"   | |  | |_| ||  _|         \\ \\ /\\ / /  ||   || ||___/ ||   ||"+RESET);
            System.out.println(BRIGHT_CYAN+"   | |  |  _  || |___         \\ V  V /   ||   || || \\   ||  //"+RESET);
            System.out.println(BRIGHT_BLUE+"   |_|  |_| |_||_____|         \\_/\\_/     -----  ||  \\   ----"+RESET);

            String[] brands = {"Maruti", "Tata", "Mahindra", "Ashokleyland", "ForceMotors"};
            String word = brands[new Random().nextInt(brands.length)].toUpperCase();
    
            String masked = word.replaceAll("[A-Z]", "_");
            System.out.println(BLUE + "Word has " + word.length() + " characters." + RESET);
            System.out.println(BRIGHT_CYAN + "Guess the word: " + masked + RESET);
    
            return startGame(word, masked); 
        }
    }

    boolean startGame(String actual, String hidden) {
        int tries = 5;
        System.out.println(CYAN + "Welcome to Word Guessing Game" + RESET);

        for (int i = 1; i <= tries; i++) {
            System.out.print(BRIGHT_YELLOW + "Attempt " + i + "/" + tries + " - Guess: " + RESET);
            String guess = input.nextLine().toUpperCase();

            if (guess.equals(actual)) {
                System.out.println(GREEN + "Correct! You win 20% discount." + RESET);
                return true;
            } else {
                System.out.println(RED + "Wrong guess." + RESET);
            }
        }

        System.out.println(RED + "You lost! The correct word was: " + actual + RESET);
        return false;
    }

    boolean numberguess() {
        int number = 1 + (int)(100 * Math.random());
        int K = 5;

        System.out.println(CYAN + "Number Guessing Rules:\n" + RESET +
            "1. A number is chosen between 1 and 100.\n" +
            "2. You have " + K + " attempts to guess the correct number.");

        System.out.println(BRIGHT_YELLOW + "Enter 1 to play or any other number to re choose the game" + RESET);
        int choice = Integer.parseInt(input.nextLine());

        if (choice != 1) {
            games();
            return false;
        } else {
            System.out.println("\u001B[91m  _\u001B[92m   \u001B[93m_\u001B[94m   \u001B[95m_\u001B[96m   \u001B[91m_\u001B[92m   \u001B[93m__\u001B[94m  \u001B[95m__\u001B[96m   \u001B[91m____\u001B[92m    \u001B[93m_____\u001B[94m   \u001B[95m____\u001B[0m");
            System.out.println("\u001B[96m | \\ \u001B[91m| |\u001B[92m | |\u001B[93m | |\u001B[94m |  \\/  |\u001B[95m |  _ \\\u001B[96m  | ____|\u001B[91m |  _ \\\u001B[0m");
            System.out.println("\u001B[93m |  \\| |\u001B[94m | |\u001B[95m | |\u001B[96m | |\\/| |\u001B[91m | |_) |\u001B[92m |  _|  \u001B[93m | |_) |\u001B[0m");
            System.out.println("\u001B[92m | |\\  |\u001B[93m | |_| |\u001B[94m | |  | |\u001B[95m |  _ < \u001B[96m | |___ \u001B[91m |  _ < \u001B[0m");
            System.out.println("\u001B[91m |_| \\_|\u001B[92m  \\___/\u001B[93m  |_|  |_|\u001B[94m | |_) |\u001B[95m |_____|\u001B[96m |_| \\_\\\u001B[0m");
            System.out.println("                          \u001B[94m|_____/\u001B[0m                      ");
            System.out.println("  \u001B[91m____\u001B[92m   _   _\u001B[93m   _____\u001B[94m   ____\u001B[95m    ____\u001B[96m    _____\u001B[91m   _   _\u001B[92m    ____  \u001B[0m");
            System.out.println(" \u001B[92m/ ___|\u001B[93m | | | |\u001B[94m | ____|\u001B[95m / ___|\u001B[96m  / ___|\u001B[91m  |_   _|\u001B[92m | \\ | |\u001B[93m  / ___| \u001B[0m");
            System.out.println("\u001B[93m| |  _ \u001B[94m | | | |\u001B[95m |  _|  \u001B[96m \\___ \\\u001B[91m  \\___ \\\u001B[92m    | |  \u001B[93m |  \\| |\u001B[94m | |  _  \u001B[0m");
            System.out.println("\u001B[94m| |_| |\u001B[95m | |_| |\u001B[96m | |___\u001B[91m   ___) |\u001B[92m  ___) |\u001B[93m   | |  \u001B[94m | |\\  |\u001B[95m | |_| | \u001B[0m");
            System.out.println("\u001B[95m \\____|\u001B[96m  \\___/ \u001B[91m |_____|\u001B[92m |____/\u001B[93m  |____/\u001B[94m   _| |_ \u001B[95m |_| \\_|\u001B[96m  \\____| \u001B[0m");
            System.out.println("                                        \u001B[91m|_____|\u001B[0m           ");
		
            for (int i = 0; i < K; i++) {
                System.out.print(BRIGHT_YELLOW + "Enter your guess (Attempt " + (i + 1) + "): " + RESET);
                int guess = Integer.parseInt(input.nextLine());

                if (guess == number) {
                    System.out.println(GREEN + "Congratulations! You guessed the correct number." + RESET);
                    System.out.println(GREEN + "You get 15% discount on your bill!" + RESET);
                    return true;
                } else if (guess < number) {
                    System.out.println(RED + "The number is greater than " + guess + RESET);
                } else {
                    System.out.println(RED + "The number is less than " + guess + RESET);
                }
            }

            System.out.println(RED + "You've exhausted all attempts. The correct number was: " + number + RESET);
            return false; 
        }
    }

    boolean game2048() {
        int[][] board = new int[4][4];
        Random rand = new Random();

        class Game2048Helper {
            void showBoard() {
                for (int i = 0; i < 4; i++) {
                    for (int k = 0; k < 4; k++) System.out.print("-------");
                    System.out.println();

                    System.out.print("|");
                    for (int j = 0; j < 4; j++) System.out.print("      |");
                    System.out.println();

                    System.out.print("|");
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == 0) {
                            System.out.printf("  %-3s |", "");
                        } else {
                            String color = getColor(board[i][j]);
                            System.out.printf("  %s%-3d%s |", color, board[i][j], RESET);
                        }
                    }
                    System.out.println();

                    System.out.print("|");
                    for (int j = 0; j < 4; j++) System.out.print("      |");
                    System.out.println();
                }

                for (int k = 0; k < 4; k++) System.out.print("-------");
                System.out.println();
            }

            String getColor(int value) {
                if (value == 2) return CYAN;
                if (value == 4) return GREEN;
                if (value == 8) return YELLOW;
                if (value == 16) return BLUE;
                if (value == 32) return MAGENTA;
                if (value == 64) return RED;
                if (value == 128) return BRIGHT_CYAN;
                if (value == 256) return BRIGHT_GREEN;
                if (value == 512) return BRIGHT_YELLOW;
                if (value == 1024) return BRIGHT_BLUE;
                if (value == 2048) return BRIGHT_MAGENTA;
                return BRIGHT_RED;
            }

            void addRandom() {
                List<int[]> empty = new ArrayList<>();
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++)
                        if (board[i][j] == 0) empty.add(new int[]{i, j});
                if (!empty.isEmpty()) {
                    int[] pos = empty.get(rand.nextInt(empty.size()));
                    board[pos[0]][pos[1]] = rand.nextDouble() < 0.9 ? 2 : 4;
                }
            }

            boolean moveLeft() {
                boolean moved = false;
                for (int i = 0; i < 4; i++) {
                    int[] row = board[i];
                    int[] compressed = new int[4];
                    int idx = 0;
                    for (int val : row)
                        if (val != 0) compressed[idx++] = val;
                    for (int j = 0; j < 3; j++) {
                        if (compressed[j] != 0 && compressed[j] == compressed[j + 1]) {
                            compressed[j] *= 2;
                            compressed[j + 1] = 0;
                            moved = true;
                        }
                    }
                    int[] newRow = new int[4];
                    idx = 0;
                    for (int val : compressed)
                        if (val != 0) newRow[idx++] = val;
                    if (!Arrays.equals(row, newRow)) moved = true;
                    board[i] = newRow;
                }
                return moved;
            }

            boolean moveRight() {
                reverseRows();
                boolean moved = moveLeft();
                reverseRows();
                return moved;
            }

            boolean moveUp() {
                transpose();
                boolean moved = moveLeft();
                transpose();
                return moved;
            }

            boolean moveDown() {
                transpose();
                boolean moved = moveRight();
                transpose();
                return moved;
            }

            void transpose() {
                for (int i = 0; i < 4; i++)
                    for (int j = i + 1; j < 4; j++) {
                        int temp = board[i][j];
                        board[i][j] = board[j][i];
                        board[j][i] = temp;
                    }
            }

            void reverseRows() {
                for (int i = 0; i < 4; i++) {
                    int[] row = board[i];
                    for (int j = 0; j < 2; j++) {
                        int temp = row[j];
                        row[j] = row[3 - j];
                        row[3 - j] = temp;
                    }
                }
            }

            boolean checkWin() {
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++)
                        if (board[i][j] == 2048) return true;
                return false;
            }

            boolean checkGameOver() {
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++)
                        if (board[i][j] == 0) return false;
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 3; j++)
                        if (board[i][j] == board[i][j + 1]) return false;
                for (int j = 0; j < 4; j++)
                    for (int i = 0; i < 3; i++)
                        if (board[i][j] == board[i + 1][j]) return false;
                return true;
            }
        }

        System.out.println(CYAN + "2048 Game Rules:-" + RESET);
        System.out.println(BRIGHT_MAGENTA+"        1.Use 'w', 'a', 's', 'd' to move tiles Up, Left, Down, Right."+RESET);
        System.out.println(BRIGHT_MAGENTA+"        2.Combine tiles with the same number to reach 2048!"+RESET);
        System.out.println(BRIGHT_YELLOW + "Enter 1 to play or any other number to re choose the game" + RESET);
        int choice = Integer.parseInt(input.nextLine());

        if (choice != 1) {
            games();
            return false;
        } else {
            System.out.println(BRIGHT_CYAN + "****    ****   *   *   **** ");
            System.out.println("*   *  *    *  *   *  *    *");
            System.out.println("   *   *    *  *****   **** ");
            System.out.println("  *    *    *      *  *    *");
            System.out.println("*****   ****       *   **** " + RESET);
            
            Game2048Helper game = new Game2048Helper();
            game.addRandom();
            game.addRandom();

            while (true) {
                game.showBoard();
                System.out.println(BLUE + "Choose a move:" + RESET);
                System.out.println(RED+"W/w: Up" + RESET);
                System.out.println(RED+"S/s: Down" + RESET);
                System.out.println(RED+"A/a: Left" + RESET);
                System.out.println(RED+"D/d: Right" + RESET);
                System.out.println(BRIGHT_BLUE+"Q/q: Quit" + RESET);
                System.out.print(BRIGHT_YELLOW + "Enter your move: " + RESET);
                String moveInput = input.nextLine().trim().toUpperCase();
                if (moveInput.isEmpty()) {
                    System.out.println(RED + "Invalid input! Use W/A/S/D or Q." + RESET);
                    continue;
                }
                char move = moveInput.charAt(0);

                if (move == 'Q') {
                    System.out.println(RED + "Game quit. No discount earned." + RESET);
                    return false;
                }

                boolean moved = false;
                switch (move) {
                    case 'W': moved = game.moveUp(); break;
                    case 'S': moved = game.moveDown(); break;
                    case 'A': moved = game.moveLeft(); break;
                    case 'D': moved = game.moveRight(); break;
                    default: System.out.println(RED + "Invalid input! Use W/A/S/D or Q." + RESET); continue;
                }

                if (game.checkWin()) {
                    game.showBoard();
                    System.out.println(GREEN + "Congratulations! You reached 2048! You win 50% discount." + RESET);
                    return true;
                }

                if (moved) {
                    game.addRandom();
                }

                if (game.checkGameOver()) {
                    game.showBoard();
                    System.out.println(RED + "Game over! No moves left. No discount earned." + RESET);
                    return false;
                }
            }
        }
    }
}

class TourPackage {
    Scanner sc = new Scanner(System.in);
    String selectedCity = "";
    int cityTravelBill = 0;
    int hotelBill = 0;
    int foodBill = 0;
    int[] localTravelBill = new int[5];
    double discount = 0.0;

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String ORANGE_BOLD = "\u001B[38;5;208m";

    private final Map<String, String[]> cityPatterns = new HashMap<>();

    {
        cityPatterns.put("Vizag", new String[]{
            " ***            ***    ****************    ******************         *******             *************** ",
            "  ***          ***     ****************    *************  *          *       *          *  ************** ",
            "   ***        ***            ***                     *  *           *   ***   *        *  *               ",
            "    ***      ***             ***                   *  *            *   *****   *       *  *       ******* ",
            "     ***    ***              ***                 *  *             *             *      *  *       ***** * ",
            "      ***  ***               ***               *  *              *  ***********  *     *  *          *  * ",
            "       ******          ****************     *   ************    *  *           *  *     *  ***********  * ",
            "        ****           ****************    *****************   ****             ****      *************** "
        });
        cityPatterns.put("Hyderabad", new String[]{
            "***   ***     ***         ****  ********          ",
            "* *   * *      *  *      *  *   *       *  ",
            "* * * * *        *  *  *   *    * ***   *  ",
            "* ***** *         *  *   *      * * *   *    ",
            "* *   * *          *    *       * ***   *    ",
            "* *   * *          *   *        *       *       ",
            "***   ***          *****        ********             "
         });
        cityPatterns.put("Kerala", new String[]{
            "*       *   *********   *******     ***     *               ***",
            "*     *     *           *      *   *   *    *              *   *",
            "*   *       *           *      *  *     *   *             *     *",
            "* *         *********   *******  *       *  *            *       *",
            "**          *           *   *    *********  *            *********",
            "* *         *           *    *   *       *  *            *       *",
            "*   *       *           *     *  *       *  *            *       *",
            "*     *     *           *      * *       *  *            *       *",
            "*       *   *********   *       *        *   *********   *       *"
        });
        cityPatterns.put("Goa", new String[]{
            "  *****      ******         ********           ",
            " *     *    *      *       *        *      ",
            "*           * **** *      *   ***    *             ",
            "*           * *  * *     *  ********  *          ",
            "*   ****    * *  * *    *              *   ",
            "*      *    * **** *   *  ************  *       ",
            " *     *    *      *  *  *            *  *         ",
            "  *****      ******  ****              ****    "
        });
        cityPatterns.put("Delhi", new String[]{
            "* * * *       * * * * *     *             *       *      * * * * * * * ",
            "*       *     *             *             *       *            *       ",
            "*       *     *             *             *       *            *       ",
            "*       *     * * *         *             * * * * *            *       ",
            "*       *     *             *             *       *            *       ",
            "*       *     *             *             *       *            *       ",
            "* * * *       * * * * *     * * * * *     *       *      * * * * * * * "
        });
    }

    void selectTourPackage() throws InterruptedException {
        while (true) {
            System.out.println(CYAN + "\nSelect Your Tour Package:" + RESET);
            System.out.println(GREEN + "1. Vizag\n2. Hyderabad\n3. Kerala\n4. Goa\n5. Delhi" + RESET);
            System.out.print(YELLOW + "Enter choice (1-5): " + RESET);
            int choice = sc.nextInt();

            if (choice == 1) selectedCity = "Vizag";
            else if (choice == 2) selectedCity = "Hyderabad";
            else if (choice == 3) selectedCity = "Kerala";
            else if (choice == 4) selectedCity = "Goa";
            else if (choice == 5) selectedCity = "Delhi";
            else {
                System.out.println(RED + "Invalid choice, please select a valid number (1-5)." + RESET);
                continue;
            }

            String[] pattern = cityPatterns.get(selectedCity);
            String color = selectedCity.equals("Vizag") ? RED : selectedCity.equals("Hyderabad") ? RED :
                           selectedCity.equals("Kerala") ? GREEN : selectedCity.equals("Goa") ? YELLOW : RED;
            for (String line : pattern) {
                for (char ch : line.toCharArray()) {
                    System.out.print(color + ch + RESET);
                    Thread.sleep(3);
                }
                System.out.println();
            }

            System.out.println(CYAN + "Select mode of travel to " + selectedCity + ":" + RESET);
            System.out.println(GREEN + "1. Bus - 2000\n2. Train - 1000\n3. Flight - 5000" + RESET);

            while (true) {
                System.out.print(YELLOW + "Enter choice: " + RESET);
                int travel = sc.nextInt();
                if (travel == 1) {
                    cityTravelBill = 2000;
                    break;
                } else if (travel == 2) {
                    cityTravelBill = 1000;
                    break;
                } else if (travel == 3) {
                    cityTravelBill = 5000;
                    break;
                } else {
                    System.out.println(RED + "Invalid travel mode. Please choose 1, 2, or 3." + RESET);
                }
            }
            break;
        }
    }

    void bookHotel() {
        System.out.println(CYAN + "\nSelect Hotel in " + selectedCity + ":" + RESET);
        String[] hotels = new String[3];
        switch (selectedCity) {
            case "Vizag":
                hotels = new String[]{"Sea View Hotel", "Dolphin Stay", "Beach Inn"};
                break;
            case "Hyderabad":
                hotels = new String[]{"Charminar Suites", "Pearl Residency", "City Comforts"};
                break;
            case "Kerala":
                hotels = new String[]{"Munnar Heights", "Backwater Resort", "Spice Villa"};
                break;
            case "Goa":
                hotels = new String[]{"Sunset Bay", "Goa Comforts", "Beachside Inn"};
                break;
            case "Delhi":
                hotels = new String[]{"Capital Residency", "Delhi Palace", "Red Fort Inn"};
                break;
        }

        System.out.println(GREEN + "1. " + hotels[0] + " - 2000 (5 days)");
        System.out.println("2. " + hotels[1] + " - 2500 (5 days)");
        System.out.println("3. " + hotels[2] + " - 3000 (5 days)" + RESET);

        while (true) {
            System.out.print(YELLOW + "Choose hotel (1-3): " + RESET);
            int hotelChoice = sc.nextInt();
            if (hotelChoice == 1) {
                hotelBill = 2000;
                break;
            } else if (hotelChoice == 2) {
                hotelBill = 2500;
                break;
            } else if (hotelChoice == 3) {
                hotelBill = 3000;
                break;
            } else {
                System.out.println(RED + "Invalid hotel choice. Please enter a number between 1 and 3." + RESET);
            }
        }
    }

    void bookFood() {
        System.out.println(CYAN + "\nSelect Food Plan:" + RESET);
        System.out.println(GREEN + "1. Veg - 750 (5 days)\n2. Non-Veg - 1250 (5 days)\n3. Mixed - 2000 (5 days)" + RESET);
        while (true) {
            System.out.print(YELLOW + "Choose food type (1-3): " + RESET);
            int choice = sc.nextInt();
            if (choice == 1) {
                foodBill = 750;
                break;
            } else if (choice == 2) {
                foodBill = 1250;
                break;
            } else if (choice == 3) {
                foodBill = 2000;
                break;
            } else {
                System.out.println(RED + "Invalid food type. Please enter 1, 2, or 3." + RESET);
            }
        }
    }

    void dayWiseScheduleAndTravel() {
        String[] places = new String[5];
        switch (selectedCity) {
            case "Vizag":
                places = new String[]{"Rushikonda", "RK Beach", "Kailasagiri", "Simhachalam", "Araku"};
                break;
            case "Hyderabad":
                places = new String[]{"Charminar", "Golconda", "Birla Mandir", "Hussain Sagar", "Yadagirigutta"};
                break;
            case "Kerala":
                places = new String[]{"Alleppey", "Munnar", "Kochi", "Wayanad", "Athirapally Waterfalls"};
                break;
            case "Goa":
                places = new String[]{"Baga Beach", "Calangute Beach", "Dudhsagar Waterfalls", "Mackie's Night Bazaar", "Casino Pride"};
                break;
            case "Delhi":
                places = new String[]{"Taj Mahal", "India Gate", "Qutub Minar", "Red Fort", "Parliament House"};
                break;
        }

        System.out.println(CYAN + "\nTour Schedule for " + selectedCity + ":" + RESET);
        for (int i = 0; i < places.length; i++) {
            System.out.println(PURPLE + "Day " + (i + 1) + ": " + places[i] + RESET);
        }

        for (int day = 1; day <= 5; day++) {
            while (true) {
                System.out.print(YELLOW + "\nEnter the day number (Day " + day + "): " + RESET);
                int inputDay = sc.nextInt();
                if (inputDay == day) {
                    String place = places[day - 1];
                    System.out.println(GREEN + "Today you are visiting: " + place + RESET);
                    System.out.println(CYAN + "Select travel mode for Day " + day + ":" + RESET);
                    System.out.println(GREEN + "1. Bus - 100\n2. Bike - 200\n3. Car - 500" + RESET);

                    while (true) {
                        System.out.print(YELLOW + "Enter travel mode: " + RESET);
                        int travel = sc.nextInt();
                        if (travel == 1) {
                            localTravelBill[day - 1] = 100;
                            break;
                        } else if (travel == 2) {
                            localTravelBill[day - 1] = 200;
                            break;
                        } else if (travel == 3) {
                            localTravelBill[day - 1] = 500;
                            break;
                        } else {
                            System.out.println(RED + "Invalid choice. Choose 1, 2, or 3." + RESET);
                        }
                    }

                    System.out.println(GREEN + "Let's start Journey to " + place + "." + RESET);
                    System.out.println(PURPLE + "Welcome to " + place + "!" + RESET);
                    System.out.println("Day " + day + " Travel Bill: " + localTravelBill[day - 1]);
                    break;
                } else {
                    System.out.println(RED + "Please enter Day " + day + " only. Follow the sequence." + RESET);
                }
            }
        }
    }

    void showTotalBill() {
        int totalLocalTravel = 0;
        for (int bill : localTravelBill) {
            totalLocalTravel += bill;
        }

        int total = cityTravelBill + hotelBill + foodBill + totalLocalTravel;
        double discountedTotal = total * (1 - discount / 100);

        System.out.println(ORANGE_BOLD + "\n========= Final Bill Summary =========" + RESET);
        System.out.println();
        System.out.println("City Travel Bill    : " + cityTravelBill);
        System.out.println("Hotel Bill          : " + hotelBill);
        System.out.println("Food Bill           : " + foodBill);
        for (int i = 0; i < 5; i++) {
            System.out.println("Day " + (i + 1) + " Local Travel : " + localTravelBill[i]);
        }
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println(YELLOW + "Total Tour Bill     : " + total + RESET);
        if (discount > 0) {
            System.out.println(GREEN + "Discount Applied    : " + discount + "%" + RESET);
            System.out.println(GREEN + "Final Bill (after discount) : " + Math.round(discountedTotal) + RESET);
        }
    }

    void start() throws InterruptedException {
        selectTourPackage();
        bookHotel();
        bookFood();
        dayWiseScheduleAndTravel();
        showTotalBill();
    }
}

class TravelGameApp {
    static Scanner sc = new Scanner(System.in);
    static User x = new User();

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String WHITE = "\u001B[37m";
    static final String BOLD = "\u001B[1m";
    static final String UNDERLINE = "\u001B[4m";
    static final String BRIGHT_YELLOW = "\u001B[93m";
    static final String BRIGHT_GREEN = "\u001B[92m";

    boolean isValid() {
        return isValidUsername(x.getName()) && isValidPassword(x.getPass())
                && isValidMobileNumber(x.getPhoneNumber()) && isValidEmail(x.getEmail());
    }

    boolean isValidUsername(String username) {
        return username != null && username.matches("[a-zA-Z0-9]{4,}");
    }

    boolean isValidPassword(String password) {
        return password != null &&
                password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    boolean isValidMobileNumber(long phoneNumber) {
        return String.valueOf(phoneNumber).matches("[6-9]\\d{9}");
    }

    boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    String generateOTP() {
        Random rand = new Random();
        int otp = rand.nextInt(9000) + 1000;
        return String.valueOf(otp);
    }

    void signUp() throws InterruptedException {
        System.out.println(BOLD + BLUE + "\n=======================================");
        System.out.println("             SIGN UP                ");
        System.out.println("=======================================" + RESET);
        System.out.println(YELLOW + "Enter your details to create new account\n" + RESET);

        String username;
        while (true) {
            System.out.print(CYAN + "Enter username (min 4 characters): " + RESET);
            username = sc.next();
            if (isValidUsername(username)) break;
            System.out.println(RED + "Invalid username format." + RESET);
        }

        long phoneNumber;
        while (true) {
            System.out.print(CYAN + "Enter mobile number (10 digits starting with 6-9): " + RESET);
            try {
                phoneNumber = Long.parseLong(sc.next());
                if (isValidMobileNumber(phoneNumber)) break;
            } catch (Exception e) {
                System.out.println(RED + "Invalid number format." + RESET);
            }
            System.out.println(RED + "Invalid mobile number format." + RESET);
        }

        sc.nextLine();
        String email;
        while (true) {
            System.out.print(CYAN + "Enter your email: " + RESET);
            email = sc.nextLine();
            if (isValidEmail(email)) break;
            System.out.println(RED + "Invalid email format." + RESET);
        }

        String otp = generateOTP();
        System.out.println(MAGENTA + "Your OTP is: " + otp + RESET);
        System.out.print(YELLOW + "Enter the OTP sent to your mobile: " + RESET);
        String enteredOtp = sc.nextLine();
        while (!otp.equals(enteredOtp)) {
            System.out.print(RED + "Invalid OTP. Please enter the correct OTP: " + RESET);
            enteredOtp = sc.nextLine();
        }

        String password;
        while (true) {
            System.out.println(YELLOW + "\nPassword requirements:");
            System.out.println("# Minimum 8 characters");
            System.out.println("# At least 1 uppercase letter");
            System.out.println("# At least 1 lowercase letter");
            System.out.println("# At least 1 digit");
            System.out.println("# At least 1 special character (@#$%^&+=!)" + RESET);
            System.out.print(CYAN + "Enter password: " + RESET);
            password = sc.nextLine();
            if (isValidPassword(password)) break;
            System.out.println(RED + "Password does not meet requirements." + RESET);
        }

        x.setName(username);
        x.setPhoneNumber(phoneNumber);
        x.setEmail(email);
        x.setPass(password);

        System.out.println(GREEN + "Account created successfully!" + RESET);
        System.out.print(BLUE + "Enter 1 to login or any key to exit: " + RESET);
        char ch = sc.next().charAt(0);
        sc.nextLine();
        if (ch == '1') login();
        else System.out.println(GREEN + "Thank you :)" + RESET);
    }

    void login() throws InterruptedException {
        System.out.println(BOLD + MAGENTA + "\n--- LOGIN ---" + RESET);
        System.out.println(YELLOW + "Enter your credentials to login" + RESET);
        System.out.print(CYAN + "Enter Username : " + RESET);
        String username = sc.nextLine();

        System.out.print(CYAN + "Enter Password : " + RESET);
        String password = sc.nextLine();

        if (username.equals(x.getName()) && password.equals(x.getPass())) {
            System.out.println(GREEN + "Login successful!" + RESET);
            
            String[] lines = {
                "   *     *     *****     *     *   *****       *******    *****     *     *   *****         *****     *     *    *****     *****    *     *    ",
                "    *   *     *     *    *     *   *    *         *      *     *    *     *   *    *       *     *    *     *   *     *   *     *    *   *     ",
                "     * *      *     *    *     *   *    *         *      *     *    *     *   *    *       *     *    *     *   *     *   *     *     * *      ",
                "      *       *     *    *     *   *****          *      *     *    *     *   *****        ******     *     *   *     *   *     *      *       ",
                "      *       *     *    *     *   *  *           *      *     *    *     *   *  *         *     *    *     *   *     *   *     *      *       ",
                "      *       *     *    *     *   *   *          *      *     *    *     *   *   *        *     *    *     *   *     *   *     *      *       ",
                "      *        *****      *****    *    *         *       *****      *****    *    *        *****      *****    *****     *****        *       "
            };
            for (String line : lines) {
                for (char ch : line.toCharArray()) {
                    System.out.print(RED + ch + RESET);
                    Thread.sleep(3);
                }
                System.out.println();
            }

            proceedToGamesAndTour();
        } else if (!username.equals(x.getName()) && !password.equals(x.getPass())) {
            System.out.println(RED + "Invalid credentials - both username and password are incorrect." + RESET);
            System.out.print(YELLOW + "Press 1 to know your username or any number to exit: " + RESET);
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                while (true) {
                    System.out.print(CYAN + "Enter your mobile number: " + RESET);
                    long phoneNumber = Long.parseLong(sc.nextLine());
                    if (phoneNumber == x.getPhoneNumber()) {
                        System.out.println(GREEN + "Your username: " + x.getName() + RESET);
                        System.out.print(BLUE + "Enter 1 to go for login or any number to exit: " + RESET);
                        int n1 = Integer.parseInt(sc.nextLine());
                        if (n1 == 1) login();
                        else System.out.println(GREEN + "Thank you" + RESET);
                        break;
                    } else {
                        System.out.print(RED + "User not found\nPress 1 to re-enter or any key to exit: " + RESET);
                        char ch = sc.next().charAt(0);
                        sc.nextLine();
                        if (ch != '1') {
                            System.out.println(GREEN + "Thank you" + RESET);
                            break;
                        }
                    }
                }
            } else {
                System.out.println(GREEN + "Thank you" + RESET);
            }
        } else if (!username.equals(x.getName())) {
            System.out.print(RED + "Invalid username. Press 1 to reset or any number to exit: " + RESET);
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                System.out.print(CYAN + "Enter new Username: " + RESET);
                x.setName(sc.nextLine());
                System.out.println(GREEN + "Your new username: " + x.getName() + RESET);
                System.out.print(BLUE + "Enter 1 to go for login or any number to exit: " + RESET);
                int n1 = Integer.parseInt(sc.nextLine());
                if (n1 == 1) login();
                else System.out.println(GREEN + "Thank you" + RESET);
            } else {
                System.out.println(GREEN + "Thank you" + RESET);
            }
        } else {
            System.out.print(RED + "Invalid password. Press 1 to reset or any number to exit: " + RESET);
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                String newPassword;
                while (true) {
                    System.out.println(YELLOW + "Password requirements:");
                    System.out.println("# Minimum 8 characters");
                    System.out.println("# At least 1 uppercase letter");
                    System.out.println("# At least 1 lowercase letter");
                    System.out.println("# At least 1 digit");
                    System.out.println("# At least 1 special character (@#$%^&+=!)" + RESET);
                    System.out.print(CYAN + "Enter new Password: " + RESET);
                    newPassword = sc.nextLine();
                    if (isValidPassword(newPassword)) break;
                    System.out.println(RED + "Password does not meet requirements." + RESET);
                }
                x.setPass(newPassword);
                System.out.println(GREEN + "Your new password: " + x.getPass() + RESET);
                System.out.print(BLUE + "Enter 1 to go for login or any number to exit: " + RESET);
                int n1 = Integer.parseInt(sc.nextLine());
                if (n1 == 1) login();
                else System.out.println(GREEN + "Thank you" + RESET);
            } else {
                System.out.println(GREEN + "Thank you" + RESET);
            }
        }
    }

    void proceedToGamesAndTour() throws InterruptedException {
        TourPackage tp = new TourPackage();
        tp.selectTourPackage();
        tp.bookHotel();
        tp.bookFood();
        tp.dayWiseScheduleAndTravel();

        GameZone gameZone = new GameZone();
        System.out.println(GREEN + "*** Win the game to get a Discount on your Tour Package! ***" + RESET);
        System.out.println(BRIGHT_YELLOW + "Enter 1 to play the games or any other number to proceed to final bill: " + RESET);
        int n = Integer.parseInt(sc.nextLine());

        double discount = 0.0;
        if (n == 1) {
            discount = gameZone.games();
            System.out.println(BRIGHT_GREEN + "Your discount: " + discount + "%" + RESET);
        }

        tp.discount = discount;
        tp.showTotalBill();
    }

    public static void main(String[] args) throws InterruptedException {
        TravelGameApp app = new TravelGameApp();
        System.out.println(BOLD + BLUE + "========================================");
        System.out.println("         Welcome to Travel & Game System ");
        System.out.println("========================================" + RESET);
        System.out.println(BOLD + MAGENTA + "1 - Signup\n2 - Login" + RESET);
        System.out.print(CYAN + "Enter your choice: " + RESET);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            app.signUp();
        } else if (n == 2) {
            app.login();
        } else {
            System.out.println(RED + "Invalid choice. Please select again." + RESET);
            main(args);
        }
    }
}