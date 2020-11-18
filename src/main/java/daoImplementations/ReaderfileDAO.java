package daoImplementations;

import dao.Dao;
import helper.DatabaseHelper;
import model.Readerfile;


import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ReaderfileDAO implements Dao<Readerfile> {
    private DatabaseHelper databaseHelper;

    // Constructor
    public ReaderfileDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    @Override
    public Optional<Readerfile> get(int id) {
        return Optional.ofNullable(databaseHelper.getEntityManager().find(Readerfile.class, id));
    }

    @Override
    public List<Readerfile> getAll() {
        TypedQuery<Readerfile> query = databaseHelper.getEntityManager().createQuery("SELECT r FROM Readerfile r", Readerfile.class);
        return query.getResultList();
    }

    @Override
    public boolean create(Readerfile readerfileEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.persist(readerfileEntity));
    }

    @Override
    public boolean update(Readerfile old, Readerfile newObj) {
        old.setId(newObj.getId());
        old.setLoanDate(newObj.getLoanDate());
        old.setBookId(newObj.getBookId());
        old.setReaderId(newObj.getReaderId());
        old.setEmployeeId(newObj.getEmployeeId());

        old.setBookByBookId(newObj.getBookByBookId());
        old.setEmployeeByEmployeeId(newObj.getEmployeeByEmployeeId());
        old.setReaderByReaderId(newObj.getReaderByReaderId());
        return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
    }

    @Override
    public boolean delete(Readerfile readerfileEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.remove(readerfileEntity));
    }
}