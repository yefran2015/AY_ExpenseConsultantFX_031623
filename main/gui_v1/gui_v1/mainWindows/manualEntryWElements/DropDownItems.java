package gui_v1.mainWindows.manualEntryWElements;

import java.util.Arrays;

/**
 * A generic class/ object that keeps a list of Strings as items for a drop-down menu.
 * It automatically sorts them and adds 2 optional items: NEW item, and NO item (= unfilled).
 */
public class DropDownItems {

    private String extraItem1 = "";  // used for <NEW ITEM>, or <--no item-->, if just one used
    private String extraItem2 = "";  // used for <--no item-->, if two used

    private String[] names;

    /**
     * Constructor which creates a list of drop down menu items.
     * @param list list of Strings to sort and store
     */
    public DropDownItems(String[] list) {
        names = new String[list.length];
        System.arraycopy(list, 0, names, 0, list.length);
        updateList(list);
    }

    /**
     * Constructor which creates a list of drop down menu items +
     * one additional item (used as NEW item or NO item)
     * @param list list of Strings to sort and store
     * @param extra item to store as last
     */
    public DropDownItems(String[] list, String extra) {
        names = new String[list.length + 1];
        System.arraycopy(list, 0, names, 0, list.length);
        extraItem1 = extra;
        updateList(list);
    }

    /**
     * Constructor which creates a list of drop down menu items +
     * two additional item (used as NEW item and NO item)
     * @param list list of Strings to sort and store
     * @param extra1 item to store as second to last
     * @param extra2 item to store as last
     */
    public DropDownItems(String[] list, String extra1, String extra2) {
        names = new String[list.length + 2];
        System.arraycopy(list, 0, names, 0, list.length);
        extraItem1 = extra1;
        extraItem2 = extra2;
        updateList(list);
    }

    /**
     * Returns the length of the stored list (including the optional extra items).
     * @return length of list
     */
    public int getSize() {
        return names.length;
    }

    /**
     * Adds one new item in the drop-down list. Uses updateList() method to get
     * it ready for another use.
     * @param item new item to be added to the list
     */
    public void addItem(String item) {
        String[] newList = new String[names.length+1];
        System.arraycopy(names, 0, newList, 1, names.length);
        newList[0] = item;
        updateList(newList);
    }

    /**
     * Replaces the current list with a new supplied list for the drop-down menu.
     * If the list already contained the extras, it will strip them first, sort
     * the list and add them back. If the list didn't contain the extras, it will
     * attach them at the end.
     * @param bankList new list of menu items to replace the old one
     */
    public void updateList(String[] bankList) {
        String[] bl;
        int subtract = 0, add = 0;
        if (bankList==null || bankList.length==0) return;
        if (bankList[bankList.length-1].equalsIgnoreCase(extraItem1) ||
                bankList[bankList.length-1].equalsIgnoreCase(extraItem2)) {
            subtract = 1;
            if (bankList.length == 1) return;
        }
        if (bankList[bankList.length-2].equalsIgnoreCase(extraItem1) && subtract==1) {
            subtract = 2;
            if (bankList.length == 2) return;
        }
        bl = new String[bankList.length - subtract];
        System.arraycopy(bankList, 0, bl, 0, bankList.length - subtract);
        Arrays.sort(bl);
        if (extraItem1.length()>0) add = 1;
        if (extraItem2.length()>0) add = 2;
        names = new String[bl.length + add];
        System.arraycopy(bl, 0, names, 0, bl.length);
        if (add==2) {
            names[names.length-2] = extraItem1;
            names[names.length-1] = extraItem2;
        } else if (add==1) {
            names[names.length-1] = extraItem1;
        }
    }

    /**
     * Returns the stored, sorted list (including the optional extra items at the end).
     * @return list of menu items
     */
    public String[] getList() {
        return names;
    }

    /*
    public static void main(String[] args) {
        DropDownItems items = new DropDownItems(new String[]{"Wells Fargo", "Bank of America", "Abc Bank"},
                "<--no bank-->", "<NEW BANK>");
        String[] list = items.getList();
        for (int i = 0; i < list.length; i++) System.out.println(list[i]);
    }
    */
}

