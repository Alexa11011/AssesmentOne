/**
 * KIT107 Assignment 1
 *
 * Periodic Table Printer
 *
 * @author J. Dermoudy
 * @version 30/7/2024
 * 
 * This file is COMPLETE.
 * 
 */

import java.util.Scanner;

public class AssigOne224
{
    /**
     * main() -- entry point
     *
     * @param args -- command line arguments
     */
    public static void main(String args[])
    {
        // PeriodicTable p;
    
        // // create PeriodicTable object
        // p=new PeriodicTable();
        
        System.out.println("\t\t\t\t\t\t\t\t Periodic Table");
        System.out.println("\t\t\t\t\t\t\t\t ==============");
        // // show (portion of) periodic table
        // p.printTables();
        // p.printGroups();

        element e = new element();

        int[] bounds = {0, 118, 1}; //basicly test paramaters, in order they are lower bounds, upper bounds and weather to include f block, 1 for yes

        e.displayMainBlock(bounds);
        e.test_code(); // this is a method that makes every permutation between [0-118, 0-118, 0-1] which is about 27k periodic tables haha
        


    }
}