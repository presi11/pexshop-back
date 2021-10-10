package co.edu.udea.pexshop.integration.domain.lounge.service;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.service.ILoungeService;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LoungeServiceImplementedSpec {

    @Autowired
    private ILoungeService loungeService;

    @Test
    public void getLoungesList() {
        List<LoungeEntity> lounges =  loungeService.findAll();
        assert(lounges.size() > 0);
    }

    @Test
    public void getSchedulesFromLoungeId() {
        List<ScheduleEntity> lounges =  loungeService.listLoungeSchedulesById(1);
        assert(lounges.size() > 0);
    }
}
