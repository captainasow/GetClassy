import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String[] words;
        ArrayList<Person> people = new ArrayList<>();
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);


                String header = String.format("ID#   Firstname  Lastname  Title  YOB");
                String underline = String.format("==============================================");
                System.out.println(header);
                System.out.println(underline);

                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    words = line.split(", ");
                    System.out.println(words[0] + "   " + words[1] + "    " + words[2] + "   " + words[3] + "   " + words[4]);
                    people.add(new Person(words[1], words[2], words[0], words[3], Integer.parseInt(words[4])));
                }

                System.out.println(people);

                inFile.close();
            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}
