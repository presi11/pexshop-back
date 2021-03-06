package co.edu.udea.pexshop.domain.user.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "permission")
    private List<PermissionRole> permisionRoleList;

}
