package br.com.hrom.maplinkcodechallenge.domain;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

import br.com.hrom.maplinkcodechallenge.math.geo.PointInRectangle;

/**
 * Um cidade contendo perímetro retangular ({@link Point}) e localidades
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String name;
	List<Location> locations = new ArrayList<Location>();
	private Point bottomLeftPoint;
	private Point topRightPoint;

	public City(Point bottomLeftPoint, Point topRightPoint) {
		super();
		setBottomLeftPoint(bottomLeftPoint);
		setTopRightPoint(topRightPoint);
	}

	public City(String name, Point bottomLeftPoint, Point topRightPoint) {
		super();
		this.name = name;
		setBottomLeftPoint(bottomLeftPoint);
		setTopRightPoint(topRightPoint);
	}

	public City(String name, List<Location> targets, Point bottomLeftPoint, Point topRightPoint) {
		super();
		this.name = name;
		this.locations = targets;
		setBottomLeftPoint(bottomLeftPoint);
		setTopRightPoint(topRightPoint);
	}

	/**
	 * Verifica se um ponto está contido dentro da área da cidade
	 * 
	 * @param point
	 * @return
	 */
	public boolean contains(Point point) {
		return PointInRectangle.test(point, bottomLeftPoint, topRightPoint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Busca uma localização dentro da cidade
	 * 
	 * @param locationName nome do local procurado
	 * @return um {@link Optional} que pode conter os dados do local procurado
	 */
	public Optional<Location> findLocationByName(String locationName){
		Optional<Location> location = locations.stream().filter(local -> local.getName().equals(locationName)).findFirst();
		
		if(location.isPresent())
			return Optional.of(SerializationUtils.clone(location.get()));
		
		return Optional.empty();
	}

	public List<Location> getLocations() {
		return this.locations.stream().map(source -> SerializationUtils.clone(source)).collect(Collectors.toList());
	}

	public void addTarget(Location target) {
		notNull(target, "target não pode ser null");
		this.locations.add(target);
	}

	public void setLocations(List<Location> targets) {
		notNull(targets, "locations não pode ser null");
		this.locations = targets;
	}

	public Point getBottomLeftPoint() {
		return bottomLeftPoint;
	}

	public void setBottomLeftPoint(Point bottomLeftPoint) {
		notNull(bottomLeftPoint, "bottomLeftPoint não pode ser null");
		this.bottomLeftPoint = bottomLeftPoint;
	}

	public Point getTopRightPoint() {
		return topRightPoint;
	}

	public void setTopRightPoint(Point topRightPoint) {
		notNull(topRightPoint, "topRightPoint não pode ser null");
		this.topRightPoint = topRightPoint;
	}

}
