package de.fhro.inf.prg3.a06;

import de.fhro.inf.prg3.a06.model.Joke;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		String API_BASE_URL = "http://api.icndb.com/jokes/random/";

		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

		Retrofit.Builder builder =
				new Retrofit.Builder()
						.baseUrl(API_BASE_URL)
						.addConverterFactory(
								GsonConverterFactory.create()
						);

		Retrofit retrofit =
				builder
						.client(
								httpClient.build()
						)
						.build();

		ICNDBApi client =  retrofit.create(ICNDBApi.class);

		Call<Joke> call = client.getRandomJoke();
		Joke j = call.execute().body();
		System.out.println(j.getContent());


	}

}
