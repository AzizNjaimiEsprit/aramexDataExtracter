package sample.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.models.Item;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Export {


    public static void export (ArrayList<Item> toExport) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");

//            ArrayList<Item> toExport = new ArrayList<Item>();
//            toExport.add(new Item("Aziz", "aziz@gmail.com"));
//            toExport.add(new Item("Mahdi", "mahdi@gmail.com"));
//            toExport.add(new Item("amine", "amine@gmail.com"));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();

            String timeStamp = dtf.format(now);

            String excelFilePath = "C:\\Aramex\\output\\Export_" + timeStamp + ".xlsx";

            Export.writeHeaderLine(sheet);
            Export.writeDataLines(toExport, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static  void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Name");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Email");


    }

    private static void writeDataLines(List<Item> itemList, XSSFWorkbook workbook,
                                       XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

        for (Item item : itemList) {
            String name = item.getName();
            String email = item.getEmail();


            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(name);

            cell = row.createCell(columnCount++);
            cell.setCellValue(email);

        }
    }
}