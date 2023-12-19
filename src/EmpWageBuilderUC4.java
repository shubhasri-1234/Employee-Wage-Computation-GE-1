public class EmpWageBuilderUC4 {
    public static final int PART_TIME=1;
    public static final int FULL_TIME=2;
    public static int Wage_per_hour=20;
    public static void main(String[] args){

        int emphrs=0;
        int empwage=0;
        int check=(int)Math.floor(Math.random()*10)%3;
        switch(check){
            case PART_TIME: 
                emphrs=8;
                break;
            case FULL_TIME:
                emphrs=16;
                break;
            default:
                emphrs=0;
        }
        empwage=emphrs*Wage_per_hour;
        System.out.println("Wage: "+ empwage);
    }
}
