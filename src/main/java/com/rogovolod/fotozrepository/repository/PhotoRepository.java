package com.rogovolod.fotozrepository.repository;

import com.rogovolod.fotozrepository.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
