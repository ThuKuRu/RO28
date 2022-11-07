package utils;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLOutput;

import static jdk.xml.internal.SecuritySupport.isFileExists;

public class FileManager {
    public static boolean isFileExits(String pathFile){
        return new File(pathFile).exists() ? true : false;
    }

    public static boolean isFolderExits(String pathFolder){
        return new File(pathFolder).exists() ? true : false;
    }

    public void createNewFile(String pathFile) throws Exception{
        if(isFileExits(pathFile)){
            throw new Exception(" Error! File Exist.");
        }
        boolean result = new File(pathFile).createNewFile();
        System.out.println(result ? " Create file success."
                                    : " Create file fail.");
    }

    public void createNewFile(String path, String fileName) throws Exception{
        String pathFile = path + fileName;
        createNewFile(pathFile);
    }

    public void deleteFile(String pathFile) throws Exception{
        if(!isFileExits(pathFile)){
            throw new Exception(" Error! File Not Exist.");
        }
        boolean result = new File(pathFile).delete();
        System.out.println(result ? " Delete file success."
                                  : " Delete file fail.");

    }

    public static boolean isFolder(String pathFile){
        File file = new File(pathFile);
        return file.isDirectory();
    }

    public static void isFolderOrFile(String pathFile) throws Exception{
        File file = new File(pathFile);
        if (file.isDirectory()) {
            System.out.println(" This is a foder");
        } else if (file.isFile()) {
            System.out.println(" This is a file");
        } else {
            throw new Exception(" Error! Path is not folder.");
        }
    }

    public static String[] getAllFileName(String path) throws Exception{
        File file = new File(path);
        if (!isFolder(path)) {
            throw new Exception(" Error! Path is not folder.");
        } else {
            return file.list();
        }
    }

    public static void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
        File file = new File(sourceFile);
        if(!isFileExits(sourceFile)){
            throw new Exception(" Error! File Not Exist.");
        }
        String[] s = sourceFile.split("/");
        newName = s[s.length - 1];
        String destinationNew = distinationPath + "//" + newName;
        if(isFileExits(destinationNew)){
            throw new Exception(" Error! newPath has File same name");
        }
        File source = new File(sourceFile);
        File dest = new File(distinationPath);
        Files.copy(source.toPath(), dest.toPath());

    }

    public static void moveFile(String sourceFile, String destinationPath) throws Exception {
        File file = new File(sourceFile);
        if(!isFileExits(sourceFile)){
            throw new Exception(" Error! File Not Exist.");
        }
        File source = new File(sourceFile);
        File dest = new File(destinationPath);
        Files.move(source.toPath(), dest.toPath());
    }

    public static void renameFile(String pathFile, String newName)throws Exception{
        File file = new File(pathFile);
        if(!isFileExits(pathFile)){
            throw new Exception(" Error! File Not Exist.");
        }
        if(isFileExits(newName)){
            throw new Exception(" Error! Name is Exist.");
        }
        File oldFile = new File(pathFile);
        File newFile = new File(newName);
        oldFile.renameTo(newFile);
    }

    public static void createNewFolder(String newPathFolder) throws Exception {
        if (isFolderExits(newPathFolder)) {
            throw new Exception(" Error! Folder is Exists");
        }
        new File(newPathFolder).mkdir();
    }

}
