package br.com.stefanini.treinamento.boleto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.stefanini.treinamento.exception.ManagerException;
import br.com.stefanini.treinamento.exception.NumeroConvenioException;

public class BloquetoProxy {

	public static BloquetoBB getBloqueto(String codigoBanco,
			String codigoMoeda, Date dataVencimento, Date dataBase,
			BigDecimal valor, String numeroConvenioBanco,
			String complementoNumeroConvenioBancoSemDV,
			String numeroAgenciaRelacionamento,
			String contaCorrenteRelacionamentoSemDV, String tipoCarteira)
			throws NumeroConvenioException, ManagerException {

		if (numeroConvenioBanco == null || numeroConvenioBanco.isEmpty()) {
			throw new NumeroConvenioException(
					"Número do convênio não informado");
		}

		if (numeroConvenioBanco.length() == 4) {
			return new BloquetoBBConvenio4(codigoBanco, codigoMoeda,
					dataVencimento, dataBase, valor, numeroConvenioBanco,
					complementoNumeroConvenioBancoSemDV,
					numeroAgenciaRelacionamento,
					contaCorrenteRelacionamentoSemDV, tipoCarteira);
		}

		if (numeroConvenioBanco.length() == 6) {
			return new BloquetoBBConvenio6(codigoBanco, codigoMoeda,
					dataVencimento, dataBase, valor, numeroConvenioBanco,
					complementoNumeroConvenioBancoSemDV,
					numeroAgenciaRelacionamento,
					contaCorrenteRelacionamentoSemDV, tipoCarteira);
		}

		if (numeroConvenioBanco.length() >= 7) {
			return new BloquetoBBConvenioAcima1000000(codigoBanco, codigoMoeda,
					dataVencimento, dataBase, valor, numeroConvenioBanco,
					complementoNumeroConvenioBancoSemDV,
					numeroAgenciaRelacionamento,
					contaCorrenteRelacionamentoSemDV, tipoCarteira);
		}

		throw new ManagerException(String.format(
				"Número do convênio %s inválido ou não implementado ",
				numeroConvenioBanco));

	}
}
