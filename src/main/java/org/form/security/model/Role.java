package org.form.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String roleName;

    private String roleDescription;

    private Integer level;

    private Boolean isActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    private Integer modifiedBy;
}
