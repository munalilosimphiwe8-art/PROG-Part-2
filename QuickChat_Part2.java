package com.mycompany.quickchat_part2;

import java.util.Scanner;

public class QuickChat_Part2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("== REGISTER ==");

        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("Cellphone (+27...): ");
        String cellphone = input.nextLine();

        Login user = new Login(firstName, lastName, username, password, cellphone);

        String reg = user.registerUser();
        System.out.println(reg);

        if (!reg.equals("User is registered successfully.")) {
            return;
        }

        System.out.println("\n== LOGIN ==");

        System.out.print("Username: ");
        String loginU = input.nextLine();

        System.out.print("Password: ");
        String loginP = input.nextLine();

        boolean login = user.loginUser(loginU, loginP);

        System.out.println(user.returnLoginStatus(login));

        if (!login) return;

        System.out.println("\nWELCOME TO QUICKCHAT");

        System.out.print("How many messages? ");
        int num = input.nextInt();
        input.nextLine();

        int option;

        do {

            System.out.println("\n1. Send Messages");
            System.out.println("2. Show messages (coming soon)");
            System.out.println("3. Quit");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:

                    for (int i = 0; i < num; i++) {

                        System.out.println("\nMessage " + (i + 1));

                        System.out.print("Recipient: ");
                        String rec = input.nextLine();

                        System.out.print("Message: ");
                        String msg = input.nextLine();

                        Message m = new Message(i + 1, rec, msg);

                        System.out.println(m.checkRecipientCell());
                        System.out.println(m.checkMessageLength());
                        System.out.println("Hash: " + m.createMessageHash());

                        System.out.println("1 Send  2 Discard  3 Store");
                        int choice = input.nextInt();
                        input.nextLine();

                        System.out.println(m.sentMessage(choice));

                        if (choice == 1) {
                            System.out.println(m.printMessages());
                        }
                    }

                    System.out.println("Total messages: " + Message.returnTotalMessages());
                    break;

                case 2:
                    System.out.println("Coming soon");
                    break;

                case 3:
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 3);

        input.close();
    }
}