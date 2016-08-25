package org.mattshine.katas.refactoring;

import java.time.LocalDateTime;

public class Person {
    public String name;
    private LocalDateTime birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}