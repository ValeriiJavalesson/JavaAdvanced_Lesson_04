package valerko.lgs.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private Accreditation accreditation;
	@Column
	private Integer numberOfInstitutes;
	@Column
	private Integer numberОfStudents;
	@Column
	private String address;

	public University() {
	}

	public University(String name, Accreditation accreditation, Integer numberOfInstitutes, Integer numberОfStudents,
			String address) {
		this.name = name;
		this.accreditation = accreditation;
		this.numberOfInstitutes = numberOfInstitutes;
		this.numberОfStudents = numberОfStudents;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Accreditation getAccreditation() {
		return accreditation;
	}

	public void setAccreditation(Accreditation accreditationLevel) {
		this.accreditation = accreditationLevel;
	}

	public Integer getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(Integer numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public Integer getNumberОfStudents() {
		return numberОfStudents;
	}

	public void setNumberОfStudents(Integer numberОfStudents) {
		this.numberОfStudents = numberОfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", accreditation=" + accreditation + ", numberOfInstitutes="
				+ numberOfInstitutes + ", numberОfStudents=" + numberОfStudents + ", address=" + address + "]";
	}

}
