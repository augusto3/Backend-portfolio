package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private String nameProyectos;
    private String urlProyectos;
    private String descripcion;
    private int Persona_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameProyectos() {
		return nameProyectos;
	}
	public void setNameProyectos(String nameProyectos) {
		this.nameProyectos = nameProyectos;
	}
	public String getUrlProyectos() {
		return urlProyectos;
	}
	public void setUrlProyectos(String urlProyectos) {
		this.urlProyectos = urlProyectos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPersona_id() {
		return Persona_id;
	}
	public void setPersona_id(int persona_id) {
		Persona_id = persona_id;
	}
    
    
    
}
