package daoImplementations;

import dao.Dao;
import helper.DatabaseHelper;
import model.Book;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BookDAO  implements Dao<Book> {
    private DatabaseHelper databaseHelper;

    // Constructor
    public BookDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public Optional<Book> get(int id) {
        return Optional.ofNullable(databaseHelper.getEntityManager().find(Book.class, id));
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = databaseHelper.getEntityManager().createQuery("SELECT b from Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public boolean create(Book bookEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.persist(bookEntity));
    }

    @Override
    public boolean update(Book old, Book newObj) {
        old.setId(newObj.getId());
        old.setAuthor(newObj.getAuthor());
        old.setName(newObj.getName());
        old.setNumberOfCopies(newObj.getNumberOfCopies());
        old.setPrice(newObj.getPrice());
        old.setReleaseYear(newObj.getReleaseYear());
        old.setPublishingHouseId(newObj.getPublishingHouseId());
      //  old.setPublishinghouseByPublishingHouseId(newObj.getPublishinghouseByPublishingHouseId());
      //  old.setReaderfilesById(newObj.getReaderfilesById());
        return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
    }

    @Override
    public boolean delete(Book bookEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.remove(bookEntity));
    }
}