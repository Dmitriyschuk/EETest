import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class Mail {
    public static void main(String[] args) throws IOException, MessagingException {

        FileInputStream fis = new FileInputStream("D:\\JavaProjects\\MailProject\\src\\mail.properties");
        Properties properties = new Properties();
        properties.load(fis);

//        String to = "poleschuk.mailbox@gmail.com";
//        String hostSMTP = "smtp.yandex.ru";
//        Integer port = 465;

        String user = properties.getProperty("mail.user");
        String password = properties.getProperty("mail.password");
        String host = properties.getProperty("mail.host");


        //IMAP
        Properties prop = new Properties();
        prop.put("mail.store.protocol", "imaps"); //ssl

        Store store = Session.getDefaultInstance(prop).getStore();
        store.connect(host,user,password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        System.out.println("Количество писем " + inbox.getMessageCount());




//        properties.put("mail.smtp.host", hostSMTP);
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(user, password);
//            }
//        });
//
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("dmitriyschuk@yandex.ru"));
//        InternetAddress[] addresses = {new InternetAddress(to)};
//        msg.setRecipients(Message.RecipientType.TO, addresses);
//        msg.setSubject("Email from java");
//        msg.setSentDate(new Date());
//        msg.setText("Пример работы с почтой из java");
//
//
//        Transport.send(msg);

    }
}
