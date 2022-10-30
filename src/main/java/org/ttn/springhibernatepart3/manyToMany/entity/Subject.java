package org.ttn.springhibernatepart3.manyToMany.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Subject {

    @Column(name = "subjectname")
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
