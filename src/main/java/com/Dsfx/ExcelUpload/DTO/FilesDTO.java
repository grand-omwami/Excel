package com.Dsfx.ExcelUpload.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class FilesDTO {

    private String Id;
    private String FileName;
    private String Url;
    private String FileType;
    private Double size;
    private byte[] data;

    public FilesDTO(String fileName, String fileDownloadUri, String fileType, int length) {
    }
}

