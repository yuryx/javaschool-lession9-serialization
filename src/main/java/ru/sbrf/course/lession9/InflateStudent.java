package ru.sbrf.course.lession9;

import java.io.*;
import java.util.Calendar;

/**
 * Created by sbt-mikhiyenko-yua on 14.09.2017.
 */
public class InflateStudent {
    public static void main(String[] args) {
        String filename = "student.ser";

        Student student = null;
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis)
        )
        {
           student = (Student) in.readObject();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        System.out.println("Время сериализации:"
                +student.getCreationDate());
        System.out.println("Текущее время:"
                + Calendar.getInstance().getTime());
        System.out.println(student.toString());

    }
}
