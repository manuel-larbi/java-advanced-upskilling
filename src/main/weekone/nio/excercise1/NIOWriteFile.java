package weekone.nio.excercise1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOWriteFile {
    public void readFileAndWriteToFile(String input, String outputFilePath) {
        Path outputFile = Paths.get(outputFilePath);

        try (FileChannel writeChannel = FileChannel.open(outputFile, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // Convert input string to byte array
            byte[] inputBytes = input.getBytes();

            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.wrap(inputBytes);

            // Write the buffer content to the output file
            while (buffer.hasRemaining()) {
                writeChannel.write(buffer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
