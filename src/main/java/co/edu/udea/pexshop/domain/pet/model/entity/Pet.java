package co.edu.udea.pexshop.domain.pet.model.entity;

import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import co.edu.udea.pexshop.domain.user.model.entity.PermissionRole;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "tbl_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String petName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "size")
    private String size;

    @Column(name = "age")
    private int age;

    @Column(name = "vaccination_plan")
    private String vaccinationPlan;

    @Column(name = "care_to_have")
    private String careToHave;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "pet")
    private List<ScheduleEntity> scheduleList;

}
