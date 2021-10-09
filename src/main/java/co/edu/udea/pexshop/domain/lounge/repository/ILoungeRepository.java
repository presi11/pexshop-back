package co.edu.udea.pexshop.domain.lounge.repository;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoungeRepository extends CrudRepository<LoungeEntity, Long> {


}
