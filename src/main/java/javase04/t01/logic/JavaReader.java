package javase04.t01.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class JavaReader {
    static final String[] keywords = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"};

    public JavaReader() {

    }

    public void analyzeJavaCode(String resultFileName){
        String fileName = "javase04.t01/Pen";
        checkForKeyWords(readFromFile(fileName), resultFileName);
    }

    private void checkForKeyWords(String javaCode, String fileName) {
        StringBuilder regex = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < keywords.length - 1; i++) {
            map.put(keywords[i], 0);
            regex.append(keywords[i]);
            regex.append("|");
        }

        regex.append(keywords[keywords.length - 1]);
        map.put(keywords[keywords.length - 1], 0);

        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(javaCode);

        while (matcher.find()) {
            map.replace(matcher.group(), map.get(matcher.group()) + 1);
        }

        StringBuilder toWrite = new StringBuilder();

        for (int i = 0; i < keywords.length; i++) {
            int count = map.get(keywords[i]);
            if (count > 0) {
                String res = String.format("%10s: %d", keywords[i], count);
                toWrite.append(res);
                toWrite.append("\n");
                System.out.println(res);
            }
        }

        File file;
        file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.getParentFile() != null)
                    Files.createDirectories(Paths.get(file.getPath()).getParent());
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(new String(e.toString().getBytes(Charset.forName("CP1251")), Charset.forName("CP1252")));
            }
        }

        try (OutputStream outputStream = new FileOutputStream(file, false)) {
            outputStream.write(toWrite.toString().getBytes(Charset.forName("CP1251")));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String readFromFile(String fileName) {
        StringBuilder javaCode = new StringBuilder();
        File file;
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(fileName).getFile());

        try (InputStream inputStream = new ByteArrayInputStream(new FileInputStream(file).readAllBytes())) {
            javaCode.append(new String(inputStream.readAllBytes(), Charset.forName("CP1251")));
        } catch (IOException e) {
            System.out.println(e);
        }
        return javaCode.toString();
    }
}
