package ru.bikbaev.hw_3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MapperStudent {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void writeFileJson(String fileName, List<Student> student) throws IOException {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(fileName), student);
        System.out.println(ANSI_GREEN + "Creat .json file " + fileName + ANSI_RESET + "\n");
    }


    public static List<Student> readJSON(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        students = objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        System.out.println(ANSI_GREEN + "\nread .json file " + fileName + " complete\n" + ANSI_RESET);
        return students;
    }

    public static void writeFileXml(String fileName, List<Student> students) throws IOException {
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        xmlMapper.writeValue(new File(fileName), students);
        System.out.println(ANSI_GREEN + "Creat .xml file " + fileName + "\n" + ANSI_RESET);
    }

    public static List<Student> readXML(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        students = xmlMapper.readValue(new File(fileName), xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        System.out.println(ANSI_GREEN + "\nread .xml file " + fileName + " complete\n" + ANSI_RESET);
        return students;
    }

    public static void writeFileBin(String fileName, List<Student> students) throws IOException {
        try (FileOutputStream outFile = new FileOutputStream(fileName)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(outFile);
            outputStream.writeObject(students);
            System.out.println(ANSI_GREEN + "Creat .bin file " + fileName + "\n" + ANSI_RESET);

        }

    }


    public static List<Student> readBin(String file) throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            list = (List<Student>) inputStream.readObject();
            System.out.println(ANSI_GREEN+"\nread .bin file "+file+" complete\n"+ANSI_RESET);
        }
        return list;
    }


}
