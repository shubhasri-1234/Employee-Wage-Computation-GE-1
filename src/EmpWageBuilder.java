import java.util.ArrayList;
import java.util.List;

public class EmpWageBuilder {
    private static final List<CompanyEmpWage> companyEmpWages = new ArrayList<>();

    public static class CompanyEmpWage {
        private final String companyName;
        private final int wagePerHour;
        private final int workingDaysPerMonth;
        private final int workingHoursPerMonth;
        private int totalWage;
        private List<Integer> dailyWages;
        public static final int FULL_DAY_HOURS = 8;
        public static final int PART_TIME_HOURS = 4;

        public CompanyEmpWage(String companyName, int wagePerHour, int workingDaysPerMonth, int workingHoursPerMonth) {
            this.companyName = companyName;
            this.wagePerHour = wagePerHour;
            this.workingDaysPerMonth = workingDaysPerMonth;
            this.workingHoursPerMonth = workingHoursPerMonth;
            this.totalWage = 0;
            this.dailyWages = new ArrayList<>();
        }

        public String getCompanyName() {
            return companyName;
        }

        public int getWagePerHour() {
            return wagePerHour;
        }

        public int getWorkingDaysPerMonth() {
            return workingDaysPerMonth;
        }

        public int getWorkingHoursPerMonth() {
            return workingHoursPerMonth;
        }

        public void addDailyWage(int dailyWage) {
            dailyWages.add(dailyWage);
        }

        public List<Integer> getDailyWages() {
            return dailyWages;
        }

        public int getTotalWage() {
            return totalWage;
        }

        public void updateTotalWage(int dailyWage) {
            totalWage += dailyWage;
        }
    }

    public static void addCompanyEmpWage(CompanyEmpWage companyEmpWage) {
        companyEmpWages.add(companyEmpWage);
    }

    public static void calculateWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            System.out.println("Calculating for company: " + companyEmpWage.getCompanyName());
            int attendance = (int) (Math.random() * 3); // 0 for absent, 1 for full time, 2 for part-time

            switch (attendance) {
                case 0:
                    System.out.println("Employee is Absent");
                    break;
                case 1:
                    System.out.println("Employee is Present (Full time)");
                    calculateWage(companyEmpWage, CompanyEmpWage.FULL_DAY_HOURS);
                    break;
                case 2:
                    System.out.println("Employee is Present (Part time)");
                    calculateWage(companyEmpWage, CompanyEmpWage.PART_TIME_HOURS);
                    break;
            }
        }
    }

    private static void calculateWage(CompanyEmpWage companyEmpWage, int hours) {
        int dailyWage = companyEmpWage.getWagePerHour() * hours;
        System.out.println("Daily Employee Wage: " + dailyWage);
        companyEmpWage.addDailyWage(dailyWage);
        companyEmpWage.updateTotalWage(dailyWage);
        int monthlyWage = dailyWage * companyEmpWage.getWorkingDaysPerMonth();
        System.out.println("Monthly Employee Wage: " + monthlyWage);
    }

    public static int getTotalWage(String companyName) {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            if (companyEmpWage.getCompanyName().equals(companyName)) {
                return companyEmpWage.getTotalWage();
            }
        }
        return 0; // Return 0 if company not found
    }

    public static void main(String[] args) {
        CompanyEmpWage company1 = new CompanyEmpWage("Company1", 20, 20, 100);
        addCompanyEmpWage(company1);

        CompanyEmpWage company2 = new CompanyEmpWage("Company2", 25, 22, 110);
        addCompanyEmpWage(company2);

        calculateWage();

        // Example: Get total wage for "Company1"
        int totalWageCompany1 = getTotalWage("Company1");
        System.out.println("Total wage for Company1: " + totalWageCompany1);
    }
}
