package valerko.lgs.service;

import java.util.List;

import valerko.lgs.domain.Accreditation;
import valerko.lgs.domain.University;

public interface UniversityService {

	University create(University university);

	University findById(int id);

	University findByName(String name);

	University update(University university);

	void deleteById(Long id);

	Long deleteByName(String name);

	Long deleteByAddress(String address);

	List<University> findByAccreditation(Accreditation accreditationLevel);

	List<University> findByNumberOfInstitutes(Integer numberOfInstitutes);

	List<University> findByNumberОfStudents(Integer numberОfStudents);

	List<University> findByAddress(String Address);

	List<University> findAll();

	Long deleteByAccreditation(Accreditation accreditation);

}
