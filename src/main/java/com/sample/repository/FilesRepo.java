package com.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.model.FileWrapper;

public interface FilesRepo extends MongoRepository<FileWrapper, String> {

}
