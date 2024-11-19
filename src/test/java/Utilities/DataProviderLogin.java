package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {
	@DataProvider(name="testadminlogindata")
	public String[][] getData() throws IOException {
	    String path = System.getProperty("user.dir")+"\\TestData\\testadminnegativedata.xlsx"; //taking Excel file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility and passing the path of the excel file

	    int totalrows = xlutil.getRowCount("Sheet1"); //it will return value starting from index 1
	    int totalcols = xlutil.getCellCount("Sheet1", 0); //it will return value starts from 0ne
	    String AdminLoginData[][] = new String[totalrows][totalcols]; //created for two dimension array which can store, doesn't need the header row of excel file

	    for (int i = 1; i <= totalrows; i++) { //read the data from xl storing in two dimensional array
	        for (int j = 0; j < totalcols; j++) {
	            AdminLoginData[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
	            //array   							excel file
	        }
	    }

	    return AdminLoginData;

}
}
