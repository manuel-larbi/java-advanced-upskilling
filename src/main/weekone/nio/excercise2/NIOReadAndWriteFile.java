package weekone.nio.excercise2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOReadAndWriteFile {
    public void readFileAndWriteToFile(String inputFilePath, String outputFilePath) {
        Path inputFile = Paths.get(inputFilePath);
        Path outputFile = Paths.get(outputFilePath);

        try (FileChannel readChannel = FileChannel.open(inputFile, StandardOpenOption.READ);
             FileChannel writeChannel = FileChannel.open(outputFile, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead;
            do {
                // Attempt to read data into the buffer (might not read all requested bytes)
                bytesRead = readChannel.read(buffer);

                // Process the read data and write it to the output file
                if (bytesRead > 0) {
                    buffer.flip(); // Switch the buffer from writing mode to reading mode
                    writeChannel.write(buffer); // Write buffer content to the output file
                    buffer.clear(); // Prepare the buffer for the next read operation
                }
            } while (bytesRead > 0); // Continue reading until EOF

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
