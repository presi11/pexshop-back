package co.edu.udea.pexshop.domain.user.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany
//    private List<User> users;

}
