package ssau.esa.lr.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(schema = "public", name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @Column(name = "count")
    private int count;
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                count == book.count &&
                Objects.equals(name, book.name) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count, name, genre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{").append("\n\t");
        sb.append("id=").append(id).append(",\n\t");
        sb.append("name='").append(name).append("',\n\t");
        sb.append("genre='").append(genre.getName()).append("',\n\t");
        sb.append("author='").append(author.getName()).append(' ').append(author.getSurname()).append("',\n\t");
        sb.append("count=").append(count).append(",\n\t");
        sb.append('}');
        return sb.toString();
    }
}
