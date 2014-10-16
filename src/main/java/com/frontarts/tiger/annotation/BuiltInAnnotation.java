package com.frontarts.tiger.annotation;

import java.util.List;

/**
 * Created with IntelliJ IDEA @ 11/21/11 11:28 AM
 * Copyright © 1994-2011. EMC Corporation.  All Rights Reserved.
 *
 * @author wangy23
 */
public class BuiltInAnnotation {
    class Food {
    }

    class Hay extends Food {
    }

    class Animal {
        Food getFood() {
            return null;
        }

        @Deprecated
        void deprecatedMethod() {
        }
    }

    class Horse extends Animal{
        @Override
        Hay getFood(){
             return null;
         }
        @SuppressWarnings({"deprecation","unchecked"})
        void callDeprecatedMethod(List horses){
            Animal a = new Animal();
            deprecatedMethod();
            horses.add(a);

        }
    }
}
