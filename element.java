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

    final String DUMMY_ELEMENT = "";
    //This whole block is useless as the index of elements is meaningful, changing indexes messes everything up ;-;
    // private String[][] main_body = new String[86][2]; //Store Elements from TABLE with postitive column numbers
    private String[][] f_block = new String[30][2]; //Store elements from TABLE with negitive column numbers
    Boolean fblockdraw; //boolean weather to print f block or not
    int[] bounds = new int[2]; //array for storing upper and lower bounds of elements to print

    public element(){ // all interface stuff goes in here
        user_lowerbounds = (question)
        user_upperbounds = (question2)

        user_fblock_result = (question3)

        if fblockdraw == "y"{
            fblockdraw = true;
        } 

        else{ 
            fblockdraw = false;
        }

        if (upperbounds <= 0){ //if 0 for upper bounds assume and print whole thing with assuming message
            upperbounds = 118
        }

        if (lowerbounds > upperbounds){
            bad
        }
    }

    public void displayMainBlock(){ //I dont like that this "display" method is also in charge of loading the fblock

        int atomic_number = 1;
        String formatted_element; 
        int needed_column; //column number for each element in the array
        int current_column = 1;
        int f_block_index = 0;

        for (String[] unformatted_element: TABLE ){

            needed_column = Integer.parseInt(unformatted_element[1]);  //the array element at index 1 is a string, so convert to integer by parsing
            //current_column %= COLUMNS;  //Alexa may discard

            if ((needed_column < current_column) & (needed_column > 0)){  //if current column is over the needed column, go to the next line, unless needed column is neg
                System.out.println();
                current_column = 1; //when going to next line reset current colom to 1
            }

            while ((needed_column > current_column) & (needed_column > 0)) { //handling gaps in the periodic table, prints dummy elements if a gap is needed
                System.out.printf("%8s", DUMMY_ELEMENT); //% is escape, 8 characters, looking for string s, put in a dummy element which is an empty string; printf allows formatting
                current_column++;
            }

            if (needed_column <= 0){ //If element is in the fblock, dont print and just store it for later
                f_block[f_block_index] = unformatted_element[0], atomic_number;
                f_block_index++;
            }

            else{ //could use elseif with bounds to print only whats needed
                formatted_element = atomic_number + " " + unformatted_element[0] + " ";  //formatting for the element inside the cell
                System.out.printf("%8s", formatted_element);  //printing the element; ensuring 8 wide inside each cell
                current_column++;
            }
            
            atomic_number++;
        }

        if (fblockdraw == true){
            displayFBlock();
        }
    }

    public void displayFBlock(){ //display the fblock of the table, needs to be done after display main block which feels a bit bad, it is working though

        int current_column = 1;
        final int STARTING_COLUMNS = 3; //column to start printing from
        final int ENDING_COLUMNS = 17; //column to stop printing at

        System.out.println();
        System.out.println();

        for (String formatted_element: f_block){
        
            if (current_column > ENDING_COLUMNS){ //print new line when at end of allowed space
                System.out.println();
                current_column = 1;
            }
        
            while (current_column < STARTING_COLUMNS){ //print dummy element when before print area
                System.out.printf("%8s", DUMMY_ELEMENT);
                current_column++;
            }
            if (formatted_element[1] within bounds)
            System.out.printf("%8s", formatted_element);
            current_column++;
        }
    }
}
