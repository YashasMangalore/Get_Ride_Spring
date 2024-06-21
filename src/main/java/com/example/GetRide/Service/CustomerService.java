package com.example.GetRide.Service;

import com.example.GetRide.Converter.CustomerConverter;
import com.example.GetRide.Dto.Requests.AddCustomerRequest;
import com.example.GetRide.Dto.Responses.CustomerResponse;
import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Model.Customer;
import com.example.GetRide.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public String addCustomer(AddCustomerRequest customerRequest)
    {
        //dto->entity
        Customer customer=CustomerConverter.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);
        return "Customer saved successfully";
    }

    public CustomerResponse getCustomer(String customerEmailId) throws Exception
    {
        try
        {
            Customer customer = customerRepository.findByCustomerEmailId(customerEmailId);
            //entity->response
            return customer != null ? CustomerConverter.customerToCustomerResponse(customer) : null;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error retrieving customer with email: " + customerEmailId, e);
        }
    }

    public List<CustomerResponse> getByGenderAgeGreater(Gender gender, Integer age,Boolean greater)//SQL
    {
        List<Customer> customerList;
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        if(greater)
        {
            customerList = customerRepository.getByGenderAgeGreater(String.valueOf(gender), age);
            for (Customer customer : customerList)
            {
                customerResponseList.add(CustomerConverter.customerToCustomerResponse(customer));
            }
        }
        else
        {
            customerList = customerRepository.getByGenderAgeLower(gender, age);
            for(Customer customer:customerList)
            {
                customerResponseList.add(CustomerConverter.customerToCustomerResponse(customer));
            }
        }

        return customerResponseList;
    }
}
