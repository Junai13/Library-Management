package com.library;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main method = new Main();
        method.input();
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        BookService service = new BookServiceClass();
        System.out.println(" \t \u200B\uD83D\uDE4F Welcome to Book Management Application \u200B\uD83D\uDE4F");
        service.defaultbook();
        do {
            System.out.println("--------------------------------------------");
            System.out.println("""
                    1.Add Book
                    2.Show All Books
                    3.Show Available Books
                    4.Borrow Book
                    5.Return Book
                    6.Exit""");
            System.out.println("--------------------------------------------");
            System.out.println("Enter Your Choice !");
            String ch = sc.next();
            switch (ch) {
                case "1":
                    service.addBook();
                    break;
                case "2":
                    service.showAllBooks();
                    break;
                case "3":
                    service.showAllAvailableBooks();
                    break;
                case "4":
                    service.borrowBook();
                    break;
                case "5":
                    service.returnBook();
                    break;
                case "6":
                    System.out.println(" \u200B\uD83D\uDE4F Thank you for Using Application \u200B\uD83D\uDE4F ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter Valid Choice !");
            }
        }
        while (true);
    }
}