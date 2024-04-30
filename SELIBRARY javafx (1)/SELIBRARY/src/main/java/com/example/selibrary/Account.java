package com.example.selibrary;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;





public class Account implements Serializable {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Book> BookIssued;
    public ArrayList<Book> foundBooks = new ArrayList<>();
    public ArrayList<Book> books;
    File file = new File("IssuedBooks.txt");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    Date currentDate = new Date();

    long tenDaysInMillis = 10 * 24 * 60 * 60 * 1000L;
    Date dateofreturn = new Date(currentDate.getTime() + tenDaysInMillis);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    void ReturnBook(int id) {
        Date todaysdate = new Date();
        for (Book book : foundBooks) {
            if (book.getId() == id) {
                foundBooks.remove(book);
                book.setAvailablecopies(book.getAvailablecopies() + 1);
                System.out.println("Your book is Returned");


                if (todaysdate.before(dateofreturn) || todaysdate.equals(dateofreturn)) {
                    System.out.println("NO Fine");
                } else {
                    System.out.println("You should check your fine");
                    long daysLate = (dateofreturn.getTime() - todaysdate.getTime()) / (1000 * 60 * 60 * 24);
                    if (daysLate > 0) {
                        fineAmount = (int) daysLate * 10; // Assuming a fine of Rs. 10 per day
                    } else {
                        fineAmount = 0;
                    }
                    System.out.println("your fine is :" + fineAmount);
                }
                break; // Exit the loop after finding the book

            } else
                System.out.println("Your book is  not Returned");
        }
    }


    Account(ArrayList<Book> books) {
        this.books = books;
    }

    public void searchForBookById(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                foundBooks.add(book);
                //  foundBooks.get()
            }

        }
        System.out.println("Your Issue Date is \n" + currentDate);
        System.out.println("Your Date of Return is\n " + dateofreturn);
        fo(foundBooks);


    }

    Account() {

    }


    public ArrayList<Book> searchForBookByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        System.out.println("Your Issue Date is \n" + "["+currentDate+"]");
        System.out.println("Your Date of Return is \n" +"["+dateofreturn+"]");
        fo(foundBooks);
        return foundBooks;
    }
    //         ArrayList<Book> foundBooks = new ArrayList<>();

    public void fo(ArrayList<Book> foundBooks) {
        //       for (int i = 0; i < foundBooks.size(); i++) {
        if (foundBooks.get(0).getAvailablecopies() > 0) {
            foundBooks.get(0).setAvailablecopies(foundBooks.get(0).getAvailablecopies() - 1);
            System.out.println("=>YOUR BOOK=> ");
            System.out.println("ID  AvaiableCopies     Title");
            System.out.println(foundBooks.get(0).getId()+"     "+foundBooks.get(0).getAvailablecopies()+"           "+foundBooks.get(0).getTitle());
            System.out.println("Your book is issued");
        }
        else {
            System.out.println("Book is not available");
        }

        //    }
        // }

    }






    public ArrayList<Book> searchForBookByIsbn(String isbn) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                foundBooks.add(book);
            }
        }
        System.out.println("Your Issue Date is "+currentDate);
        System.out.println("Your Date of Return is "+dateofreturn);
        fo(foundBooks);
        return foundBooks;
    }



    private Date issueDate;
    private Date returnDate;
    private int fineAmount;
    private String reservedBook;
    private String referenceBook;



    // Getter and setter methods for all attributes

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getReservedBook() {
        return reservedBook;
    }

    public void setReservedBook(String reservedBook) {
        this.reservedBook = reservedBook;
    }

    public String getReferenceBook() {
        return referenceBook;
    }

    void issueBook()  {

        System.out.println("(1)-Press 1 to search for book");
        int aa= sc.nextInt();
        if(aa==1){
            System.out.println("(1)-Press 1 to search with Title");
            System.out.println("(2)-Press 2 to search with Id");
            System.out.println("(3)-Press 3 to search for ISBN");
            int qq= sc.nextInt();
            if(qq==1){
                System.out.println("(1)-Enter Book Title");
                sc.nextLine();
                String ss=sc.nextLine();

                System.out.println(searchForBookByTitle(ss));


            } else if (qq==2)
            {
                System.out.println("(1)-Enter book ID");
                int gg=sc.nextInt();
                searchForBookById(gg);


            } else if (qq==3)
            {
                System.out.println("(1)-Enter ISBN to search");
                sc.nextLine();
                String hh= sc.nextLine();

                searchForBookByIsbn(hh);

            }
            else{
                System.out.println("Invalid input");
            }

        }



    }

    public void setReferenceBook(String referenceBook) {
        this.referenceBook = referenceBook;
    }


    public  void Interface2() throws IOException, ClassNotFoundException {
        for(int i=0;i!=-1;i++) {
            Librarian l1 = new Librarian();
            Student s1 = new Student();
            Scanner sc = new Scanner(System.in);

            System.out.println("____________________________________________");
            System.out.println("|                                          |");
            System.out.println("|               SE-Library                 |");
            System.out.println("|                                          |");
            System.out.println("____________________________________________");

            System.out.println("Enter User Type ");
            System.out.println();
            System.out.println("(1)-Press 1 for Student");
            System.out.println("(2)-press 2 for Librarian");


            int x;
            while (true) {
                if (sc.hasNextInt())
                {
                    x = sc.nextInt();
                    break;
                }
                else
                {
                    System.out.println("(1)-Invalid input. Please enter a valid integer.");
                    x = sc.nextInt();
// Clear the invalid input from the scanner buffer
                }
            }
            if (x == 1) {


                System.out.println("____________________________________________");
                System.out.println("|                                          |");
                System.out.println("|              Signup/Login                |");
                System.out.println("|                                          |");
                System.out.println("____________________________________________");


                s1.Signup();


                System.out.println("(1)-Press 1 for logout");
                System.out.println("(2)-Press 2 to show Main Manu");

                int jj=sc.nextInt();
                if(jj==1){
                    try {
                        System.out.println("____________________________________________");
                        System.out.println("|                                          |");
                        System.out.println("|                 Logout                   |");
                        System.out.println("|                                          |");
                        System.out.println("____________________________________________");
                        s1.Logout();
                    }
                    catch (Exception e){
                        System.out.println("(1)-Invalid Output Please input valid input");
                        s1.Logout();

                    }
                } else if (jj==2) {
                    // try {
                    Interface();
//                    }
//                    catch (Exception e){
//                        System.out.println("(1)-Invalid Output Please input valid input");
//                        Interface();
//                    }
//                        Scanner sc = new Scanner(System.in);
                }

            } else if (x == 2) {
                System.out.println("____________________________________________");
                System.out.println("|                                          |");
                System.out.println("|              Signup/Login                |");
                System.out.println("|                                          |");
                System.out.println("____________________________________________");


                l1.Signup();




                Interface1();

            } else
                System.out.println("Invalid Input");
            Interface2();
        }
    }


    void Interface1() throws IOException, ClassNotFoundException {
        //try {
        Librarian l1 = new Librarian();
        // l1.Signup();
//    }
//    catch (Exception e){
//        System.out.println("(1)-Invalid Output Please input valid input");
//        l1.Signup();
//    }
        System.out.println("(1)-Press 1 for logout");
        System.out.println("(2)-Press 2 to show main menu");
        int gg=sc.nextInt();
        if(gg==1){
            try {
                l1.Logout();
            }
            catch (Exception e){
                System.out.println("(1)-Invalid Output Please input valid input");
                l1.Logout();
            }
        } else if (gg==2)
        {
            System.out.println("(1)-Press 1 to add new books");
            System.out.println("(2)-Press 2 to  ShowAllBooks ");
            System.out.println("(3)-Press 3 to remove Books through id");
            System.out.println("(4)-Press 4 for Exit ");
            int ss=sc.nextInt();
            if(ss==1)
            {
                l1.AddBook(books);
                Interface1();

            } else if (ss==2) {

                l1.ShowAllBooks(books);
                Interface1();
            }
            else if (ss==3) {

                l1.deleteBook(books);
                Interface1();

            } else if (ss==4) {
                Interface2();

            }

        }

    }
    public void Interface() throws IOException, ClassNotFoundException {
        Librarian l1= new Librarian();
        System.out.println("(0)-Press 0 to show all Books");
        System.out.println("(1)-Press 1 to Issue Book");
        System.out.println("(2)-Press 2 to return Book");
        System.out.println("(3)-Press 3 to show fine");
        System.out.println("(4)-Press 4 to exit");
        int gg=sc.nextInt();
        if(gg==0){

            l1.ShowAllBooks(books);
            Interface();

        }

        else if(gg==1){
            issueBook();
            Interface();
        } else if (gg==2) {
            System.out.println("Press 1 to return through ID");
            int ee=sc.nextInt();
            if(ee==1){
                System.out.println("Enter Book ID ");
                //sc.nextInt();
                int aaa = sc.nextInt();
                // try {
                ReturnBook(aaa);


                Interface();
                // FUN();
            }

        } else if (gg==3) {
            System.out.println(getFineAmount());
            // FUN();
            Interface();

        } else if (gg==4) {
            Interface2();

        }
    }

}