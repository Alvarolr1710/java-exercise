package com.javaexercises;

import com.javaexercises.enums.ActionsEnum;
import com.javaexercises.enums.FamilyEnum;
import com.javaexercises.enums.GenderEnum;
import com.javaexercises.families.Demiwolf;
import com.javaexercises.families.Elf;
import com.javaexercises.families.Human;
import com.javaexercises.families.Orc;

import java.util.Arrays;
import java.util.Scanner;

public class ExerciseApplication {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Characters player1 = setPlayer(keyboard);
        System.out.println(player1.toString());
        start(keyboard, player1);

    }

    private static void start(Scanner keyboard, Characters player1) {
        boolean quit = true;
        do {
            System.out.println("Decide your next action:");
            System.out.println(Arrays.toString(ActionsEnum.values()));
            switch (keyboard.nextLine().toLowerCase()) {
                case "walk":
                    walk(keyboard, player1);
                    break;
                case "attack":
                    System.out.println(player1.getName() + " is attacking");
                    player1.attack();
                    break;
                case "quit":
                    quit = false;
                default:
                    System.out.println("You selected an invalid action");
                    break;
            }
            System.out.println(player1.toString());
        } while (quit);
    }

    private static void walk(Scanner keyboard, Characters player1) {
        System.out.println("Select your walking coordinates");
        System.out.print("x coordinates:");
        int xAxis = Integer.parseInt(keyboard.nextLine());
        System.out.print("y coordinates:");
        int yAxis = Integer.parseInt(keyboard.nextLine());
        player1.walk(xAxis, yAxis);
    }

    private static Characters setPlayer(Scanner keyboard) {
        Characters player1 = createNewCharacter(keyboard);
        setPlayerName(keyboard, player1);
        setPlayerGender(keyboard, player1);
        setPlayerWeapon(keyboard, player1);
        return player1;
    }

    private static void setPlayerWeapon(Scanner keyboard, Characters player1) {
        System.out.println("Please select your weapon:");
        player1.setWeapon(keyboard.next());
    }

    private static void setPlayerGender(Scanner keyboard, Characters player1) {
        System.out.println("Please enter your gender:");
        System.out.println(Arrays.toString(GenderEnum.values()));
        player1.setGender(keyboard.next());
    }

    private static void setPlayerName(Scanner keyboard, Characters player1) {
        System.out.println("Welcome \nPlease enter your name:");
        player1.setName(keyboard.next());
        System.out.println("Welcome: " + player1.getName());
    }

    private static Characters createNewCharacter(Scanner keyboard) {
        System.out.println("Welcome \nPlease enter your family:");
        System.out.println(Arrays.toString(FamilyEnum.values()));
        return selectYourCharacter(keyboard.next());
    }

    private static Characters selectYourCharacter(String characterFamily) {
        Characters characters;
        switch (characterFamily.toLowerCase()) {
            case "human":
                characters = new Human();
                break;
            case "orc":
                characters = new Orc();
                break;
            case "elf":
                characters = new Elf();
                break;
            case "demiwolf":
                characters = new Demiwolf();
                break;
            default:
                characters = null;
                System.out.println("Your class selections are invalid");
        }
        return characters;
    }

}