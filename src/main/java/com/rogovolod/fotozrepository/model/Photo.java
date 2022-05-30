package com.rogovolod.fotozrepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOZ")
public class Photo {

    @Id
    private Integer id;

    private String fileName;

    @JsonIgnore
    private byte[] photo;

    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public Photo() {
    }

    public Photo(Integer id, String fileName, byte[] photo) {
        this.id = id;
        this.fileName = fileName;
        this.photo = photo;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
