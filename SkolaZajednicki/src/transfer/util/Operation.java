/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Neon
 */
public interface Operation {
    
    public static final int LOGIN = 0;

    public static final int ADD_ADMINISTRATOR = 1;
    public static final int DELETE_ADMINISTRATOR = 2;
    public static final int EDIT_ADMINISTRATOR = 3;
    public static final int GET_ALL_ADMINISTRATOR = 4;
    
    public static final int ADD_TIP_KURSA = 5;
    public static final int DELETE_TIP_KURSA = 6;
    public static final int EDIT_TIP_KURSA = 7;
    public static final int GET_ALL_TIP_KURSA = 8;
    
    public static final int ADD_KURS = 9;
    public static final int DELETE_KURS = 10;
    public static final int EDIT_KURS = 11;
    public static final int GET_ALL_KURS = 12;
    
    public static final int ADD_POLAZNIK = 13;
    public static final int DELETE_POLAZNIK = 14;
    public static final int EDIT_POLAZNIK = 15;
    public static final int GET_ALL_POLAZNIK = 16;
    
    public static final int ADD_GRUPA = 17;
    public static final int DELETE_GRUPA = 18;
    public static final int EDIT_GRUPA = 19;
    public static final int GET_ALL_GRUPA = 20;
    
    public static final int ADD_PREDAVAC = 21;
    public static final int DELETE_PREDAVAC = 22;
    public static final int EDIT_PREDAVAC = 23;
    public static final int GET_ALL_PREDAVAC = 24;
    


}
