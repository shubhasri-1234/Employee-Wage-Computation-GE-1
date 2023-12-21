import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    private static final int WAGE_PER_HOUR = 20;

    private boolean isPresent() {
        int check = (int) Math.floor(Math.random() * 10) % 2;
        return check == 1;
    }

    private int generateWorkHours() {
        int isFullTime = (int) Math.floor(Math.random() * 10) % 2;

        if (isPresent()) {
            return (isFullTime == 1) ? 8 : 4;
        }

        return 0;
    }

    public int calculateDailyWage() {
        return generateWorkHours() * WAGE_PER_HOUR;
    }

    public int calculateMonthlyWage(int daysLimit, int hoursLimit) {
        int days = 0;
        int totalEmpHours = 0;
        int monthlyWage = 0;

        while (days < daysLimit && totalEmpHours < hoursLimit) {
            int dailyWage = calculateDailyWage();
            monthlyWage += dailyWage;
            totalEmpHours += generateWorkHours();
            days++;
        }

        return monthlyWage;
    }

    // New method to compute monthly wage for a specific company
    public int calculateCompanyMonthlyWage(int wagePerHour, int daysLimit, int hoursLimit) {
        int monthlyWage = 0;
        monthlyWage=(daysLimit*hoursLimit)*wagePerHour;
        return monthlyWage;
    }

    public static void main(String[] args) {
        System.out.println("................Welcome to Employee Wage Computation..................");

        Day5 employee = new Day5();

        int dailyWage = employee.calculateDailyWage();
        System.out.println("Employee Wage per day: " + dailyWage);

        // UC5
        int monthlyWageUC5 = 0;
        for (int i = 0; i < 20; i++) {
            monthlyWageUC5 += employee.calculateDailyWage();
        }
        System.out.println("Employee Monthly Wage (UC5): " + monthlyWageUC5);

        // UC6
        int monthlyWageUC6 = employee.calculateMonthlyWage(20, 100);
        System.out.println("Employee Monthly Wage (UC6): " + monthlyWageUC6);

        // Managing multiple companies using ArrayList
        ArrayList<Company> companies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //for 5 companies
        for(int i=0;i<5;i++){
        System.out.print("Enter name of company: ");
        String name = scanner.next();
        System.out.print("WagePerHour: ");
        int wagePerHour  = scanner.nextInt();
        System.out.print("Number of working days per month: ");
        int workingdays  = scanner.nextInt();
        System.out.print("Number of working hours per day: ");
        int workinghrs  = scanner.nextInt();
        companies.add(new Company(name,wagePerHour,workingdays, workinghrs));
        }

        for (Company company : companies) {
            int companyWage = employee.calculateCompanyMonthlyWage(company.getWagePerHour(),company.getDaysLimit(),company.getHoursLimit());
            System.out.println(company.getName()+" Company has a"+ " Monthly Wage: " + companyWage);
        }
        scanner.close();
    }
    
}

class Company {
    private String name;
    private int wagePerHour;
    private int workingdays;
    private int workinghrs;

    public Company(String name, int wagePerHour, int workingdays, int workinghrs ) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.workingdays = workingdays;
        this.workinghrs  = workinghrs ;
    }

    public String getName() {
        return name;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getDaysLimit() {
        return workingdays;
    }

    public int getHoursLimit() {
        return workinghrs ;
    }
}
