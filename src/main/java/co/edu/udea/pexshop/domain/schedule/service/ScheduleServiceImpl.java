package co.edu.udea.pexshop.domain.schedule.service;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.service.ILoungeService;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IPetService;
import co.edu.udea.pexshop.domain.schedule.model.dto.CreateScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import co.edu.udea.pexshop.domain.schedule.repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private ILoungeService loungeService;

    @Autowired
    private IPetService petService;

    @Override
    public boolean createSchedule(CreateScheduleDTO createScheduleDTO) {
        // validate maximum capacity
        int capacity = loungeService.getCurrentCapacityOfLoungeByLoungeId(createScheduleDTO.getLoungeId());
        ScheduleEntity schPet = scheduleRepository.getScheduleByPetId(Long.valueOf(createScheduleDTO.getPetId()));
        Pet currentPet = petService.findById(Long.valueOf(createScheduleDTO.getPetId()));
        if (capacity > 0 && schPet == null && currentPet != null) {
            Pet petAssigned = new Pet();
            LoungeEntity lounge = new LoungeEntity();
            ScheduleEntity schedule = new ScheduleEntity();
            lounge.setId(Long.valueOf(createScheduleDTO.getLoungeId()));
            petAssigned.setId(Long.valueOf(createScheduleDTO.getPetId()));

            schedule.setPet(petAssigned);
            schedule.setLounge(lounge);
            schedule.setSchool(createScheduleDTO.isSchool());
            schedule.setKindergarten(createScheduleDTO.isKindergarten());
            schedule.setSunDay(createScheduleDTO.isSunDay());
            schedule.setStatus(Boolean.valueOf(true));
            java.util.Date currentDate = new java.util.Date();
            schedule.setScheduleDate(new Date(currentDate.getTime()));
            scheduleRepository.save(schedule);
            lounge.setCurrentQuantity(capacity - 1);
            loungeService.updateCurrentLoungeCapacity(lounge);
            return true;
        }
        return false;
    }

    @Override
    public List<ScheduleEntity> getSchedulesFromLoungeByLoungeId(Long id) {
        return scheduleRepository.getSchedulesByLoungeId(id);
    }
}
