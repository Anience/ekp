package com.landray.kmss.zsrd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017-3-27.
 */
public class ListUtil {
    public static List nullToEmptyList(List list) {
        return (list == null) ? new ArrayList() : list;
    }
}
