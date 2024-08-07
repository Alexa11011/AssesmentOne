import java.util.Scanner;

public class element {
    
    protected final static String TABLE[][]={{"H","1"},{"He","18"},{"Li","1"},{"Be","2"},{"B","13"},{"C","14"},{"N","15"},{"O","16"},{"F","17"},
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
//test

    // width of elements is 7, there are 18 coloms and 9 rows
    // that means the table will be 7 x 18 = 126 spaces long, with a space between each making it 7 x 18 + 16 = 142 wide, or 158 with double spacing between elements 
    public static void display(){

        int atomic_weight = 1;
        String element;
        int needed_column; 
        int current_column = 1;
        final String DUMMY_ELEMENT = "";
        final int COLUMNS = 18;

        for (String[] elm: TABLE ){
            
            needed_column = Integer.parseInt(elm[1]);
            current_column %= COLUMNS;

            while ((needed_column > current_column) & (current_column != COLUMNS)) {
                System.out.printf("%8s", DUMMY_ELEMENT);
                current_column++;
            }

            element = atomic_weight + " " + elm[0] + " ";
        
            System.out.printf("%8s", element);
            
            if (current_column % COLUMNS == 0){
                System.out.println();
                current_column++;
            }
            current_column++;
            atomic_weight++;
        }
    }


}
