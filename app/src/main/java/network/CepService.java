package network;

import model.Address;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

  @GET("/cep/{cep}")
  Call<Address> getAddress(@Path("cep") String cep);
}
