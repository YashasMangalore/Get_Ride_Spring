package com.example.GetRide.Controller;

import com.example.GetRide.Dto.Requests.AddBookingRequest;
import com.example.GetRide.Dto.Responses.BookingResponse;
import com.example.GetRide.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookingController
{
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookCab(@RequestBody AddBookingRequest bookingRequest) throws Exception
    {
        try
        {
            BookingResponse bookingResponse = bookingService.bookCab(bookingRequest);
            return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
