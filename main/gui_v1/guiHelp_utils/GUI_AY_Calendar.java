package gui_v1.guiHelp_utils;

import java.util.Calendar;

public class GUI_AY_Calendar {
    public static final int DEFAULT_START_YEAR = 1900;
    public static String[] monthsArr = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    public static String[] monthsnqm3Arr = new String[]{"Jan","Feb","Mar","Apr","may","jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    private static String[] yearsArr;
    private static String[] daysOfMonthArr;

    public static String[] getYearsAscedinArr(int startYear){
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] years = new String[currYear-startYear];
        int c=0;
        for(int i= startYear; i<= Calendar.getInstance().get(Calendar.YEAR); i++){
            years[c++] = i+"";
//            o(years[c-1]+"");
        }
        return years;
    }
    public static String[] getYearsAscedingArr(){
        return getYearsAscedinArr(DEFAULT_START_YEAR);

    }
    public static String[] getYearsDecendingArr(int startYear){
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] years = new String[currYear-startYear];
        int c=0;
        for(int i= Calendar.getInstance().get(Calendar.YEAR); i>startYear ; i--){
            years[c++] = i+"";
//            o(years[c-1]+"");
        }
        return years;
    }
    public static String[] getYearsDesendingArr(){
//        o("---->>>>"+Calendar.getInstance().get(Calendar.MONTH));
        return getYearsDecendingArr(DEFAULT_START_YEAR);
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
    public static int[] getDaysInMountsAtYearArr(int year){
        int[] daysInMonthsAtYear = new int[]{year,31,28, 31,30,31,30,31,31,30,31,30,31};

        if(year%4 ==0) {
            daysInMonthsAtYear[2] = 29;
        }
       return   daysInMonthsAtYear;

    }
    public static String[] getDaysAsStrArrForMountOFYear(int month, int year){
        String[] daysOfMonthArr = new String[getDaysInMountsAtYearArr(year)[month]];

        for(int i=0; i< daysOfMonthArr.length; i++) {
            daysOfMonthArr[i] = (i+1)+"";
        }
        return   daysOfMonthArr;

    }
    public static int[] getDaysAsArrForMountOFYear(int month, int year){
        int[] daysOfMonthArr = new int[getDaysInMountsAtYearArr(year)[month]];

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
    public static String[] getDaysInMountsAtYearAsStringArr(int year){
        return  numToStringArr(getDaysInMountsAtYearArr(year));
    }
    private static String[] numToStringArr(int[] arr){
        String[] answr = new String[arr.length];
        for(int i=0;  i< arr.length; i++){
            answr[i] = arr[i]+"";
        }
        return answr;
    }
    private static void o(Object ob){
        System.out.println(ob+"");
    }
}
