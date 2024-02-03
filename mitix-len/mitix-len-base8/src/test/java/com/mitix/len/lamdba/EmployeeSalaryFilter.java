package com.mitix.len.lamdba;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class EmployeeSalaryFilter implements EmployeeFilter {
    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() > 8000.00;
    }
}
