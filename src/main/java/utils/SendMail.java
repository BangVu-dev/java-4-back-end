package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendMail {

    public static void sendEmailWhenOrder(String toMail, String orderId) throws MessagingException, UnsupportedEncodingException {

        final String fromEmail = "bangvvpk01973@fpt.edu.vn";
        // Mat khai email cua ban
        final String password = "0782673677";
        // dia chi email nguoi nhan
        final String toEmail = toMail;

        final String subject = "Đơn hàng của bạn đã được xác nhận";
        final String body = "Chúc mừng bạn đã đặt hàng thành công,\nmã đơn hàng "
                + "của bạn là " + orderId +". Đơn hàng của bạn sẽ được giao trong thời gian sớm nhất!";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "BangVu-dev"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
    
    public static void sendEmailWhenRegister(String toMail) throws MessagingException, UnsupportedEncodingException {

        final String fromEmail = "bangvvpk01973@fpt.edu.vn";
        // Mat khai email cua ban
        final String password = "0782673677";
        // dia chi email nguoi nhan
        final String toEmail = toMail;

        final String subject = "Đăng kí tài khoản thành công";
        final String body = "Bây giờ bạn có thể mua hàng và thực hiện các chức năng trên web";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "BangVu-dev"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
    
    public static void sendPassword(String toMail, String newPass) throws MessagingException, UnsupportedEncodingException {

        final String fromEmail = "bangvvpk01973@fpt.edu.vn";
        // Mat khai email cua ban
        final String password = "0782673677";
        // dia chi email nguoi nhan
        final String toEmail = toMail;

        final String subject = "Mật khẩu mới của bạn là " + newPass + ".\n";
        final String body = "Vui lòng không cung cấp mật khẩu cho bất kì ai.";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "BangVu-dev"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
}
