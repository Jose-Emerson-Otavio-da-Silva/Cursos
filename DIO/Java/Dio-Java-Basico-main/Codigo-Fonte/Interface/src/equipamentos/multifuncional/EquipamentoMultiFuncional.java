package equipamentos.multifuncional;

import equipamentos.copiadora.Copiadora;
import equipamentos.digitalizadora.Digitalizadora;
import equipamentos.impressora.Impressora;

public class EquipamentoMultiFuncional implements Copiadora, Digitalizadora, Impressora {
	public void copiar() {
		System.out.println("Copiando via Multifuncional.");
	}

	public void digitalizar() {
		System.out.println("Digitalizando via Multifuncional.");
	}

	public void imprimir() {
		System.out.println("Imprimindo via Multifuncional.");
	}

}
