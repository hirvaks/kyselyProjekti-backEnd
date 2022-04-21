package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Entity
public class Questionare {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnore
    private List<Question> questions;

    public Questionare(long id, String name, boolean status, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.questions = questions;
    }

    public Questionare() {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Questionare [id=" + id + ", name=" + name + ", questions=" + questions + ", status=" + status + "]";
    }

}