import com.gridnine.testing.moduleSearch.ArriveBeforeDeparture;
import com.gridnine.testing.moduleSearch.FlightBeforeNow;
import com.gridnine.testing.moduleSearch.MoreTwoHoursWait;
import com.gridnine.testing.testclass.Flight;
import com.gridnine.testing.testclass.FlightBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestModuleSearch {
    public class TestSearchModule {
        //в тестах проверены условия на соответствие true/false
        private List<Flight> flights;

        @Before
        public void createFlights() {
            flights = FlightBuilder.createFlights();
        }

        @Test
        public void TestArriveBeforeDeparture() {
            ArriveBeforeDeparture arr = new ArriveBeforeDeparture();
            Assert.assertTrue(arr.search(flights.get(2)));
            Assert.assertFalse(arr.search(flights.get(3)));
        }

        @Test
        public void TestFlightBeforeNow() {
            FlightBeforeNow flightBeforeNow = new FlightBeforeNow();
            Assert.assertFalse(flightBeforeNow.search(flights.get(2)));
            Assert.assertTrue(flightBeforeNow.search(flights.get(5)));
        }

        @Test
        public void TestMoreTwoHoursWait() {
            MoreTwoHoursWait more = new MoreTwoHoursWait();
            Assert.assertTrue(more.search(flights.get(5)));
            Assert.assertFalse(more.search(flights.get(4)));
        }
    }
}
