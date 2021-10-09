package co.edu.udea.pexshop.domain.lounge.model.entity;

import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_lounge")
public class LoungeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "pet_specialty")
    private String petSpecialty;

    @JoinColumn(name = "maximum_capacity")
    private int maximumCapacity;

    @Column(name = "current_quantity")
    private int currentQuantity;

    @Column(name= "availability")
    private String availability;

    @OneToMany(mappedBy = "lounge")
    private List<ScheduleEntity> scheduleList;
}
