package org.form.security.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;
    private String lastName;

    private Boolean isActive = true;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private Date createdDate = new Date();

    private Integer createdBy;

    @UpdateTimestamp
    private Date modifiedDate;

    private Integer modifiedBy;
}
