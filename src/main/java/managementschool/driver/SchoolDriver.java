package managementschool.driver;

import java.util.Scanner;
import managementschool.entity.School;
import managementschool.entity.Student;
import managementschool.entity.Teacher;
import managementschool.service.SchoolService;
import managementschool.service.StudentService;
import managementschool.service.TeacherService;

public class SchoolDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SchoolService schoolService = new SchoolService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        while (true) {
            System.out.println("\n===== School Management Menu =====");
            System.out.println("1. Add School");
            System.out.println("2. View All Schools");
            System.out.println("3. Update School");
            System.out.println("4. Delete School");
            System.out.println("5. Add Student");
            System.out.println("6. View All Students");
            System.out.println("7. Add Teacher");
            System.out.println("8. View All Teachers");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter School ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter School Name: ");
                    String sname = sc.nextLine();
                    System.out.print("Enter School Address: ");
                    String saddr = sc.nextLine();
                    School school = new School(sid, sname, saddr);
                    schoolService.save(school);
                    break;

                case 2:
                    schoolService.getAllSchools();
                    break;

                case 3:
                    System.out.print("Enter School ID to update: ");
                    int usid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New School Name: ");
                    String usname = sc.nextLine();
                    System.out.print("Enter New School Address: ");
                    String usaddr = sc.nextLine();
                    schoolService.update(new School(usid, usname, usaddr));
                    break;

                case 4:
                    System.out.print("Enter School ID to delete: ");
                    int dsid = sc.nextInt();
                    schoolService.delete(dsid);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int stid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String stname = sc.nextLine();
                    System.out.print("Enter Student Age: ");
                    int stage = sc.nextInt();
                    sc.nextLine();
                    studentService.save(new Student(stid, stname, stage));
                    break;

                case 6:
                    studentService.getAllStudents();
                    break;

                case 7:
                    System.out.print("Enter Teacher ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Teacher Name: ");
                    String tname = sc.nextLine();
                    System.out.print("Enter Teacher Subject: ");
                    String tsub = sc.nextLine();
                    teacherService.save(new Teacher(tid, tname, tsub));
                    break;

                case 8:
                    teacherService.getAllTeachers();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
