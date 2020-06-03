package com.acseed;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;

/**
 * Date: 2019-08-21 22:44
 *
 * @author hongchen.cao
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(Main.class.getClassLoader())
                .getLoaded();

        assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
    }
}
