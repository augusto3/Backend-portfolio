package com.project.portfolio.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private String nameCurso;
    private String urlCurso;
    private String urlCertificado;
    private int educacion_id;
    private int educacion_persona_id;

    public Cursos() {
    }
    
    public long getId() {
	return id;
    }
    public void setId(long id) {
	this.id = id;
    }
    public String getNameCurso() {
	return nameCurso;
    }
    public void setNameCurso(String nameCurso) {
	this.nameCurso = nameCurso;
    }
    public String getUrlCurso() {
	return urlCurso;
    }
    public void setUrlCurso(String urlCurso) {
    	this.urlCurso = urlCurso;
    }
    public String getUrlCertificado() {
    	return urlCertificado;
    }
    public void setUrlCertificado(String urlCertificado) {
    	this.urlCertificado = urlCertificado;
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
