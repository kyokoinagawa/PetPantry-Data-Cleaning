package com.petpantry.petpantry.UI;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String HomeScreenOption(){
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("V) View Current Inventory");
        System.out.println("D) Donation Entry");
        System.out.println("P) Pet Pantry Pick-Up");
        System.out.println("E) Exit");
        System.out.println();

        String selectedOption = scanner.next();
        String option = selectedOption.trim().toUpperCase(Locale.ROOT);

        while (!option.equals("V") && !option.equals("D") && !option.equals("P") && !option.equals("E")) {
            try {
                if (!option.equals("V") && !option.equals("D") && !option.equals("P") && !option.equals("E")) {
                    throw new IllegalArgumentException("Please enter V, D, P, or E as your choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.print("Select an option: ");
                selectedOption = scanner.nextLine();
                option = selectedOption.trim().toUpperCase();
            }
        }

        if (option.equals("V")) {
            return "View Current Inventory";
        } else if (option.equals("D")) {
            return "Donation Entry";
        } else if (option.equals("P")) {
            return "Pet Pantry Pick-Up";
        } else if (option.equals("E")) {
            return "exit";
        }
        return "";
    }
}
