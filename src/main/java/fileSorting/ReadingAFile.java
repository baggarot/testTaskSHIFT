package fileSorting;

import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class ReadingAFile {

    public int[] readingAFileFromIntegers(String files) {
        try (Scanner inputStream = new Scanner(new FileReader(files))) {
            List<Integer> list = new ArrayList<>();
            while (inputStream.hasNext()) {
                String line = inputStream.nextLine();
                if (line.contains(" ")) continue;
                list.add(Integer.valueOf(line));
            }
            inputStream.close();
            int[] array = new int[list.size()];
            for (int i = 0; i < array.length; i++) array[i] = list.get(i);
            return array;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new int[0];
    }

    public String[] readingAFileFromLines(String files) {
        try (Scanner inputStream = new Scanner(new FileReader(files))) {
            List<String> list = new ArrayList<>();
            while (inputStream.hasNext()) {
                String line = inputStream.nextLine();
                if (line.contains(" ")) continue;
                list.add(line);
            }
            inputStream.close();
            String[] array = new String[list.size()];
            for (int i = 0; i < array.length; i++) array[i] = list.get(i);
            return array;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new String[0];
    }
}