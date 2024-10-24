package lab7.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles = new ArrayList<>();

    public ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    /**
     * Override the visitFile method to find all .java and .class files
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        // Check if the file has a .java or .class extension
        if (file.toString().endsWith(".java") || file.toString().endsWith(".class")) {
            javaFiles.add(file); // Add the file to the list
        }
        return FileVisitResult.CONTINUE; // Continue walking the file tree
    }

    public static void main(String[] args) {

        Path startingDir = Paths.get("./src/lab7");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        /*
         * The walkFileTree method does a depth-first traversal of a directory, starting from startingDir.
         * When it reaches a file, the visitFile method is invoked on the currently visited file.
         */
        try {
            Files.walkFileTree(startingDir, filesVisitor);
            ArrayList<Path> javaFiles = filesVisitor.getJavaFiles();

            // Print the number of files visited
            System.out.println("Number of Java-related files: " + javaFiles.size());

            // Print the names of the files visited
            for (Path file : javaFiles) {
                System.out.println(file.getFileName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
