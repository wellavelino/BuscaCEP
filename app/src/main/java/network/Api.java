package network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Address;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Api {

  public static final Gson GSON = new GsonBuilder()
      .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SS'Z'")
      .create();

  private CepService api;

  private static Api INSTANCE;

  /**
   * Sets up the singleton instance
   *
   * @return Singleton instance
   */
  public static Api getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Api();
    }
    return INSTANCE;
  }

  public void getAddress(String cep, final OnResponseCallBack callBack) {
    Call<Address> userResponsePage = api.getAddress(cep);
    userResponsePage.enqueue(new Callback<Address>() {
      @Override
      public void onResponse(Call<Address> call, Response<Address> response) {
          if (response.body() != null) {
              callBack.onSuccess(response.body());
          }
      }

      @Override
      public void onFailure(Call<Address> call, Throwable t) {
        callBack.onFailure(call);
      }
    });
  }

  private Api() {
    api = new Retrofit.Builder()
        .baseUrl("http://correiosapi.apphb.com/")
        .addConverterFactory(GsonConverterFactory.create(GSON))
        .build()
        .create(CepService.class);
  }

  public interface OnResponseCallBack {
    void onSuccess(Address address);
    void onFailure(Call<Address> call);
  }
}
