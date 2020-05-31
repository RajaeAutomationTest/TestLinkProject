package TestLink.POM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testCSV_importation {

	
	public static void main(String[] args) {
		
		
		 	String csvFile = "Data\\addUser.csv";
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
	            data = new  String[4][10];
	            
	            
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
	            
				for (int i = 0 ; i < 4 ; i++) {
					for ( int k = 0; k < 10 ; k++) {
						System.out.print(data[i][k] + " ,");
					}
					System.out.println("");
				}

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
	
	}
	
}
