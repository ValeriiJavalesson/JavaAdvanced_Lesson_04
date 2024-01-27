package valerko.lgs.service;

import java.util.List;

import valerko.lgs.domain.Participant;

public interface ParticipantService {

	Participant create(Participant participant);

	Participant readById(Integer id);

	Participant update(Participant participant);

	void deleteById(Integer id);

	List<Participant> readAll();
}
