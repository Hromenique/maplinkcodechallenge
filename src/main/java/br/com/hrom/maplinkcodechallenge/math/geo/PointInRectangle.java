package br.com.hrom.maplinkcodechallenge.math.geo;

import br.com.hrom.maplinkcodechallenge.domain.Point;

/**
 * Responsávle pelo algoritmo que indica se um ponto encontra-se dentro da área delimitada de retângulo delimitado por dois pontos (bottomLeftPoint e topRightPoint)
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class PointInRectangle {

	/**
	 * Verifica se um ponto encontra-se dentro da área de um retângulo
	 * 
	 * @param point ponto a ser verificado
	 * @param bottomLeftPoint ponto baixo e à esquerda que é um dos limites do retângulo
	 * @param topRightPoint ponto topo e à direita que é um dos limites do retângulo
	 * @return
	 */
	public static boolean test(Point point, Point bottomLeftPoint, Point topRightPoint) {
		double cx = Math.min(bottomLeftPoint.getLat(), topRightPoint.getLat());
		double cy = Math.min(bottomLeftPoint.getLng(), topRightPoint.getLng());

		double dx = Math.max(bottomLeftPoint.getLat(), topRightPoint.getLat());
		double dy = Math.max(bottomLeftPoint.getLng(), topRightPoint.getLng());

		return ((point.getLat() >= cx) && (point.getLat() <= dx) && (point.getLng() >= cy) && (point.getLng() <= dy));

	}
}
