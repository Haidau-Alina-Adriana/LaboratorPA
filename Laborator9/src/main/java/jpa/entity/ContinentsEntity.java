package jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "CONTINENTS", schema = "STUDENT")

@NamedQueries({
        @NamedQuery(name = "ContinentDAO.findById",
                query = "select c from ContinentsEntity c order by c.id"),
        @NamedQuery(name = "ContinentDAO.findByName",
                query = "select c from ContinentsEntity c where c.name = :continentName"),
})


public class ContinentsEntity {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContinentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
