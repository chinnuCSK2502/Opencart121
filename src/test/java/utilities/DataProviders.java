package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Taking the Excel file from the testData folder
        String path = ".\\testData\\opencart_LoginData.xlsx";

        // Creating an object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        // Getting the total number of rows and columns
        int totalrows = xlutil.getRowCount("Sheet1");
        System.out.println("Total rows returned: " + totalrows);
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Creating a two-dimensional array to store the login data
        String logindata[][] = new String[totalrows][totalcols];

        // Reading data from Excel and storing it in the two-dimensional array
        // Starting from row index 1 to skip the header row
        for (int i = 1; i <= totalrows; i++) {

            // Loop through each column
            for (int j = 0; j < totalcols; j++) {

                // Reading Excel cell data and storing it in the array
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        // Returning the two-dimensional array
        return logindata;
    }
}


