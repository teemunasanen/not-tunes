package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.CustomerRepository;
import hutnas.nottunes.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String index() {
        return "This is the root page";
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
