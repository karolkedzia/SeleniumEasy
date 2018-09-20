package Core;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {

    public static int randomInt() {
        return (int) (Math.random() * 1000);
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphanumeric(100);
    }







//        this.random = random;
//        value1 = (int) (Math.random() * 1000);
//        value2 = (int) (Math.random() * 1000);
//        return this.random;
    }


