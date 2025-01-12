package estabelecimento;

import equipamentos.copiadora.Copiadora;
import equipamentos.digitalizadora.Digitalizadora;
import equipamentos.impressora.Deskjet;
import equipamentos.impressora.Impressora;
import equipamentos.multifuncional.EquipamentoMultiFuncional;

public class Fabrica {
	public static void main(String[] args) {
		EquipamentoMultiFuncional en = new EquipamentoMultiFuncional();
		
		Impressora impressora = en;
		Digitalizadora digitalizadora = en;
		Copiadora copiadora = en;
		
		Impressora deskjet = new Deskjet();		
		
		impressora.imprimir();
		digitalizadora.digitalizar();
		copiadora.copiar();
		deskjet.imprimir();
	}	
}
