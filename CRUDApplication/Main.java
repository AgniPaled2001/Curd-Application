package CRUDApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentClass{
    private int studId;
    private String studName;
    private String studEmailId;
    private char studGrade;
    private long studNumber;
    
     static HashMap<Integer,StudentClass> studentData=new HashMap<>();
    static int countStudent=1;

    public int getStudId(){
        return studId;
    }
    public void setStudId(int studId) {
        this.studId = studId;
    }
    public String getStudName() {
        return studName;
    }
    public void setStudName(String studName) {
        this.studName = studName;
    }
    public String getStudEmailId() {
        return studEmailId;
    }
    public void setStudEmailId(String studEmailId) {
        this.studEmailId = studEmailId;
    }
    public char getStudGrade() {
        return studGrade;
    }
    public void setStudGrade(char studGrade) {
        this.studGrade = studGrade;
    }
    public long getStudNumber() {
        return studNumber;
    }
    public void setStudNumber(long studNumber) {
        this.studNumber = studNumber;
    }
}
public class Main {

    public static void toCreateANewStudent(){
        System.out.println("Welcome - creating a new student");
        Scanner input =new Scanner(System.in);
        StudentClass obj=new StudentClass();
        obj.setStudId(StudentClass.countStudent);
        System.out.println("Student ID :"+obj.getStudId());

        System.out.print("Enter Student name:");
        obj.setStudName(input.next());
        System.out.print("Enter Student Email:");
        obj.setStudEmailId(input.next());
        System.out.print("Enter Student Grade:");
        obj.setStudGrade(input.next().charAt(0));
        System.out.print("Enter Student Number");
        obj.setStudNumber(input.nextLong());
        StudentClass.studentData.put(obj.getStudId(),obj);
        StudentClass.countStudent++;
        System.out.println("Thank you-Student creation Successfully");
        toDisplayAllStudent();
        
   }
    public static void toRemoveStudent(){
        System.out.println("Welcome - Remove a student");
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the Id of the student to be removed");
        int id=input.nextInt();
        if(StudentClass.studentData.containsKey(id)){
            StudentClass.studentData.remove(id);
            System.out.println("Student Is Removed Successfully");
        }else{
            System.out.println("Student does not exist with this ID!!!!\n");
        }

    }
    public static void toUpdateANewStudent(){
        System.out.println("Welcome - Update the Student");
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the Id of the student to be updated");
        int id=input.nextInt();
        if(StudentClass.studentData.containsKey(id)){
            System.out.println("1.Update Name");
            System.out.println("2.Update Email");
            System.out.println("3.Update Grade");
            System.out.println("4.Update Number");
            System.out.print("Enter the choice");
            int choice=input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Updated Name");
                    String name=input.next();
                    StudentClass.studentData.get(id).setStudName(name);
                    break;
                case 2:
                    System.out.println("Enter the Updated email");
                    String email=input.next();
                    StudentClass.studentData.get(id).setStudEmailId(email);
                    break;
                case 3:
                    System.out.println("Enter the Updated grade");
                    char grade=input.next().charAt(0);
                    StudentClass.studentData.get(id).setStudGrade(grade);
                    break;
                case 4:
                    System.out.println("Enter the Updated Number");
                    long number=input.nextLong();
                    StudentClass.studentData.get(id).setStudNumber(number);
                    break;    
                default:
                    System.out.println("Invalid choice!!!!");
                    return;
            }
            System.out.println("Student data updated Successfully!!!!!\n");
            toDisplayAllStudent();
        }else{
            System.out.println("Student Does not Exist with this id!!!!\n");
        }
   }
   public static void toDisplayAllStudent(){
       System.out.println("----------------------------------------------------------------------------------------------");
       System.out.println("Student ID\t\tStudent Name\t\tStudent Email\t\tStudent Grade\t\t Student Number");
       System.out.println("----------------------------------------------------------------------------------------------");
       for(Map.Entry<Integer,StudentClass> studentData: StudentClass.studentData.entrySet()){
       System.out.print(studentData.getKey()+"\t\t\t");
       System.out.print(studentData.getValue().getStudName()+"\t\t");
       System.out.print(studentData.getValue().getStudEmailId()+"\t\t");
       System.out.print(studentData.getValue().getStudGrade()+"\t\t");
       System.out.println(studentData.getValue().getStudNumber());
      }
      System.out.println("----------------------------------------------------------------------------------------------");

   }
   public static void toSearchAStudent(){
          System.out.println("Welcome-Search a student");
          Scanner input=new Scanner(System.in);

          System.out.println("Enter the id of the student to be searched");
          int id=input.nextInt();

          if(StudentClass.studentData.containsKey(id)){
            System.out.println("Student Name:"+StudentClass.studentData.get(id).getStudName());
            System.out.println("Student Email:"+StudentClass.studentData.get(id).getStudEmailId());
            System.out.println("Student Grade:"+StudentClass.studentData.get(id).getStudGrade());
            System.out.println("Student Number:"+StudentClass.studentData.get(id).getStudNumber());
            System.out.println("Student data is displayed Successfully!!!!\n");
          }
          else{
            System.out.println("Student Does not have to exist!!!!!\n");
          }
        //   input.close();
   }


    private static void printMenu(){
        System.out.println("1:To create new student");
        System.out.println("2:To remove student data");
        System.out.println("3:To update a student");
        System.out.println("4:To display all a student data");
        System.out.println("5:To search a student");
        System.out.println("6:To exit application");
        System.out.println("Enter a choice");
    }

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        Boolean flag=true;
        System.out.println("\t\t\tStudent database Application\n");

        while (flag) {
            printMenu();
            int choice=input.nextInt();

            switch (choice) {
                case 1:
                    toCreateANewStudent();
                    break;
                case 2:
                    toRemoveStudent();
                    break;
                case 3:
                    toUpdateANewStudent();
                    break;
                case 4:
                    toDisplayAllStudent();
                    break;
                case 5:
                    toSearchAStudent();
                    break;
                case 6:
                    flag =false;
                    break;
                default:
                    System.err.println("Invalid Choice");
            }
        }
        System.out.println("Have a Nice Day");
        // input.close();
    }
}
