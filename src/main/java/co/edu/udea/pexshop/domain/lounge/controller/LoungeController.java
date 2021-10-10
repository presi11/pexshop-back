package co.edu.udea.pexshop.domain.lounge.controller;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.service.LoungeServiceImplemented;
import co.edu.udea.pexshop.domain.schedule.mapper.IScheduleMapper;
import co.edu.udea.pexshop.domain.schedule.model.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/lounge")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoungeController {

    @Autowired
    private LoungeServiceImplemented loungeService;

    @Autowired
    private IScheduleMapper scheduleMapper;

    @PreAuthorize("hasAuthority('get_all_lounges')")
    @GetMapping
    public ResponseEntity<List<?>> listAll(){
        List<LoungeEntity> lounges = loungeService.findAll();
        return ResponseEntity.ok(lounges);
    }

    @PreAuthorize("hasAuthority('get_lounge_schedules')")
    @GetMapping("/schedule/{id}")
    public ResponseEntity<?> getLoungeSchedule(@PathVariable int id){
        List<ScheduleDTO> scheduleResponse = loungeService.listLoungeSchedulesById(id).stream()
                .map(scheduleMapper::toScheduleDTO)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }
}
