import java.io.*;
import java.util.*;

public class z_6 {
    public static String read() {
        StringBuilder a = new StringBuilder();
        try (FileReader reader = new FileReader("text6.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                a.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return a.toString();
    }

    public static void write(String a, boolean bo) {
        try (FileWriter writer = new FileWriter("text6.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ArrayList<Double> sm = new ArrayList<Double>();
        String cs = read();
        int k = 0, j = 1, c = 0;
        boolean t3 = true, t4 = true, t5 = true;
        for (int i = 0; i < cs.length(); i++) {
            if (cs.charAt(i) == ';')
                k++;
            if (k == 3 & t3) {
                while (true) {
                    if (cs.charAt(i - j) == ';') {
                        sm.add(Double.parseDouble(cs.substring(i - j + 2, i)));
                        j = 1;
                        t3 = false;
                        break;
                    }
                    j++;
                }
            }
            if (k == 4 & t4) {
                while (true) {
                    if (cs.charAt(i - j) == ';') {
                        sm.add(Double.parseDouble(cs.substring(i - j + 2, i)));
                        j = 1;
                        t4 = false;
                        break;
                    }
                    j++;
                }
            }
            if (k == 5 & t5) {
                while (true) {
                    if (cs.charAt(i - j) == ';') {
                        sm.add(Double.parseDouble(cs.substring(i - j + 2, i)));
                        j = 1;
                        t5 = false;
                        break;
                    }
                    j++;
                }
            }
            if (k == 5) {
                k = 0;
                t3 = true;
                t4 = true;
                t5 = true;
            }
        }
        for (int i = 0; i < sm.size(); i += 3) {
            if (sm.get(i) <= 90 & sm.get(i + 1) <= 2007 & sm.get(i + 2) > 100000) {
                c++;
            }
        }
        write("\nКоличество спортсменов, удовлетворяющих критериям: " + c, true);
    }
}