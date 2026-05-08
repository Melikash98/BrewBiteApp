package com.melikash98.brewbite.Location;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The RetrofitClient class is a simple utility class responsible for creating
 * and providing a single shared instance of Retrofit throughout the application.
 *
 * Retrofit is used here to handle network communication with the remote weather API
 * in a clean, structured, and maintainable way.
 *
 * Main responsibilities of this class:
 * - Building the Retrofit instance only once using the Singleton pattern
 * - Defining the base URL of the OpenWeatherMap API
 * - Adding the Gson converter so JSON responses can be automatically parsed
 *   into Java model classes
 *
 * Why this class is important:
 * - Prevents creating multiple Retrofit objects unnecessarily
 * - Centralizes API configuration in one place
 * - Makes network setup easier to maintain and update
 *
 * Current configuration:
 * - Base URL: https://api.openweathermap.org/
 * - Converter: GsonConverterFactory
 *
 * Typical use case:
 * - Used together with Retrofit service interfaces such as WeatherApi
 *   to perform API requests and receive structured response data.
 */

public class RetrofitClient {
    private static Retrofit retrofit;

    /**
     * Returns the shared Retrofit instance.
     *
     * If the instance has not been created yet, it will be initialized first
     * with the required base URL and Gson converter.
     *
     * @return the Retrofit singleton instance
     */

    public static Retrofit getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()

                    .baseUrl("https://api.openweathermap.org/")

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }

        return retrofit;
    }

}
