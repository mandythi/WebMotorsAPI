package steps.com.br;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import requests.com.br.Gets;

public class WebMotorsAPISteps extends Gets {

	@SuppressWarnings("unused")
	private String endPoint = null;
	@SuppressWarnings("unused")
	private String parametro = null;
	@SuppressWarnings("unused")
	private String valor = null;
	@SuppressWarnings("unused")
	private String statusCode = null;
	@SuppressWarnings("unused")
	private String quantidadeVeiculos = null;

	@Dado("^que envio um GET para o endPoint \"([^\"]*)\"$")
	public void queEnvioUmGETParaOEndPoint(String endPoint) {
		this.endPoint = endPoint;
		relatorio("Dado que envio um GET para o endPoint " + endPoint + " executado com sucesso");
	}

	@Dado("^o Response Code me retorna status \"([^\"]*)\"$")
	public void oResponseCodeMeRetornaStatus(String statusCode) {
		this.statusCode = statusCode;
		relatorio("Dado que Response Code me retorna status " + statusCode + " executado com sucesso");
	}

	@Dado("^envio o parâmetro \"([^\"]*)\" com valor \"([^\"]*)\"$")
	public void envioOParâmetroComValor(String parametro, String valor) {
		this.parametro = parametro;
		this.valor = valor;
		relatorio("E envio o parâmetro " + parametro + " com valor " + valor);
	}

	@Dado("^valido a quantidade de veiculos \"([^\"]*)\"$")
	public void validoAQuantidadeDeVeiculos(String quantidadeVeiculos) {
		GetContaPaginas(endPoint, valor, statusCode, quantidadeVeiculos);
	}

	@Dado("^valido Response Body vazio$")
	public void validoResponseBodyVazio() {
		relatorio("E valido Response Body vazio");
	}
	
	@Então("^valido o Schema \"([^\"]*)\"$")
	public void validoOSchema(String nomeSchema) {
		validaSchema(endPoint, statusCode, parametro, valor, nomeSchema);
	}

	@Dado("^valido Response Body \"([^\"]*)\" e \"([^\"]*)\"$")
	public void validoResponseBodyE(String message, String messageDetail) {
		validaItemBodyJson("Message", message);
		validaItemBodyJson("MessageDetail", messageDetail);
	}

	
}
