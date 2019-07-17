/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 08:46
 */

package com.atguigu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {


    /**
     *
     * @return
     * */
    public static void main(String[] args){

        User u1 = new User();
        u1.setId(10);

        User u2 = new User();
        u2.setId(123);
        u2.setUserName("sb,sb2");//模糊查询


        User u3 = new User();
        u3.setEmail("123@qq.com,qwe@qq.com");//其中任意一个

        String sql1 = query(u1);
        String sql2 = query(u2);
        String sql3 = query(u3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        System.out.println("******************************");
        System.out.println("******************************");

        Department d1 = new Department();
        d1.setName("sb,ewq");
        d1.setAmount(10);
        d1.setLeader("sbb");

        System.out.println(query(d1));


    }

    private static String query(Object f){


        StringBuilder sb = new StringBuilder();

        Class c = f.getClass();

        if (!c.isAnnotationPresent(Table.class)) {
            return null;
        }

        Annotation annotation = c.getAnnotation(Table.class);
        Table t = (Table) annotation;
        String tableName = t.value();

        sb.append("select * from ").append(tableName).append(" where 1=1 ");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnName = column.value();

                String fieldName = field.getName();
                String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);

                Object fieldValue = null;
                try {
                    Method method = c.getMethod(getMethodName);
                    fieldValue = method.invoke(f);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (fieldValue == null ||
                        (fieldValue instanceof Integer && (Integer)fieldValue ==0)) {
                    continue;
                }

                sb.append(" and ").append(columnName);
                if(fieldValue instanceof String){

                    if (((String) fieldValue).contains(",")) {
                        String[] values = ((String) fieldValue).split(",");
                        sb.append(" in( ");
//                        for (int i = 0; i < values.length; i++) {
//                            if(i == values.length - 1){
//                                sb.append("'").append(values[i]).append("'");
//                            }else{
//                                sb.append("'").append(values[i]).append("'").append(",");
//                            }
//                        }

                        for (String value : values) {
                            sb.append("'").append(value).append("'").append(",");
                        }
                        sb.deleteCharAt(sb.length()-1);
                        sb.append(" )");
                    }else {
                        sb.append("=").append("'").append(fieldValue).append("'");
                    }

                }else if(fieldValue instanceof Integer){
                    sb.append("=").append(fieldValue);
                }

            }
        }
        return sb.toString();
    }

}
