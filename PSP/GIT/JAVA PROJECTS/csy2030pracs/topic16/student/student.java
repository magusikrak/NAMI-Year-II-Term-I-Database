import java.util.ArrayList;

public class student {
    public int stud_id;
    public String name;

    public student(int stud_id, String name) {

        this.stud_id = stud_id;
        this.name = name;

    }

    public String toString() {
        return "Student ID = " + this.stud_id + ", Student name =" + this.name;
    }
}