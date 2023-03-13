package gui_v1.help_utils;
import java.util.Calendar;
import java.util.Date;
public class GUI_AY_Calendar {
    public static final int ERR = -1;
    public static final int DEFAULT_START_YEAR = 1900;
    public static String[] monthsArr = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    public static String[] monthNamesStrArr = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public static String[] getMonthFullNamesStrArr = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
            "JULY", "AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};

    private static String[] yearsArr;
    private static String[] daysOfMonthArr;

    public static String[] getYearsAscendingArr(int startYear){
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] years = new String[currYear-startYear];
        int c=0;
        for(int i= startYear; i<= currYear; i++){
            years[c++] = i+"";
        }
        return years;
    }
    public static String[] getYearsAscendingArr(){
        return getYearsAscendingArr(DEFAULT_START_YEAR);

    }
    public static String[] getYearsDescendingArr(int startYear){
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] years = new String[currYear-startYear];
        int c=0;
        for(int i= Calendar.getInstance().get(Calendar.YEAR); i>startYear ; i--){
            years[c++] = i+"";
        }
        return years;
    }
    public static String[] getYearsDescendingArr(){
        return getYearsDescendingArr(DEFAULT_START_YEAR);
    }
    /**
     * @param year --year of which to get number of days per month
     * @return -- numeric integer array with year at [0] index,
     *        --- and number of days in months located at [1] to [12] indexes of array.
     *        --- at index [1] is January
     *        --- at index [12] is Deciweber
     *
     *
     */
    public static int[] getDaysInMonthAtYearArr(int year){
        int[] daysInMonthsAtYear = new int[]{year,31,28, 31,30,31,30,31,31,30,31,30,31};

        if(isThisYearLeap(year)) {
            daysInMonthsAtYear[2] = 29;
        }
        return   daysInMonthsAtYear;

    }

    /**
     * @param year - numerical yaer to be checked if leap or not
     * @return -- TRUE if year is leap, and FALSE if year is not leap
     *  1.) Leap year is dividable by 4  and not by 100 -->
     *   y % 4 == 0 && y % 100 != 0
     *  2.) Exception of rule 1 -->
     *   ---> Leap year can be decidable by 100 if also dividable by 400 ( 4 % 100 % 4) == 0 -->
     *   year % 400 == 0 ; or  (year % 4 % 100 == 0 )
     *
     */
    public static boolean isThisYearLeap(int year) {
        return ((year % 4 == 0 && year % 100 !=0 ) || (year % 400 ==0));
    }

    public static String[] getDaysAsStrArrForMountOfYear(int month, int year){
        String[] daysOfMonthArr = new String[getDaysInMonthAtYearArr(year)[month]];

        for(int i=0; i< daysOfMonthArr.length; i++) {
            daysOfMonthArr[i] = (i+1)+"";
        }
        return   daysOfMonthArr;
    }
    public static int[] getDaysAsNumArrForMonthOfYear(int month, int year){
        int[] daysOfMonthArr = new int[getDaysInMonthAtYearArr(year)[month]];

        for(int i=0; i< daysOfMonthArr.length; i++) {
            daysOfMonthArr[i] = i+1;
        }
        return   daysOfMonthArr;

    }
    /**
     * @param year --year of which to get number of days per month
     * @return -- String array with year at [0] index,
     *        --- and number of days in months located at [1] to [12] indexes of array.
     *        --- at index [1] is January
     *        --- at index [12] is Deciweber
     *
     *
     */
    public static String[] getDaysInMonthAtYearAsStringArr(int year){
        return  numToStringArr(getDaysInMonthAtYearArr(year));
    }
    private static String[] numToStringArr(int[] arr){
        String[] answr = new String[arr.length];
        for(int i=0;  i< arr.length; i++){
            answr[i] = arr[i]+"";
        }
        return answr;
    }

    public static String getTodayDateWithMonthNameAsStr(){
        return getTodayMonth()+"/"+getTodayDayOfMonth()+"/"+getTodayYear();
    }

    public static String[] getTodayDateAsStrArr(){
        return AY_TodayDay.getInstance().getTodayDateAsFullStringArr();
    }
    public static String getTodayMonth() {
        return AY_TodayDay.getInstance().getTodayMonth();
    }

    public static String getTodayDayOfMonth() {
        return AY_TodayDay.getInstance().getTodayDayOfMonth();
    }

    public static String getTodayYear() {
        return AY_TodayDay.getInstance().getTodayYear();
    }
    public static String todayAsString() {
        return AY_TodayDay.getInstance().toString();
    }

    private static class AY_TodayDay{
        private static AY_TodayDay instance;
        private final String  todayDateFullString;
        private final String[]  todayDateFullStrArr;

        private AY_TodayDay(){
            todayDateFullString = (new Date(System.currentTimeMillis()))+"";
            todayDateFullStrArr = todayDateFullString.split(" ");
        }
        public static  AY_TodayDay getInstance(){
            if(instance == null){
                instance = new AY_TodayDay();
            }
            return  instance;
        }
        public String getTodayDateAsFullString(){
            return  todayDateFullString;
        }
        public String[] getTodayDateAsFullStringArr(){
            return  todayDateFullStrArr;
        }
        public String getTodayMonthName(){
            return  todayDateFullStrArr[1];
        }
        public String getTodayMonth(){
            return  convertMonthNameToNumber(todayDateFullStrArr[1])+"";
        }
        public String getTodayDayOfMonth(){
            return  todayDateFullStrArr[2];
        }
        public String getTodayYear(){
            return  todayDateFullStrArr[5];
        }
        @Override
        public String toString(){
            return (getTodayMonthName()+ " "+getTodayMonth() +" " +getTodayDayOfMonth()+
                    " "+ getTodayYear());
        }

        public int convertMonthNameToNumber(String month){
            for(int i=0; i< monthNamesStrArr.length;i++){
                if(monthNamesStrArr[i].compareToIgnoreCase(month)==0){
                    return ++i;
                }
            }
            return ERR;
        }

    }
    private static void o(Object ob){
        System.out.println(ob+"");
    }
}
