package com.sample.model;

import java.io.InputStream;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FileWrapper {
	@Id
	private String title;
	private InputStream stream;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	public FileWrapper(String title) {
		super();
		this.title = title;
	}
	public FileWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
