package com.web.demo.controls;

import com.web.demo.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("email")
public class EmailRestController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailRestController.class);

    private EmailService emailService;

    @Autowired
    public EmailRestController setEmailService(EmailService emailService) {
        this.emailService = emailService;
        return this;
    }

    @GetMapping(value = "/sendEmailTmp")
    public String sendEmail() throws Exception {
        emailService.sendEmail();
        return "Email sent successfully";
    }

    @GetMapping(value = "/sendEmail/{email}")
    public ResponseEntity<String> sendSimpleEmail(@PathVariable("email") String email) {
        try {
            emailService.sendSimpleEmail(email, "Welcome", "This is a welcome email for your!!");
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    /*@GetMapping(value = "/simple-order-email/{user-email}")
    public ResponseEntity sendEmailAttachment(@PathVariable("user-email") String email) {
        emailService.sendEmailWithAttachment(email, "Order Confirmation",
                "Thanks for your recent order",
                "classpath:purchase_order.pdf");
        return new ResponseEntity<>("Please check your inbox for order confirmation", HttpStatus.OK);
    }*/
}
