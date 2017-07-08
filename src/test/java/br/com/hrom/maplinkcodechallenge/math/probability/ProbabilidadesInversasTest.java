package br.com.hrom.maplinkcodechallenge.math.probability;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.number.IsCloseTo.closeTo;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProbabilidadesInversasTest {

	@Rule
    public ExpectedException expectedException = ExpectedException.none();	
	
	@SuppressWarnings("unchecked")
	@Test
	public void comTotatilidade100Porcento(){
		ItemProbabilidade item1 = new ItemProbabilidade(1.0, "villain distance to Gotham University");
		ItemProbabilidade item2 = new ItemProbabilidade(2.0, "villain distance to Gotham City Hall");
		ItemProbabilidade item3 = new ItemProbabilidade(3.0, "villain distance to Wayne Enterprises");
		
		List<ItemProbabilidade> itensCalculados = new ProbabilidadesInversas(100.0).calcula(Arrays.asList(item1, item2, item3));
		
		assertThat(itensCalculados,
				contains(
						allOf(
								hasProperty("referencia", equalTo("villain distance to Gotham University")),
								hasProperty("valor", equalTo(1.0)),
								hasProperty("probabilidade", closeTo(54.54, 0.5))
							),
						allOf(
								hasProperty("referencia", equalTo("villain distance to Gotham City Hall")),
								hasProperty("valor", equalTo(2.0)),
								hasProperty("probabilidade", closeTo(27.27, 0.5))
							),
						allOf(
								hasProperty("referencia", equalTo("villain distance to Wayne Enterprises")),
								hasProperty("valor", equalTo(3.0)),
								hasProperty("probabilidade", closeTo(18.18, 0.5))
							)
						
						)
				);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void comTotalidade1(){
		ItemProbabilidade item1 = new ItemProbabilidade(1.0, "villain distance to Gotham University");
		ItemProbabilidade item2 = new ItemProbabilidade(2.0, "villain distance to Gotham City Hall");
		ItemProbabilidade item3 = new ItemProbabilidade(3.0, "villain distance to Wayne Enterprises");
		
		List<ItemProbabilidade> itensCalculados = new ProbabilidadesInversas(1.0).calcula(Arrays.asList(item1, item2, item3));
		
		assertThat(itensCalculados,
				contains(
						allOf(
								hasProperty("referencia", equalTo("villain distance to Gotham University")),
								hasProperty("valor", equalTo(1.0)),
								hasProperty("probabilidade", closeTo(0.5454, 0.0005))
							),
						allOf(
								hasProperty("referencia", equalTo("villain distance to Gotham City Hall")),
								hasProperty("valor", equalTo(2.0)),
								hasProperty("probabilidade", closeTo(0.2727, 0.0005))
							),
						allOf(
								hasProperty("referencia", equalTo("villain distance to Wayne Enterprises")),
								hasProperty("valor", equalTo(3.0)),
								hasProperty("probabilidade", closeTo(0.1818, 0.0005))
							)
						
						)
				);
		
	}
	
	@Test
	public void comItemProbabilidadeComValorZero(){
		ItemProbabilidade item1 = new ItemProbabilidade(0.0, "villain distance to Gotham University");
		ItemProbabilidade item2 = new ItemProbabilidade(2.0, "villain distance to Gotham City Hall");
		ItemProbabilidade item3 = new ItemProbabilidade(3.0, "villain distance to Wayne Enterprises");
		expectedException.expect(ArithmeticException.class);
		new ProbabilidadesInversas(100.0).calcula(Arrays.asList(item1, item2, item3));		
	}
}
