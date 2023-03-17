package gui_v1.help_utils;

public interface GUI_Routines_Not_Used {
    private String[] increaseByCreateGetDataFromArr(int increaseBy, String[] from){
        String[] newArr = new String[from.length+increaseBy];
        for(int i=increaseBy; i< newArr.length; i++){
            newArr[i] = from[i-increaseBy].trim();
        }
        return newArr;
    }

    private void addAtFront(String st, String[] arr){
        arr[0] = st.trim()+"";
    }

}
