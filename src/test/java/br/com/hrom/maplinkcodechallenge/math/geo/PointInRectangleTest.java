package br.com.hrom.maplinkcodechallenge.math.geo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import br.com.hrom.maplinkcodechallenge.domain.Point;

public class PointInRectangleTest {
	
	private Point bottomLeftPoint = new Point(40.746422, -73.994753);
	private Point topRightPoint = new Point( 40.763328, -73.968039);
	
	@Test
	public void pontoNosLimites(){
		Point point1 = new Point(40.746422, -73.994753);
		Point point2 = new Point(40.763328, -73.968039);
		
		Point point3 = new Point(40.746422, -73.968039);
		Point point4 = new Point(40.763328, -73.994753);
		
		Point point5 = new Point(40.746422, -73.974753);		
		
		assertTrue(PointInRectangle.test(point1 , bottomLeftPoint, topRightPoint));
		assertTrue(PointInRectangle.test(point2 , bottomLeftPoint, topRightPoint));
		assertTrue(PointInRectangle.test(point3 , bottomLeftPoint, topRightPoint));
		assertTrue(PointInRectangle.test(point4 , bottomLeftPoint, topRightPoint));
		assertTrue(PointInRectangle.test(point5 , bottomLeftPoint, topRightPoint));
	}
	
	@Test
	public void pontoDentro(){
		Point point = new Point(40.756422,  -73.978039);
		assertTrue(PointInRectangle.test(point , bottomLeftPoint, topRightPoint));
	}
	
	@Test
	public void PontoFora(){
		Point point = new Point(40.736422,  -73.978039);
		assertFalse(PointInRectangle.test(point , bottomLeftPoint, topRightPoint));
	}
}
