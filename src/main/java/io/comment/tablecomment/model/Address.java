package io.comment.tablecomment.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String city;
    private String state;

}
