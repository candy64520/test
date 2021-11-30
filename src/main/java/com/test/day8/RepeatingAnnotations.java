package com.test.day8;

/**
 * @Package: com.test.day8
 * @ClassName: RepeatingAnnotations
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/13 17:08
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };

    @Filter( "filter188888888888888888888888888888888888888" )
    @Filter( "filter2111111111111111111" )
    public interface Filterable {
    }

    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }


        TreeMap treeMap = new TreeMap<>();

        treeMap.put(1,2);
        treeMap.put(8,3);
        treeMap.put(2,3);
        System.out.println(treeMap.toString());

        Optional< String > fullName = Optional.ofNullable( "33" );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

        ConcurrentHashMap map =new ConcurrentHashMap();
    }
    public void  test(){

    }
}