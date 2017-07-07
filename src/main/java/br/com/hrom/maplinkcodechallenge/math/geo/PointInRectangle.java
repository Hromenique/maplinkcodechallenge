package br.com.hrom.maplinkcodechallenge.math.geo;

import br.com.hrom.maplinkcodechallenge.domain.Point;

/**
 * 
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class PointInRectangle {	
	
	 public static boolean test(Point point, Point bottomLeftPoint, Point topRightPoint) {
         double cx = Math.min(bottomLeftPoint.getLat(), topRightPoint.getLat());
         double cy = Math.min(bottomLeftPoint.getLng(), topRightPoint.getLng());

         double dx = Math.max(bottomLeftPoint.getLat(), topRightPoint.getLat());
         double dy = Math.max(bottomLeftPoint.getLng(), topRightPoint.getLng());

         return ((point.getLat() >= cx) && (point.getLat() <= dx) && (point.getLng() >= cy) && (point.getLng() <= dy));

}
}
