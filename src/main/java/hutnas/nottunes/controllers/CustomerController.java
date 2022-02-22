package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.CustomerCountryRepository;
import hutnas.nottunes.data_access.CustomerGenreRepository;
import hutnas.nottunes.data_access.CustomerRepository;
import hutnas.nottunes.data_access.CustomerSpenderRepository;
import hutnas.nottunes.models.Customer;
import hutnas.nottunes.models.CustomerCountry;
import hutnas.nottunes.models.CustomerGenre;
import hutnas.nottunes.models.CustomerSpender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private CustomerRepository customerRepository = new CustomerRepository();
    private CustomerCountryRepository countryRepository = new CustomerCountryRepository();
    private CustomerSpenderRepository spenderRepository = new CustomerSpenderRepository();
    private CustomerGenreRepository genreRepository = new CustomerGenreRepository();


    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    //Example endpoint: /api/customers/1
    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }

    //Example endpoint: /api/customers/search?name=daan
    @RequestMapping(value = "/api/customers/search", method = RequestMethod.GET)
    public Customer getCustomerByName(@RequestParam(value = "name") String name) {
        return customerRepository.getCustomerByName(name);
    }

    //Example endpoint: /api/customers/page/10?offset=20
    @RequestMapping(value = "/api/customers/page/{limit}", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomersByLimitAndOffset(@PathVariable(value="limit") String limit, @RequestParam(value="offset") String offset){
        return customerRepository.getCustomersByLimitAndOffset(limit, offset);
    }

    //Add new customer
    @RequestMapping(value = "api/customers", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    //Update customer
    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.PUT)
    public Boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateExistingCustomer(customer, id);
    }

    @RequestMapping(value = "api/customers/countries", method = RequestMethod.GET)
    public ArrayList<CustomerCountry> getAllCustomerCountries(){
        return countryRepository.getAllCustomerCountries();
    }

    @RequestMapping(value = "api/customers/invoice", method = RequestMethod.GET)
    public ArrayList<CustomerSpender> getCustomersByTotalInvoice() {
        return spenderRepository.getCustomersByTotalInvoice();
    }

    @RequestMapping(value="api/customers/{id}/popular/genre", method = RequestMethod.GET)
    public ArrayList<CustomerGenre> getCustomerFavoriteGenre(@PathVariable String id) {
        return genreRepository.getCustomerFavoriteGenre(id);
    }
}
