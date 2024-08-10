import java.util.Scanner;

public class element {
    
    protected final static String[][] TABLE={{"H","1"},{"He","18"},{"Li","1"},{"Be","2"},{"B","13"},{"C","14"},{"N","15"},{"O","16"},{"F","17"},
    {"Ne","18"},{"Na","1"},{"Mg","2"},{"Al","13"},{"Si","14"},{"P","15"},{"S","16"},{"Cl","17"},{"Ar","18"},{"K","1"},{"Ca","2"},
    {"Sc","3"},{"Ti","4"},{"V","5"},{"Cr","6"},{"Mn","7"},{"Fe","8"},{"Co","9"},{"Ni","10"},{"Cu","11"},{"Zn","12"},{"Ga","13"},
    {"Ge","14"},{"As","15"},{"Se","16"},{"Br","17"},{"Kr","18"},{"Rb","1"},{"Sr","2"},{"Y","3"},{"Zr","4"},{"Nb","5"},{"Mo","6"},
    {"Tc","7"},{"Ru","8"},{"Rh","9"},{"Pd","10"},{"Ag","11"},{"Cd","12"},{"In","13"},{"Sn","14"},{"Sb","15"},{"Te","16"},
    {"I","17"},{"Xe","18"},{"Cs","1"},{"Ba","2"},{"La","-11"},{"Ce","-12"},{"Pr","-13"},{"Nd","-14"},{"Pm","-15"},{"Sm","-16"},
    {"Eu","-17"},{"Gd","-18"},{"Tb","-19"},{"Dy","-20"},{"Ho","-21"},{"Er","-22"},{"Tm","-23"},{"Yb","-24"},{"Lu","-25"},
    {"Hf","4"},{"Ta","5"},{"W","6"},{"Re","7"},{"Os","8"},{"Ir","9"},{"Pt","10"},{"Au","11"},{"Hg","12"},{"Tl","13"},{"Pb","14"},
    {"Bi","15"},{"Po","16"},{"At","17"},{"Rn","18"},{"Fr","1"},{"Ra","2"},{"Ac","-31"},{"Th","-32"},{"Pa","-33"},{"U","-34"},
    {"Np","-35"},{"Pu","-36"},{"Am","-37"},{"Cm","-38"},{"Bk","-39"},{"Cf","-40"},{"Es","-41"},{"Fm","-42"},{"Md","-43"},
    {"No","-44"},{"Lr","-45"},{"Rf","4"},{"Db","5"},{"Sg","6"},{"Bh","7"},{"Hs","8"},{"Mt","9"},{"Ds","10"},{"Rg","11"},
    {"Cn","12"},{"Uut","13"},{"Fl","14"},{"Uup","15"},{"Lv","16"},{"Uus","17"},{"Uuo","18"}};

    final String DUMMY_ELEMENT = "x";
    private String[][] fBlock = new String[30][2]; //Store elements from TABLE with negitive column numbers
    int fBlockDraw = 1; //boolean weather to print f block or not
    int[] bounds = {0, 118, fBlockDraw} ; //array for storing upper and lower bounds of elements to print, has final keywork for testing

    public void test_code(){ //this paramater generates every possible set of paramaters and tests the funtion with them, useful for finding issues
        final int UPPERBOUNDS = 118;
        int[][] combos = new int[(UPPERBOUNDS + 1) * (UPPERBOUNDS + 1) * 2][3];
        int index = 0;

        for (int i = 0; i <= UPPERBOUNDS; i++){ //Generate the superset

            for (int j = 0; j <= UPPERBOUNDS; j++){

                for (int k = 0; k <= 1; k++){
                    
                    if (i < j){
                        combos[index][0] = i;
                        combos[index][1] = j;
                        combos[index][2] = k; 
                    }
                    index++;
                }

            }
        }

        for (int i = 0; i < combos.length; i++) { // use the superset

            System.out.printf("[%d, %d, %d]%n", combos[i][0], combos[i][1], combos[i][2]);
            bounds[0] = combos[i][0];
            bounds[1] = combos[i][1];
            bounds[2] = combos[i][2];
            displayMainBlock();

            System.out.println();
        }

    }


    public element(){ // all interface stuff goes in here
        
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


    public void displayMainBlock(){

        int atomicNumber = 1;
        String formattedElement; 
        int neededColumn; //column number for each element in the array
        int currentColumn = 1;
        int fBlockIndex = 0;

        for (String[] unformattedElement: TABLE ){

            neededColumn = Integer.parseInt(unformattedElement[1]);  //the array element at index 1 is a string, so convert to integer by parsing
            //current_column %= COLUMNS;  //Alexa may discard

            if ((neededColumn < currentColumn) & (neededColumn > 0)){  //if current column is over the needed column, go to the next line, unless needed column is neg
                System.out.println();
                currentColumn = 1; //when going to next line reset current colom to 1
            }

            while ((neededColumn > currentColumn) & (neededColumn > 0)) { //handling gaps in the periodic table, prints dummy elements if a gap is needed
                System.out.printf("%8s", DUMMY_ELEMENT); //% is escape, 8 characters, looking for string s, put in a dummy element which is an empty string; printf allows formatting
                currentColumn++;
            }

            if (neededColumn <= 0){ //If element is in the fblock, dont print and just store it for later
                fBlock[fBlockIndex][0] = unformattedElement[0];
                fBlock[fBlockIndex][1] = String.valueOf(atomicNumber);
                fBlockIndex++; 
            }

            else if ((atomicNumber >= bounds[0]) & (atomicNumber <= bounds[1] )) { //could use elseif with bounds to print only whats needed
                formattedElement = atomicNumber + " " + unformattedElement[0] + " ";  //formatting for the element inside the cell
                System.out.printf("%8s", formattedElement);  //printing the element; ensuring 8 wide inside each cell
                currentColumn++;
            }

            else{
                System.out.printf("%8s", DUMMY_ELEMENT); //% is escape, 8 characters, looking for string s, put in a dummy element which is an empty string; printf allows formatting
                currentColumn++;
            }
            
            atomicNumber++;
        }

         if (bounds[2] == 1){
             displayFBlock();
        }
    }

    public void displayFBlock(){ //display the fblock of the table, needs to be done after display main block which feels a bit bad, it is working though

        final int STARTING_COLUMNS = 3; //column to start printing from
        final int ENDING_COLUMNS = 17; //column to stop printing at
        int currentColumn = 1;
        String formattedElement = "";
        int atomicNumber;

        System.out.println();
        System.out.println();

        for (String[] unformattedElement: fBlock){

            atomicNumber = Integer.parseInt(unformattedElement[1]);
        
            if (currentColumn > ENDING_COLUMNS){ //print new line when at end of allowed space
                System.out.println();
                currentColumn = 1;
            }
        
            while (currentColumn < STARTING_COLUMNS){ //print dummy element when before print area
                System.out.printf("%8s", DUMMY_ELEMENT);
                currentColumn++;
            }
            if ((atomicNumber >= bounds[0]) & ( atomicNumber <= bounds[1])){
                formattedElement = unformattedElement[0] + " " + unformattedElement[1] + " ";
                System.out.printf("%8s", formattedElement);
                currentColumn++;
            }

            else {
                System.out.printf("%8s", DUMMY_ELEMENT);
                currentColumn++;
            }
        }
    }
}
