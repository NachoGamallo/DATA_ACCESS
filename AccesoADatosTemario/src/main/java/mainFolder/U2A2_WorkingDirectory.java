package mainFolder;

import java.io.File;
import java.io.IOException;

public class U2A2_WorkingDirectory {

    public static void main(String[] args) throws IOException, InterruptedException, IOException {

        String command;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            command = "cmd /c dir";
        } else {
            command = "sh -c ls";
        }

        //Ex1
        ProcessBuilder pb = new ProcessBuilder(command.split("\\s"));
        pb.inheritIO();

        System.out.println("Working directory: " + pb.directory());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));

        pb.start().waitFor();


        //Ex2
        System.setProperty("user.dir", System.getProperty("user.home"));

        pb = new ProcessBuilder(command.split("\\s"));
        pb.inheritIO();

        System.out.println("Working directory: " + pb.directory());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));


        pb.start().waitFor();


        //Ex3

        pb = new ProcessBuilder(command.split("\\s"));
        pb.inheritIO();

        pb.directory(new File(System.getProperty("user.home")));
        System.out.println("Working directory: " + pb.directory());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));
        
        pb.start().waitFor();
    }
}
