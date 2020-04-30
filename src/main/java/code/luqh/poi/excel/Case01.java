package code.luqh.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @author luqh
 * @date 2019/10/28
 **/
public class Case01 {

    public static void main(String[] args) throws IOException {
        Workbook wb = new XSSFWorkbook();

        try (InputStream pin = new FileInputStream("C:\\Users\\luqh\\Pictures\\1.jpg")) {
            int picture = wb.addPicture(IOUtils.toByteArray(pin), Workbook.PICTURE_TYPE_JPEG);

            CreationHelper helper = wb.getCreationHelper();
            Sheet sheet1 = wb.createSheet("new sheet");

            Drawing<?> drawing = sheet1.createDrawingPatriarch();

            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
//            anchor.setRow2(1);
//            anchor.setDy1(1);

            Picture pict = drawing.createPicture(anchor, picture);

            pict.resize();

            try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
                wb.write(fileOut);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
