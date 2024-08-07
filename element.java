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

    private String[][] main_body = new String[86][2]; //Store Elements from TABLE with postitive column numbers
    private String[][] f_block = new String[30][2]; //Store elements from TABLE with negitive column numbers
    
    public void seperate_blocks(){ // this way of doing it breaks the attomic number tracking ARGGG!!! how annoying, >:C
        //Method for seperating the elements in TABLE with negitive numbers and postitive numbers
        // seems to work as intended
        int f_block_index = 0; //These keep track of where to put the numbers
        int main_body_index = 0;

        for (String[] element: TABLE){ 

            if (Integer.parseInt(element[1]) <= 0){
                f_block[f_block_index] = element;
                f_block_index++;
            }  

            else{
                main_body[main_body_index] = element;
                main_body_index++;
            }
        }
    }

    // width of elements is 7, there are 18 coloms and 9 rows
    // that means the table will be 7 x 18 = 126 spaces long, with a space between each making it 7 x 18 + 16 = 142 wide, or 158 with double spacing between elements 
    public void display(){

        int atomic_weight = 1;
        String element;
        int needed_column; //column number for each element in the array
        int current_column = 1;
        final String DUMMY_ELEMENT = "";
        final int COLUMNS = 18;

        for (String[] elm: main_body ){
            
            needed_column = Integer.parseInt(elm[1]);  //the array element at index 1 is a string, so convert to integer by parsing
            //current_column %= COLUMNS;  //Alexa may discard

            while ((needed_column > current_column) & (current_column != COLUMNS)) { //handling gaps in the periodic table
                System.out.printf("%8s", DUMMY_ELEMENT); //% is escape, 8 characters, looking for string s, put in a dummy element which is an empty string; printf allows formatting
                current_column++;
            }

            element = atomic_weight + " " + elm[0] + " ";  //formatting for the element inside the cell
        
            System.out.printf("%8s", element);  //printing the element; ensuring 8 wide inside each cell
            current_column++;

            if (current_column >= COLUMNS){  //if current colom is at or past the max number of coloms go to the next line
                System.out.println();
                current_column = 1; //when going to next line reset current colom to 1
            }
            atomic_weight++;
        }
    }


}
