package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Universidad {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private String nameUniversidad;
    private String nameCursos;
    private String fechaInicio;
    private String fechaFin;
    private String historialAcademico;
    private int educacion_id;
    private int educacion_persona_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameUniversidad() {
		return nameUniversidad;
	}
	public void setNameUniversidad(String nameUniversidad) {
		this.nameUniversidad = nameUniversidad;
	}
	public String getNameCursos() {
		return nameCursos;
	}
	public void setNameCursos(String nameCursos) {
		this.nameCursos = nameCursos;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getHistorialAcademico() {
		return historialAcademico;
	}
	public void setHistorialAcademico(String historialAcademico) {
		this.historialAcademico = historialAcademico;
	}
	public int getEducacion_id() {
		return educacion_id;
	}
	public void setEducacion_id(int educacion_id) {
		this.educacion_id = educacion_id;
	}
	public int getEducacion_persona_id() {
		return educacion_persona_id;
	}
	public void setEducacion_persona_id(int educacion_persona_id) {
		this.educacion_persona_id = educacion_persona_id;
	}



}