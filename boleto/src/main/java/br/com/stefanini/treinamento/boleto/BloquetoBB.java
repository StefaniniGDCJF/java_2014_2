package br.com.stefanini.treinamento.boleto;

public interface BloquetoBB {

	/**
	 * Retorna o código de barras do Bloqueto
	 * 
	 * @return código de barras
	 */
	public String getCodigoBarras();

	/**
	 * Retorna a linha digitável do Bloqueto
	 * 
	 * @return Linha digitável
	 */
	public String getLinhaDigitavel();

	/**
	 * Retorna o digito verificador do código de barras
	 * 
	 * @return
	 */
	public int getDvCodigoBarras();

}
