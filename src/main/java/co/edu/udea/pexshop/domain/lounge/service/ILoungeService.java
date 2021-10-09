package co.edu.udea.pexshop.domain.lounge.service;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;

import java.util.List;

public interface ILoungeService {

    List<LoungeEntity> findAll();
}
