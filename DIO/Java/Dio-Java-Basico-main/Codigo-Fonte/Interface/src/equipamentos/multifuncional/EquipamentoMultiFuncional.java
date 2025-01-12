package equipamentos.multifuncional;

import equipamentos.copiadora.Copiadora;
import equipamentos.digitalizadora.Digitalizadora;
import equipamentos.impressora.Impressora;

public class EquipamentoMultiFuncional implements Copiadora, Digitalizadora, Impressora{
	public void copiar() {
		// TODO Auto-generated method stub
		System.out.println("Copiando via Multifuncional.");
	}

	public void digitalizar() {
		// TODO Auto-generated method stub
		System.out.println("Digitalizando via Multifuncional.");
	}

	public void imprimir() {
		// TODO Auto-generated method stub
		System.out.println("Imprimindo via Multifuncional.");
	}

}
