import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TimerTask;

/**
 * A program that reads the text files from the /tmp/data directory.
 * It is made to read from a docker volume, not a local directory.
 */
public class FileTimestampReader extends TimerTask {

    static final private ArrayList<File> files = new ArrayList<>();

    private static void startReading() {
        File folder = new File("/tmp/data");
        update(folder);
    }

    private static void update(final File folder) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.getName().endsWith(".txt")) {
                try {
                    if (!files.contains(fileEntry)) {
                        Scanner sc = new Scanner(fileEntry);
                        String data = sc.nextLine();
                        System.out.println(data);
                        files.add(fileEntry);
                    }

                } catch (Exception e) {
                    System.out.println("There is some kind of mistake!Fix it");
                }
            }
        }
    }

    @Override
    public void run() {
        startReading();
    }
}
