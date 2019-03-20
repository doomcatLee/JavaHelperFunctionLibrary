package com.doomcatlee.helperfunctionlibrary.csv;

import com.doomcatlee.helperfunctionlibrary.csv.pojo.CsvObject;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;
import java.util.Set;

public class ParseCsv {

    public Object parseCsvAndSaveAsObject() {
        CsvObject csvObject = new CsvObject();

        try {
            CSVReader csvReader = new CSVReader(new FileReader("test.csv"));
            List<String[]> resultArray = csvReader.readAll();

            // Ignore the first index in arrayList, because it's header
            for (String[] rowObj : resultArray.subList(1, resultArray.size())) {

                csvObject.field1 = rowObj[0];
                csvObject.field2 = rowObj[1];
                csvObject.field3 = rowObj[2];
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return csvObject;
    }
}
