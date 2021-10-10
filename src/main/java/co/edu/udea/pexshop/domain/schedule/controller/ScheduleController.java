package co.edu.udea.pexshop.domain.schedule.controller;

import co.edu.udea.pexshop.domain.schedule.model.dto.CreateScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/schedule")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @PreAuthorize("hasAuthority('schedule_pet')")
    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody CreateScheduleDTO createScheduleDTO){

        boolean scheduleResponse = scheduleService.createSchedule(createScheduleDTO);
        if(scheduleResponse) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }

    }

}
