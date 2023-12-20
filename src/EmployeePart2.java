public class EmployeePart2 {
    //encapsulation
    private static final int WAGE_PER_HOUR = 20;

    private boolean isPresent() {
        int check=(int)Math.floor(Math.random()*10)%2;
        return check == 1;
    }

    private int generateWorkHours() {
        int isFullTime = (int)Math.floor(Math.random()*10)%2;

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

    public static void main(String[] args) {
        System.out.println("................Welcome to Employee Wage Computation..................");

        EmployeePart2 employee = new EmployeePart2();

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
    }
}
