package com.doomcatlee.helperfunctionlibrary.csv;

import com.doomcatlee.helperfunctionlibrary.csv.pojo.CsvObject;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;
import java.util.Set;

public class ParseCsv {

    /**
     *
     *  Given CSV file, loop through all rows excluding the header,
     *  then grab each column using index and save as a custom object (CsvObject)
     *
     * **/
    public CsvObject parseCsvAndSaveAsObject(String filePath) {
        CsvObject csvObject = new CsvObject();

        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            List<String[]> arrayWithHeader = csvReader.readAll();

            // Ignore the first index in arrayList, because it's header
            List<String[]> arrayWithoutHeader = arrayWithHeader.subList(1, arrayWithHeader.size());

            for (String[] rowObj : arrayWithoutHeader) {
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
