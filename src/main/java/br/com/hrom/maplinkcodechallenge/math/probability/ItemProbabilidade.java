package br.com.hrom.maplinkcodechallenge.math.probability;

/**
 * Um item de um cálculo de probabilidade. Possui os atribuitos <b>valor</b>, <b>referencia</b> e <b>valor</b>: <br>
 * Ex: <br>
 * <b>referencia</b>: uma instância de um objeto do qual queremos extrair algum tipo de probabilidade<br>
 * <b>valor</b>: um valor (em geral, extraído ou referente ao objeto de referencia) que será uma grandeza direta ou inderetamente proporcional à probabilidade <br>
 * <b>probabilidae</b>: chande de algo acontecer, basenado se no valor (peso) <br>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class ItemProbabilidade {
	private double valor;
	private double probabilidade;
	private Object referencia;

	/**
	 * 
	 * @param valor o valor (ou grandeza) a ser utilizada como peso no cálculo das probabilidades
	 * @param referencia um objeto que está relacionado ao valor (peso) que será utilizado no cálculo das probabilidades
	 */
	public ItemProbabilidade(double valor, Object referencia) {
		super();
		this.valor = valor;
		this.referencia = referencia;
	}

	public double getValor() {
		return valor;
	}
	
	/**
	 * Recupera o valor inverso. Utilizado para casos onde envolvam grandezas inversamente proporcionais
	 * 
	 * @return o inverso do valor (1/valor)
	 * @throws ArithmeticException nos casos onde o valor é igual a zero (1/0)
	 */
	public double getValorInverso()throws ArithmeticException{
		if(valor == 0)
			throw new ArithmeticException("O valor é zero. É impossível extrair o inverso em representação decimal, pois é necessário uma divisão por zero (1/0)");
		
		return 1/valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}

	/**
	 * 
	 * @param clazz um {@link Class} representando o tipo da referência a ser recuperada
	 * @return
	 */
	public <T> T getReferencia(Class<T> clazz){
		return clazz.cast(referencia);
	}
	
	public Object getReferencia() {
		return referencia;
	}

	public void setReferencia(Object grandeza) {
		this.referencia = grandeza;
	}
	
	
}
