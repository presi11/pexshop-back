package co.edu.udea.pexshop.domain.lounge.service;


import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.repository.ILoungeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoungeServiceImplemented  implements ILoungeService {

    @Autowired
    private ILoungeRepository loungeRepository;

    @Override
    public List<LoungeEntity> findAll() {
        return (List<LoungeEntity>) loungeRepository.findAll();
    }
}
