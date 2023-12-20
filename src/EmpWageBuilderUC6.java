public class EmpWageBuilderUC6 {
    public static final int PART_TIME=1;
    public static final int FULL_TIME=2;
    public static int Wage_per_hour=20;
    public static int working_days=20;
    public static int max_hrs_month=100;
    public static void main(String[] args){

        int emphrs=0;
        int monthlywage=0;
        int totalemphrs=0;
        int totalworkdays=0;
        while(totalemphrs<=max_hrs_month && totalworkdays<working_days ){
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
        totalemphrs+=emphrs;
        totalworkdays+=1;
        System.out.println("Day: "+ totalworkdays + "  " +"emp hrs:" +emphrs);
    }
    monthlywage=totalemphrs*Wage_per_hour;
    System.out.println("Monthlywage: "+monthlywage);
    } 
}
