/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brett
 */

import java.util.Scanner;
public class Tax {
    public static void main(String[] args)
    {
    
        // declare variables
        int customerID;
        double totalEarnings = 0.0;
        double federalTaxesWH = 0.0;
        double stateTaxWH = 0.0;
        double deductions = 0.0;
        double taxableIncome = 0.0;
        double federalTax = 0.0;
        double stateRefund = 0.0;
        double stateTax = 0.0;
        double federalRefund = 0.0;

        // Create a Scanner input object
        Scanner input = new Scanner(System.in);

        //Create Output String
        String outputString = new String();
        outputString ="Cust.                   Taxable Federal State Federal State Federal State\n" +
                      " ID   Income Deductions Income    Tax    Tax    W/H    W/H  Refund  Refund\n" +
                      "===== ====== ========== ======= ======= ===== ======= ===== ======= ======\n";

        
        // Begin first customer

        // Get first Customer ID
        System.out.print("Enter the first Customer ID: ");
        customerID = input.nextInt();

        while(customerID != -1)
        {
            // Get income and withholding information
            System.out.print("Enter the total earnings: ");
            totalEarnings = input.nextDouble();
            
            System.out.print("Enter the deductions: ");
            deductions = input.nextDouble();
            
            System.out.print("Enter the federal withholdings: ");
            federalTaxesWH = input.nextDouble();
            
            System.out.print("Enter the state withholdings: ");
            stateTaxWH = input.nextDouble();
            
            // Calculate taxes due/refunds
            taxableIncome = totalEarnings - deductions;
            
            if (taxableIncome <= 10000.0)
            {
                federalTax = 0.0;
            }
            else
            {
                if(taxableIncome <= 20000.0)
                {
                    federalTax = 0.15 * (taxableIncome - 10000.0);
                }
                else
                {
                    if(taxableIncome <= 40000.0)
                    {
                        federalTax = 0.2 * (taxableIncome - 20000.0) + 0.15 * 10000.0;
                    }
                    else
                    {
                        if(taxableIncome > 40000.0)
                        {
                            federalTax = 0.3 * (taxableIncome - 40000.0) + (0.2 * 20000.0) + (0.15 * 10000);
                        }
                    }
                }
            }

            //Calculate state tax
            
            stateTax = federalTax * 0.07;
            
            //Calculate Refunds
            
            federalRefund = federalTaxesWH - federalTax;
            stateRefund = stateTaxWH - stateTax;
            
            // Add data to output String
            outputString += String.format("%4d  $%5.0f   $%4.0f    $%5.0f  $%5.0f  $%3.0f  $%5.0f  $%4.0f  $%4.0f   $%3.0f\n", customerID, totalEarnings, deductions, taxableIncome, federalTax, stateTax, federalTaxesWH, stateTaxWH, federalRefund, stateRefund);


            // Get next Customer ID
            System.out.print("Enter the next customer ID: ");
            customerID = input.nextInt();
        }

        // Print out table of data and end program
        System.out.println(outputString);

   }
}
