package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Employee {
    private int id;
    private String name;
    private String phone;
    private String adress;
    private String jobName;
    private Collection<Readerfile> readerfilesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "adress", nullable = true, length = 45)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "jobName", nullable = true, length = 45)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (adress != null ? !adress.equals(employee.adress) : employee.adress != null) return false;
        if (jobName != null ? !jobName.equals(employee.jobName) : employee.jobName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<Readerfile> getReaderfilesById() {
        return readerfilesById;
    }

    public void setReaderfilesById(Collection<Readerfile> readerfilesById) {
        this.readerfilesById = readerfilesById;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
