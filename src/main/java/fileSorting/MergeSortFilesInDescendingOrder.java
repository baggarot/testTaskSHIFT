package fileSorting;

import lombok.NoArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor
public class MergeSortFilesInDescendingOrder {

    private int positionA = 0;
    private int positionB = 0;

    public void writingAFile(String files, String files1, String files2) {
        try (FileWriter writer = new FileWriter(files)) {
            ReadingAFile file = new ReadingAFile();
            int[] array = mergeSortDescending(Objects.requireNonNull(file.readingAFileFromIntegers(files1)),
                    Objects.requireNonNull(file.readingAFileFromIntegers(files2)));
            for (int j : array) {
                String str = Integer.toString(j);
                writer.write(str);
                writer.append('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writingLinesToAFile(String file, String file1, String file2) {
        try (FileWriter writer = new FileWriter(file)) {
            ReadingAFile readingAFile = new ReadingAFile();
            String[] array = mergeSortDescendingRows(readingAFile.readingAFileFromLines(file1),
                    readingAFile.readingAFileFromLines(file2));
            for (String str : array) {
                writer.write(str);
                writer.append('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int[] mergeSortDescending(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        for (int i = arrayC.length - 1; i >= 0; i--) {
            if (positionA > arrayA.length - 1) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB > arrayB.length - 1) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }

    private String[] mergeSortDescendingRows(String[] arrayA, String[] arrayB) {
        String[] arrayC = new String[arrayA.length + arrayB.length];
        for (int i = arrayC.length - 1; i >= 0; i--) {
            if (positionA > arrayA.length - 1) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB > arrayB.length - 1) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA].length() < arrayB[positionB].length()) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }
}