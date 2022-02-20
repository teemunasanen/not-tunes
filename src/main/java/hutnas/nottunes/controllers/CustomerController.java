package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.CustomerRepository;
import hutnas.nottunes.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private CustomerRepository customerRepository = new CustomerRepository();


    @GetMapping("/")
    public String index() {
        return "This is the root page";
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
