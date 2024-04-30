package com.example.selibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Librarian  extends User  {

    File file = new File("Bokks.txt");
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    Scanner sc = new Scanner(System.in);
    Book b1 = new Book();

    public Librarian() throws IOException {
    }
    void ShowAllBooks(ArrayList<Book> books) throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(new FileInputStream(file));
        books = (ArrayList<Book>) ois.readObject();
        ois.close();
        System.out.println("Id     Publication Date    AVailableCopies       Title");
        for(int i=0;i<books.size();i++)
        {
            System.out.println(books.get(i).getId()+"          "+books.get(i).getPublicationDate()+"         "+books.get(i).getAvailablecopies()+"                    "+books.get(i).getTitle());
        }
    }

    void AddBook(ArrayList<Book> books) throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(books);
        oos.close();
        System.out.println("Enter book title");
        String title=sc.nextLine();
        b1.setTitle(title);

        System.out.println("Enter book id");
        int Id=sc.nextInt();
        b1.setId(Id);

        System.out.println("Enter book isbn");
        sc.nextLine();
        String isbn=sc.nextLine();
        b1.setISBN(isbn);

        System.out.println("Publication Date DD/MM/YYYY");
        String date=sc.nextLine();
        b1.setPublicationDate(date);

        System.out.println("Enter Available Copies");
        int availableCopies=sc.nextInt();
        b1.setAvailablecopies(availableCopies);

        books.add(new Book(title,Id,isbn,date,availableCopies));
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(books);
        oos.close();
    }





    void RemindForRenew(ArrayList<Book> books) throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(new FileInputStream(file));
        books = (ArrayList<Book>) ois.readObject();
        ois.close();
        for (Book book : books) {
            if (b1.getAvailablecopies() == 0) {
                b1.setAvailablecopies(b1.getAvailablecopies() + 5);
                System.out.println("Now the book is renewed");
            }
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(books);
        oos.close();
    }

    public void deleteBook(ArrayList<Book> books) throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(new FileInputStream(file));
        books = (ArrayList<Book>) ois.readObject();
        ois.close();

        System.out.println("Enter Book id of removable book");
        int id = sc.nextInt();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                System.out.println("Book " + book.getTitle() + " has been removed");
            }
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(books);
        oos.close();
    }




    @Override
    void Signup() {
        try{
            super.Signup();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    void Logout() {
        super.Logout();
    }
    @Override
    public void Login() throws IOException, ClassNotFoundException {
        super.Login();
    }
}

