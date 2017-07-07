package br.com.hrom.maplinkcodechallenge.math.probability;

import java.util.List;

/**
 * Efetua o cálculo de probabilidades para grandezas inversamente proporcionas
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class ProbabilidadesInversas{

	private double somaProbabilidades;

	public ProbabilidadesInversas() {
		this(100.0);
	}

	public ProbabilidadesInversas(double somaProbabilidades) {
		this.somaProbabilidades = somaProbabilidades;
	}

	/**
	 * Faz o cálculo, baseando-se nos seguites passos: <br>
	 * 
	 * Sendo <b>x = a, b...n</b> grandezas inversamente proporcionas e o valores (peso) de um evento a acontecer. Sendo <b>c</b> a constante de proporcionalidades. <br>
	 * Temos que <b>1/x * c = probabilidade de acontecimento de um determinado evento</b>. <br><br>
	 * Então: <br>
	 * (1/a)c + (1/b)c + .... + (1/n)c = soma das probabilidades <br>
	 * 
	 * (1/a + 1/b + ... + 1/n)c = soma das probabilidades <br>
	 * 
	 * c = (soma das probabilidades)/(1/a + 1/b + ... + 1/n) <br><br>
	 * 
	 * Assim, podemos fazer: <br>
	 * (1/x)c = probabilidade <br>
	 * (1/x)((soma das probabilidades)/(1/a + 1/b + ... + 1/n)) = probabilidade <br>
	 * 
	 * @param itens 
	 * @return itens com as probabilidades calculadas
	 */
	public List<ItemProbabilidade> calcula(List<ItemProbabilidade> itens) {
		double somaProbabilidadesInversas = itens.stream().map(ItemProbabilidade::getValorInverso).reduce(0.0, (a, b) -> a + b);
		
		double constanteDeProporcionalidade = somaProbabilidades/somaProbabilidadesInversas;

		itens.forEach(item -> {
			item.setProbabilidade(item.getValorInverso() * constanteDeProporcionalidade);
		});

		return itens;
	}

}
