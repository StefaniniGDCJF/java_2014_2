package br.com.stefanini.treinamento;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import br.com.stefanini.treinamento.boleto.BloquetoBB;
import br.com.stefanini.treinamento.boleto.BloquetoProxy;
import br.com.stefanini.treinamento.exception.ManagerException;
import br.com.stefanini.treinamento.exception.NumeroConvenioException;

public class Principal {

	public static void main(String[] args) {

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

		try {
			BloquetoBB bloqueto = BloquetoProxy.getBloqueto(codigoBanco,
					codigoMoeda, dataVencimento, dataBase, valor,
					numeroConvenioBanco, complementoNumeroConvenioBancoSemDV,
					numeroAgenciaRelacionamento,
					contaCorrenteRelacionamentoSemDV, tipoCarteira);

			System.out.println("Código de Barras do Boleto Bancário:\t"
					+ bloqueto.getCodigoBarras());
			System.out.println("Linha digitável do Boleto Bancário:\t"
					+ bloqueto.getLinhaDigitavel());

		} catch (ManagerException e) {
			e.printStackTrace();
		} catch (NumeroConvenioException e) {
			e.printStackTrace();
		}

	}

}
