package javase05.t01.logic;

import lombok.AccessLevel;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Explorer {
    File currentDirectory;
    File[] directories;
    Notepad notepad;

    final String[] commands = {"cd", "edit", "pwd", "ls", "help"};

    public Explorer() {
        notepad = new Notepad();
        currentDirectory = new File(System.getProperty("user.dir"));
        directories = currentDirectory.listFiles();
        printCurrentDirectory();
    }

    public boolean inputCommand() {
        Scanner scanner = getScannerWithSin();
        scanner.useDelimiter("\n");

        String command = scanner.next();
        if (command.matches("^cd.*")) {
            String[] parts = command.split(" ");
            if (parts.length != 2) {
                System.out.println("HELP: cd [directory_name]");
                return true;
            }

            if (changeDirectory(parts[1])) {
                System.out.println("Current directory:");
                printCurrentDirectory();
            }

        } else if (command.matches("^pwd.*")) {
            printCurrentDirectory();
        } else if (command.matches("^ls.*")) {
            printFilesAndDirectories();
        } else if (command.matches("^edit.*")){
            String[] parts = command.split(" ");
            if (parts.length != 2) {
                System.out.println("HELP: edit [file_name]");
                return true;
            }

            openTextFile(parts[1]);
        } else if (command.matches("^exit.*")){
            return false;
        } else {
            System.out.println("List commands:\npwd\ncd [dir]\nedit [file_name]\nls\nexit");
        }
        return true;
    }

    private void printCurrentDirectory() {
        System.out.println(currentDirectory.getPath());
    }

    private void printFilesAndDirectories() {
        directories = currentDirectory.listFiles();
        if (directories == null)
            return;

        if (currentDirectory.getParentFile() != null)
            System.out.println("d ..");

        for (int i = 0; i < directories.length; i++) {
            String[] files = directories[i].getPath().split("\\\\|/");
            if (directories[i].listFiles() == null)
                System.out.println(String.format("f %s", files[files.length - 1]));
            else
                System.out.println(String.format("d %s\\", files[files.length - 1]));
        }
    }

    private boolean changeDirectory(String dir) {
        if (dir.equals("..")) {
            if (currentDirectory.getParentFile() == null)
                return false;
            currentDirectory = currentDirectory.getParentFile();
        }

        for (int i = 0; i < directories.length; i++) {
            if (directories[i].listFiles() == null)
                continue;
            String[] files = directories[i].getPath().split("\\\\|/");
            if (files[files.length - 1].equalsIgnoreCase(dir)) {
                currentDirectory = directories[i];
                directories = currentDirectory.listFiles();
                return true;
            }
        }
        return false;
    }

    private void openTextFile(String fileName) {
        for (int i = 0; i < directories.length; i++) {
            if (directories[i].listFiles() != null)
                continue;
            String[] files = directories[i].getPath().split("\\\\|/");
            if (files[files.length - 1].equalsIgnoreCase(fileName)) {
                if (!notepad.loadFile(directories[i].getPath()))
                    return;
                break;
            }
        }

        Scanner scanner = getScannerWithSin();
        scanner.useDelimiter("\n");

        boolean exit = false;
        System.out.println("Commands: print\nget [line]\nedit [line] [text]\nadd [text]\nwrite\nclose\n----------------------");
        while (!exit) {
            String command = scanner.next();

            if (command.matches("^edit.*")) {
                String[] parts = command.split(" ");
                if (parts.length != 3) {
                    System.out.printf("Wrong command!");
                    continue;
                }
                try {
                    int line = Integer.parseInt(parts[1]);
                    if (!notepad.editText(line, parts[2])) {
                        System.out.printf("Text not edited");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (command.matches("^get.*")) {
                String[] parts = command.split(" ");
                if (parts.length != 2) {
                    System.out.printf("Wrong command!");
                    continue;
                }
                try {
                    int line = Integer.parseInt(parts[1]);
                    System.out.println(notepad.getText(line));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (command.matches("^add.*")) {
                String[] parts = command.split(" ");
                if (parts.length != 2) {
                    System.out.printf("Wrong command!");
                    continue;
                }
                notepad.addText(parts[1]);
            } else if (command.matches("^write.*")) {
                notepad.writeFile();
            } else if (command.matches("^close.*")) {
                notepad.closeFile();
                exit = true;
            } else if (command.matches("^print.*")) {
                notepad.printFile();
            } else{
                System.out.println("Commands: print\nget [line]\nedit [line] [text]\nadd [text]\nwrite\nclose\n----------------------");
            }
        }
    }

    private Scanner getScannerWithSin() {
        return new Scanner(new NonCloseableIn(System.in));
    }

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    class NonCloseableIn extends InputStream {
        @Delegate(excludes = Closeable.class)
        final InputStream in;

        public NonCloseableIn(InputStream in) {
            this.in = in;
        }

        @Override
        public void close() {
        }
    }
}
