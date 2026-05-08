package com.melikash98.brewbite.Interface;

import com.melikash98.brewbite.Location.CityModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * The WeatherApi interface defines the Retrofit API endpoints used for
 * communicating with the weather and geolocation services inside the application.
 *
 * This interface is mainly responsible for retrieving city location data
 * from the remote API based on a user search query.
 *
 * Current features:
 * - Searches cities using city name and optional country information
 * - Supports limiting the number of returned results
 * - Uses an API key for authorized requests
 * - Returns structured city location data mapped into CityModel objects
 *
 * This interface works together with Retrofit to simplify network operations
 * by converting HTTP requests into clean and easy-to-use Java method calls.
 *
 * Endpoint details:
 * - Endpoint: geo/1.0/direct
 * - HTTP Method: GET
 * - Response Type: List<CityModel>
 *
 * Typical use cases:
 * - Searching for cities before requesting weather data
 * - Location autocomplete systems
 * - Converting city names into geographic coordinates
 * - Preparing latitude and longitude values for weather forecasts
 *
 * Important notes:
 * - The API response may return multiple cities with similar names
 * - The limit parameter should be used carefully to reduce unnecessary data usage
 * - A valid API key is required for successful requests
 */
public interface WeatherApi {
    @GET("geo/1.0/direct")
    Call<List<CityModel>> getCities(

            @Query("q") String cityCountry,

            @Query("limit") int limit,

            @Query("appid") String apiKey
    );
}
