package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataproviderAddMentor {
	
	@DataProvider(name="testAddMentorValid",indices= {0})
	public String[][] getData() throws IOException {
	    String path = System.getProperty("user.dir")+"\\TestData\\AddMentorTestData.xlsx"; //taking Excel file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility and passing the path of the excel file

	    int totalrows = xlutil.getRowCount("Sheet1"); //it will return value starting from index 0
	    int totalcols = xlutil.getCellCount("Sheet1", 0); //it will return value starts from 0ne
	    String AddMentorData[][] = new String[totalrows][totalcols]; //created for two dimension array which can store, doesn't need the header row of excel file

	    for (int i = 1; i <= totalrows; i++) { //read the data from xl storing in two dimensional array
	        for (int j = 0; j < totalcols; j++) {
	            AddMentorData[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
	            //array   							excel file
	        }
	    }

	    return AddMentorData; //returning two dimension array
	}
	
	@DataProvider(name="testAddMentorInValid")
	public String[][] getinvalidData() throws IOException {
	    String path = System.getProperty("user.dir")+"\\TestData\\AddMentorTestData.xlsx"; 

	    ExcelUtility xlutil = new ExcelUtility(path); 

	    int totalrows = xlutil.getRowCount("Sheet1"); 
	    int totalcols = xlutil.getCellCount("Sheet1", 0); 
	    String AddMentorData[][] = new String[totalrows-1][totalcols]; //total rows-1,because only need 8 rows,only 8 invalid data 

	    for (int i = 2; i <= totalrows; i++) { 
	    	//i=2,because only want data from 3rd row
	        for (int j = 0; j < totalcols; j++) {
	            AddMentorData[i-2][j] = xlutil.getCellData("Sheet1", i, j); //2,0
	        }
	    }
	    return AddMentorData;
	}	
}	


