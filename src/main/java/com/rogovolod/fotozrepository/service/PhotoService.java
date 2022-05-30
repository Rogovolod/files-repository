package com.rogovolod.fotozrepository.service;

import com.rogovolod.fotozrepository.model.Photo;
import com.rogovolod.fotozrepository.repository.PhotoRepository;

import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setPhoto(data);
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photoRepository.save(photo);
        return photo;
    }
}
