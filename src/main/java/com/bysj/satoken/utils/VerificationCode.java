package com.bysj.satoken.utils;

import java.util.Random;

public class VerificationCode {
    public static String getCode() {
        return String.valueOf(new Random().nextInt(900000) + 99999);
    }
}
