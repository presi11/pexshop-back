package co.edu.udea.pexshop.domain.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

}
