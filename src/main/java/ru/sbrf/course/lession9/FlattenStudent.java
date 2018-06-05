package ru.sbrf.course.lession9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by sbt-mikhiyenko-yua on 14.09.2017.
 */
public class FlattenStudent {
    public static void main(String[] args) {
        String filename = "student.ser";

        Student student = new Student();
        student.setName("Иван");
        student.setAge(25);
        student.setCourse(Course.SECOND);
        student.setPassword("1****2");
        try(FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fos)
            )
        {
           out.writeObject(student);
        } catch(IOException ex) {
            ex.printStackTrace();
        }

//        try(FileOutputStream fos = new FileOutputStream(filename);
//            ObjectOutputStream out = new ObjectOutputStream(fos)
//        )
//        {
//            student.setAge(99);
//            out.writeObject(student);
//        } catch(IOException ex) {
//            ex.printStackTrace();
//        }
    }


}
