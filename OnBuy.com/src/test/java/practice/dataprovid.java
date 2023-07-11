package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Base_class;
import com.Onbuy.com_Utilityclasses.Excel_utility;
import com.Onbuy.com_Utilityclasses.File_utility;

public class dataprovid  {
    
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		 Object[][] obj=new Object[3][3];
		 File_utility flib=new File_utility();
		 Excel_utility elib=new Excel_utility();
		   
		 
		  String ENV_FILE_PATH =    flib.getFilePathFromPropertiesFile("projectConfigDataFilePath"); 
		   String TEST_SCRIPT_EXCEL_FILE_PATH =    flib.getFilePathFromPropertiesFile("testScriptdatafilePath");
	String  src= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_1"
			, "src");
	String  dst= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_2"
			, "dst");
	String  price= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_3"
			, "price");
	return obj;
		}
	@Test(dataProvider = "getdata")
	public void getTheData(String src,String dst,String price)
	{
		System.out.println(src+" "+dst+" "+price);
	}
}
