package int202.prefinalint202;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import int202.prefinalint202.entities.Customer;
import int202.prefinalint202.repositories.CustomerRepository;

public class Ar {
    public static void main(String[] args) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d,16,16);
        // hash(int iterations, int memory, int parallelism, char[] password)
        CustomerRepository repository = new CustomerRepository();
        repository.getEntityManager().getTransaction().begin();
        char[] password;
        for(Customer c : repository.findAll()) {
            password = c.getCustomerNumber().toString().toCharArray();
            c.setPassword(argon2.hash(2, 16, 1, password));
        }
        repository.getEntityManager().getTransaction().commit();
    }
}
