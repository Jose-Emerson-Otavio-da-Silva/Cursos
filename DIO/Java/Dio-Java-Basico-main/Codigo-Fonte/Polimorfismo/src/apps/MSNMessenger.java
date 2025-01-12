package apps;

public class MSNMessenger extends ServicoMensagemInstantanea{
	public void enviarMensagem() {
		validarConectadoInternet();
		System.out.println("Enviando mensagem pelo MSN Messenger");
	}
	public void receberMensagem() {
		System.out.println("Recebendo mensagem pelo MSN Messenger");
	}
	@Override
	public void salvarHistoricoMensagem() {
		// TODO Auto-generated method stub
		System.out.println("Salvando o histórico da mensagem");
	}
}
