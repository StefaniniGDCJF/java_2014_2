package br.com.stefanini.treinamento.boleto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.Assert;

import br.com.stefanini.treinamento.exception.ManagerException;
import br.com.stefanini.treinamento.exception.NumeroConvenioException;

public class TestBoletoConvenio6 {

	@Test
	public void testConvenio6CodigoBarras() throws ManagerException,
			NumeroConvenioException {

		String codigoBanco = "001";
		String codigoMoeda = "9";

		Calendar calendarVencimento = Calendar.getInstance();
		calendarVencimento.set(2014, 07, 30);
		Date dataVencimento = calendarVencimento.getTime();

		Calendar calendar = Calendar.getInstance();
		calendar.set(1997, 10, 07);
		Date dataBase = calendar.getTime();

		BigDecimal valor = BigDecimal.valueOf(655.87);
		String numeroConvenioBanco = "123456";
		String complementoNumeroConvenioBancoSemDV = "12345";
		String numeroAgenciaRelacionamento = "2121";
		String contaCorrenteRelacionamentoSemDV = "01423574";
		String tipoCarteira = "17";

		BloquetoBB bloqueto = BloquetoProxy.getBloqueto(codigoBanco,
				codigoMoeda, dataVencimento, dataBase, valor,
				numeroConvenioBanco, complementoNumeroConvenioBancoSemDV,
				numeroAgenciaRelacionamento, contaCorrenteRelacionamentoSemDV,
				tipoCarteira);

		Assert.assertEquals(bloqueto.getCodigoBarras(),
				"00195614000000655871234561234521210142357417");

	}

	@Test
	public void testConvenio6LinhaDigitavel() throws ManagerException,
			NumeroConvenioException {

		String codigoBanco = "001";
		String codigoMoeda = "9";

		Calendar calendarVencimento = Calendar.getInstance();
		calendarVencimento.set(2014, 07, 30);
		Date dataVencimento = calendarVencimento.getTime();

		Calendar calendar = Calendar.getInstance();
		calendar.set(1997, 10, 07);
		Date dataBase = calendar.getTime();

		BigDecimal valor = BigDecimal.valueOf(655.87);
		String numeroConvenioBanco = "123456";
		String complementoNumeroConvenioBancoSemDV = "12345";
		String numeroAgenciaRelacionamento = "2121";
		String contaCorrenteRelacionamentoSemDV = "01423574";
		String tipoCarteira = "17";

		BloquetoBB bloqueto = BloquetoProxy.getBloqueto(codigoBanco,
				codigoMoeda, dataVencimento, dataBase, valor,
				numeroConvenioBanco, complementoNumeroConvenioBancoSemDV,
				numeroAgenciaRelacionamento, contaCorrenteRelacionamentoSemDV,
				tipoCarteira);

		Assert.assertEquals(bloqueto.getLinhaDigitavel(),
				"00191.23454 61234.521211 01423.574175 5 61400000065587");

	}

}
