package com.sayant.model;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.sayant.model.Ingredient; 

@Entity
public class Pizza {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pizza_id")
	private long id;
	private String name;
	private String imagePath;
	
	@ElementCollection
	@CollectionTable(name="INGREDIENT", joinColumns = @JoinColumn(name="pizzaID"))
	private Set<Ingredient> ingredients;
	
	@ElementCollection
	@CollectionTable(name="COMMENTS", joinColumns = @JoinColumn(name="pizzaID"))
	private Set<Comment> comments;
	
    public Pizza(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    Pizza() {
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
