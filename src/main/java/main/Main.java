package main;

import daoImplementations.*;
import helper.DatabaseHelper;
import model.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseHelper dh = DatabaseHelper.getInstance();

        BookDAO bookDao = new BookDAO(dh);
        ReaderDAO readerDao = new ReaderDAO(dh);
        EmployeeDAO employeeDao = new EmployeeDAO(dh);
        PublishinghouseDAO publishinghouseDao = new PublishinghouseDAO(dh);
        ReaderfileDAO readerfileDao = new ReaderfileDAO(dh);

        Scanner sc = new Scanner(System.in);


        System.out.println("Chose an option:");
        System.out.println("1.Book CRUD 2.Reader CRUD 3.Employee CRUD 4. Publishing house CRUD 5.Loan book 6. Exit ");

        int option = sc.nextInt();
        int nextOption;

        switch (option) {
            case 1:
                loop:
                while (true) {
                    System.out.println("Chose an option:");
                    System.out.println("1.Read & Print 2.Create 3.Delete 4.Update 5. Exit");
                    nextOption = sc.nextInt();
                    switch (nextOption) {
                        case 1: {
                            List<Book> booksList = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Before adding...");
                            List<Book> booksList = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }
                            System.out.println("Add a book to the database. Enter details: ");
                            System.out.println("Id:");
                            int id = sc.nextInt();
                            System.out.println("Book name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("Author :");
                            String author = sc.nextLine();
                            System.out.println("Price: ");
                            int price = sc.nextInt();
                            System.out.println("Release year: ");
                            int year = sc.nextInt();
                            System.out.println("Number of copies: ");
                            int number = sc.nextInt();

                            publishinghouseDao.getAll();
                            System.out.println("Enter publishing house id: ");
                            int phId = sc.nextInt();

                            Book book = new Book();
                            book.setId(id);
                            book.setName(name);
                            book.setAuthor(author);
                            book.setPrice(price);
                            book.setReleaseYear(year);
                            book.setNumberOfCopies(number);
                            book.setPublishingHouseId(phId);
                            bookDao.create(book);
                            System.out.println("Book added succesfuly into the database.");

                            System.out.println("After adding...");
                            List<Book> bookList2 = bookDao.getAll();
                            for (Book book2 : bookList2) {
                                System.out.println(book2.toString());
                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Before delete...");
                            List<Book> booksList = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }

                            System.out.println("Delete book from the database with id: ");
                            int id = sc.nextInt();
                            Optional<Book> idBookToDelete = bookDao.get(id);
                            bookDao.delete(idBookToDelete.get());
                            System.out.println("Book deleted succesfully.");

                            System.out.println("After delete...");
                            List<Book> booksList2 = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }
                        }

                        case 4: {
                            System.out.println("Before update...");
                            List<Book> booksList = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }

                            System.out.println("Update book with id: ");
                            int id = sc.nextInt();
                            Optional<Book> bookToUpdate = bookDao.get(id);
                            Book updatedBook = new Book();

                            System.out.println("Id:");
                            int newId = sc.nextInt();
                            System.out.println("Book name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();
                            System.out.println("Author :");
                            String newAuthor = sc.nextLine();
                            System.out.println("Price: ");
                            int newPrice = sc.nextInt();
                            System.out.println("Release year: ");
                            int newYear = sc.nextInt();
                            System.out.println("Number of copies: ");
                            int newNumberOfCopies = sc.nextInt();
                            System.out.println("Enter publishing house id: ");
                            int newHouseId = sc.nextInt();

                            updatedBook.setId(newId);
                            updatedBook.setName(newName);
                            updatedBook.setAuthor(newAuthor);
                            updatedBook.setPrice(newPrice);
                            updatedBook.setReleaseYear(newYear);
                            updatedBook.setNumberOfCopies(newNumberOfCopies);
                            updatedBook.setPublishingHouseId(newHouseId);

                            bookDao.update(bookToUpdate.get(), updatedBook);

                            System.out.println("Book updated succesfully: ");

                            System.out.println("After update...");
                            List<Book> updatedBooksList = bookDao.getAll();
                            for (Book book : booksList) {
                                System.out.println(book.toString());
                            }

                        }

                        case 5: {
                            break loop;
                        }

                        default: {
                            System.out.println("Invalid option...");
                        }
                    }


                }
                break;

            case 2:
                loop:
                while (true) {
                    System.out.println("Chose an option:");
                    System.out.println("1.Read & Print 2.Create 3.Delete 4.Update 5.Exit");

                    nextOption = sc.nextInt();
                    switch (nextOption) {
                        case 1: {
                            List<Reader> readersList = readerDao.getAll();
                            for (Reader reader : readersList) {
                                System.out.println(reader.toString());
                            }
                            break;
                        }

                        case 2: {
                            System.out.println("Before adding...");

                            List<Reader> readersList = readerDao.getAll();
                            for (Reader reader : readersList) {
                                System.out.println(reader.toString());
                            }

                            System.out.println("Add a reader to the database. Enter details: ");

                            System.out.println("Id:");
                            int id = sc.nextInt();

                            System.out.println("Reader name: ");
                            sc.nextLine();
                            String name = sc.nextLine();

                            System.out.println("Phone :");
                            String phone = sc.nextLine();

                            System.out.println("Adress: ");
                            String adress = sc.nextLine();

                            Reader reader = new Reader();
                            reader.setId(id);
                            reader.setName(name);
                            reader.setPhone(phone);
                            reader.setAdress(adress);
                            readerDao.create(reader);

                            System.out.println("Reader added succesfuly into the database.");

                            System.out.println("After adding...");

                            List<Reader> readersList2 = readerDao.getAll();

                            for (Reader rd : readersList2) {
                                System.out.println(rd.toString());
                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Before delete...");

                            List<Reader> readersList = readerDao.getAll();
                            for (Reader reader : readersList) {
                                System.out.println(reader.toString());
                            }

                            System.out.println("Delete reader from the database with id: ");
                            int id = sc.nextInt();
                            Optional<Reader> idReaderToDelete = readerDao.get(id);
                            readerDao.delete(idReaderToDelete.get());
                            System.out.println("Reader deleted succesfully from the database.");

                            System.out.println("After delete...");
                            List<Reader> readersList2 = readerDao.getAll();

                            for (Reader rd : readersList2) {
                                System.out.println(rd.toString());
                            }
                            break;
                        }

                        case 4: {
                            System.out.println("Before update...");

                            List<Reader> readersList = readerDao.getAll();
                            for (Reader reader : readersList) {
                                System.out.println(reader.toString());
                            }

                            System.out.println("Update reader with id: ");
                            int id = sc.nextInt();

                            Optional<Reader> readerToUpdate = readerDao.get(id);
                            Reader updatedReader = new Reader();

                            System.out.println("Id:");
                            int newId = sc.nextInt();

                            System.out.println("Reader name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();

                            System.out.println("Phone :");
                            String newPhone = sc.nextLine();

                            System.out.println("Adress: ");
                            String newAdress = sc.nextLine();

                            updatedReader.setId(newId);
                            updatedReader.setName(newName);
                            updatedReader.setPhone(newPhone);
                            updatedReader.setAdress(newAdress);


                            readerDao.update(readerToUpdate.get(), updatedReader);

                            System.out.println("Reader updated succesfully: ");

                            System.out.println("After update...");
                            List<Reader> readersList2 = readerDao.getAll();
                            for (Reader reader : readersList) {
                                System.out.println(reader.toString());
                            }

                            break;
                        }

                        case 5: {
                            break loop;
                        }

                        default: {
                            System.out.println("Invalid option...");
                        }

                    }


                }
                break;

            case 3:
                loop:
                while (true) {
                    System.out.println("Chose an option:");
                    System.out.println("1.Read & Print 2.Create 3.Delete 4.Update 5. Exit");
                    nextOption = sc.nextInt();
                    switch (nextOption) {
                        case 1: {
                            List<Employee> employeeList = employeeDao.getAll();
                            for (Employee employee : employeeList) {
                                System.out.println(employee.toString());
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Before adding...");
                            List<Employee> employeeList = employeeDao.getAll();
                            for (Employee employee : employeeList) {
                                System.out.println(employee.toString());
                            }
                            System.out.println("Add an employee to the database. Enter details: ");

                            System.out.println("Id:");
                            int newId = sc.nextInt();

                            System.out.println("Name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();

                            System.out.println("Phone :");
                            String newPhone = sc.nextLine();

                            System.out.println("Adress: ");
                            String newAdress = sc.nextLine();

                            Employee employee = new Employee();
                            employee.setId(newId);
                            employee.setName(newName);
                            employee.setPhone(newPhone);
                            employee.setAdress(newAdress);

                            employeeDao.create(employee);
                            System.out.println("Employee added succesfuly into the database.");

                            System.out.println("After adding...");
                            List<Employee> employeeList2 = employeeDao.getAll();
                            for (Employee emp : employeeList) {
                                System.out.println(emp.toString());
                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Before delete...");
                            List<Employee> employeeList = employeeDao.getAll();
                            for (Employee employee : employeeList) {
                                System.out.println(employee.toString());
                            }

                            System.out.println("Delete employee from the database with id: ");
                            int id = sc.nextInt();

                            Optional<Employee> idEmployeeToDelete = employeeDao.get(id);
                            employeeDao.delete(idEmployeeToDelete.get());
                            System.out.println("Employee deleted succesfully.");

                            System.out.println("After delete...");
                            List<Employee> employeeList2 = employeeDao.getAll();
                            for (Employee emp : employeeList) {
                                System.out.println(emp.toString());
                            }
                        }

                        case 4: {
                            System.out.println("Before update...");
                            List<Employee> employeeList = employeeDao.getAll();
                            for (Employee employee : employeeList) {
                                System.out.println(employee.toString());
                            }

                            System.out.println("Update employee with id: ");
                            int id = sc.nextInt();

                            Optional<Employee> employeeToUpdate = employeeDao.get(id);
                            Employee updatedEmployee = new Employee();

                            System.out.println("Id:");
                            int newId = sc.nextInt();

                            System.out.println("Employee name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();

                            System.out.println("Phone: ");
                            String newPhone = sc.nextLine();

                            System.out.println("Adress: ");
                            String newAdress = sc.nextLine();


                            updatedEmployee.setId(newId);
                            updatedEmployee.setName(newName);
                            updatedEmployee.setPhone(newPhone);
                            updatedEmployee.setAdress(newAdress);

                            employeeDao.update(employeeToUpdate.get(), updatedEmployee);

                            System.out.println("Employee data updated succesfully... ");

                            System.out.println("After update...");
                            List<Employee> employeeList2 = employeeDao.getAll();
                            for (Employee emp : employeeList) {
                                System.out.println(emp.toString());
                            }

                        }

                        case 5: {
                            break loop;
                        }

                        default: {
                            System.out.println("Invalid option...");
                        }
                    }


                }
                break;
            case 4:
                loop:
                while (true) {
                    System.out.println("Chose an option:");
                    System.out.println("1.Read & Print 2.Create 3.Delete 4.Update 5. Exit");
                    nextOption = sc.nextInt();
                    switch (nextOption) {
                        case 1: {
                            List<Publishinghouse> publishersList = publishinghouseDao.getAll();
                            for (Publishinghouse publisher : publishersList ) {
                                System.out.println(publisher.toString());
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Before adding...");
                            List<Publishinghouse> publishersList = publishinghouseDao.getAll();
                            for (Publishinghouse publisher : publishersList ) {
                                System.out.println(publisher.toString());
                            }

                            System.out.println("Add a publishing house  to the database. Enter details: ");
                            System.out.println("Id:");
                            int id = sc.nextInt();

                            System.out.println("Name: ");
                            sc.nextLine();
                            String name = sc.nextLine();

                            System.out.println("Phone :");
                            String phone = sc.nextLine();

                            System.out.println("Adress: ");
                            String adress = sc.nextLine();

                            Publishinghouse publisher = new Publishinghouse();
                            publisher.setId(id);
                            publisher.setName(name);
                            publisher.setPhone(phone);
                            publisher.setAdress(adress);

                            publishinghouseDao.create(publisher);
                            System.out.println("Publisher added succesfuly into the database.");

                            System.out.println("After adding...");
                            List<Publishinghouse> publishersList2 = publishinghouseDao.getAll();
                            for (Publishinghouse publisher2 : publishersList ) {
                                System.out.println(publisher2.toString());
                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Before delete...");
                            List<Publishinghouse> publishersList = publishinghouseDao.getAll();
                            for (Publishinghouse publisher : publishersList ) {
                                System.out.println(publisher.toString());
                            }

                            System.out.println("Delete publishing house from the database with id: ");
                            int id = sc.nextInt();

                            Optional<Publishinghouse> publisherToDelete = publishinghouseDao.get(id);
                            publishinghouseDao.delete(publisherToDelete.get());
                            System.out.println("Publisher deleted succesfully.");

                            System.out.println("After delete...");
                            List<Publishinghouse> publishersList2 = publishinghouseDao.getAll();
                            for (Publishinghouse publisher2 : publishersList ) {
                                System.out.println(publisher2.toString());
                            }
                        }

                        case 4: {
                            System.out.println("Before update...");
                            List<Publishinghouse> publishersList = publishinghouseDao.getAll();
                            for (Publishinghouse publisher : publishersList ) {
                                System.out.println(publisher.toString());
                            }

                            System.out.println("Update publisher with id: ");
                            int id = sc.nextInt();

                            Optional<Publishinghouse> publisherToUpdate = publishinghouseDao.get(id);
                            Publishinghouse updatedPublisher = new Publishinghouse();

                            System.out.println("Id:");
                            int newId = sc.nextInt();

                            System.out.println("Name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();

                            System.out.println("Phone :");
                            String newPhone = sc.nextLine();

                            System.out.println("Adress: ");
                            String newAdress = sc.nextLine();

                            updatedPublisher.setId(newId);
                            updatedPublisher.setName(newName);
                            updatedPublisher.setPhone(newPhone);
                            updatedPublisher.setAdress(newAdress);

                            publishinghouseDao.update(publisherToUpdate.get(), updatedPublisher);

                            System.out.println("Publisher updated succesfully: ");

                            System.out.println("After update...");
                            List<Publishinghouse> publishersList2 = publishinghouseDao.getAll();
                            for (Publishinghouse publisher2 : publishersList ) {
                                System.out.println(publisher2.toString());
                            }


                        }

                        case 5: {
                            break loop;
                        }

                        default: {
                            System.out.println("Invalid option...");
                        }
                    }


                }
                break;
            case 5: {
                    System.out.println("Enter reader id: ");
                    int readerId = 0, bookId = 0, employeeId = 0;

                    if (sc.hasNextInt()) {
                        readerId = sc.nextInt();
                    }

                    System.out.println("Enter book id");
                    if (sc.hasNextInt()) {
                        bookId = sc.nextInt();
                    }

                    System.out.println("Enter employee id");
                    if (sc.hasNextInt()) {
                        employeeId = sc.nextInt();
                    }
                loanBook(bookId, employeeId, readerId);

            }
            break;

            case 6:
                System.out.println("Exiting...");
                System.exit(1);
                break;


        }
    }
    public static void loanBook(int bookId, int employeeId, int readerId) {
        Scanner sc = new Scanner(System.in);

        DatabaseHelper dh = DatabaseHelper.getInstance();

        BookDAO bookDao = new BookDAO(dh);
        ReaderDAO readerDao = new ReaderDAO(dh);
        EmployeeDAO employeeDao = new EmployeeDAO(dh);
        ReaderfileDAO rfDao = new ReaderfileDAO(dh);

        System.out.println("Loan a book: ");

        try {
            Optional<Book> idBook = bookDao.get(bookId);
            Optional<Reader> idReader = readerDao.get(readerId);
            Optional<Employee> idEmployee = employeeDao.get(employeeId);

            int numberOfCopies = idBook.get().getNumberOfCopies();


            if (numberOfCopies >= 1) {
                Readerfile rf = new Readerfile();

                rf.setLoanDate("16-01-2020");
                rf.setBookId(bookId);
                rf.setEmployeeId(employeeId);
                rf.setReaderId(readerId);

                Book book = idBook.get();
                book.setNumberOfCopies(numberOfCopies - 1);

                rfDao.create(rf);
                bookDao.update(idBook.get(), book);
                System.out.println("Book loaned to: " + idReader.get().getName());
            } else
                System.out.println("No books available.");
        }
        catch(Exception e) {
            System.err.println("Entity does not exist in the database " + e.getMessage().toString());
        }
    }
}