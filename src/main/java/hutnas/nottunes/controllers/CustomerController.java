package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.CustomerCountryRepository;
import hutnas.nottunes.data_access.CustomerRepository;
import hutnas.nottunes.models.Customer;
import hutnas.nottunes.models.CustomerCountry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private CustomerRepository customerRepository = new CustomerRepository();
    private CustomerCountryRepository countryRepository = new CustomerCountryRepository();


    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    //Example endpoint: /api/customer/1
    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }

    //Example endpoint: /api/customer?name=daan
    @RequestMapping(value = "/api/customer", method = RequestMethod.GET)
    public Customer getCustomerByName(@RequestParam(value = "name") String name) {
        return customerRepository.getCustomerByName(name);
    }

    //Example endpoint: /api/customers/10?offset=20
    @RequestMapping(value = "/api/customers/{limit}", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomersByLimitAndOffset(@PathVariable(value="limit") String limit, @RequestParam(value="offset") String offset){
        return customerRepository.getCustomersByLimitAndOffset(limit, offset);
    }

    //Add new customer
    @RequestMapping(value = "api/customers", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    //Update customer
    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.PUT)
    public Boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateExistingCustomer(customer);
    }

    @RequestMapping(value = "api/countries", method = RequestMethod.GET)
    public ArrayList<CustomerCountry> getAllCustomerCountries(){
        return countryRepository.getAllCustomerCountries();
    }

}
