package valerko.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import valerko.lgs.dao.UniversityRepository;
import valerko.lgs.domain.Accreditation;
import valerko.lgs.domain.University;
import valerko.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University create(University university) {
		return universityRepository.save(university);
	}

	@Override
	public University findById(int id) {
		return universityRepository.getReferenceById((long) id);
	}

	@Override
	public University findByName(String name) {

		return universityRepository.findByName(name);
	}

	@Override
	public University update(University university) {
		return universityRepository.save(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Long deleteByName(String name) {
		return universityRepository.deleteByName(name);

	}

	@Override
	public List<University> findByAccreditation(Accreditation accreditationLevel) {
		return universityRepository.findByAccreditation(accreditationLevel);
	}

	@Override
	public List<University> findByNumberOfInstitutes(Integer numberOfInstitutes) {
		return universityRepository.findByNumberOfInstitutes(numberOfInstitutes);
	}

	@Override
	public List<University> findByNumberОfStudents(Integer numberОfStudents) {
		return universityRepository.findByNumberОfStudents(numberОfStudents);
	}

	@Override
	public List<University> findByAddress(String address) {
		return universityRepository.findByAddress(address);
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

	@Transactional
	@Override
	public Long deleteByAddress(String address) {
		return universityRepository.deleteByAddress(address);
	}

	@Transactional
	@Override
	public Long deleteByAccreditation(Accreditation accreditation) {
		return universityRepository.deleteByAccreditation(accreditation);
	}
}
