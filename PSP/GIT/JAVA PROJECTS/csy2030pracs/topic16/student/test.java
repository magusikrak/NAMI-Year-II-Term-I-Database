import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class test {
    public static void main(String[] args) {

        ArrayList<student> list = new ArrayList<student>();
        list.add(new student(1, "John"));
        list.add(new student(2, "Steve"));

        for (int index = 0; index < list.size(); index++)

        {
            System.out.println(list.get(index));
        }

    }
}