package co.edu.udea.pexshop.domain.schedule.mapper;

import co.edu.udea.pexshop.domain.schedule.model.dto.ScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IScheduleMapper {

    ScheduleDTO toScheduleDTO(ScheduleEntity scheduleEntity);

}
