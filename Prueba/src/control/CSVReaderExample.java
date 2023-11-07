package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderExample {

    public static void main(String[] args) {
        String file = "D:\\LucaTicSteam\\Grupo04T1\\WKLucaSteamVG/vgsales.csv";

        BufferedReader reader = null;
        String line = "";
        ArrayList<String[]> data = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }

            for (String[] row : data) {
                for (String index : row) {
                    System.out.printf("%-20s", index);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { 
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 