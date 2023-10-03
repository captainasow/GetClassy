public class Main {
    public static void main(String[] args)
    {Person abdoul = new Person("Abdoul", "Sow", "000001", "MR.", 2003);

        System.out.println(abdoul.getAge());
        System.out.println(abdoul.getAge(2010));
        System.out.println(abdoul.toCSVDataRecord());



    }
}