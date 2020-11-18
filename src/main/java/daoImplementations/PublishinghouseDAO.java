package daoImplementations;

import dao.Dao;
import helper.DatabaseHelper;
import model.Publishinghouse;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PublishinghouseDAO implements Dao<Publishinghouse> {
    private DatabaseHelper databaseHelper;

    // Constructor
    public PublishinghouseDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public Optional<Publishinghouse> get(int id) {
        return Optional.ofNullable(databaseHelper.getEntityManager().find(Publishinghouse.class, id));
    }

    @Override
    public List<Publishinghouse> getAll() {
        TypedQuery<Publishinghouse> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM Publishinghouse p", Publishinghouse.class);
        return query.getResultList();
    }

    @Override
    public boolean create(Publishinghouse publishinghouseEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.persist(publishinghouseEntity));
    }

    @Override
    public boolean update(Publishinghouse old, Publishinghouse newObj) {
        old.setId(newObj.getId());
        old.setName(newObj.getName());
        old.setAdress(newObj.getAdress());
        old.setPhone(newObj.getPhone());
        old.setBooksById(newObj.getBooksById());
        return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
    }

    @Override
    public boolean delete(Publishinghouse publishinghouseEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.remove(publishinghouseEntity));
    }
}