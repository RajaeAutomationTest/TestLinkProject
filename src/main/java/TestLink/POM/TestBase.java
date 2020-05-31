package TestLink.POM;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class TestBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait ;
	public static Actions action;
	public static String URL = "http://localhost/testlink";
	public static String FileXpath = "D:\\Projets Eclipse\\TestLink\\Data\\Data.xlsx";
	public static String username = "admin";
	public static String password = "admin";
	
	// pour stocker le login et pass de l'utilisateur ajouté
	public static String NewUserLogin = "";
	public static String NewUserpassword = "";
	
	public static LogInPage loginPage;
	public static HomePage homePage;
	public static UserManagementPage userManagementPage;
	public static CreateUserPage createUserPage;
	
	public TestBase() {

	}

	public void initialisation ()  {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,30000);
		action = new Actions(driver);

		loginPage = new LogInPage();
		homePage = new HomePage();
		userManagementPage = new UserManagementPage();
		createUserPage = new CreateUserPage();
	}
	

	public void finish()  {
		driver.quit();
	}


	public void MarkFaildTest() {
		Assert.assertFalse(true);
		
	}

	public static Object[][] getData(String XLSSheet) throws Exception{
		
		File file = new File(FileXpath);

		FileInputStream fis= new FileInputStream(file);
	
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet(XLSSheet); 

		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum() ;

		Object[][] data = new Object[rows][cells];
		for( int i = 0 ; i < rows ; i++) {
			for( int k = 0 ; k < cells ; k++) {
				if(sheet.getRow(i+1).getCell(k) != null) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				}
				else {
					data[i][k] ="";
				}
			}
		}
		workbook.close();
//		for( int i = 0 ; i < rows ; i++) {
//			for( int k = 0 ; k < cells ; k++) {
//				System.out.println(data[i][k]);
//			}
//		}
		return data; 
	}
	
	public static String[][] getDataCSV(String fileName) throws Exception{
		
	 	String csvFile = "Data\\"+fileName+".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String[][] data = null;
        try {

        	// charger le fichier csv
            br = new BufferedReader(new FileReader(csvFile));
            
            // eliminer l'entete du tableau
            line = br.readLine();
          
            // initialiser une collection pour stoquer les utilisateurs
            data = new  String[1][10];
            
            
            int j = 0;
            // parcourir les lignes du tableau
            while ((line = br.readLine()) != null) {
                //utiliser point-virgule comme séparateur
                String[] user = line.split(cvsSplitBy);
                for(int i = 0 ; i<10 ; i++) {
                data[j][i] = user[i];
               
                }
                j++;
            }
            
//			for (int i = 0 ; i < 4 ; i++) {
//				for ( int k = 0; k < 10 ; k++) {
//					System.out.print(data[i][k] + " ,");
//				}
//				System.out.println("");
//			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return data;
	}
}
