package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviderDP
{
	@DataProvider(name="testAddProjectAddCancelBtn",indices= {0})
	public String[][] getData() throws IOException {
	    String path = System.getProperty("user.dir")+"\\TestData\\AddprojectData.xlsx"; //taking Excel file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility and passing the path of the excel file

	    int totalrows = xlutil.getRowCount("Sheet1"); //it will return value starting from index 0
	    int totalcols = xlutil.getCellCount("Sheet1", 0); //it will return value starts from 0ne
	    String Addprojectdata[][] = new String[totalrows][totalcols]; //created for two dimension array which can store, doesn't need the header row of excel file

	    for (int i = 1; i <= totalrows; i++) { //read the data from xl storing in two dimensional array
	        for (int j = 0; j < totalcols; j++) {
	            Addprojectdata[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
	            //array   							excel file
	        }
	    }

	    return Addprojectdata; //returning two dimension array
	}
	@DataProvider(name="testAddProjectNegativedata")
	public String[][] getNegativeData() throws IOException {
	    String path = System.getProperty("user.dir")+"\\TestData\\NegativeDataAddproject.xlsx"; 
	    
	    ExcelUtility xlutil = new ExcelUtility(path); 

	    int totalrows = xlutil.getRowCount("Sheet1"); 
	    int totalcols = xlutil.getCellCount("Sheet1", 0); 
	    String Addprojectdata[][] = new String[totalrows][totalcols]; 
	    for (int i = 1; i <= totalrows; i++) { 
	        for (int j = 0; j < totalcols; j++) {
	            Addprojectdata[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
	            						
	        }
	    }

	    return Addprojectdata; 
	}


}
