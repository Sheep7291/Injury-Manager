package Training.Plan.Injury.Manager.repository;

import Training.Plan.Injury.Manager.entity.InjuryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjuryRepository extends JpaRepository<InjuryEntity,Long > {

    List<InjuryEntity> findByUsername(String username);

}
