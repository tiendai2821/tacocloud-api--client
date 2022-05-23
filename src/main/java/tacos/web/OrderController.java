package tacos.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Order;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	
	@PostMapping
	public String processOrder(@RequestParam("order") String order) {
		System.out.println("Process Order");
//	List<Ingredient> ingredients = new ArrayList<Ingredient>();
//	for (String ingredientId : ingredientIds.split(",")) {
//	Ingredient ingredient = rest.getForObject("http://localhost:8080/ingredients/{id}",Ingredient.class, ingredientId);
//	ingredients.add(ingredient);
//	}
//	Order order = new Order();
//	taco.setName(name);
//	taco.setIngredients(ingredients);
	System.out.println(order);
	rest.postForObject("http://localhost:8080/order", order, Order.class);
	return "redirect:/";
	}
}