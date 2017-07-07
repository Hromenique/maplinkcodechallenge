package br.com.hrom.maplinkcodechallenge.domain;

import java.io.Serializable;

import org.springframework.util.Assert;

/**
 * Um Vilão do Batman
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Villain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Point location;

	public Villain(String name) {
		super();
		setName(name);
	}

	public Villain(String name, Point location) {
		super();
		setName(name);
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Assert.notNull(name, "name não pode ser null");
		this.name = name;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
