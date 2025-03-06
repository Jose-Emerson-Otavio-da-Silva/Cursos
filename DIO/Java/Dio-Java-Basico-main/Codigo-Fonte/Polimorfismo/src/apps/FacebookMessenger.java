package apps;

public class FacebookMessenger extends ServicoMensagemInstantanea{
	public void enviarMensagem() {
		validarConectadoInternet();
		System.out.println("Enviando mensagem pelo Facebook Messenger");
	}
	public void receberMensagem() {
		System.out.println("Recebendo mensagem pelo Facebook Messenger");
	}
	@Override
	public void salvarHistoricoMensagem() {
		// TODO Auto-generated method stub
		System.out.println("Salvando o histórico da mensagem");
	}
}
