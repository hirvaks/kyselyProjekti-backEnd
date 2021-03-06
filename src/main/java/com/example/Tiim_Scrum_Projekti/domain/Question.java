package com.example.Tiim_Scrum_Projekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "typeid")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question"/* orphanRemoval = true */)
    @JsonIgnore
    private List<Answer> answers;

    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "questionareid")
    private Questionare questionare;

    public Question(String name, Type type, List<Answer> answers,
            Questionare questionare) {
        this.name = name;
        this.type = type;
        this.answers = answers;
        this.questionare = questionare;
    }

    public Question(String name, Type type, Questionare questionare) {
        this.name = name;
        this.type = type;
        this.questionare = questionare;
    }

    public Question() {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Questionare getQuestionare() {
        return questionare;
    }

    public void setQuestionare(Questionare questionare) {
        this.questionare = questionare;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", questionare=" + questionare
                + ", type=" + type + "]";
    }

}
