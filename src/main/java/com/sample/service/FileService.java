package com.sample.service;

import java.io.IOException;
import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class FileService {

	@Autowired
	private GridFsTemplate template;

	@Autowired
	private GridFsOperations operations;

	public GridFSFile getFile(String id) throws IllegalStateException, IOException {
		GridFSFile file = template.findOne(new Query(Criteria.where("_id").is(id)));
		return file;
	}

	public String addFile(String title, MultipartFile file) throws IOException {
		DBObject metaData = new BasicDBObject();
		metaData.put("title", title);
		ObjectId id = template.store(file.getInputStream(), file.getName(), file.getContentType(), metaData);
		return id.toString();
	}

}
