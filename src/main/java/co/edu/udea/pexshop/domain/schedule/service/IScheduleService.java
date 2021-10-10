package co.edu.udea.pexshop.domain.schedule.service;

import co.edu.udea.pexshop.domain.schedule.model.dto.CreateScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;

import java.util.List;

public interface IScheduleService {

    boolean createSchedule(CreateScheduleDTO createScheduleDTO);

    List<ScheduleEntity> getSchedulesFromLoungeByLoungeId(Long id);
}
