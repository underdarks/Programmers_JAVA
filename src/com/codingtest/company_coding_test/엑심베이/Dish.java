package com.codingtest.company_coding_test.엑심베이;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


public class Dish {

    private String   name;    //음식명

    public Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
