package com.nafisulbari.fileupload.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UploadController {


    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @PostMapping("/upload-action")
    public ModelAndView uploadAction(@RequestParam("myfile") MultipartFile theFile, Model model) {

        //selecting the local-storage folder to save the files
        String uploadDir = System.getProperty("user.dir") + "\\local-storage\\";

        String fileName = theFile.getOriginalFilename();

        try {
            //saving the file to the selected folder
            Files.copy(theFile.getInputStream(), Paths.get(uploadDir + fileName), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();

            //a friendly flag if the uploading fails
            model.addAttribute("flag", "Upload Failed");
            return new ModelAndView("index");
        }

        model.addAttribute("flag", "Upload Successful, Check the 'local-storage' folder");
        return new ModelAndView("index");
    }
}
