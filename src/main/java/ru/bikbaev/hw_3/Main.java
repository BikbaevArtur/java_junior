package ru.bikbaev.hw_3;
/*
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.

 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        Student student = new Student("Ivan", 21, 4.4);
        Student student2 = new Student("Vasa", 23, 3.4);
        students.add(student2);
        students.add(student);


        String fileNameJSON = "Student.json";
        String fileNameXML = "Student.xml";
        String fileNameBin = "Student.bin";

        MapperStudent.writeFileJson(fileNameJSON, students);
        MapperStudent.writeFileXml(fileNameXML, students);
        MapperStudent.writeFileBin(fileNameBin, students);

        List<Student> studentList = new ArrayList<>();


        studentList = MapperStudent.readJSON(fileNameJSON);
        studentList.forEach(System.out::println);

        studentList = MapperStudent.readXML(fileNameXML);
        students.forEach(System.out::println);

        studentList=MapperStudent.readBin(fileNameBin);
        studentList.forEach(System.out::println);


    }
}
