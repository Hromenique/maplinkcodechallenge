package br.com.hrom.maplinkcodechallenge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.util.Assert.notNull;

/**
 * Um cidade contendo perímetro retangular ({@link Point}) e possíveis alvos dos
 * vilões ({@link Target})
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class City {

	String name;
	List<Target> targets = new ArrayList<Target>();
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

	public City(String name, List<Target> targets, Point bottomLeftPoint, Point topRightPoint) {
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

	public List<Target> getTargets() {
		return Collections.unmodifiableList(this.targets);
	}

	public void addTarget(Target target) {
		notNull(target, "target não pode ser null");
		this.targets.add(target);
	}

	public void setTargets(List<Target> targets) {
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
