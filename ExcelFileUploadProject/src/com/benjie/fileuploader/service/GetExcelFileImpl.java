package com.benjie.fileuploader.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class GetExcelFileImpl implements GetExcelFile {

	private static String inputFile;

	static {
		inputFile = "C:/Users/benjamin.rusiana/Downloads/abocado.xls";
	}
	
	public GetExcelFileImpl() {

	}

	public void GetExcelFileImpl(String inputFile) {
		this.inputFile = inputFile;
	}

	@Override
	public Map<Integer, List<String>> ReadExcel() {
//		FileInputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(new File(
//					"C:/Users/benjamin.rusiana/Downloads/abocado.xls"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
//
//		Workbook workbook = null;
//		try {
//			workbook = new XSSFWorkbook(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Sheet firstSheet = workbook.getSheetAt(5);
//
//		Iterator<Row> iterator = firstSheet.iterator();
//
//		// Test test=new Test();
//		int rowCnt = 0;
//
//		while (iterator.hasNext()) {
//			Row nextRow = iterator.next();
//
//			Iterator<Cell> cellIterator = nextRow.cellIterator();
//			List<String> obj = new ArrayList<String>();
//			while (cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//
//				String cellobj = cell.getStringCellValue();
//
//				if ("".equals(cell.getStringCellValue())) {
//					obj.add("Missing");
//
//				} else if (cellobj.equals(null)) {
//					obj.add("");
//
//				} else {
//					obj.add(cell.getStringCellValue());
//				}
//
//			}
//
//			data.put(rowCnt, obj);
//			rowCnt++;
//
//		}
//		return data;
		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
		List<String> msg = new ArrayList<String>();
		msg.add("testing");
		msg.add("benjie");
		
				data.put(1, msg);
				
		return data;
	}

}
