package com.djonatah.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    @Id
    private String uuid;
    @Column
    private String name;
    @Column
    private String email;
}
