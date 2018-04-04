package javase05.t01.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Explorer {
    File currentDirectory;
    File[] directories;

    final String[] commands = {"cd", "edit", "pwm", "ls"};

    public Explorer() {
        currentDirectory = new File(System.getProperty("user.dir"));
        directories = currentDirectory.listFiles();
    }

    public void printCurrentDirectory() {
        System.out.println(currentDirectory.getPath());
    }

    public void printFilesAndDrirectories() {
        directories = currentDirectory.listFiles();
        if (directories == null)
            return;

        for (int i = 0; i < directories.length; i++) {
            String[] files = directories[i].getPath().split("\\\\|/");
            if (directories[i].listFiles() == null)
                System.out.println(String.format("f %s", files[files.length - 1]));
            else
                System.out.println(String.format("d %s\\", files[files.length - 1]));
        }
    }

    public boolean changeDirectory(String dir){
        for (int i = 0; i < directories.length; i++) {
            if (directories[i].listFiles() == null)
                continue;
            String[] files = directories[i].getPath().split("\\\\|/");
            if (files[files.length-1].equalsIgnoreCase(dir)){
                currentDirectory = directories[i];
                directories = currentDirectory.listFiles();
                return true;
            }
        }
        return false;
    }
}
