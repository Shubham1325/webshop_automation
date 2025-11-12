package com.webshopautomation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public static String getData(String filePath, String sheetName, int row, int column) {
        FileInputStream fis = null;
        Workbook wb = null;
        String cellValue = "";

        try {
            fis = new FileInputStream(filePath);
            wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row rowVal = sheet.getRow(row);
            Cell colVal = rowVal.getCell(column);

            if (colVal == null) {
                return "";
            }

            switch (colVal.getCellType()) {
                case STRING:
                    cellValue = colVal.getStringCellValue();
                    break;

                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(colVal)) {
                        // Handle date format
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        cellValue = dateFormat.format(colVal.getDateCellValue());
                    } else {
                        // Handle numeric format (avoid showing 12.0 for 12)
                        double numericValue = colVal.getNumericCellValue();
                        if (numericValue == (long) numericValue) {
                            cellValue = String.valueOf((long) numericValue);
                        } else {
                            cellValue = String.valueOf(numericValue);
                        }
                    }
                    break;

                case BOOLEAN:
                    cellValue = String.valueOf(colVal.getBooleanCellValue());
                    break;

                case FORMULA:
                    // Evaluate formula and return value as string
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellValue evaluatedValue = evaluator.evaluate(colVal);
                    switch (evaluatedValue.getCellType()) {
                        case STRING:
                            cellValue = evaluatedValue.getStringValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(colVal)) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                cellValue = dateFormat.format(colVal.getDateCellValue());
                            } else {
                                double numVal = evaluatedValue.getNumberValue();
                                if (numVal == (long) numVal) {
                                    cellValue = String.valueOf((long) numVal);
                                } else {
                                    cellValue = String.valueOf(numVal);
                                }
                            }
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(evaluatedValue.getBooleanValue());
                            break;
                        default:
                            cellValue = "";
                            break;
                    }
                    break;

                case BLANK:
                    cellValue = "";
                    break;

                default:
                    cellValue = "";
                    break;
            }

        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null)
                    wb.close();
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cellValue;
    }
}
