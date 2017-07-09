package br.com.hrom.maplinkcodechallenge.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Target;
import br.com.hrom.maplinkcodechallenge.service.villainattack.VillainAttackProbabilityLogic;



@RunWith(SpringRunner.class)
@SpringBootTest
public class VillainAttackProbabilityLogicTest {

	@Autowired
	private VillainAttackProbabilityLogic logic;
	
	@Value("${villain.maxProbabilityAttack}")
	private double maxProbabilityAttack;
	
	@SuppressWarnings("unchecked")
	@Test
	public void calculaProbabilidade(){
		Target t1 = new Target("alvo1", new Point(10, 20), 1);
		Target t2 = new Target("alvo2", new Point(10, 20), 2);
		
		List<Target> targets = logic.calculeProbability(Arrays.asList(t1, t2));
		
		assertEquals(2, targets.size());
		assertThat(targets, 
				containsInAnyOrder(
						allOf(
								hasProperty("name", equalTo("alvo1")),	
								hasProperty("distanceToVillain", equalTo(1.0)),
								hasProperty("probability", closeTo(66.66, 0.009))
							),
						allOf(
								hasProperty("name", equalTo("alvo2")),	
								hasProperty("distanceToVillain", equalTo(2.0)),
								hasProperty("probability", closeTo(33.33, 0.009))
							)
						)
				);		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void calculaProbabilidadeComTargetComDistanciaIgualAZero(){
		Target t1 = new Target("alvo1", new Point(10, 20), 0);
		Target t2 = new Target("alvo2", new Point(10, 20), 2);
		
		List<Target> targets = logic.calculeProbability(Arrays.asList(t1, t2));
		
		assertEquals(2, targets.size());
		assertThat(targets, 
				containsInAnyOrder(
						allOf(
								hasProperty("name", equalTo("alvo1")),	
								hasProperty("distanceToVillain", equalTo(0.0)),
								hasProperty("probability", equalTo(95.0))
							),
						allOf(
								hasProperty("name", equalTo("alvo2")),	
								hasProperty("distanceToVillain", equalTo(2.0)),
								hasProperty("probability", equalTo(5.0))
							)
						)
				);	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void calculaProbabilidadeComTargetComProbabilidadeAcimaDoMaximo(){
		Target t1 = new Target("alvo1", new Point(10, 20), 100);
		Target t2 = new Target("alvo2", new Point(10, 20), 100);
		Target t3 = new Target("alvo3", new Point(10, 20), 1);
		
		List<Target> targets = logic.calculeProbability(Arrays.asList(t1, t2, t3));
		
		assertEquals(3, targets.size());
		assertThat(targets, 
				containsInAnyOrder(
							allOf(
									hasProperty("name", equalTo("alvo1")),	
									hasProperty("distanceToVillain", equalTo(100.0)),
									hasProperty("probability", equalTo(2.5))
								),
							allOf(
									hasProperty("name", equalTo("alvo2")),	
									hasProperty("distanceToVillain", equalTo(100.0)),
									hasProperty("probability", equalTo(2.5))
								),
							allOf(
									hasProperty("name", equalTo("alvo3")),	
									hasProperty("distanceToVillain", equalTo(1.0)),
									hasProperty("probability", equalTo(95.0))
								)
						)
				);	
	}
	
	@Test
	public void calculaProbabilidadeComListaDeAlvosVazia(){
		List<Target> targets = logic.calculeProbability(new ArrayList<Target>());
		assertEquals(0, targets.size());
	}
}
