package br.com.idtech.util;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by DOM on 13/12/2016.
 */
public class ExportExcel {
    private FileOutputStream saida;
    private HSSFWorkbook wb;
    //private HSSFSheet service, usuarios;


    public ExportExcel() {
        wb = new HSSFWorkbook();
    }

    public ExportExcel withFileOutput(File f) {
        try {
            saida = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ExportExcel withSheet(String... sheets) {
        for (String s : sheets) {
            wb.createSheet(s);
            wb.getSheet(s).setDefaultColumnStyle(0, style());
            wb.getSheet(s).setDefaultColumnStyle(1, style());
            wb.getSheet(s).setColumnWidth(0, 10*700);
            wb.getSheet(s).setColumnWidth(1, 8*700);
        }
        return this;
    }

    public ExportExcel withDataServ(List<SenhaServico> s, int sheetIndex) {
        HSSFRow row = wb.getSheetAt(sheetIndex).createRow(0);

        row.createCell(0).setCellValue("Serviço");
        row.createCell(1).setCellValue("Qtd. Atendimentos");
        row.getCell(0).setCellStyle(header());
        row.getCell(1).setCellStyle(header());

        int rowIndex = 1;
        for (SenhaServico se : s) {
            HSSFRow r = wb.getSheetAt(sheetIndex).createRow(rowIndex);
            HSSFCell col0 = r.createCell(0);
            col0.setCellValue(se.getServico());

            HSSFCell col1 = r.createCell(1);
            col1.setCellValue(se.getTotal());

          /*  col0.setCellStyle(style());
            col1.setCellStyle(style());*/

            rowIndex++;
        }


        return this;
    }

    public ExportExcel withDataUser(List<SenhasUsuario> s, int sheetIndex) {
        HSSFRow row = wb.getSheetAt(sheetIndex).createRow(0);
        row.createCell(0).setCellValue("Usuário");
        row.createCell(1).setCellValue("Qtd. Atendimentos");
        row.getCell(0).setCellStyle(header());
        row.getCell(1).setCellStyle(header());

        int rowIndex = 1;
        for (SenhasUsuario u : s) {
            HSSFRow r = wb.getSheetAt(sheetIndex).createRow(rowIndex);

            HSSFCell col0 = r.createCell(0);
            col0.setCellValue(u.getUsuario());

            HSSFCell col1 = r.createCell(1);
            col1.setCellValue(u.getTotal());
/*
            col0.setCellStyle(style());
            col1.setCellStyle(style());*/

            rowIndex++;
        }

        return this;
    }

    private CellStyle style() {
        CellStyle estilo = wb.createCellStyle();

        estilo.setAlignment(CellStyle.ALIGN_CENTER);
        estilo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        estilo.setBottomBorderColor(HSSFColor.BLACK.index);
        estilo.setLeftBorderColor(HSSFColor.BLACK.index);
        estilo.setRightBorderColor(HSSFColor.BLACK.index);
        estilo.setTopBorderColor(HSSFColor.BLACK.index);

        estilo.setBorderBottom(CellStyle.BORDER_THIN);
        estilo.setBorderLeft(CellStyle.BORDER_THIN);
        estilo.setBorderRight(CellStyle.BORDER_THIN);
        estilo.setBorderTop(CellStyle.BORDER_THIN);

      //  estilo.setWrapText(true);
        return estilo;
    }

    private CellStyle header() {
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headerStyle.setBorderRight(CellStyle.BORDER_THIN);
        headerStyle.setBorderTop(CellStyle.BORDER_THIN);
        return headerStyle;
    }

    public void export() {
        try {
            wb.write(saida);
            saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
