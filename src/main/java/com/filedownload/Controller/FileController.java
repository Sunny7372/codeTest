/*
package com.filedownload.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/file")
public class FileController{
    private static final Logger log = LoggerFactory.getLogger(FileController.class);


    private static final String File_Directory="C:\\Users\\sunny\\Downloads\\FileDownload";

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource>downloadFile(@PathVariable String filename) {
        File file = new File(File_Directory +  "\\" +  filename);
        log.info("here is a file:{}",file);
        if(file.canRead()){
            System.out.println("hii readable");
        }

        else if (!file.getAbsoluteFile().exists()) {
            log.info("file not found then it is coming");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        try{
            log.info("if file is there is then it will run{}",file);
            FileInputStream stream=new FileInputStream(file);
            InputStreamResource resource= new InputStreamResource(stream);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    . body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


    }
}
*/
