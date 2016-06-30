package com.benjie.fileuploader.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.benjie.fileuploader.model.FileBucket;
import com.benjie.fileuploader.service.GetExcelFile;
import com.benjie.fileuploader.util.FileValidator;

@Controller
public class ExcelFileUploaderController {

	@Autowired
	FileValidator fileValidator;
	@Autowired
	GetExcelFile excelFile;

	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "welcome";
	}

	@RequestMapping(value = "/fileUploader", method = RequestMethod.GET)
	public String getUploadPage(ModelMap model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "fileUploader";
	}

	@RequestMapping(value = "/fileUploader", method = RequestMethod.POST)
	public String fileUpload(@Valid FileBucket fileBucket,
			BindingResult result, ModelMap model) throws IOException {

		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "fileUploader";
		} else {
			System.out.println("Fetching file");
			MultipartFile multipartFile = fileBucket.getFile();
			InputStream in = multipartFile.getInputStream();
			File destination = new File("/some-location/"
					+ multipartFile.getOriginalFilename());
			// Now do something with file...
			FileUtils.copyInputStreamToFile(in, destination);

			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			return "success";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/readexceltowebview", method = RequestMethod.GET)
	public Map<Integer, List<String>> ReadExcelToWebView() {
		
		return excelFile.ReadExcel();
	}
	
}
