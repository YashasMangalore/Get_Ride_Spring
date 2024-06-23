package com.example.GetRide.Exception;

public class CustomerNotFoundException extends RuntimeException//and not exception to avoid writing throws
{
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
