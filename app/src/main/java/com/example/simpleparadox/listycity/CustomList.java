package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this function will get the size of the list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * this function will add a city object into the list
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
        return;
    }

    /**
     * this function will check for a specific city in the list
     * @param city
     *      This is the candidate city to check for
     * @return
     *      Returns a boolean indicating whether this list contains a city
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list, if the city doesn't exist then it throws
     * IllegalArgumentException
     *
     * @throws IllegalArgumentException
     *      If the city doesn't exist in the list this is thrown
     * @param city
     *      This is a candidate city to remove
     *
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }

        cities.remove(city);
    }

    /**
     * This checks how many cities are in the list and returns it
     *
     * @return
     *      Returns an int indicating the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
