package kavinex;

import java.util.Arrays;


public class RuosiamasPatiekalas extends Patiekalas {
	
	public int trukme_ruosimo;
	
	public RuosiamasPatiekalas() {
		
	}
	
	public RuosiamasPatiekalas (
			String pavadinimas
			, String n_busena
			, int id_uzsakymo
			, int trukme_ruosimo 
			, String laikas_uzsakymo
			, String laikas_pateikimo
			, Double kaina
			, String klientas			
		) {
		
		super ( 
				pavadinimas
				, n_busena
				, id_uzsakymo
				, laikas_uzsakymo
				, laikas_pateikimo
				, kaina
				, klientas				
		);
		this.trukme_ruosimo = trukme_ruosimo;
		bus_paruostas_uz += trukme_ruosimo;
		bus_patiektas_apytiksliai_uz += trukme_ruosimo;
		bukle = PatiekaluPateikimoBusenos.Neparuoštas;
	}
	
	public boolean papildomiPalyginimai (Object obj) {
		
		boolean iret = false; 
		
		String[] galimosKlases = { "kavinex.RuosiamasPatiekalas", "kavinex.KarstasPatiekalas" };
		
		if (  
					Arrays.asList ( galimosKlases ).indexOf( obj.getClass().getName() )
				 >=
					0
				) {		
		
			RuosiamasPatiekalas palyginimui = ( RuosiamasPatiekalas ) obj;
			iret = 
					super.papildomiPalyginimai( obj )
				&&					
					this.trukme_ruosimo == palyginimui.trukme_ruosimo
				;
		}
		return iret;
	}
	
	public String toString() {
		
		return super.toString() + this.trukme_ruosimo + ";";
	}	

	public int trukmeRuosimo() {
		
		return bus_paruostas_uz;
	}	
}