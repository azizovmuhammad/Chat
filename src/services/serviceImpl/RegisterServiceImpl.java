package services.serviceImpl;

import enums.Role;
import main.User;
import models.Main;
import services.RegisterService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RegisterServiceImpl implements RegisterService {

    static Scanner scanner;

    @Override
    public boolean signUp() {

        System.out.println("Welcome to Our Registration Service");
        scanner = new Scanner(System.in);
        System.out.println("Enter your FirsName: ");
        String firstname = scanner.nextLine();

        System.out.println("Enter your LastName: ");
        String lastname = scanner.nextLine();

        System.out.println("Enter your UserName: ");
        String username = scanner.next();

        System.out.println("Enter your Password: ");
        String password = scanner.next();

        System.out.println("Choose your Role: ");
        int indexOfRole = 1;
        for (Role value : Role.values()) {
            System.out.println(indexOfRole + ". " + value);
            indexOfRole++;
        }

        int roleIndex = scanner.nextInt();
        Role role = Role.values()[roleIndex-1];

        List<User> users = Main.users;
        int lastIndex = users.size() + 1;


        User newUser = new User(Long.valueOf(lastIndex),firstname,lastname,username,password,role,false);

        Main.users.add(newUser);
        return true;
    }

    @Override
    public boolean signIn() {

        scanner = new Scanner(System.in);
        System.out.print("Enter your UserName: ");
        String userName = scanner.next();
        System.out.print("Enter your Password: ");
        String password = scanner.next();
        int counter = 0;

        for (User user : Main.users) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                Main.currentUser = user;
                return true;
            }
            counter++;
        }
        if (counter == 0) {
            System.out.println("This Username not found!!!");
        }
        else {
            System.out.println("Password is Wrong!!!");
        }
        return false;
        }
}

