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
        PeriodicTable p;
    
        // Create PeriodicTable object
        p = new PeriodicTable();
        
        System.out.println("\t\t\t\t\t\t\t\t Periodic Table");
        System.out.println("\t\t\t\t\t\t\t\t ==============");

        // Show (portion of) periodic table
        p.printTables();
        p.printGroups();

        //p.unit_test(); // A testing method that makes every permutation between [0-118, 0-118, 0-1] which is about 14k periodic tables to test with
        


    }
}