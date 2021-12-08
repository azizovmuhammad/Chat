package models;

import enums.Role;
import exceptionFile.UserNotFoundException;
import main.User;
import services.DemonstrationService;
import services.RegisterService;
import services.serviceImpl.DemonstrationServiceImpl;
import services.serviceImpl.RegisterServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    private static Scanner scanner;
    public static List<User> users;
    public static User currentUser;

    static RegisterService registerService;
    static DemonstrationService demonstrationService;

    public static void main(String[] args) {

        System.out.println("========== Online Chat ==========");

        User admin = new User(1L,"Ali","Aliev","ali_o2o4","123123",Role.ADMIN,true);
        User user = new User(2L,"Malik","Malikov","malik_o2o4","123456",Role.USER,true);

        users = new ArrayList<>();
        users.add(admin);
        users.add(user);

        while (true) {
            showMainMenu();

            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    signIn();
                    break;

                case 2:
                    signUp();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrect option!");
            }


        }


    }


    private static void showMainMenu() {
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("0. Exit");
    }

    private static void signIn() {

        registerService = new RegisterServiceImpl();
        boolean isSuccess = registerService.signIn();

        if (currentUser.getSignedIn()){
            if (currentUser.getRole().equals(Role.ADMIN)){
                adminMenu();
            }
            else if (currentUser.getRole().equals(Role.USER)){
                userMenu();
            }
        }
    }

    private static void userMenu() {

        scanner = new Scanner(System.in);
        int choice = -1;
        while (currentUser.getSignedIn()){
            System.out.println("\n========== Welcome User Menu ==========");
            System.out.println("1. Send Message");
            System.out.println("2. Send Message Group");
            System.out.println("3. Create New Group");
            System.out.println("4. Add new User in Your Group");
            System.out.println("5. Change the Password");
            System.out.println("0. Exit");

            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (users.size() == 0) {
                            System.out.println("No User Yet!");
                            break;
                        }
                        sendMess();
                        break;
                    case 2:
                        sendMessGr();
                        break;
                    case 3:
                        createGr();
                        break;
                    case 4:
                        addUser();
                        break;
                    case 5:
                        changePassUser();
                        break;
                    default:
                        break;

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private static void changePassUser() {

    }

    private static void addUser() {

    }

    private static void createGr() {

    }

    private static void sendMessGr() {

    }

    private static void sendMess() {

    }




    private static void adminMenu() {

        scanner = new Scanner(System.in);
        int choice = -1;
        while(currentUser.getSignedIn()){
            System.out.println("\n========== Welcome Admin Menu ==========");
            System.out.println("1. View the User");
            System.out.println("2. Block the User");
            System.out.println("3. Active the User");
            System.out.println("4. Delete the User");
            System.out.println("5. Change the Password");
            System.out.println("0. Exit");

            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (users.size() == 0) {
                            System.out.println("No User Yet!");
                            break;
                        }
                        viewUser();
                        break;
                    case 2:
                        blockUser();
                        break;
                    case 3:
                        activeUser();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    case 5:
                        changePassAdmin();
                        break;
                    default:
                        break;

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

}

    private static void changePassAdmin() {

    }

    private static void deleteUser() {

    }

    private static void activeUser() {

    }

    private static void blockUser() {

    }

    private static void viewUser() {

    }


    private static void signUp() {
        registerService = new RegisterServiceImpl();
        boolean isSuccess = registerService.signUp();
        try {
            if (isSuccess)
                System.out.println("Success");
        } catch (UserNotFoundException userNotFoundException){
            System.out.println("User Not Found!!!");
        }

    }
}

