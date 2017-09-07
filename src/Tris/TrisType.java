/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tris;

import ClassObjets.Connaissance;
import java.util.Comparator;

/**
 *
 * @author CDI305
 */
public class TrisType implements Comparator<Connaissance> {

    @Override
    public int compare(Connaissance c1, Connaissance c2) {
        return new Integer(c1.getTypeContact()).compareTo (new Integer(c2.getTypeContact()));
    }

}
