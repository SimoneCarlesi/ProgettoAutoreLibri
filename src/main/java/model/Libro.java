package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
@NamedQuery(
	    name="findAllBooks",
	    query="SELECT c FROM Libro c"
	)
public class Libro implements Serializable{ //
	//Eclipse:(1) Select: 
	//(Your Project) -> Properties -> JPA;
	// (2) Look for "Persistent class management" and select the option "Discover annotated classes automatically"; 
	//(3) Press "Apply".

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int libroId;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "numero_pagine")
	private int numeroPagine;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn()
	private Autore autore;

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
