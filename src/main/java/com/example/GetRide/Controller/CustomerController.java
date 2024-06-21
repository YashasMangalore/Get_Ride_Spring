package com.example.GetRide.Controller;

import com.example.GetRide.Dto.Requests.AddCustomerRequest;
import com.example.GetRide.Dto.Responses.CustomerResponse;
import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController     //or Transformer same but different name
{
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody AddCustomerRequest customerRequest)
    {
        String response=customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerResponse> getCustomer(@RequestParam("email") String customerEmailId) throws Exception
    {
        try
        {
            CustomerResponse customerResponse = customerService.getCustomer(customerEmailId);
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}/greater/{greater}")
    public ResponseEntity<List<CustomerResponse>> getByGenderAgeGreater(@PathVariable("gender") Gender gender,
            @PathVariable("age") Integer age, @PathVariable("greater") Boolean greater)
    {
        List<CustomerResponse> responseList=customerService.getByGenderAgeGreater(gender,age,greater);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
