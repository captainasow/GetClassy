import java.util.Calendar;

public class Person
{
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;
    static private int IDSeed = 1;


    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    public String getFirstName() {
        return firstName;
    }
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }
    public Person(String firstName, String lastName, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = this.genIDNum();
        this.title = title;
        this.YOB = YOB;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    private String genIDNum() {
        String newID = "" + IDSeed;
        while (newID.length() < 8)
            newID = "0" + newID;

        IDSeed++;

        return newID;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }


    public String fullName() {
        return firstName + ' ' + lastName;
    }

    public String formalName() {
        return title + ' ' + fullName();
    }

    public int getAge() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) - YOB;
    }
    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSVDataRecord() {

        return ID + ", " + firstName + ", " + lastName + ", " + title + ", "  + YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

}
