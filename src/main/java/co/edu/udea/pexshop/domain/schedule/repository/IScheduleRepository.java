package co.edu.udea.pexshop.domain.schedule.repository;

import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScheduleRepository extends CrudRepository<ScheduleEntity, Long> {

    @Query("SELECT sch, pet FROM ScheduleEntity sch inner join Pet pet on pet.id=sch.pet.id where sch.lounge.id = ?1 and sch.status = true")
    List<ScheduleEntity> getSchedulesByLoungeId(Long id);

    @Query("SELECT sch from ScheduleEntity sch where sch.status = true and sch.pet.id = ?1")
    ScheduleEntity getScheduleByPetId(Long petId);
}
