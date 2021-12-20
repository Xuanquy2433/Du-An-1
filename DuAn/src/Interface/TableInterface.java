/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanbi
 */
public abstract class TableInterface {
     public String getTableName() {
        return this.getClass().getSimpleName();
    }
    public String getIdName(){
        return this.getClass().getDeclaredFields()[0].getName();
    }
    
    public abstract int getId();
    
    public String[] getColumnNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] columnNames = new String[fields.length - 1];
        for (int i = 0; i < fields.length; i++) {
            if (i == 0) {
                continue;
            }
            columnNames[i -1] = fields[i].getName();
        }
        return columnNames;
    }
    
    public Object[] getValues() {
        Field[] fields = this.getClass().getDeclaredFields();
        Object[] values = new Object[fields.length - 1];
        for (int i = 0; i < fields.length; i++) {
            try {
                if (i == 0) {
                    continue;
                }
                // gÃ¡n chá»¯ get + tÃªn feild
                
                // láº¥y feild name
                String methodName = fields[i].getName();
                
                // vÃ­ dá»¥ tenDanhMuc cháº¡y cÃ¡i nÃ y ra Chá»¯ "T" in hoa Ä‘áº§u
                String upperChuDau = (methodName.charAt(0) + "").toUpperCase();
                
                methodName = "get" + upperChuDau + methodName.substring(1);
                Method getMethod = this.getClass().getMethod(methodName, null);
                values[i - 1] = getMethod.invoke(this, null);
                
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return values;
    }
    
    // láº¥y toÃ n bá»™ dá»¯ liá»‡u cá»§a table interface
    public Object[] getAllValues() {
        List<Object> objects = new ArrayList<>();
        // láº¥y id
        objects.add(this.getId());
        // láº¥y values
        // chuyá»ƒn value thÃ nh list
        List<Object> values = Arrays.asList(this.getValues());
        // thÃªm vÃ o máº£ng dá»¯ liá»‡u tráº£ vá»�
        objects.addAll(values);
        return objects.toArray();
    }
    
    // Táº¡o hÃ m táº¡o Ä‘á»‘i tÆ°á»£ng vÃ  lÆ°u giÃ¡ trá»‹ vÃ o Ä‘á»‘i tÆ°á»£ng
    public void setValue(Object ...objs) {
        try {
            // duyá»‡t qua cÃ¡c feild vÃ  gÃ¡n giÃ¡ trá»‹ cho nÃ³ vÃ o Ä‘á»‘i tÆ°á»£ng
            Field[] feilds = this.getClass().getDeclaredFields();
            Method[] methods = this.getClass().getMethods();
            for (int i = 0; i < feilds.length; i++) {
                String fieldName = feilds[i].getName();
                fieldName = (fieldName.charAt(0) + "").toUpperCase()
                        + fieldName.substring(1, fieldName.length());
                String setMethodName  = "set" + fieldName;
                Method method = Arrays.stream(methods).filter(q -> q.getName().equals(setMethodName)).findFirst().orElse(null);
                if (method != null) method.invoke(this, objs[i]);
            }
        } catch (SecurityException ex) {
            Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TableInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
