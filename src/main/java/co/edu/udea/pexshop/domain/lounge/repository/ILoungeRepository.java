package co.edu.udea.pexshop.domain.lounge.repository;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ILoungeRepository extends CrudRepository<LoungeEntity, Long> {

    @Query("SELECT lng.maximumCapacity - lng.currentQuantity FROM LoungeEntity lng where lng.id = ?1")
    int getAvailableQuotasByLoungeId(Long id);

    @Modifying
    @Query("UPDATE LoungeEntity lng set lng.currentQuantity = lng.currentQuantity + 1 where lng.id = ?1")
    void sumLoungeCurrentQuantity(Long id);
}
