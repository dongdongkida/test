import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {

        if(findCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialAmount);
            this.customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName) ;
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer: this.customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        } return null;
    }

    public ArrayList<Customer> getCustomers (){
        return this.customers;
    }

}
