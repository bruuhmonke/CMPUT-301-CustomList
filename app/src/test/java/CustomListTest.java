import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();

        list.addCity(new City("Halifax", "NS"));

        assertEquals(listSize+1, list.getCount());

    }

    @Test
    public void testHasCity() {
        City mockCity = new City("Calgary", "Alberta");

        assertFalse(list.hasCity(mockCity));

        list.addCity(mockCity);

        assertTrue(list.hasCity(mockCity));
    }

    @Test
    public void testDeleteCity() {

        City mockCity = new City("Victoria", "British Columbia");

        list.addCity(mockCity);

        assertTrue(list.hasCity(mockCity));

        list.deleteCity(mockCity);

        assertFalse(list.hasCity(mockCity));

    }

    @Test
    public void testCountCities() {
        City mockCity1 = new City("Quebec City", "Quebec");
        City mockCity2 = new City("Ottawa", "Ontario");

        assertEquals(1, list.countCities());

        list.add(mockCity1);

        assertEquals(2, list.countCities());

        list.add(mockCity2);

        assertEquals(3, list.countCities());

        list.deleteCity(mockCity2);

        assertEquals(2, list.countCities());

        list.deleteCity(mockCity1);

        assertEquals(1, list.countCities());
    }
}
