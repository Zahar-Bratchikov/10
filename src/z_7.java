import java.io.*;

import static java.lang.Math.*;

public class z_7 {
    public static void write(String a, boolean bo) {
        try (FileWriter writer = new FileWriter("text7.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        write("Диапазон аргумента: -3<=x<=3\nФункция:\nif (x >= 0) \n\tx = pow(x,2)+2x\nelse \n\tx = -cos(x)\nВывод в порядке возрастания x\n", false);
        for (double x = -3.0; x <= 3.0; x += 0.5) {
            if (x >= 0)
                write(("x=" + x + "; f(x)=" + pow(x, 2) + 2 * x + "\n"), true);
            else
                write(("x=" + x + "; f(x)=" + -cos(x) + "\n"), true);
        }
    }
}