package com.sample.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.sample.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService service;
	@GetMapping("/hello/{name}")
	public String getMessage(@PathVariable String name) {
		
		return "Welcome "+name;
	}
	@PostMapping("/file/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getContentType());
		String id = service.addFile("File1", file);
		return id;
	}
	@Autowired
	private GridFsOperations operations;
	
	@GetMapping("/file/download/{id}")
	public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String id) throws IOException {
		
		GridFSFile file = service.getFile(id);
		System.out.println(file.getMetadata().get("title").toString());
		System.out.println(file.getMetadata().get("_contentType"));
		System.out.println(file.getLength());
		
		return ResponseEntity
				.ok()
				.contentType(MediaType.parseMediaType(file.getMetadata().get("_contentType").toString()))
				.contentLength(file.getLength())
				.body(operations.getResource(file));
	}
}
