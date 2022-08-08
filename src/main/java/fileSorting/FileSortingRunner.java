package fileSorting;

public class FileSortingRunner {

    public static void main(String[] args) {
        MergeSortFilesInAscendingOrder ascending = new MergeSortFilesInAscendingOrder();
        MergeSortFilesInDescendingOrder descending = new MergeSortFilesInDescendingOrder();
        String sortMode;
        String dataType;
        String outputFileName;
        String inputFileName1;
        String inputFileName2;
        if (args.length == 5) {
            sortMode = args[0];
            dataType = args[1];
            outputFileName = args[2];
            inputFileName1 = args[3];
            inputFileName2 = args[4];
            if (sortMode.equals("-a")) {
                if (dataType.equals("-s")) {
                    ascending.writingLinesToAFile(outputFileName, inputFileName1, inputFileName2);
                } else if (dataType.equals("-i")) {
                    ascending.writingToFile(outputFileName, inputFileName1, inputFileName2);
                } else System.out.println("incorrect data type specified");
            } else if (sortMode.equals("-d")) {
                if (dataType.equals("-s")) {
                    descending.writingLinesToAFile(outputFileName, inputFileName1, inputFileName2);
                } else if (dataType.equals("-i")) {
                    descending.writingAFile(outputFileName, inputFileName1, inputFileName2);
                } else System.out.println("incorrect data type specified");
            } else System.out.println("sort mode is incorrect");
        } else if (args.length == 4) {
            dataType = args[0];
            outputFileName = args[1];
            inputFileName1 = args[2];
            inputFileName2 = args[3];
            if (dataType.equals("-s")) {
                ascending.writingLinesToAFile(outputFileName, inputFileName1, inputFileName2);
            } else if (dataType.equals("-i")) {
                ascending.writingToFile(outputFileName, inputFileName1, inputFileName2);
            } else System.out.println("incorrect data type specified");
        } else System.out.println("command entered incorrectly");
    }
}