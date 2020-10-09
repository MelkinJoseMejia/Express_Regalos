package com.init.credit.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.init.credit.utils.Utils;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BulkLoadRest {
	
	

	 @PostMapping("/bulkLoad/uploadFile")
	 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		 if (!Utils.hasExcelFormat(file)) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an excel file!");
		    }
		 
		 return ResponseEntity.status(HttpStatus.OK)
		            .body("Spring boot: Uploaded the file successfully: " + file.getOriginalFilename());
	 }
}
