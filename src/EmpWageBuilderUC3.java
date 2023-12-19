public class EmpWageBuilderUC3 {
    public static void main(String[] args){
        int Wage_per_hour=20;
        double check=Math.floor(Math.random()*10)%3;
        int emphrs=0;
        int empwage=0;
        if(check==1) emphrs=4;
        else if(check==2) emphrs=8;
        else emphrs=0;
        empwage=emphrs*Wage_per_hour;
        System.out.println("Wage: "+empwage);
    }
}
