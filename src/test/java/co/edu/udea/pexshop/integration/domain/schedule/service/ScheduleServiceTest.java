package co.edu.udea.pexshop.integration.domain.schedule.service;

import co.edu.udea.pexshop.domain.schedule.model.dto.CreateScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.service.IScheduleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ScheduleServiceTest {

    @Autowired
    @Mock
    private IScheduleService scheduleService;

    @Test
    public void scheduleCreationTest() {
        CreateScheduleDTO createScheduleDTO = new CreateScheduleDTO();
        createScheduleDTO.setSchool(true);
        createScheduleDTO.setLoungeId(1);
        createScheduleDTO.setKindergarten(true);
        createScheduleDTO.setSunDay(true);
        createScheduleDTO.setPetId(35);
       boolean response = scheduleService.createSchedule(createScheduleDTO);
        assertTrue(response);
    }
}
