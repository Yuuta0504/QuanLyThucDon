package UTIL;

import java.util.HashMap;

public class OTPManager {
    private static final HashMap<String, String> otpStorage = new HashMap<>();

    // Lưu OTP cho email
    public static void storeOTP(String email, String otp) {
        otpStorage.put(email, otp);
    }

    // Lấy OTP đã lưu
    public static String getOTP(String email) {
        return otpStorage.get(email);
    }

    // Xóa OTP sau khi dùng
    public static void removeOTP(String email) {
        otpStorage.remove(email);
    }

    // Kiểm tra OTP có đúng không
    public static boolean verifyOTP(String email, String otp) {
        String saved = otpStorage.get(email);
        return saved != null && saved.equals(otp);
    }
}
