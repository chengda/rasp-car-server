package org.dingle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/api/video")
public class VideoController {
    private Logger logger = LoggerFactory.getLogger(VideoController.class);

    @GetMapping(path = "/mpeg")
    public void acceptVideo(HttpServletResponse response) {
        try {
            URLConnection connection = new URL("http://localhost:8081").openConnection();
            response.setContentType("multipart/x-mixed-replace; boundary=--BoundaryString");
            try (InputStream inputStream = connection.getInputStream(); OutputStream outputStream = response.getOutputStream()) {
                byte[] buff = new byte[1024 * 1024 * 10];
                int n = 0;
                while ((n = inputStream.read(buff)) > 0) {
                    outputStream.write(buff, 0, n);
                }
                outputStream.flush();
            }
        } catch (Exception e) {

        }
    }
}
