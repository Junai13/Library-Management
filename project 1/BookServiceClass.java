package com.library;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BookServiceClass implements BookService {
        public static final String RED="\u001B[31m";
        public static final String RESET="\u001B[0m";
        public static final String PURPLE="\u001B[35m";
        public static final String GREEN="\u001B[32m";
        public static final String CYAN="\u001B[36m";
        Scanner sc=new Scanner(System.in);
        Validator validator=new Validator();
        List<Book> books=new ArrayList<>();
        List<BorrowBook> borrowBook=new ArrayList<>();
        List<Object> detailOfBorrow = new ArrayList<>();
        public void defaultbook(){

            Book book1 = new Book("001","Head First Java","Kathy Sierra & Bert Bates","2000","Available");
            Book book2 = new Book("002","Clean Code","Robert C. Martin Series","1998","Available");
            Book book3 = new Book("003","JAVA","James Gossiling","1991","Available");
            Book book4 = new Book("004","Thanneer Thesam","Vaira muthu","2013","Available");
            Book book5 = new Book("005","Ponniyin Selvan part 1","Kalki Krishnarayan","1950","Available");
            Book book10 = new Book("010","Wings of Fire","Dr.A.P.J.Abdul Kalam","2003","Available");
            books.add(book1);books.add(book2);books.add(book3);books.add(book4);
            books.add(book5);books.add(book10);
        }

        @Override
        public void addBook() {
            String bookid= validator.validateId();
            String Author=validator.validateAuthorTitle("Author");
            String Title=validator.validateAuthorTitle("Title");
            String year=validator.validatePublishYear();

            Book book=new Book(bookid,Title,Author,year,"Available");
            books.add(book);
            System.out.println(GREEN+"Book Added Successfully !!!"+RESET);
        }
        @Override
        public void showAllBooks() {
            boolean flag=false;
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(CYAN+"%s%30s%40s%15s%20s","ID","TITLE","AUTHOR","  PUBLISHED YEAR","STATUS"+RESET);
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
            for (Book book:books){
                System.out.printf("%s%30s%40s%10s%20s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
                System.out.println();
                flag=true;
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
            if(flag==false)
                System.out.println(RED+"There are no Books in Library"+RESET);
        }
        public void showAllAvailableBooks(){
            boolean flag=false;
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
            System.out.format(PURPLE+"%s%30s%40s%15s%20s","ID","TITLE","AUTHOR","PUBLISHED YEAR","STATUS"+RESET);
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------");
            if(books.size()>0){
                for (Book book:books){
                    if(book.getStatus()=="Available"){
                         System.out.printf("%s %30s%40s%10s%20s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(), book.getStatus());
                        System.out.println();
                        flag=true;
                    }
                }
            }
            else{
                System.out.println(RED+"No Books Available with this name in the library"+RESET);
            }
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
            if(flag==false)
                System.out.println(RED+"There are no books with status Available"+RESET);
        }
        public void borrowBook(){
            String bookid= validator.validateId();
            boolean flag=false;
            for(Book book:books){
                if(book.getId().equals(bookid) && book.getStatus().equals("Available")){
                    flag=true;
                    System.out.println(GREEN+"Book Borrowed Successfully !!!"+RESET);
                    book.setStatus("Not Available");
                    System.out.println("Borrowed Book Details: "+book);
                }
            }
            if(flag==false)
                System.out.println(RED+"This book is not available to borrow"+RESET);
        }
        public void returnBook(){
            boolean flag=false;
            String bookid= validator.validateId();
            for(Book book:books){
                if(book.getId().equals(bookid) && book.getStatus().equals("Not Available")){
                    flag=true;
                    System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                    book.setStatus("Available");
                    System.out.println("Returned Book Details: "+book);
                }
            }
            if(flag==false)
                System.out.println(RED+"We can not return this book"+RESET);
        }
}
