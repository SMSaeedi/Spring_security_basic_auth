package com.example.demo;

import com.example.demo.dao.EmployeeDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootDemoTests {

    private static final ObjectMapper om = new ObjectMapper();

    @LocalServerPort
    int randomServerPort;

    int timeout = 10_000;

    public RestTemplate restTemplate;

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();

        //Connect timeout
        clientHttpRequestFactory.setConnectTimeout(timeout);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(timeout);
        return clientHttpRequestFactory;
    }

    @Before
    public void setUp() {
        restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    @Test
    public void testGetEmployeeList_success() {
        String url = "http://localhost:" + randomServerPort + "/getAllStaffs/";
        String username = "mmm7029";
        String password = "137029@Sms";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity(employeeDao.getAllEmployees(), requestHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.withBasicAuth(username, password)
                .exchange(url,
                        HttpMethod.POST,
                        requestEntity,
                        String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            printJSON(requestEntity);
        }
    }

    private static void printJSON(Object object) {
        String result;
        try {
            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}