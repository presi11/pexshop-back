package co.edu.udea.pexshop.domain.schedule.service;

import co.edu.udea.pexshop.domain.schedule.model.dto.CreateScheduleDTO;

public interface IScheduleService {

    public boolean createSchedule(CreateScheduleDTO createScheduleDTO);
}
