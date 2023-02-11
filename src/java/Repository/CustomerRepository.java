package Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
