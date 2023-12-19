public class EmpWageBuilderUC5 {
    public static final int PART_TIME=1;
    public static final int FULL_TIME=2;
    public static int Wage_per_hour=20;
    public static int working_days=20;
    public static void main(String[] args){

        int emphrs=0;
        int empwage=0;
        int monthlywage=0;
        for(int day=0;day<working_days;day++){
        int check=(int)Math.floor(Math.random()*10)%3;
        switch(check){
            case PART_TIME: 
                emphrs=4;
                break;
            case FULL_TIME:
                emphrs=8;
                break;
            default:
                emphrs=0;
        }
        empwage=emphrs*Wage_per_hour;
        monthlywage+=empwage;
        System.out.println("Wage: "+ empwage);
    }
    System.out.println("Monthlywage: "+monthlywage);
    } 
}
