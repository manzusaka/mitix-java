package com.mitix.len.lamdba;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class TestLamdba02 {

    List<Employee> employees = Arrays.asList(new Employee("张三", 25, 6666.00),
            new Employee("李四", 33, 7777.00),
            new Employee("王五", 55, 199999.00),
            new Employee("赵柳", 24, 4500.00),
            new Employee("卡卡", 37, 8888.00),
            new Employee("赵付", 29, 7777.00),
            new Employee("拉姆", 61, 9700.00),
            new Employee("老板", 49, 1.00));

    /**
     * 如果增加一个过滤  会有一个方法
     *
     * @param ees
     * @return
     */
    public List<Employee> filterEmployee01(List<Employee> ees) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : ees) {
            if (employee.getAge() < 35) {
                employees.add(employee);
            }
        }
        return employees;
    }

    /**
     * 如果增加一个过滤  会有一个方法
     *
     * @param ees
     * @return
     */
    public List<Employee> filterEmployee02(List<Employee> ees) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : ees) {
            if (employee.getSalary() > 8000.00) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void test01() {
        List<Employee> ees = filterEmployee01(employees);
        for (Employee ee : ees) {
            System.out.println(ee);
        }

        System.out.println("-----------------------------");

        ees = filterEmployee02(employees);
        for (Employee ee : ees) {
            System.out.println(ee);
        }

    }


    /**
     * 设计模式   做一个通用的比较器
     *
     * @param employees
     * @param filter
     * @return
     */
    public List<Employee> filterEmployee(List<Employee> employees, EmployeeFilter filter) {
        List<Employee> ees = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.filter(employee)) {
                ees.add(employee);
            }
        }
        return ees;
    }


    /**
     * 使用设计模式达到和test01一样的效果
     */
    @Test
    public void test02() {
        List<Employee> ees = filterEmployee(employees, new EmployeeAgeFilter());
        for (Employee ee : ees) {
            System.out.println(ee);
        }

        System.out.println("-----------------------------");

        ees = filterEmployee(employees, new EmployeeSalaryFilter());
        for (Employee ee : ees) {
            System.out.println(ee);
        }

    }


    /**
     * 可以使用匿名内部类去达到效果
     */
    @Test
    public void test03() {
        List<Employee> ees = filterEmployee(employees, new EmployeeFilter() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() < 35;
            }
        });

        for (Employee ee : ees) {
            System.out.println(ee);
        }

        System.out.println("-----------------------------");

        ees = filterEmployee(employees, new EmployeeFilter() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getSalary() > 8000.00;
            }
        });
        for (Employee ee : ees) {
            System.out.println(ee);
        }
    }


    /**
     * 可以使用匿名内部类去达到效果
     */
    @Test
    public void test04() {
        List<Employee> ees = filterEmployee(employees, employee -> employee.getAge() < 35);

        for (Employee ee : ees) {
            System.out.println(ee);
        }

        System.out.println("-----------------------------");

        ees = filterEmployee(employees, employee -> employee.getSalary() > 8000.00);
        for (Employee ee : ees) {
            System.out.println(ee);
        }
    }
}
