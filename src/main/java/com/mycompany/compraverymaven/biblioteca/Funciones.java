package com.mycompany.compraverymaven.biblioteca;

import com.mycompany.compraverymaven.dtopdf.Pempleados;
import com.mycompany.compraverymaven.dtopdf.Pordencompra;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Funciones {

    public void exportarexcel(JTable t) {
        try {
            exportarexcel_2(t);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void exportarexcel_2(JTable t) throws IOException {

        int nfilas = t.getRowCount();
        int ncolumnas = t.getColumnCount();
        //fin estilos            
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx");
            try {
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
                archivoXLSX.createNewFile();
                XSSFWorkbook libro = new XSSFWorkbook();
                XSSFSheet hoja = libro.createSheet("Mi hoja de trabajo 1");

                //ESTILOS
                CellStyle estilo1 = libro.createCellStyle();
                XSSFFont fuente1 = libro.createFont();

                fuente1.setBold(true);
                fuente1.setFontName("IMPACT");
                fuente1.setColor(IndexedColors.WHITE.getIndex());
                fuente1.setFontHeightInPoints((short) 14);

                estilo1.setFont(fuente1);
                estilo1.setFillForegroundColor(IndexedColors.BLUE.getIndex());
                estilo1.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
                estilo1.setAlignment(HorizontalAlignment.CENTER);
                estilo1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                estilo1.setBorderRight(BorderStyle.MEDIUM);
                estilo1.setRightBorderColor(IndexedColors.BLACK.getIndex());
                estilo1.setBorderLeft(BorderStyle.MEDIUM);
                estilo1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                estilo1.setBorderTop(BorderStyle.MEDIUM);
                estilo1.setTopBorderColor(IndexedColors.BLACK.getIndex());
                estilo1.setBorderBottom(BorderStyle.MEDIUM);
                estilo1.setBottomBorderColor(IndexedColors.BLACK.getIndex());

                CellStyle estilo2 = libro.createCellStyle();
                XSSFFont fuente2 = libro.createFont();
                fuente2.setBold(false);
                fuente2.setFontName("ARIAL");
                fuente2.setColor(IndexedColors.BLACK1.getIndex());
                fuente2.setFontHeightInPoints((short) 10);

                estilo2.setFont(fuente2);
                estilo2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                estilo2.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
                estilo2.setAlignment(HorizontalAlignment.LEFT);
                estilo2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                estilo2.setBorderRight(BorderStyle.THIN);
                estilo2.setRightBorderColor(IndexedColors.BLACK.getIndex());
                estilo2.setBorderLeft(BorderStyle.THIN);
                estilo2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                estilo2.setBorderTop(BorderStyle.THIN);
                estilo2.setTopBorderColor(IndexedColors.BLACK.getIndex());
                estilo2.setBorderBottom(BorderStyle.THIN);
                estilo2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                //fin estilos 

                FileOutputStream archivo = new FileOutputStream(archivoXLSX);

                hoja.setDisplayGridlines(false);
                for (int f = 0; f < nfilas; f++) {
                    // hoja.setColumnWidth(f, 10000);
                    XSSFRow fila = hoja.createRow(f);
                    for (int c = 0; c < ncolumnas; c++) {
                        XSSFCell celda = fila.createCell(c);
                        celda.setCellStyle(estilo1);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < nfilas; f++) {
                    XSSFRow fila = hoja.createRow(filaInicio);
                    // hoja.setColumnWidth(f, 10000);
                    filaInicio++;
                    for (int c = 0; c < ncolumnas; c++) {
                        XSSFCell celda = fila.createCell(c);

                        if (t.getValueAt(f, c) != null) {

                            if (t.getValueAt(f, c) instanceof String) {
                                celda.setCellValue((String) t.getValueAt(f, c));
                            } else if (t.getValueAt(f, c) instanceof Boolean) {

                                if (t.getValueAt(f, c).equals(true)) {
                                    celda.setCellValue((String) "Verdadero");
                                } else {
                                    celda.setCellValue((String) "Falso");
                                }

                            } else if (t.getValueAt(f, c) instanceof Date) {
                                celda.setCellValue((Date) t.getValueAt(f, c));
                            } else if (t.getValueAt(f, c) instanceof Double) {
                                celda.setCellValue((Double) t.getValueAt(f, c));
                            }

                        }
//                        else {
//                            if (t == listita.getTblAsistencias()) {
//                                celda.setCellValue((String) "NO ASISTIO");
//                            } else {
//                                celda.setCellValue((String) "");
//                            }
//                        }
                    }
                    hoja.autoSizeColumn(f);
                }

                libro.write(archivo);
                archivo.close();
                JOptionPane.showMessageDialog(null, "Exportación exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Desktop.getDesktop().open(archivoXLSX);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    public void exportarpdf(InputStream plantilla) {

        System.out.println("Ubicacion de reporte " + plantilla.toString());
        try {
            JasperReport jr = JasperCompileManager.compileReport(plantilla);
            Map<String, Object> pr = new HashMap<>();
            JREmptyDataSource jre = new JREmptyDataSource();
            JasperPrint jp = JasperFillManager.fillReport(jr, pr, jre);
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String[][] tablatostring(JTable t) {
        // int filaInicio = 1;
        int nfilas = t.getRowCount();
        int ncolumnas = t.getColumnCount();
        String valor[][] = new String[nfilas][ncolumnas];
        for (int f = 0; f < nfilas; f++) {
            //filaInicio++;
            for (int c = 0; c < ncolumnas; c++) {
                if (t.getValueAt(f, c) != null) {

                    if (t.getValueAt(f, c) instanceof String) {
                        valor[f][c] = t.getValueAt(f, c).toString();
                    } else if (t.getValueAt(f, c) instanceof Boolean) {
                        valor[f][c] = t.getValueAt(f, c).toString();
                    } else if (t.getValueAt(f, c) instanceof Date) {
                        valor[f][c] = t.getValueAt(f, c).toString();
                    } else if (t.getValueAt(f, c) instanceof LocalDate) {
                        valor[f][c] = t.getValueAt(f, c).toString();
                    } else if (t.getValueAt(f, c) instanceof Double) {
                        valor[f][c] = t.getValueAt(f, c).toString();
                    }

                }

            }
        }
        return valor;

    }

    public void exportarpdf2(JTable t) {
        int nfilas = t.getRowCount();
        // int ncolumnas = t.getColumnCount();
        List lista = new ArrayList();
        for (int i = 0; i < nfilas; i++) {
            Pempleados p = new Pempleados(t.getValueAt(i, 0).toString(),
                    t.getValueAt(i, 1).toString(),
                    t.getValueAt(i, 2).toString(),
                    t.getValueAt(i, 3).toString(),
                    t.getValueAt(i, 4).toString(),
                    t.getValueAt(i, 5).toString());
            lista.add(p);
        }
        JasperReport reporte;
        try {
            //Map<String,Object> hm =new HashMap<>();
            reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\ABEL\\Documents\\MEGAsync\\UTP\\VI CICLO\\INTEGRADOR\\EXTRAS\\TAREAS\\PROYECTO 2\\AVANCE 3\\CompraveryMaven\\src\\main\\resources\\informes\\empleado3.jasper");
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(imprimir, false);

        } catch (JRException e) {
        }

    }

    public void exportarpdf3(JTable t, String norden, String proveedor, String fcompra, String ruc, String total) {

        int nfilas = t.getRowCount();
        // int ncolumnas = t.getColumnCount();
        List lista = new ArrayList();
        for (int i = 0; i < nfilas; i++) {
            String producto = t.getValueAt(i, 0).toString();
            String cantidad = t.getValueAt(i, 1).toString();
            String preciocu = t.getValueAt(i, 2).toString();
            String importe = t.getValueAt(i, 3).toString();
            System.out.println(producto +" "+ cantidad+" "+ preciocu+" "+ importe);
            Pordencompra po = new Pordencompra(norden, proveedor, fcompra, ruc,
                    producto,
                    cantidad,
                    preciocu,
                    importe, total);
            po.toString();
            lista.add(po);
        }
        JasperReport reporte;
        try {
            //Map<String,Object> hm =new HashMap<>();
            reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\ABEL\\Documents\\MEGAsync\\UTP\\VI CICLO\\INTEGRADOR\\EXTRAS\\TAREAS\\PROYECTO 2\\A\\CompraveryMaven\\src\\main\\resources\\informes\\ordencompra.jasper");
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(imprimir, false);

        } catch (JRException e) {
        }

    }
}
