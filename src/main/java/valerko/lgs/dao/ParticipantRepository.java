package valerko.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import valerko.lgs.domain.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>, CrudRepository<Participant, Integer> {


}
