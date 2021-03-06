package better.service;

import better.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Personnel {

    private List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public Personnel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public void afficherSalaires() {
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: employees) {
            total += employee.calculerSalaire();
        }
        return total / employees.size();
    }

    public Object[][] tableauSalaires (){   // compilation des employes sous forme de tableau à dimensions
         Object[][] tableau =new Object[100][6];
         int pos = 0;
        for (Employee employee: employees) {
            tableau[pos][0] = employee.getType();
            tableau[pos][1] = employee.getFirstname();
            tableau[pos][2] = employee.getLastname();
            tableau[pos][3] = employee.getAge();
            tableau[pos][4] = employee.getEntryYear();
            tableau[pos++][5] = employee.calculerSalaire();
        }
        return tableau;
    }
}
