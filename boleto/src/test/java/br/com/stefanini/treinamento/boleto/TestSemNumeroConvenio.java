package br.com.stefanini.treinamento.boleto;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import br.com.stefanini.treinamento.exception.ManagerException;
import br.com.stefanini.treinamento.exception.NumeroConvenioException;

public class TestSemNumeroConvenio {

	@Test(expected = NumeroConvenioException.class)
	public void testSemNumeroConvenio() throws ManagerException, NumeroConvenioException {

		String codigoBanco = "";
		String codigoMoeda = "";
		Date dataVencimento = null;
		Date dataBase = null;
		BigDecimal valor = null;
		String numeroConvenioBanco = null;
		String complementoNumeroConvenioBancoSemDV = null;
		String numeroAgenciaRelacionamento = null;
		String contaCorrenteRelacionamentoSemDV = null;
		String tipoCarteira = null;

		BloquetoBB bloqueto = BloquetoProxy.getBloqueto(codigoBanco,
				codigoMoeda, dataVencimento, dataBase, valor,
				numeroConvenioBanco, complementoNumeroConvenioBancoSemDV,
				numeroAgenciaRelacionamento, contaCorrenteRelacionamentoSemDV,
				tipoCarteira);

		System.out.println("Código de Barras do Boleto Bancário"
				+ bloqueto.getCodigoBarras());
		System.out.println("Linha digitável do Boleto Bancário"
				+ bloqueto.getCodigoBarras());

	}

}
