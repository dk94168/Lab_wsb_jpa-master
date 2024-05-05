package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// relacja dwukierunkowa, właściciel relacji od strony dziecka
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "visit_id")
	private Collection<MedicalTreatmentEntity> medical;

	// relacja jednokierunkowa, właściciel relacji
	@ManyToOne(
			//cascade = CascadeType.ALL,
			cascade = { CascadeType.MERGE, CascadeType.PERSIST },
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	// relacja jednokierunkowa, właściciel relacji
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() { return doctor; }
	public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }

	public PatientEntity getPatient() { return patient; }
	public void setPatient(PatientEntity patient) { this.patient = patient; }

}
