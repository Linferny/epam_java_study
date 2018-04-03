package javase04.t03.logic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEncodingChanger {
    public static void changeEncodingToUTF16(String fileName) {
        File file = new File(fileName);

        StringBuilder text = new StringBuilder();

        try (Reader in = new InputStreamReader(new FileInputStream(file), "UTF8")) {
            char[] buffer = new char[256];
            int countChar;
            while (in.ready()) {
                countChar = in.read(buffer);
                text.append(new String(buffer, 0, countChar));
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF8")) {
            String utf16 = new String(text.toString().getBytes("UTF8"), "UTF16");

            System.out.println(String.format("UTF8 string: %s", text));
            System.out.println(String.format("UTF8 bytes converted to UTF16: %s", utf16));
            System.out.println(String.format("UTF16 string converted back to UTF8: %s", new String(utf16.getBytes("UTF16"), "UTF8")));

            writer.write(utf16);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void generateFileWithUTF8(String fileName) {
        File file;
        file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.getParentFile() != null)
                    Files.createDirectories(Paths.get(file.getPath()).getParent());
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF8"))) {
            writer.write(new String("Test text in UTF8 Encoding!".getBytes(), Charset.forName("UTF8")));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
