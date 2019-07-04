package com.sayant.pizzaApp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sayant.model.Ingredient;
import com.sayant.model.Comment;
import com.sayant.model.Pizza;
import com.sayant.repository.PizzaRepository;

@SpringBootApplication
@EnableJpaRepositories("com.sayant.repository")
@EntityScan("com.sayant.model")
public class PizzaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaAppApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(PizzaRepository pizzaRepository) {
        return (args) -> { 
        	// Creating the pizza element
        	System.out.println("Initilized");
        	Pizza pizza = pizzaRepository.save(new Pizza("Cheese Pizza", "https://image.shutterstock.com/z/stock-photo-supreme-pizza-lifted-slice-84904912.jpg"));
        	
        	//Creating and adding the ingredients set
        	Set<Ingredient> ingredients = new HashSet();
        	ingredients.add(new Ingredient("Tomato", 2));
        	ingredients.add(new Ingredient("Cheese", 4));
        	pizza.setIngredients(ingredients);
        	
        	// Creating and adding the comments set
        	Set<Comment> comments = new HashSet();
        	comments.add(new Comment("Juan", 3, "This is the initial comment.", new Date()));
        	comments.add(new Comment("Maria", 3, "This is another initial comment.", new Date()));
        	pizza.setComments(comments);
        	
        	pizzaRepository.save(pizza);
        	
        	pizza = pizzaRepository.save(new Pizza("Supreme Pizza", "https://lh3.googleusercontent.com/-1Iil24qU-EM/VqnJ50T5vII/AAAAAAAFQzI/O2jXEMQXKt0/s800-Ic42/cheese-pizza-2.jpg"));
        	//Creating and adding the ingredients set
        	ingredients = new HashSet();
        	ingredients.add(new Ingredient("Tomato", 2));
        	ingredients.add(new Ingredient("Cheese", 4));
        	pizza.setIngredients(ingredients);
        	
        	// Creating and adding the comments set
        	comments = new HashSet();
        	comments.add(new Comment("Juan", 3, "This is the initial comment.", new Date()));
        	comments.add(new Comment("Maria", 3, "This is another initial comment.", new Date()));
        	pizza.setComments(comments);
        	
        	pizzaRepository.save(pizza);
        	pizza = pizzaRepository.save(new Pizza("Veggie Pizza", "https://image.shutterstock.com/z/stock-photo-supreme-pizza-lifted-slice-84904912.jpg"));
        	//Creating and adding the ingredients set
        	ingredients = new HashSet();
        	ingredients.add(new Ingredient("Tomato", 2));
        	ingredients.add(new Ingredient("Cheese", 4));
        	pizza.setIngredients(ingredients);
        	
        	// Creating and adding the comments set
        	comments = new HashSet();
        	comments.add(new Comment("Juan", 3, "This is the initial comment.", new Date()));
        	comments.add(new Comment("Maria", 3, "This is another initial comment.", new Date()));
        	pizza.setComments(comments);
        	
        	pizzaRepository.save(pizza);
        	pizza = pizzaRepository.save(new Pizza("Meat Pizza", "https://image.shutterstock.com/z/stock-photo-supreme-pizza-lifted-slice-84904912.jpg"));
        	//Creating and adding the ingredients set
        	ingredients = new HashSet();
        	ingredients.add(new Ingredient("Tomato", 2));
        	ingredients.add(new Ingredient("Cheese", 4));
        	pizza.setIngredients(ingredients);
        	
        	// Creating and adding the comments set
        	comments = new HashSet();
        	comments.add(new Comment("Juan", 3, "This is the initial comment.", new Date()));
        	comments.add(new Comment("Maria", 3, "This is another initial comment.", new Date()));
        	pizza.setComments(comments);
        	
        	pizzaRepository.save(pizza);
        	pizza = pizzaRepository.save(new Pizza("Pepperoni Pizza", "https://image.shutterstock.com/z/stock-photo-supreme-pizza-lifted-slice-84904912.jpg"));
        	//Creating and adding the ingredients set
        	ingredients = new HashSet();
        	ingredients.add(new Ingredient("Tomato", 2));
        	ingredients.add(new Ingredient("Cheese", 4));
        	pizza.setIngredients(ingredients);
        	
        	// Creating and adding the comments set
        	comments = new HashSet();
        	comments.add(new Comment("Juan", 3, "This is the initial comment.", new Date()));
        	comments.add(new Comment("Maria", 3, "This is another initial comment.", new Date()));
        	pizza.setComments(comments);
        	
        	pizzaRepository.save(pizza);
        	
        };
    }
}
