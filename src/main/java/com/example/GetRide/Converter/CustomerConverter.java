package com.example.GetRide.Converter;


import com.example.GetRide.Dto.Requests.AddCustomerRequest;
import com.example.GetRide.Dto.Responses.CustomerResponse;
import com.example.GetRide.Model.Customer;

public class CustomerConverter
{
    public static CustomerResponse customerToCustomerResponse(Customer customer)
    {
        return CustomerResponse.builder()
                .customerName(customer.getCustomerName())
                .customerAge(customer.getCustomerAge())
                .customerGender(customer.getCustomerGender())
                .customerEmailId(customer.getCustomerEmailId())
                .customerMobileNumber(customer.getCustomerMobileNumber())
                .build();
    }

    public static Customer customerRequestToCustomer(AddCustomerRequest customerRequest)
    {
        return Customer.builder()
                .customerName(customerRequest.getCustomerName())
                .customerGender(customerRequest.getCustomerGender())
                .customerEmailId(customerRequest.getCustomerEmailId())
                .customerMobileNumber(customerRequest.getCustomerMobileNumber())
                .customerAge(customerRequest.getCustomerAge())
                .build();
    }
}
