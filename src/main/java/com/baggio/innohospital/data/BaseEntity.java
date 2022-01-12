package com.baggio.innohospital.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "entity_sequence",
                sequenceName = "entity_sequence",
                allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    private Integer id;

}
