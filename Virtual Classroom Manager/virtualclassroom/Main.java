package virtualclassroom;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Setup logger to print to console with a simple formatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);

        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("********************************");
            System.out.println("Virtual Classroom Manager");
            System.out.println("********************************");
            System.out.println("1. Add Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Schedule Assignment");
            System.out.println("4. Submit Assignment");
            System.out.println("5. List Classrooms");
            System.out.println("6. List Students in Classroom");
            System.out.println("7. Remove Classroom");
            System.out.println("8. View Classroom Details");
            System.out.println("9. Quit");
            System.out.println("=============================");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter classroom name: ");
                    String className = sc.nextLine();
                    logger.log(Level.INFO, "Received command: add_classroom " + className);
                    manager.addClassroom(className);
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    String studentID = sc.nextLine();
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    logger.log(Level.INFO, "Received command: add_student " + studentID + " " + className);
                    manager.addStudent(studentID, className);
                    break;

                case 3:
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    System.out.print("Enter assignment details: ");
                    String assignmentDetails = sc.nextLine();
                    logger.log(Level.INFO, "Received command: schedule_assignment " + className + " " + assignmentDetails);
                    manager.scheduleAssignment(className, assignmentDetails);
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    studentID = sc.nextLine();
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    System.out.print("Enter assignment details: ");
                    String assignmentDetail = sc.nextLine();
                    logger.log(Level.INFO, "Received command: submit_assignment " + studentID + " - " + className + " - " + assignmentDetail);
                    manager.submitAssignments(studentID, className, assignmentDetail);
                    break;

                case 5:
                    logger.log(Level.INFO, "Received command: list_classrooms");
                    manager.listClassrooms();
                    break;

                case 6:
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    logger.log(Level.INFO, "Received command: list_students " + className);
                    manager.listStudents(className);
                    break;

                case 7:
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    logger.log(Level.INFO, "Received command: remove_classroom " + className);
                    manager.removeClassroom(className);
                    break;

                case 8:
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    logger.log(Level.INFO, "Received command: view_classroom " + className);
                    viewClassroomDetails(className, manager);
                    break;

                case 9:
                    logger.log(Level.INFO, "Received command: quit");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println("Exiting Virtual Classroom Manager...");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void viewClassroomDetails(String className, VirtualClassroomManager manager) {
        logger.log(Level.INFO, "Viewing Classroom Details: " + className);
        System.out.println("View Classroom Details");
        System.out.println("-----------------------");
        System.out.println("Classroom: " + className);

        if (manager.getClassrooms().containsKey(className)) {
            Classroom classroom = manager.getClassrooms().get(className);
            System.out.println("Students:");
            for (String student : classroom.getStudents()) {
                System.out.println(student);
            }
            System.out.println("Assignments:");
            for (String assignment : classroom.getAssignments()) {
                System.out.println(assignment);
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
