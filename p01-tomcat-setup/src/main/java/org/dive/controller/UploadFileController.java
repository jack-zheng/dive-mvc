package org.dive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class UploadFileController {

    /**
     * curl -X POST http://localhost:8080/p01-tomcat-setup/app/upload \
     *   -H "Content-Type: multipart/form-data" \
     *   -F "file=@-;filename=test-file.txt;type=text/plain" <<< "This is the content of the file"
     *
     * @param file
     * @return
     */
    @PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file,
                         @RequestHeader Map<String, String> headers) {
        // for loop to print headers
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        // print file into string
        System.out.println(file);
        return "File uploaded";
    }
}
