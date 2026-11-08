package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;

import java.util.ArrayList;

public class Blogg extends Innlegg {

private Innlegg[] innleggtabell  = new Innlegg[0];
private int nesteledig;

	public Blogg() {
this(20);
	}

	public Blogg(int lengde) {
	this.innleggtabell= new Innlegg [lengde];
	}

	public int getAntall() {
        return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
        for (int i=0; i<getAntall(); i++){
		if(innleggtabell[i].getId()==innlegg.getId()){return i;}
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {
       return(finnInnlegg(innlegg)!=-1);
	}

	public boolean ledigPlass() {
		return getAntall()!=innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
if(finnes(innlegg)){return false;}
if(!ledigPlass()){return false;}
        innleggtabell[nesteledig] = innlegg;
        nesteledig++;
        return true;
	}
	
	public String toString() {
        int[] tilStreng  = new int[getAntall()];

        for(int i=0; i<tilStreng.length; i++){
            if(innleggtabell[i] instanceof Bilde) {
                tilStreng[i]=-i-1;
            }
            else{tilStreng[i]=i;}
        }
		return(getAntall()+"\n"+tilStrengRekursjon(tilStreng));
	}

    public String tilStrengRekursjon(int[] e){
        if(e.length==0){return "";}
        int[] tilStreng  = new int[e.length-1];
        for (int i=1; i<e.length; i++){
            tilStreng[i-1]=e[i];
        }
        return castTilStreng(e[0])+(tilStrengRekursjon(tilStreng));
    }
    public String castTilStreng(int e){
        if(e<0) {
            e = (e * -1) - 1;
           Bilde casted  =(Bilde) innleggtabell[e];
           return casted.toString();
        }
         Tekst casted  =(Tekst) innleggtabell[e];
        return casted.toString();
    }
	// valgfrie oppgaver nedenfor
	
	public void utvid() {
            Innlegg[] utvidetTabell = new Innlegg[Math.max(innleggtabell.length * 2, 1)];
            for (int i = 0; i < getAntall(); i++) {
                utvidetTabell[i] = innleggtabell[i];
            }
            innleggtabell = utvidetTabell;
        }

	
	public boolean leggTilUtvid(Innlegg innlegg) {
        if(finnes(innlegg)){return false;}
	if(!ledigPlass()){
        utvid();
    }
        leggTil(innlegg);
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
        int i =finnInnlegg(innlegg);
        if(i<0){return false;}
                Innlegg [] nyTabell = new Innlegg[innleggtabell.length];

                for (int j=0; j<getAntall()-1; j++){
                    if(j<i){nyTabell[j]=  innleggtabell[j];
                }else{nyTabell[j]=  innleggtabell[j+1];}
                }
        innleggtabell=nyTabell;
		nesteledig--;
        return true;
	}
	
	public int[] search(String k) {
        int[] inneholderOrd =new int[getAntall()];
        int j=0;
         for (int i=0; i<inneholderOrd.length; i++){

    { Tekst castedTekst  =(Tekst) innleggtabell[i];
        if(castedTekst.getTekst().contains(k)){
            inneholderOrd[j]= innleggtabell[i].getId();
            j++;}
         }}
int[]retur = new int[j];
         for (int l=0; l<j; l++){
             retur[l]=inneholderOrd[l];
         }
        return retur;
}}