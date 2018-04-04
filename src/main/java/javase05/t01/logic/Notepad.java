package javase05.t01.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notepad {
    File file;
    boolean readyToEdit;
    List<String> textLines;

    public Notepad(String path) {
        file = new File(path);
    }

    public void loadFile() {
        readyToEdit = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                textLines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        readyToEdit = true;
    }

    public void printFile() {
        if (!readyToEdit)
            return;
        for (String s : textLines)
            System.out.println(s);

    }

    public void writeFile() {
        if (!readyToEdit)
            return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : textLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        readyToEdit = false;
        textLines = null;
        file = null;
    }

    public void addText(String text) {
        if (!readyToEdit)
            return;
        textLines.add(text);
    }

    public String getText(int lineNumber) {
        if (!readyToEdit || lineNumber < 0 || lineNumber >= textLines.size())
            return "";
        return textLines.get(lineNumber);
    }

    public boolean editText(int lineNumber, String text){
        if (!readyToEdit || lineNumber < 0 || lineNumber >= textLines.size())
            return false;
        textLines.set(lineNumber, text);
        return true;
    }

    public boolean deleteLine(int lineNumber){
        if (!readyToEdit || lineNumber < 0 || lineNumber >= textLines.size())
            return false;
        textLines.remove(lineNumber);
        return true;
    }

}
