import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public boolean addNewBranch(String branchName){
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch!=null && branch.addNewCustomer(customerName,initialAmount)){
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch!=null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public void showBranchCustomersList(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);

        if(branch == null) {
            System.out.println("Sorry, the bank you are looking for not exist in system");
        } else{
            System.out.println("Customer for branch " + branch.getName());
            for (int i=0; i<branch.getCustomers().size();i++) {
                Customer customer = branch.getCustomers().get(i);
                System.out.println((i+1) + ". " + customer.getName());
                if(showTransactions) {
                    System.out.println("Transanction Record: ");
                    for (int j=0; j<customer.getTransactions().size(); j++) {
                        System.out.println((j+1) + "-" + customer.getTransactions().get(j));
                    }
                }
            }
        }
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }
}
