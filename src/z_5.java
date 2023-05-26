import java.io.*;

public class z_5 {
    public static boolean isAbbreviation(String word) {
        return word.matches("[A-ZА-Я]+");
    }

    public static boolean hasAbbreviations(String sentence) {
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            if (isAbbreviation(word)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String firstFilePath = "text5_1.txt";
        String secondFilePath = "text5_2.txt";

        try (BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFilePath));
             BufferedWriter secondFileWriter = new BufferedWriter(new FileWriter(secondFilePath, true))) {

            String line;
            while ((line = firstFileReader.readLine()) != null) {
                String[] sentences = line.split("[.!?]+");

                for (String sentence : sentences) {
                    if (hasAbbreviations(sentence)) {
                        secondFileWriter.write(sentence.trim());
                        secondFileWriter.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
