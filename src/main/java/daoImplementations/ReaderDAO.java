package daoImplementations;

import dao.Dao;
import helper.DatabaseHelper;
import model.Reader;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ReaderDAO implements Dao<Reader> {

    private DatabaseHelper databaseHelper;

    // Constructor
    public ReaderDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public Optional<Reader> get(int id) {
        return Optional.ofNullable(databaseHelper.getEntityManager().find(Reader.class, id));
    }

    @Override
    public List<Reader> getAll() {
        TypedQuery<Reader> query = databaseHelper.getEntityManager().createQuery("SELECT r FROM Reader r", Reader.class);
        return query.getResultList();
    }

    @Override
    public boolean create(Reader readerEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.persist(readerEntity));
    }

    @Override
    public boolean update(Reader old, Reader newObj) {
        old.setId(newObj.getId());
        old.setAdress(newObj.getAdress());
        old.setName(newObj.getName());
        old.setPhone(newObj.getPhone());
        old.setReaderfilesById(newObj.getReaderfilesById());
        return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
    }

    @Override
    public boolean delete(Reader readerEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.remove(readerEntity));
    }
}