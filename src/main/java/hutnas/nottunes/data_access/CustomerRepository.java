package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepository {
    public ArrayList<Customer> getAllCustomers();

}
