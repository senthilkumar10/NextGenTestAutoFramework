package com.tac.utility;

import com.tac.constants.FrameworkConstants;
import com.tac.customexceptions.FrameworkExceptions;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List<Map<String,String>> getTestExecutionDetails(String sheetName)  {

        List<Map<String,String>> listOfMaps = null;
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getTestexecexcelpath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            Map<String,String> map = null;
            listOfMaps = new ArrayList<>();

            int lastRowCount = sheet.getLastRowNum();
            int lastColCount = sheet.getRow(0).getLastCellNum();

            for(int i=1;i<=lastRowCount;i++){
                map = new HashMap<>();
                for(int j=0;j<lastColCount;j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                listOfMaps.add(map);
            }


        } catch (FileNotFoundException e) {
            throw new FrameworkExceptions("Excel file is not found");
        } catch (IOException e) {
            throw new FrameworkExceptions("IO exception happened while reading the Excel");
        }
        return listOfMaps;
    }

}
