import java.util.Timer;

/**
 * Starts the application with a timer which executes the program every 60 seconds(1 minute)
 * as there may be new files saved
 */
public class Application {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new FileTimestampReader(), 0, 60000);
    }
}
