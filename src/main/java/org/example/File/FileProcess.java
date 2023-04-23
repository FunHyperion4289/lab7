package org.example.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.Customer.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileProcess {
    private final String fileName = "customer";
    private final String fileExtension = ".json";
    private final String directory = "D:\\";
    private final String filePath = directory+ fileName + fileExtension;


    public void CheckFileExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            CreateFile();
        }
    }
    public void CreateFile() {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void WriteFile(List<Customer> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File(filePath), list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public List<Customer> ReadFile(List<Customer> list) {
        File file = new File(filePath);
        if (file.length() == 0) {
            return list;
        }
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            list = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });
        }
        catch (IOException err){
            err.printStackTrace();
        }
        return list;
    }
}