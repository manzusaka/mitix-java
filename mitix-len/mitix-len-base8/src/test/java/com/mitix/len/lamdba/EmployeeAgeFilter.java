package com.mitix.len.lamdba;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class EmployeeAgeFilter implements EmployeeFilter {
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() < 35;
    }
}
