import java.io.*;
public class z_2 {
    public static void file(String a,boolean bo) {
        try(FileWriter writer = new FileWriter("text2.txt", bo))
        {
            writer.write(a);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        file("",false);
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                file(i+"-"+j+"="+(i-j)+" "+"\t",true);
            }
            file("\n",true);
        }
    }
}