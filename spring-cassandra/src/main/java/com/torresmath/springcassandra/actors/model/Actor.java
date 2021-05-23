package com.torresmath.springcassandra.actors.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("actors")
public class Actor {

    @PrimaryKeyColumn(name = "actor_id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    @Column
    private String name;

    @Column("date_of_birth")
    private LocalDate dateOfBirth;

    public Actor(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
