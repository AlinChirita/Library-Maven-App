package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Reader {
    private int id;
    private String name;
    private String phone;
    private String adress;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (id != reader.id) return false;
        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (phone != null ? !phone.equals(reader.phone) : reader.phone != null) return false;
        if (adress != null ? !adress.equals(reader.adress) : reader.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "readerByReaderId")
    public Collection<Readerfile> getReaderfilesById() {
        return readerfilesById;
    }

    public void setReaderfilesById(Collection<Readerfile> readerfilesById) {
        this.readerfilesById = readerfilesById;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

}
