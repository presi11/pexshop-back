package co.edu.udea.pexshop.domain.schedule.repository;

import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends CrudRepository<ScheduleEntity, Long> {

}
