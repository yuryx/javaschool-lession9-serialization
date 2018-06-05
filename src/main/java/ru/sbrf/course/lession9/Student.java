package ru.sbrf.course.lession9;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sbt-mikhiyenko-yua on 14.09.2017.
 */
public class Student   {
    public static final long serialVersionUID = 1L;
    String gender = "Male";
    public String name;
    private int age = 18;

    private String password;

    private Date creationDate;

    public void setCourse(Course course) {
        this.course = course;
    }

    private Course course = Course.FIRST;
    //public int course = 1;
    Person person;


    public Student(){
        setName("NaN");
        this.person = new Person();
        this.person.gender = "Female";
        this.creationDate = Calendar.getInstance().getTime();
        this.gender = "Male";
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return String.format("Student name=%s gender=%s age=%d course=%s date=%s password=%s Person=%s",
                this.name, this.gender, this.age, this.course.toString(),
                this.creationDate, this.password,
                (this.person !=null)? this.person.toString() : "NULL");
    }

//    private void writeObject(ObjectOutputStream out) {
//        try {
//            out.defaultWriteObject();
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//    }

//    private void readObject(ObjectInputStream in) {
//        try {
//            in.defaultReadObject();
//        } catch (IOException io) {
//            io.printStackTrace();
//        } catch (ClassNotFoundException cnf) {
//            cnf.printStackTrace();
//        }
//    }

    private Object writeReplace() throws java.io.ObjectStreamException {
        Student student = new Student();
        student.setAge(this.getAge());
        student.course = this.course;
        return student;
    }

    private Object readResolve()
            throws java.io.ObjectStreamException {
        System.out.println("Считанный студент:\n"+this.toString());
        Student student = new Student();
        student.setName("Марья");
        student.setAge(19);
        student.course = this.course;
        return student;
    }

}
