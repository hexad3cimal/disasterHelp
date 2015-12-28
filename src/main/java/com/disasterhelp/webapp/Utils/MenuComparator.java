package com.disasterhelp.webapp.Utils;

import com.disasterhelp.webapp.beans.MainMenu;

import java.util.Comparator;

/**
 * Created by jovin on 24/12/15.
 */
public class MenuComparator implements Comparator<MainMenu> {
    @Override
    public int compare(MainMenu m1, MainMenu m2) {
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}
