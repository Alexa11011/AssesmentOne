/**
 * KIT107 Assignment 1
 *
 * Periodic Table Printer
 *
 * PeriodicTable.java
 * 
 * @author Alexa McKone (702978) & Ellie Bedells (470967)
 * @version 20/7/2024
 * 
 * Purpose:  To print a range of elements belonging to the main group and/or f-block 
 * of the Periodic Table as specified by the user.
 * 
 * Percentage of work completed by authors:  50:50.
 */

import java.util.Scanner;

public class PeriodicTable implements PeriodicTableInterface {

    private final static String[][] TABLE = { 
            { "H", "1" }, { "He", "18" }, { "Li", "1" }, { "Be", "2" },
            { "B", "13" }, { "C", "14" }, { "N", "15" }, { "O", "16" }, { "F", "17" },
            { "Ne", "18" }, { "Na", "1" }, { "Mg", "2" }, { "Al", "13" }, { "Si", "14" }, { "P", "15" }, { "S", "16" },
            { "Cl", "17" }, { "Ar", "18" }, { "K", "1" }, { "Ca", "2" },
            { "Sc", "3" }, { "Ti", "4" }, { "V", "5" }, { "Cr", "6" }, { "Mn", "7" }, { "Fe", "8" }, { "Co", "9" },
            { "Ni", "10" }, { "Cu", "11" }, { "Zn", "12" }, { "Ga", "13" },
            { "Ge", "14" }, { "As", "15" }, { "Se", "16" }, { "Br", "17" }, { "Kr", "18" }, { "Rb", "1" },
            { "Sr", "2" }, { "Y", "3" }, { "Zr", "4" }, { "Nb", "5" }, { "Mo", "6" },
            { "Tc", "7" }, { "Ru", "8" }, { "Rh", "9" }, { "Pd", "10" }, { "Ag", "11" }, { "Cd", "12" }, { "In", "13" },
            { "Sn", "14" }, { "Sb", "15" }, { "Te", "16" },
            { "I", "17" }, { "Xe", "18" }, { "Cs", "1" }, { "Ba", "2" }, { "La", "-11" }, { "Ce", "-12" },
            { "Pr", "-13" }, { "Nd", "-14" }, { "Pm", "-15" }, { "Sm", "-16" },
            { "Eu", "-17" }, { "Gd", "-18" }, { "Tb", "-19" }, { "Dy", "-20" }, { "Ho", "-21" }, { "Er", "-22" },
            { "Tm", "-23" }, { "Yb", "-24" }, { "Lu", "-25" },
            { "Hf", "4" }, { "Ta", "5" }, { "W", "6" }, { "Re", "7" }, { "Os", "8" }, { "Ir", "9" }, { "Pt", "10" },
            { "Au", "11" }, { "Hg", "12" }, { "Tl", "13" }, { "Pb", "14" },
            { "Bi", "15" }, { "Po", "16" }, { "At", "17" }, { "Rn", "18" }, { "Fr", "1" }, { "Ra", "2" },
            { "Ac", "-31" }, { "Th", "-32" }, { "Pa", "-33" }, { "U", "-34" },
            { "Np", "-35" }, { "Pu", "-36" }, { "Am", "-37" }, { "Cm", "-38" }, { "Bk", "-39" }, { "Cf", "-40" },
            { "Es", "-41" }, { "Fm", "-42" }, { "Md", "-43" },
            { "No", "-44" }, { "Lr", "-45" }, { "Rf", "4" }, { "Db", "5" }, { "Sg", "6" }, { "Bh", "7" }, { "Hs", "8" },
            { "Mt", "9" }, { "Ds", "10" }, { "Rg", "11" },
            { "Cn", "12" }, { "Uut", "13" }, { "Fl", "14" }, { "Uup", "15" }, { "Lv", "16" }, { "Uus", "17" },
            { "Uuo", "18" } };


    final String DUMMY_ELEMENT = ""; // Empty string for printing in required gaps in the periodic table
    private String[][] fBlock = new String[30][2]; // Array for storing f-block elements from TABLE array
    boolean fBlockDraw = true; // Boolean variable for whether to print the f-block or not
    int[] bounds = { 0, 118 }; // Array for storing upper and lower bounds of elements to print


    public void unit_test() { // Unit test for user inputs

        final int UPPERBOUNDS = 118; // Upperbounds of elements to generate to test with
        int[][] combos = new int[(UPPERBOUNDS + 1) * (UPPERBOUNDS)][3]; // Array to store superset of user inputable values
        int index = 0; // Index to track where to place test inputs in combos array

        // Generates the superset of possibilities
        for (int i = 0; i <= UPPERBOUNDS; i++) { // For loop for lower bounds

            for (int j = i + 1; j <= UPPERBOUNDS; j++) { // For loop for upper bounds

                for (int k = 0; k <= 1; k++) { // For loop for f block draw boolean

                    combos[index][0] = i;
                    combos[index][1] = j;
                    combos[index][2] = k;

                    index ++;
                }
            }
        }

        for (int i = 0; i < combos.length; i++) { // Use the superset

            System.out.printf("[%d, %d, %d]%n", combos[i][0], combos[i][1], combos[i][2]); // Print every element of the combos array
            
              bounds[0] = combos[i][0];
              bounds[1] = combos[i][1];

              if (combos[i][2] == 0) {
              fBlockDraw = false;
              }
              else{
              fBlockDraw = true;
              }

              printTables(); // Test printing tables with every element of combos array
              printGroups();
              
              System.out.println();
             
        }
        System.out.println(combos.length);
    }

    public PeriodicTable() {

        Scanner scanner = new Scanner(System.in); // Scanner class object for receiving input
        char userFBlockResult; // User's decision for whether to print the f-block or not
        int userLowerBounds; // First atomic number entered by the user
        int userUpperBounds; // Second atomic number entered the user

        System.out.println("Periodic Table Printer");
        System.out.println();

        try {
            // Obtaining from the user whether they want the f-block printed
            System.out.println("Print the Lanthanum/Actinium groups if necessary [Y/N]: ");
            userFBlockResult = scanner.nextLine().charAt(0);

            if (userFBlockResult == 'y' || userFBlockResult == 'Y') {
                fBlockDraw = true;
            }

            else if (userFBlockResult == 'n' || userFBlockResult == 'N') {
                fBlockDraw = false;
            }

            else {
                fBlockDraw = false;
                System.out.println("...N assumed...");
            }

        } catch (Exception e) {
            fBlockDraw = false;
            System.out.println("...N assumed...");
        }

        try { // Try catch for user input for lower bounds
            System.out.println("Enter number of first element to print: ");
            userLowerBounds = scanner.nextInt();

            if (userLowerBounds <= 0 || userLowerBounds > 118) {
                userLowerBounds = 1;
                System.out.println("...1 assumed...");
            }
        } catch (Exception e) {
            userLowerBounds = 1;
            System.out.println("...1 assumed...");
        }
        
        try { // Try catch for user input for upper bounds
            System.out.println("Enter number of last element to print: ");
            userUpperBounds = scanner.nextInt();

            if (userUpperBounds <= 0 || userUpperBounds > 118 || userUpperBounds < userLowerBounds) {
                userUpperBounds = 118;
                System.out.println("...118 assumed...");
            }
        } catch (Exception e) {
            userUpperBounds = 118;
            System.out.println("...118 assumed...");
        }

        scanner.close();

        // Assigns the upper and lower bounds entered by the user to the "bounds" array
        bounds[0] = userLowerBounds;
        bounds[1] = userUpperBounds;
    }

    public void printTables() {

        int atomicNumber = 1; // The atomic number for each each element starting at 1
        String formattedElement; // Formatted string for displaying an element
        int neededColumn; // Column number for each element that needs to be printed
        int currentColumn = 1; // For incrementing the current column
        int fBlockIndex = 0; // For incrementing the index for each f-block element

        // Controls what to print at each position in the main block
        for (String[] unformattedElement: TABLE) {

            neededColumn = Integer.parseInt(unformattedElement[1]); // Converts array element at index 1 from a string to an integer

            // Goes to the next line if current column has gone past the needed column
            if ((neededColumn < currentColumn) & (neededColumn > 0)) { 
                System.out.println();  
                currentColumn = 1; // Reset current column to 1 when going to the new line
            }

            // Prints a gap in the table where no element is to be printed
            while ((neededColumn > currentColumn) & (neededColumn > 0)) { 
                System.out.printf("%8s", DUMMY_ELEMENT); 
                currentColumn ++;  
            }

            // If element is in the f-block, doesn't print and just stores it for later in an array
            if (neededColumn < 0) { 
                fBlock[fBlockIndex][0] = unformattedElement[0]; 
                fBlock[fBlockIndex][1] = String.valueOf(atomicNumber);
                fBlockIndex ++; 
            }

            // If element is in the main block, and within bounds set by user, prints it in a cell 8 characters wide
            else if ((atomicNumber >= bounds[0]) & (atomicNumber <= bounds[1])) { 
                formattedElement = atomicNumber + " " + unformattedElement[0] + " "; // Cell format for element
                System.out.printf("%8s", formattedElement); 
                currentColumn ++; 
            }

            // If element is outside of bounds set by user, prints a gap 8 characters wide in the table
            else {
                System.out.printf("%8s", DUMMY_ELEMENT); 
                currentColumn ++; 
            }

            atomicNumber ++; 
        }
        System.out.println();
    }

    // Method for printing the f-block if the user has requested it
    public void printGroups() { 

        final int STARTING_COLUMN = 3; // Column to start printing from
        final int ENDING_COLUMN = 17; // Column to stop printing at
        int currentColumn = 1; // Current column set at 1 to allow printing of initial gaps  
        String formattedElement = ""; // Formatted string for printing the element
        int atomicNumber; // Atomic number for each f-block element

        // Controls printing of f-block if user has selected to print it
        if (fBlockDraw == true) {

            System.out.println();

            for (String[] unformattedElement : fBlock) {

                atomicNumber = Integer.parseInt(unformattedElement[1]); // Attomic number of current element in array

                // Goes to the next line if current column has gone past the last column
                if (currentColumn > ENDING_COLUMN) { 
                    System.out.println();
                    currentColumn = 1; // Reset current column to 1 when going to the new line
                }
                // Prints a gap 8 characters wide before the print area starts
                while (currentColumn < STARTING_COLUMN) { 
                    System.out.printf("%8s", DUMMY_ELEMENT);
                    currentColumn ++; 
                }
                // Prints the element if it falls within the range set by the user
                if ((atomicNumber >= bounds[0]) & (atomicNumber <= bounds[1])) {
                    formattedElement = unformattedElement[0] + " " + unformattedElement[1] + " "; // Formatting the element string
                    System.out.printf("%8s", formattedElement); // Prints element in a cell 8 characters wide
                    currentColumn ++; 
                }
                // If element outside of range set by user, print gap
                else {
                    System.out.printf("%8s", DUMMY_ELEMENT);
                    currentColumn ++; 
                }
            }

            System.out.println();
        }
    }
}
