package weekone.nio.excercise1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOReadFile {
    public void readFile(String filePath) {
        Path file = Paths.get(filePath);

        try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {
            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead;
            do {
                // Attempt to read data into the buffer (might not read all requested bytes)
                bytesRead = channel.read(buffer);

                // Process the read data (e.g., print or write to another file)
                if (bytesRead > 0) {
                    // Handle data processing here
                    System.out.println(new String(buffer.array(), 0, bytesRead));
                    buffer.clear(); // Prepare the buffer for the next read operation
                }
            } while (bytesRead > 0); // Continue reading until EOF
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
