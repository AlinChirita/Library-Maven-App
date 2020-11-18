package model;

import javax.persistence.*;

@Entity
public class Readerfile {
    private int id;
    private String loanDate;
    private int bookId;
    private int readerId;
    private int employeeId;
    private Book bookByBookId;
    private Reader readerByReaderId;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loanDate", nullable = true, length = 45)
    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    @Basic
    @Column(name = "bookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "readerId", nullable = false)
    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    @Basic
    @Column(name = "employeeId", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Readerfile that = (Readerfile) o;

        if (id != that.id) return false;
        if (bookId != that.bookId) return false;
        if (readerId != that.readerId) return false;
        if (employeeId != that.employeeId) return false;
        if (loanDate != null ? !loanDate.equals(that.loanDate) : that.loanDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (loanDate != null ? loanDate.hashCode() : 0);
        result = 31 * result + bookId;
        result = 31 * result + readerId;
        result = 31 * result + employeeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "readerId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Reader getReaderByReaderId() {
        return readerByReaderId;
    }

    public void setReaderByReaderId(Reader readerByReaderId) {
        this.readerByReaderId = readerByReaderId;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @Override
    public String toString() {
        return "Readerfile{" +
                "id=" + id +
                ", loanDate='" + loanDate + '\'' +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", employeeId=" + employeeId +
                '}';
    }
}
