package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
	private int id;
    private int likes;
    private String bruker;
    private String dato;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {

		this.id =id;
        this.likes=0;
        this.bruker=bruker;
        this.dato=dato;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

        this.id =id;
        this.likes=likes;
        this.bruker=bruker;
        this.dato=dato;
	}
	public String getBruker() {
		return bruker;
	}
	public void setBruker(String bruker) {this.bruker=bruker;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato=dato;
	}

	public int getId() {
		return id;
	}
	public int getLikes() {
		return likes;
	}
	public void doLike () {
		this.likes=likes+1;
	}
	public boolean erLik(Innlegg innlegg) {
		return id==innlegg.id;
	}
	@Override
	public String toString() {
		return (this.id+"\n"+ this.bruker+"\n"+this.dato+"\n"+this.likes+"\n");

	}

}
