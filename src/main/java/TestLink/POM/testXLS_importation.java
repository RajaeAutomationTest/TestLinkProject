package TestLink.POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testXLS_importation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("D:\\Projets Eclipse\\TestLink\\Data\\Data.xlsx");

		FileInputStream fis= new FileInputStream(file);

		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		

		Sheet sheet = workbook.getSheet("LoginDataInvalidCase"); 

		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum() ;
		System.out.println(rows);
		System.out.println(cells);
		Object[][] data = new Object[rows][cells];
		for( int i = 0 ; i < rows ; i++) {
			for( int k = 0 ; k < cells ; k++) {
				System.out.print("["+(i+1)+"]["+k+"] : ");
				
				if(sheet.getRow(i+1).getCell(k) != null) {
					System.out.println(sheet.getRow(i+1).getCell(k).toString());
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				}
				else {
					System.out.println("");
					data[i][k] ="";
					}
				
			}
		}
		workbook.close();
		for( int i = 0 ; i < rows ; i++) {
			for( int k = 0 ; k < cells ; k++) {
				System.out.println(data[i][k]);
			}
		}


	}

}
