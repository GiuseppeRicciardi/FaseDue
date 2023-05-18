package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String firstname;
    private String lastname;
    private String birthdate; //stringa composta come dd-MM-yyyy
    private String[] grades; //pur non essendo specificato nella traccia, ho ipotizzato si stesse parlando di una lista di voti

    public Student(String firstname, String lastname, String birthdate, String[] grades){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.grades = grades;
    }

    public int getAge(){
        String[] divided1 = birthdate.split("-");
        int day = Integer.parseInt(divided1[0]);
        int month = Integer.parseInt(divided1[1]);
        int year = Integer.parseInt(divided1[2]);

        DateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String todayDate = form.format(new Date());
        String[] divided2 = todayDate.split("-");
        int actualDay = Integer.parseInt(divided2[0]);
        int actualMonth = Integer.parseInt(divided2[1]);
        int actualYear = Integer.parseInt(divided2[2]);

        int possibleAge = actualYear - year; //età provvisoria basata unicamente sugli anni trascorsi dalla nascita

        if(actualMonth < month || (actualMonth == month) && actualDay < day) //controlla se l'ultmo anno è stato effettivamente compiuto
            return possibleAge -1;
        else{
            return possibleAge;
        }
    }

    public double avgGrade(){
        int sum = 0;
        for(String g : grades){
            sum += Integer.parseInt(g);
        }
        return sum/grades.length;
    }

    public static void main(String[] args) {
        String[] grades = {"24", "26", "30", "18", "21"};
        Student student = new Student("Marco", "Rossi", "17-05-1992", grades);

        System.out.println(student.getAge());
        System.out.println(student.avgGrade());
    }

}
