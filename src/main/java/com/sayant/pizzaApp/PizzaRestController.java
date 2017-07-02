/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sayant.pizzaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sayant.model.Pizza;
import com.sayant.repository.PizzaRepository;

import java.net.URI;
import java.util.Collection;
import java.util.List;

// tag::code[]
@RestController
@CrossOrigin
@RequestMapping("/pizzas")
class PizzaRestController {

	@Autowired
	private final PizzaRepository pizzaRepository;

	@Autowired
	PizzaRestController(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<Pizza> readPizzas() {
		return this.pizzaRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{pizzaID}")
	Pizza readPizza(@PathVariable Long pizzaID) {
		return this.pizzaRepository.findOne(pizzaID);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public Pizza add(@RequestBody Pizza pizza) {
		return this.pizzaRepository.save(pizza);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	  public Pizza update(@PathVariable Long id, @RequestBody Pizza pizza) {
		Pizza pizzaUpdate = this.pizzaRepository.findOne(id);
		pizzaUpdate.setName(pizza.getName());
		pizzaUpdate.setImagePath(pizza.getImagePath());
		pizzaUpdate.setComments(pizza.getComments());
		pizzaUpdate.setIngredients(pizza.getIngredients());
		return this.pizzaRepository.save(pizzaUpdate);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/pizzas")
	//public List<Pizza> update(@RequestBody List<Pizza> listPizzas) {
	ResponseEntity<?> addList(@RequestBody List<Pizza> listPizzas) {

		listPizzas.stream().forEach(p -> this.pizzaRepository.save(p));
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/pizzas")
				.buildAndExpand(listPizzas).toUri();

		return ResponseEntity.created(location).build();
	}
}
// end::code[]
