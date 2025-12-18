package studentmanagement;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== STUDENT MANAGER ======");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Update student");
            System.out.println("4. Deactivate student");
            System.out.println("5. Show all students");
            System.out.println("6. Search student");
            System.out.println("7. Clear all");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter group: ");
                String group = sc.nextLine();

                System.out.print("Enter score: ");
                double score = Double.parseDouble(sc.nextLine());

                studentManager.addStudent(name, group, score);

            } else if (choice == 2) {

                System.out.print("Enter id: ");
                int idToRemove = Integer.parseInt(sc.nextLine());

                studentManager.removeStudent(idToRemove);

            } else if (choice == 3) {

                System.out.print("Enter id: ");
                int idToUpdate = Integer.parseInt(sc.nextLine());

                System.out.print("Enter new name: ");
                String newName = sc.nextLine();

                System.out.print("Enter new group: ");
                String newGroup = sc.nextLine();

                System.out.print("Enter new score: ");
                double newScore = Double.parseDouble(sc.nextLine());

                studentManager.updateStudent(
                        idToUpdate,
                        newName,
                        newGroup,
                        newScore
                );

            } else if (choice == 4) {

                System.out.print("Enter id: ");
                int idToDeactivate = Integer.parseInt(sc.nextLine());

                studentManager.deactivateStudent(idToDeactivate);

            } else if (choice == 5) {

                studentManager.showAll();

            } else if (choice == 6) {

                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();

                studentManager.search(keyword);

            } else if (choice == 7) {

                studentManager.clearAll();

            } else if (choice == 8) {

                System.out.println("Program exited.");
                sc.close();
                return;

            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
