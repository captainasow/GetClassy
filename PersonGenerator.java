import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> records = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");



        boolean done = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {

            ID = SafeInput.getNonZeroLenString(sc, "Enter the ID [6 Digits]");
            firstName = SafeInput.getNonZeroLenString(sc, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(sc, "Enter the last name");
            title = SafeInput.getNonZeroLenString(sc, "Enter the title");
            YOB = SafeInput.getRangedInt(sc, "Enter the year of birth ", 1000, 9999);

            Person personRec = new Person(firstName, lastName, ID, title, YOB);
            records.add(personRec);

            done = SafeInput.getYNConfirm(sc, "Are you done?");
        } while (!done);

        for( Person p: records)
            System.out.println(p.toCSVDataRecord());



        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
           OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person rec : records)
            {
                writer.write(rec.toCSVDataRecord(), 0, rec.toCSVDataRecord().length());
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
