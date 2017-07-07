package br.com.hrom.maplinkcodechallenge.domain;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

/**
 * Um cidade contendo perímetro retangular ({@link Point}) e possíveis alvos dos
 * vilões ({@link Location})
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String name;
	List<Location> targets = new ArrayList<Location>();
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
		this.targets = targets;
		setBottomLeftPoint(bottomLeftPoint);
		setTopRightPoint(topRightPoint);
	}

	public boolean contains(Point point) {
		// TODO falta implementar
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Location> getTargets() {
		return this.targets.stream().map(source -> SerializationUtils.clone(source)).collect(Collectors.toList());
	}

	public void addTarget(Location target) {
		notNull(target, "target não pode ser null");
		this.targets.add(target);
	}

	public void setTargets(List<Location> targets) {
		notNull(targets, "targets não pode ser null");
		this.targets = targets;
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
