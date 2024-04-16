package ma.xproce.inventoryservice.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.inventoryservice.dao.entities.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface CreatorRepository extends JpaRepository<Creator,Integer> {
    Page<Creator> findByNomContains(String keyword, Pageable pageable);

}
