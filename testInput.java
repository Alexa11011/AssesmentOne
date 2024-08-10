import java.util.Scanner;

public class testInput {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in); //new Scanner class object
        char userFBlockResult; //input for whether the user wants to print the f-block
        boolean fBlockDraw; // true or false depending on whether the f-block is to be printed
        int userLowerBounds; // first atomic number entered
        int userUpperBounds; // second atomic number entered

        System.out.println("Periodic Table Printer");
        System.out.println("");

        System.out.println("Print the Lanthanum/Actinium groups if necessary [Y/N]: ");
        userFBlockResult = sc.nextLine().charAt(0);

        if (userFBlockResult == 'y' || userFBlockResult == 'Y') {                 
            fBlockDraw = true;
        }
        
        else {
            if (userFBlockResult == 'n' || userFBlockResult == 'N') {
                fBlockDraw = false;
            }        
            else {
                fBlockDraw = false;
                System.out.println("...N assumed...");
            }          
        }
        
        System.out.println("Enter number of first element to print: ");
        userLowerBounds = sc.nextInt();

        if (userLowerBounds <= 0 || userLowerBounds > 118) {
            userLowerBounds = 1;
            System.out.println("...1 assumed...");
        }

        System.out.println("Enter number of last element to print: ");
        userUpperBounds = sc.nextInt();

        if (userUpperBounds <= 0 || userUpperBounds > 118) {
            userUpperBounds = 118;
            System.out.println("...118 assumed...");
        }

        if (userLowerBounds > userUpperBounds) {
            userLowerBounds = 1;
            userUpperBounds = 118;
            System.out.println("...1 to 118 assumed...");
        }
    }


}
