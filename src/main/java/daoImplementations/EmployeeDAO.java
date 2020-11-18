package daoImplementations;

import dao.Dao;
import helper.DatabaseHelper;
import model.Employee;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO implements Dao<Employee> {
    private DatabaseHelper databaseHelper;

    // Constructor
    public EmployeeDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    @Override
    public Optional<Employee> get(int id) {
        return Optional.ofNullable(databaseHelper.getEntityManager().find(Employee.class, id));
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = databaseHelper.getEntityManager().createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public boolean create(Employee employeeEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.persist(employeeEntity));
    }

    @Override
    public boolean update(Employee old, Employee newObj) {
        old.setId(newObj.getId());
        old.setName(newObj.getName());
        old.setAdress(newObj.getAdress());
        old.setPhone(newObj.getPhone());
        old.setJobName(newObj.getJobName());
        old.setReaderfilesById(newObj.getReaderfilesById());
        return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
    }

    @Override
    public boolean delete(Employee employeeEntity) {
        return databaseHelper.executeTransaction(entityManager -> entityManager.remove(employeeEntity));
    }
}
