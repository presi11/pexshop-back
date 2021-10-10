package co.edu.udea.pexshop.domain.lounge.service;


import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.repository.ILoungeRepository;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import co.edu.udea.pexshop.domain.schedule.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoungeServiceImplemented  implements ILoungeService {

    @Autowired
    private ILoungeRepository loungeRepository;

    @Autowired
    private IScheduleService scheduleService;

    @Override
    public List<LoungeEntity> findAll() {
        return (List<LoungeEntity>) loungeRepository.findAll();
    }

    @Override
    public List<ScheduleEntity> listLoungeSchedulesById(int id) {
        List<ScheduleEntity> schedules = scheduleService.getSchedulesFromLoungeByLoungeId(Long.valueOf(id));
        return schedules;
    }

    @Override
    public int getCurrentCapacityOfLoungeByLoungeId(int id) {
        return loungeRepository.getAvailableQuotasByLoungeId(Long.valueOf(id));
    }

    @Override
    public void updateCurrentLoungeCapacity(LoungeEntity loungeEntity) {
        loungeRepository.sumLoungeCurrentQuantity(loungeEntity.getId());
    }
}
