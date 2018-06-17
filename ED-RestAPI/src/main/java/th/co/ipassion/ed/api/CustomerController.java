package th.co.ipassion.ed.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.ipassion.ed.model.Customer;
import th.co.ipassion.ed.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/listAllCustomer")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<Customer> listAllCustomer() {

		List<Customer> result = new ArrayList<Customer>();

		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		for (Customer customer : repository.findAll()) {
			result.add(customer);
		}
		
		return result;
	}
}
