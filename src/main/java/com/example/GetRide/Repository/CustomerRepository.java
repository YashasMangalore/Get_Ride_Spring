package com.example.GetRide.Repository;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>//hibernate already does implementation so interface
{
    Customer findByCustomerEmailId(String email);

    @Query(value = "select * from customer where gender= :gender and age >= :age", nativeQuery = true)// :gender where : means variable coming from function
    List<Customer> getByGenderAgeGreater(String gender, Integer age);//SQL

    @Query(value = "select c from Customer c where c.customerGender = :gender and c.customerAge <= :age", nativeQuery = false)
//HibernateQl uses java variables
    List<Customer> getByGenderAgeLower(Gender gender, Integer age); //if modifying like adding @Modifying add

}
