package com.tac.utility;

import com.tac.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List<Map<String,String>> getTestExecutionDetails(String sheetName)  {

        FileInputStream fis = null;
        List<Map<String,String>> listOfMaps = null;
        try {
            fis = new FileInputStream(FrameworkConstants.getTestexecexcelpath());
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(Objects.nonNull(fis)){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return listOfMaps;
    }

}
