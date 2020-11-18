package model;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    private int id;
    private String name;
    private String author;
    private Integer price;
    private Integer releaseYear;
    private Integer numberOfCopies;
    private int publishingHouseId;
    private Publishinghouse publishinghouseByPublishingHouseId;
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
    @Column(name = "author", nullable = true, length = 45)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "releaseYear", nullable = true)
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "numberOfCopies", nullable = true)
    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    @Basic
    @Column(name = "publishingHouseId", nullable = false)
    public int getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (publishingHouseId != book.publishingHouseId) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (releaseYear != null ? !releaseYear.equals(book.releaseYear) : book.releaseYear != null) return false;
        if (numberOfCopies != null ? !numberOfCopies.equals(book.numberOfCopies) : book.numberOfCopies != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (numberOfCopies != null ? numberOfCopies.hashCode() : 0);
        result = 31 * result + publishingHouseId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "publishingHouseId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Publishinghouse getPublishinghouseByPublishingHouseId() {
        return publishinghouseByPublishingHouseId;
    }

    public void setPublishinghouseByPublishingHouseId(Publishinghouse publishinghouseByPublishingHouseId) {
        this.publishinghouseByPublishingHouseId = publishinghouseByPublishingHouseId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<Readerfile> getReaderfilesById() {
        return readerfilesById;
    }

    public void setReaderfilesById(Collection<Readerfile> readerfilesById) {
        this.readerfilesById = readerfilesById;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", numberOfCopies=" + numberOfCopies +
                ", publishingHouseId=" + publishingHouseId +
                '}';
    }
}
