package za.ac.cput.elective.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.factory.ContactFactory;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContactControllerTest {

    private static Contact contact = ContactFactory.createContact("215028545@mycput.ac.za",
            "0123456789", "0987654321");
    private static String username_admin_security = "admin";
    private static String password_admin_security = "psw";

    private static String username_student_security = "student";
    private static String password_student_security = "password";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/contact/";

    @Test
    public void a_create() {

        ResponseEntity<Contact> postResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_student_security, password_student_security)
                .postForEntity(
                baseURL + "create",
                contact,
                Contact.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Data:\n\n" + contact);

    }

    @Test
    public void b_read() {

        ResponseEntity<Contact> showResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_student_security, password_student_security)
                .getForEntity(baseURL +
                "read/" +
                contact.getEmailAdd(),
                Contact.class);

        assertEquals(contact.getEmailAdd(), showResponse.getBody().getEmailAdd());

    }

    @Test
    public void c_update() {

        Contact contactUpdated = new Contact
                .Builder()
                .copy(contact)
                .setEmailAdd("215028546@mycput.ac.za")
                .build();

        ResponseEntity<Contact> updatedResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_student_security, password_student_security)
                .postForEntity(
                baseURL + "update",
                contactUpdated,
                Contact.class);

        assertEquals(contact.getEmailAdd(),
                updatedResponse.getBody().getEmailAdd());

    }

    @Test
    public void d_getAll() {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> stringHttpEntity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> theResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .exchange(
                baseURL + "all",
                HttpMethod.GET,
                stringHttpEntity,
                String.class);

        System.out.println(theResponse);
        System.out.println(theResponse.getBody());

    }

    @Test
    public void e_delete() {
        testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .delete(baseURL + "delete/" + contact.getEmailAdd());
    }
}