package com.gridnine.testing.moduleSearch;

import com.gridnine.testing.testclass.Flight;
import com.gridnine.testing.testclass.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MoreTwoHoursWait implements FlightFilter {
    //проверяет условие -общее время, проведённое на земле превышает два часа

    public boolean search(Flight flight) {

        if (flight.getSegments().size() > 1) {
            List<Segment> list = flight.getSegments();

            for (int i = 0; i < list.size() - 1; i++) {
                LocalDateTime arr = flight.getSegments().get(i).getArrivalDate().plusMinutes(120);
                LocalDateTime depNext = flight.getSegments().get(i + 1).getDepartureDate();

                if (arr.isBefore(depNext)) {
                    return false;
                } else return true;


            }

        }
        return false;
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flightList) {
        List<Flight> filtred = new ArrayList<>();
        for (Flight flight : flightList) {
            if (search(flight)) {
                filtred.add(flight);
            }
        }
        return filtred;
    }
}
