package javase03.t01.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CrazyLogger {
    public static final String PATTERN_STANDARD = "dd-mm-YYYY: hh-mm";
    StringBuilder logs;

    public CrazyLogger() {
        logs = new StringBuilder();
    }

    public void log(String message) {
        logs.append(String.format("%s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_STANDARD)), message));
        logs.append('\n');
    }

    public void printLogs(int count) {
        if (count < 1)
            return;

        /*
        сложная реализация без создания копии всех логов

        int index = logs.indexOf("\n", 0);
        int prevIndex = index;
        System.out.println(logs.substring(0, index));
        int counter = 1;

        while (counter < count && prevIndex + 1 < logs.length()) {
            index = logs.indexOf("\n", prevIndex + 1);
            System.out.println(logs.substring(prevIndex + 1, index));
            ++counter;
            prevIndex = index;
        }
        */

        String[] sLogs = logs.toString().split("\n");
        for (int i = 0; i < count && i < sLogs.length; i++) {
            System.out.println(sLogs[i]);
        }
    }

    public void printLogs() {
        System.out.println(logs.toString());
    }

    public String[] searchByMessage(boolean print, String... messages) {
        String[] sLogs = logs.toString().split("\n");
        List<String> find = new ArrayList<>();

        for (String log : sLogs) {
            for (String message : messages) {
                if (log.toLowerCase().contains(message.toLowerCase())) {
                    if (print)
                        System.out.println(log);
                    find.add(log);
                    break;
                }
            }
        }

        return find.size() == 0 ? new String[]{""} : find.toArray(new String[find.size()]);
    }

    public String[] searchByDate(boolean print, String pattern, LocalDateTime... dates) {
        String[] sLogs = logs.toString().split("\n");
        List<String> find = new ArrayList<>();

        if (pattern == null)
            return new String[]{""};

        for (String log : sLogs) {
            for (LocalDateTime date : dates) {
                try {
                    if (log.toLowerCase().contains(date.format(DateTimeFormatter.ofPattern(pattern)).toLowerCase())) {
                        if (print)
                            System.out.println(log);
                        find.add(log);
                        break;
                    }
                } catch (DateTimeParseException e) {
                    if (print)
                        System.out.println("Wrong pattern!");
                    log("WRONG PATTERN!");
                    return find.size() == 0 ? new String[]{""} : find.toArray(new String[find.size()]);
                }
            }
        }

        return find.size() == 0 ? new String[]{""} : find.toArray(new String[find.size()]);
    }
}
