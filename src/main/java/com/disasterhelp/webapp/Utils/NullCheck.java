package com.disasterhelp.webapp.Utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by jovin on 18/12/15.
 */
public class NullCheck {



    public static boolean isEmpty( String string ){
        if( string == null || string.trim().length() == 0 ){
            return true;
        }
        return false;
    }

    public static boolean isEmpty( Map<?, ?> map ){
        if( map == null || map.isEmpty() ){
            return true;
        }
        return false;
    }


    public static boolean isEmpty( Object object ){
        if( object == null ){
            return true;
        }
        return false;
    }

    public static boolean isEmpty( Collection<?> collection ){
        if( collection == null || collection.isEmpty() ){
            return true;
        }
        return false;
    }



}
