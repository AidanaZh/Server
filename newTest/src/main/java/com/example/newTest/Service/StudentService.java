package com.example.newTest.Service;

import com.example.newTest.entity.Student;
import com.example.newTest.entity.StudentRegister;
import com.example.newTest.entity.User_info;
import com.example.newTest.repositories.StudentRepository;
import com.example.newTest.repositories.User_infoRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    User_infoRepository user_infoRepository;
    @Autowired
    StudentRepository studentRepository;
    public ResponseEntity<Object> studentRegisterService(StudentRegister studentRegister, MultipartFile[] files) throws IOException {
        User_info user_info = new User_info(null, studentRegister.getStudent_kod(),
                studentRegister.getStudent_name()+studentRegister.getStudent_kod(),
                "student");
        User_info savedUser_info = user_infoRepository.save(user_info);
        String[] imagesName = new String [5];
        for(int i = 0; i < 5; i++) {
            String path = "D:\\Aika temp\\Student Image\\" + studentRegister.getStudent_kod() +
                    "image" + i + ".jpg";
            imagesName[i] = path;
            File convertFile = new File(path);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(files[i].getBytes());
            fout.close();
        }
        Student st  = new Student(null, studentRegister.getStudent_kod(),studentRegister.getStudent_name(),
                studentRegister.getStudent_surname(), studentRegister.getStudent_faculty(),
                studentRegister.getStudent_department(),savedUser_info, imagesName[0],imagesName[1],
                imagesName[2], imagesName[3],imagesName[4]);
        Student tempSt = studentRepository.save(st);
        return new ResponseEntity<>("Student registered successfully", HttpStatus.OK);
    }
}
