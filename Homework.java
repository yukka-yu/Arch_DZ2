package ru.geekbrains.lesson2.Homework;

public class Homework {


    static Employee generateEmployee(){

        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        //TODO: Доработать реализацию
        int employeeType = (int)(2 * Math.random());
        int employeeName = (int)(names.length * Math.random());
        int employeeSurname = (int)(surnames.length * Math.random());
        double salaryFull = 40000 + 20001 * Math.random();
        double salaryFree = 1000 + 1001 * Math.random();
        if (employeeType == 0) {
            return new Worker(names[employeeName], surnames[employeeSurname], salaryFull);
        }
        else {
            return new Freelancer(names[employeeName], surnames[employeeSurname], salaryFree);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        for (Employee e: employees) {
            System.out.println(e);
        }

    }

}

/**
 * Работник (базовый класс)
 */
abstract class Employee{
    protected String name;
    protected String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Ставка
     */
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

}

class Freelancer extends Employee{

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return 20 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}

/**
 * Рабочий (фулл-тайм)
 */
class Worker extends Employee{


    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surname, name, salary);
    }
}