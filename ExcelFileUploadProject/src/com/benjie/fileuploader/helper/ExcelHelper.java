package com.benjie.fileuploader.helper;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper {

	private List<String> fieldNames = new ArrayList<String>();
	private Workbook workbook = null;
	private String workbookName = "";

	public ExcelHelper(String workbookName) {
		this.workbookName = workbookName;
		initialize();
	}

	private void initialize() {
		//setWorkbook(new HSSFWorkbook());
	}

	public void closeWorksheet() {
		FileOutputStream fileOut;

//		try {
//			//fileOut = new FileOutputStream(getWorkbookName());
//			//getWorkbook().write(fileOut);
//			//fileOut.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	private boolean setupFieldsClass(Class<?> clazz) throws Exception{
		Field[] fields = clazz.getDeclaredFields();
		
		for(int i= 0; i<fields.length; i++){
			fieldNames.add(fields[i].getName());
		}
		return true;
	}
}
