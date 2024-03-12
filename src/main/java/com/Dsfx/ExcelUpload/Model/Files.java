package com.Dsfx.ExcelUpload.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Files {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String Id;
    private String FileName;
    private String Url;
    private String FileType;
    private Double size;
    @Lob
    private byte[] data;


    public Files(String fileName, String contentType, byte[] bytes) {
    }
}
