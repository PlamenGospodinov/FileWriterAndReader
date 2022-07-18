import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Saves the current timestamp in a randomly named file each minute
 */
public class FileTimestampWriter {
    static Random random = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<String> fileNamesExisting = new ArrayList<>();
        while (true) {
            String time = LocalDateTime.now().withNano(0).toString();

            String randomName = "file" + random.nextInt(9999);
            while (fileNamesExisting.contains(randomName)) {
                randomName = "file" + random.nextInt(9999);
            }
            fileNamesExisting.add(randomName);
            Path fileName = Path.of(
                    "data/" + randomName + ".txt");
            System.out.println(fileName);
            Files.writeString(fileName, time);
            System.out.println("Successfully saved a new file with the current timestamp!");
            Thread.sleep(60000);
        }
    }
}
