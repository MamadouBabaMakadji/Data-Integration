package data.integration.extractor;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Source1ExtractorImpl implements IExtractor {
    // Extract from source 1 (Excel)
    String source = "src/main/resources/Source1.xls";
    FileInputStream inputStream = null;
    HSSFWorkbook workbook = null;

    public int extractResultR1() {
        ArrayList<Double> result = new ArrayList<Double>();
        try {
            inputStream = new FileInputStream(new File(source));
            workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                if("etudiant".equalsIgnoreCase(nextRow.getCell(3).getStringCellValue())){
                    Cell cellProvenance = nextRow.getCell(4);
                    if("France".equalsIgnoreCase(cellProvenance.getStringCellValue())){
                        Cell cellID = nextRow.getCell(0);
                        if(! (result.contains(cellID.getNumericCellValue())))
                            result.add(cellID.getNumericCellValue());
                    }
                }
            }
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.size();
    }

    public ArrayList<String> extractResultR2() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Double> identifiants = new ArrayList<Double>();
        try {
            inputStream = new FileInputStream(new File(source));
            workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Cell cellLibelleCours = nextRow.getCell(8);
                Cell cellStatut = nextRow.getCell(3);
                if("ID".equalsIgnoreCase(cellLibelleCours.getStringCellValue()) && "etudiant".equalsIgnoreCase(cellStatut.getStringCellValue())){
                    Cell cellNom = nextRow.getCell(1);
                    Cell id = nextRow.getCell(0);
                    if(!(identifiants.contains(id.getNumericCellValue()))){
                        result.add(cellNom.getStringCellValue());
                        identifiants.add(id.getNumericCellValue());
                    }
                }
            }
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<String> extractResultR3() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Double> identifiants = new ArrayList<Double>();
        try {
            inputStream = new FileInputStream(new File(source));
            workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Cell cellLibelleCours = nextRow.getCell(8);
                Cell cellStatut = nextRow.getCell(3);
                if("SGBD".equalsIgnoreCase(cellLibelleCours.getStringCellValue()) && "enseignant".equalsIgnoreCase(cellStatut.getStringCellValue())){
                    Cell cellNom = nextRow.getCell(1);
                    Cell id = nextRow.getCell(0);
                    if(!(identifiants.contains(id.getNumericCellValue()))){
                        result.add(cellNom.getStringCellValue());
                        identifiants.add(id.getNumericCellValue());
                    }
                }
            }
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
