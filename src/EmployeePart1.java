public class EmployeePart1 {
    static int WAGE_PER_HOUR = 20;

     //UC1
     public static boolean check() {
        int check=(int)Math.floor(Math.random()*10)%2;

        switch (check) {
            case 1:
                return true;

            default:
                return false;
        }

    }

    // UC2 && UC3
    public static int hoursPerDay() {
        int emphrs = 0;

        int isFullTime = (int)Math.floor(Math.random()*10)%2;

        if (check() == true) {
            switch (isFullTime) {
                case 1:
                    //fulltime
                    emphrs = 8;
                    break;

                default:
                    //parttime
                    emphrs = 4;
                    break;
            }

        }

        return emphrs;
    }


    public static void main(String[] args) {
        System.out.println("................Welcome to Employee Wage Computation..................");
        int empwage=0;
        empwage =  hoursPerDay() * WAGE_PER_HOUR;
        System.out.println("Employee Wage per day: " + empwage);
        // UC5
        int monthlyWage = 0;
        for (int i = 0; i < 20; i++) {
            monthlyWage += WAGE_PER_HOUR * hoursPerDay();
        }
        System.out.println("Employee Monthly Wage:" + monthlyWage);

        // UC6
        int days = 0;
        int totalEmpHour = 0;
        int monthlyWageUC6 = 0;
        while (days <= 20 && totalEmpHour <= 100) {
            monthlyWageUC6 += WAGE_PER_HOUR * hoursPerDay();
            totalEmpHour += hoursPerDay();
            days++;
        }

        System.out.println("Monthlywage(contition): " + monthlyWageUC6);

    }
}
