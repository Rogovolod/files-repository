package com.rogovolod.fotozrepository.web;

import com.rogovolod.fotozrepository.model.Photo;
import com.rogovolod.fotozrepository.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String welcome(){
        return "upload.html";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos() {
        return photoService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photo/delete")
    public void deletePhotoById(Integer id) {
        photoService.delete(id);
    }

    @PostMapping("/photo/upload")
    public String uploadPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return "Successfully uploaded file: " + file.getOriginalFilename();
    }

}
