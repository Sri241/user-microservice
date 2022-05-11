package com.wipro.velocity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.wipro.velocity.model.Account;

@Service
public class UserService {

	@Autowired
    private RestTemplate restTemplate; // configured to use as Load Balancer Client
   
    public List<Account> showEmployees(@PathVariable("id") int id) {
        System.out.println(id);
       
        // Invokes Account Microservice
        //  "http://localhost:9000/accounts/{empId}" -- actually we invoke
        // ms in above format
        // To avoid hardcoding of URL , we use netflix Ribbon Service which can be integrated with
        // Eureka -- Ribbon Load Balancer
        //Communicates with Account microservice using restTemple exchange method
        List<Account> accounts = restTemplate.exchange(
                "http://ACCOUNT/accounts/{empId}", HttpMethod.GET, null, new
                ParameterizedTypeReference<List<Account>>(){}, id).getBody();
                return accounts;        //user microservice returns REST data of Accounts 
              }
}
