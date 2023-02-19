import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int number;
    private static Logger logger = new Logger();

    private Logger() {
    }

    public void log(String msg) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.format("[%10s " + number++ + "] " + msg + '\n', simpleDateFormat.format(date));
    }

    public static Logger getInstance() {
        return logger;
    }
}
