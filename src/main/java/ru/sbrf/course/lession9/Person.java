package ru.sbrf.course.lession9;

import java.io.Serializable;

public class Person implements Serializable {
    public String gender = "Male";

    public String toString(){
        return "Person gender="+this.gender;
    }

}
