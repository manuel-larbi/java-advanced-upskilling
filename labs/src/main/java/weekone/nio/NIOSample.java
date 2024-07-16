package weekone.nio;

import weekone.nio.excercise1.NIOReadFile;
import weekone.nio.excercise1.NIOWriteFile;
import weekone.nio.excercise2.NIOReadAndWriteFile;

public class NIOSample {

    private static final String INPUT_FILE_PATH = "src/main/util/data.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/util/newFile.txt";

    public static void main(String[] args) {
        NIOWriteFile nioWriteFile = new NIOWriteFile();
        nioWriteFile.readFileAndWriteToFile("test", INPUT_FILE_PATH);

        NIOReadFile nioReadFile = new NIOReadFile();
        System.out.println("Printing the readFile.....");
        nioReadFile.readFile(INPUT_FILE_PATH);

        NIOReadAndWriteFile nioReadAndWriteFile = new NIOReadAndWriteFile();
        nioReadAndWriteFile.readFileAndWriteToFile(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        System.out.println("Printing the new readfile...");
        nioReadFile.readFile(OUTPUT_FILE_PATH);
    }
}
