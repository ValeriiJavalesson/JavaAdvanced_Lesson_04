package valerko.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import valerko.lgs.dao.ParticipantRepository;
import valerko.lgs.domain.Participant;
import valerko.lgs.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {
	
	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public Participant create(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public Participant readById(Integer id) {
		return participantRepository.getOne(id);
	}

	@Override
	public Participant update(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public void deleteById(Integer id) {
		participantRepository.deleteById(id);

	}

	@Override
	public List<Participant> readAll() {
		return participantRepository.findAll();
	}

}
