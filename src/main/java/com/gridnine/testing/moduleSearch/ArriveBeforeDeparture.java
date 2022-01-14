package com.gridnine.testing.moduleSearch;

import com.gridnine.testing.testclass.Flight;
import com.gridnine.testing.testclass.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArriveBeforeDeparture implements FlightFilter {
    //проверяет условие -имеются ли сегменты с датой прилёта раньше даты вылета

    public boolean search(Flight flight) {
        if (flight.getSegments().size() == 1) {
            LocalDateTime dep = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime arr = flight.getSegments().get(0).getArrivalDate();

            if (dep.isAfter(arr)) {
                return false;
            }

        } else {
            List<Segment> list = flight.getSegments();

            for (int i = 0; i < list.size() - 1; i++) {
                LocalDateTime dep = flight.getSegments().get(i).getDepartureDate();
                LocalDateTime arr = flight.getSegments().get(i).getArrivalDate();
                LocalDateTime next = flight.getSegments().get(i + 1).getDepartureDate();

                if (dep.isAfter(arr) || arr.isAfter(next)) {
                    return false;
                }

            }
        }
        return true;
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