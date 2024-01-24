package valerko.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import valerko.lgs.domain.Accreditation;
import valerko.lgs.domain.University;

public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {

	List<University> findByAccreditation(Accreditation accreditationLevel);

	List<University> findByNumberOfInstitutes(Integer numberOfInstitutes);

	List<University> findByNumberОfStudents(Integer numberОfStudents);

	List<University> findByAddress(String address);

	University findByName(String name);

	Long deleteByName(String name);

	Long deleteByAddress(String address);

	Long deleteByAccreditation(Accreditation accreditation);

}
