package com.example.GetRide.Transformer;

import com.example.GetRide.Dto.Requests.AddCabRequest;
import com.example.GetRide.Dto.Responses.CabResponse;
import com.example.GetRide.Model.Cab;

public class CabTransformer
{
    public static Cab cabRequestToCab(AddCabRequest cabRequest)
    {
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabType(cabRequest.getCabType())
                .cabFarePerKm(cabRequest.getCabFarePerKm())
                .cabIsBooked(false)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab)
    {
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabFarePerKm(cab.getCabFarePerKm())
                .cabIsBooked(cab.getCabIsBooked())
                .cabType(cab.getCabType())
                .build();
    }
}
