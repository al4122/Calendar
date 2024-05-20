import java.util.Scanner;

public class Prompt {
    private static final int[] MAX_DAYS ={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS ={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public boolean isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
        } else {
            return false;
        }

    }
    public int parseDay(String week){
        switch (week) {
            case "SU":
                return 0;
            case "MO":
                return 1;
            case "TU":
                return 2;
            case "WE":
                return 3;
            case "TH":
                return 4;
            case "FR":
                return 5;
            case "SA":
                return 6;
            default:
                return 0;
        }

    }

    public int getMaxDaysOfMonth(int year, int month){
        if(isLeapYear(year)){
            return LEAP_MAX_DAYS[month-1];
        }else {
            return MAX_DAYS[month - 1];
        }
    }

    public void printCalendar(int year, int month,int weekday){
        System.out.printf("    <<%4d년%3d월>>\n",year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        for(int i = 0; i < weekday;i++){
            System.out.print("   ");
        }
        int maxDay = getMaxDaysOfMonth(year,month);
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;
        //print first line
        for(int i = 1; i <= count;i++){
            System.out.printf("%3d",i);
        }
        System.out.println();
        //print from second line to last
        count++;
        for(int i = count; i <= maxDay;i++){
            System.out.printf("%3d",i);
            if(i % 7 == delim){
                System.out.println();
            }
        }
        System.out.println();
//        System.out.println(" 1  2  3  4  5  6  7");
//        System.out.println(" 8  9 10 11 12 13 14");
//        System.out.println("15 16 17 18 19 20 21");
//        System.out.println("22 23 24 25 26 27 28");
    }

    public void runPrompt(){
        Prompt cal = new Prompt();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("년도를 입력하세요.(exit: -1)");
            System.out.print("YEAR> ");
            int year = scanner.nextInt();
            if (year == -1){
                break;
            }
            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            int month = scanner.nextInt();
            System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
            System.out.print("WEEKDAY> ");
            String str_weekday = scanner.next();
            int weekday = parseDay(str_weekday);

            if ( month > 12 || month < 1){
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            cal.printCalendar(year,month,weekday);

        }
        System.out.println("Bye~");
    }

    public static void main(String[] args) {


        //연도와 달, 1일의 요일을 입력받아 달력 출력
        Prompt p = new Prompt();
        p.runPrompt();


    }
}
