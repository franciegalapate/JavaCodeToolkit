package finals;
import java.lang.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
Group 5 - SET B
Balanza, Clian
Barrozo, Sebastian
Galapate, Francie Gabrielle
Kerchaten, Louella
Manuntag, Wilian Dominic
Vega, Althea
 */
public class Final_CS112L {
    public static void main(String [] args) { // MAIN METHOD
        Scanner s = new Scanner(System.in);
        int choice; // user choice

        // members
        System.out.println("Welcome to our Java Program Collection!");
        System.out.println("Balanza, Clian\n" +
                "Barrozo, Sebastian\n" +
                "Galapate, Francie Gabrielle\n" +
                "Kerchaten, Louella\n" +
                "Manuntag, Wilian Dominic\n" +
                "Vega, Althea");
        System.out.println ("----------------------------------------");
        System.out.println("Press [ENTER] to see the Main Menu");

        while (true) {
            if (s.hasNextLine()) {
                mainMenu();
            }
        }
    }

    public static void mainMenu() {
        Scanner s = new Scanner(System.in);
        System.out.printf("%-40s%n", "\nPlease choose among the Java Programs");
        System.out.println("----------------------------------------");
        System.out.println("1. Determine if a number is a Perfect, Abundant, or Deficient Number\n" +
                "2. Income Tax Computation\n" +
                "3. Inserting an Element in an Array\n" +
                "4. Deleting an Element in an Array\n" +
                "5. Display the multiplication Table using 2D arrays\n" +
                "6. Remove all vowels in a word\n" +
                "7. Remove duplicate letters\n" +
                "8. Exit Program\n");
        System.out.println("----------------------------------------");
        System.out.print("Input the number corresponding to your choice: ");
        int choice = s.nextInt();
        // assign number base on user input
        switch (choice) {
            case 1: // Determine if a number is a Perfect, Abundant, or Deficient Number - FRANCIE
                System.out.println("----------------------------------------");
                System.out.println("Program: Determine if a number is a Perfect, Abundant, or Deficient Number");
                System.out.println("----------------------------------------");
                numberClassification();
                break;

            case 2: // Income Tax Computation - WILIAN
                System.out.println("----------------------------------------");
                System.out.println("Program: Income Tax Computation");
                System.out.println("----------------------------------------");
                taxIncome();
                break;

            case 3: // Inserting an Element in an Array - LOUELLA
                System.out.println("----------------------------------------");
                System.out.println("Program: Inserting an Element in an Array");
                System.out.println("----------------------------------------");
                insertingElement();
                break;

            case 4: // Deleting an Element in an Array - SEBASTIAN
                System.out.println("----------------------------------------");
                System.out.println("Program: Deleting an Element in an Array");
                System.out.println("----------------------------------------");
                terminateElement();
                break;

            case 5: // Display the multiplication Table using 2D arrays - CLIAN
                System.out.println("----------------------------------------");
                System.out.println("Program: Display the multiplication Table using 2D arrays");
                System.out.println("----------------------------------------");
                multiplicationTable();
                break;

            case 6: // Remove all vowels in a word - ALTHEA
                System.out.println("----------------------------------------");
                System.out.println("Program: Remove all vowels in a word");
                System.out.println("----------------------------------------");
                removeVowels();
                break;

            case 7: // Remove duplicate letters - WILIAN & SEBASTIAN
                System.out.println("----------------------------------------");
                System.out.println("Program: Remove duplicate letters");
                System.out.println("----------------------------------------");
                removeDuplicate();
                break;

            case 8: // Exit Program
                System.exit(0);

            default: // not within the parameters
                System.out.println("Not within the parameters... try again.\n");
        }
    }

    // 1. Determine if a number is a Perfect, Abundant, or Deficient Number - FRANCIE
    public static void numberClassification() {
        Scanner s = new Scanner(System.in);
        int number;
        do {
            System.out.print("Please enter a positive number: "); // 6
            while (!s.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer: ");
                s.next(); // consume the invalid input
            }
            number = s.nextInt();

            if (number <= 0) {
                System.out.println("Invalid input.");
            } else {
                String result = classifyNumber(number);
                System.out.println("Classification: " + result);
            }

        } while (number <= 0);
    }
    public static String classifyNumber(int num) {
        int sum = 1; // start with 1 as all numbers are divisible by 1
        for (int i = 2; i <= Math.sqrt(num); i++) { // i = 2;
            if (num % i == 0) { 
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        if (sum == num) {
            return "Perfect Number";
        } else if (sum > num) {
            return "Abundant Number";
        } else {
            return "Deficient Number";
        }
    }
    // 2. Income Tax Computation - WILIAN
    public static void taxIncome() {
        double i = 0;
        Scanner kbd = new Scanner(System.in);
        System.out.print("Please enter your income: ");
        double income = kbd.nextDouble();
        i = incomeTax(income);
        System.out.println("Your income tax amount is: " + i);
    }
    static double incomeTax(double income)
    {
        double tax;
        if (income<=250000) {
            tax = 0;
        }
        else if (income >= 250000 && income <= 400000) {
            tax = (0.2 * (income - 250000));
        }
        else if (income >= 400000 && income <= 800000) {
            tax = (0.25 * (income - 400000)) + 30000;
        }
        else if (income >= 800000 && income <= 2000000) {
            tax = (0.3 * (income - 800000)) + 1300000;
        }
        else if (income >= 2000000 && income <= 8000000) {
            tax = (0.32 * (income - 2000000)) + 490000;
        }
        else {
            tax = (0.35*(income - 8000000)) + 2410000;
        }
        return tax;
    }
    // 3. Inserting an Element in an Array - LOUELLA
    public static void insertingElement() {
        Scanner scan = new Scanner(System.in);

        Random r = new Random();
        int[] num = new int[10]; // 0 - 9
        int x;
        int index, insert;
        boolean outerBreak = false;

        // assigning random numbers
        for (int i = 0; i < num.length; i++) {
            num[i] = r.nextInt(100);
        }
        System.out.println("Array: " + Arrays.toString(num));

        do {
            // Get valid index input
            do {
                System.out.print("\nInput an index (0-9): "); // 5
                index = scan.nextInt();
                if (index < 0 || index >= 10) {
                    System.out.println("Invalid input, please try again.");
                }
            } while (index < 0 || index >= 10);

            // Get valid insert input
            do {
                System.out.print("\nEnter a number you want to insert (0-100): "); // 99
                insert = scan.nextInt();
                if (insert < 0 || insert > 100) {
                    System.out.println("Invalid input, please try again.");
                }
            } while (insert < 0 || insert > 100);

            // Insert the number at the specified index
            for (int i = index; i < num.length; i++) {
                x = num[i]; // index 5 = 82 \\ x = 82
                num[i] = insert; // index 5 = 99
                insert = x; // 99 = x
            }

            // Print the updated array
            System.out.println("New Array: " + Arrays.toString(num));

            do {
                System.out.print("\nDo you wish to insert another element? (Yes/No) ");
                char exit = scan.next().charAt(0);
                if (exit == 'y' || exit == 'Y') {
                    break;
                }
                else if (exit == 'n' || exit == 'N') {
                    outerBreak = true;
                    break;
                }
                else {
                    System.out.println("Invalid response ");
                }
            } while (true); // confirmation loop
        } while (!outerBreak);
    }

    // 4. Deleting an Element in an Array - SEBASTIAN
    static void terminateElement() {
        Scanner inp = new Scanner(System.in);
        int userNum;
        boolean found;
        boolean outerBreak = false;
        int[] array = {10, 50, 41, 28, 9, 6, 1, 20, 35, 15};
        System.out.println("Array: " + Arrays.toString(array));
        do {
            if (outerBreak)
                break;
            do {
                System.out.print("Input a number you want to delete (0-50): ");
                userNum = inp.nextInt(); //50
                found = false;
                System.out.println();
                //linear search
                //if number is found
                for (int i = 0; i < array.length; i++)
                    if (userNum == array[i]) {
                        System.out.println("Found the element... deleting");
                        //shift elements back
                        for (int j = i; j < array.length-1; j++) {
                            array[j] = array[j+1];
                        }
                        array[9] = 0;
                        found = true;
                        break;
                    }
                // if number is not found, back to user input
                if (!found)
                    System.out.println("Number not found... try again.");
            } while (!found); //user input loop

            // display array
            System.out.println("Array: " + Arrays.toString(array) + "\n");
            do {
                System.out.print("Do you wish to delete another element? (Yes/No) ");
                char exit = inp.next().charAt(0);
                if (exit == 'y' || exit == 'Y') {
                    break;
                }
                else if (exit == 'n' || exit == 'N') {
                    outerBreak = true;
                    break;
                }
                else {
                    System.out.println("Invalid response.");
                }
            } while (true); //confirmation loop
        } while (true); //main loop
    }

    // 5. Display the multiplication Table using 2D arrays - CLIAN
    public static void multiplicationTable() {
        int[][] table = new int[10][10]; // ten rows for numbers 1-10 and 10 columns for their multiples

        // nested for-loop that assigns the multiples of each number into the 2d array
        for (int column = 0; column < 10; column++){
            for(int row = 0; row < 10; row++){
                table[column][row] = (row+1)*(column+1); // +1 because the initial value starts at 0
            }
        }

        // nested for-loop that prints out the multiples of each number in each row
        for (int column = 0; column < 10; column++){
            System.out.println("\nMultiples of " + (column+1) + ": ");
            for(int row = 0; row < 10; row++){
                System.out.print(table[row][column] + " "); // prints out the multiples of each row
            }
            System.out.println(); // prints an empty line after each iteration of the outer loop
        }
    }

    // 6. Remove all vowels in a word - ALTHEA
    public static void removeVowels() {
        Scanner kbd = new Scanner(System.in);

        // empty string where the modified word will be stored later
        String nv="";

        // contains all the vowels (upper and lower case)
        String vowel= "aeiouAEIOU";

        System.out.print("Enter a string: ");
        String word= kbd.next(); // althea
                                //  012345

        // iterates through each letter in the word entered
        for (int i=0;i< word.length();i++) { // 5

            // checks if the current letter at index i in the word entered is not a vowel
            // the "indexOf" method checks if the letter exists in the vowel string (if not found then it is not a vowel)
            if( vowel.indexOf(word.charAt(i)) ==-1){ // 0
                nv+=word.charAt(i);  // if the character is not a vowel, that character goes to the string nv
            }
        }

        System.out.print("String with removed vowels: ");
        System.out.print(nv);           // prints out modified word
        System.out.println();
    }

    // 7. Remove duplicate letters - WILIAN & SEBASTIAN
    public static void removeDuplicate() {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int idx;

        System.out.print("Please enter a string: ");
        String str = s.nextLine(); // uwu


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // u, w, u
            idx = str.indexOf(c, i + 1); // u, w, u
            if (idx == -1) {
                sb.append(c);
            }
        }
        System.out.println("\nString with removed duplicates: " + sb.toString());
    }
} // main method
