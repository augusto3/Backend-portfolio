package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class MisHabilidades {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private String lenguaje;
    private int porcentaje;
    private int Persona_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getPersona_id() {
		return Persona_id;
	}
	public void setPersona_id(int persona_id) {
		Persona_id = persona_id;
	}	 


    
}
