package co.edu.udea.pexshop.domain.lounge.service;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;

import java.util.List;

public interface ILoungeService {

    List<LoungeEntity> findAll();

    List<ScheduleEntity> listLoungeSchedulesById(int id);

    int getCurrentCapacityOfLoungeByLoungeId(int id);

    void updateCurrentLoungeCapacity(LoungeEntity loungeEntity);
}
