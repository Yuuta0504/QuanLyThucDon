package UTIL;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class SendEmail {
    public static void send(String to, String otpCode) {
        final String from = "bblaze036@gmail.com";
        final String password = "ghsd ewxj gjda liib";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from, "Quản lý thực đơn"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Mã xác nhận khôi phục mật khẩu");
            message.setText("Mã xác thực của bạn là: " + otpCode);

            Transport.send(message);
            System.out.println("Đã gửi email xác nhận!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
