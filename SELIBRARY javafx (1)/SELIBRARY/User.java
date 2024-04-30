import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.*;

public class User {
    private String name;
    private int id;
    private String phoneNumber;
    private String gmail;


    File file = new File("User Details.txt");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;





    public User() throws IOException {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    Account a1 = new Account();


    private ArrayList<String> UserName = new ArrayList<>();

    private ArrayList<String> Password = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Login() throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(new FileInputStream(file));
        UserName = (ArrayList<String>) ois.readObject();
        Password = (ArrayList<String>) ois.readObject();
        ois.close();
        System.out.println("Enter UserName and Password for Login");
        System.out.println("Enter UserName ");
        String c, v;
        c = sc.next();
        sc.nextLine();
        System.out.println("Enter Password");
        v = sc.next();
        sc.nextLine();

        if (UserName.contains(c) && Password.contains(v)) {
            System.out.println("User varified");
        } else {
            System.out.println("Invalid password or Username");
            Login();
        }

    }



    void Signup() throws IOException, ClassNotFoundException {
        if(file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            UserName = (ArrayList<String>) ois.readObject();
            Password = (ArrayList<String>) ois.readObject();
            ois.close();
        }
        String a, b;

        System.out.println("Press 1 for Signup");
        System.out.println("press 2 for Login");
        System.out.println();

        int x;


        x = sc.nextInt();
        if (x == 1) {
            System.out.println("Enter Your UserName");
            a = sc.next();
            sc.nextLine();
            System.out.println("Enter Your Pasword");
            b = sc.next();
            sc.nextLine();

            // for(int i=0;i>UserName.size();i++) {

            UserName.add(a);

            //}
            //for(int i=0;i>UserName.size();i++) {

            Password.add(b);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(UserName);
            oos.writeObject(Password);
            oos.close();
            //}
            System.out.println("Your Account is Successfuly created");
            Login();
            oos.close();

        } else if (x == 2) {
            Login();



        }


        else {
            System.out.println("Invalid input");
        }


    }
    void Logout(){
        UserName.clear();
        Password.clear();
        System.out.println("Logout Sccessfuly !!");
    }



}




