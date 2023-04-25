package org.generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to 'TOKEN GENERATOR' app!");
        System.out.println("I will generate a token from random characters.");

        while (true) {
            System.out.println("\nPlease select the length of the token to generate:");
            System.out.println("(1 - 5 characters, 2 - 10 characters, 3 - 15 characters)");

            int tokenLength = 5 * getTokenLength();
            if (tokenLength == 0) {
                continue;}

            String token = generateToken(tokenLength);
            System.out.println("Your generated token is:");
            System.out.println("\n" + token + "\n");

            System.out.println("Do you want to generate another token?");
            System.out.println("1 - yes, 2 - no");
            int nextAction = new Scanner(System.in).nextInt();
            if (nextAction == 2) {
                System.out.println("Thank you for using TOKEN GENERATOR.");
                break;
            }
        }
    }

    public static Integer getTokenLength() {
        int userInt = new Scanner(System.in).nextInt();
        if (userInt == 1 || userInt == 2 || userInt == 3) {
            return userInt;}
        System.out.println("Your value is not valid!");
        return 0;
    }

    public static String generateToken(int tokenLength) {
        int randomInt;
        char randomChar;
        int lowerLimit = 33;
        int upperLimit = 127;
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < tokenLength; i++) {
            randomInt = getRandomInt(lowerLimit, upperLimit);
            randomChar = (char) randomInt;
            token.append(randomChar);
        }
        return token.toString();
    }

    public static Integer getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}