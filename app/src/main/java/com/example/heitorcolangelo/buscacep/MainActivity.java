package com.example.heitorcolangelo.buscacep;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import model.Address;
import network.Api;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements Api.OnResponseCallBack {

  private EditText cep;
  private ImageButton search;
  private Button history;
  private TextView addressText;

  private List<Address> addresses;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    addresses = new ArrayList<>();

    cep = (EditText) findViewById(R.id.cep);
    search = (ImageButton) findViewById(R.id.search);
    addressText = (TextView) findViewById(R.id.address);
    search.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Api.getInstance().getAddress(cep.getText().toString(), MainActivity.this);
      }
    });

    history = (Button) findViewById(R.id.history);
    history.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        intent.putParcelableArrayListExtra(HistoryActivity.ADDRESSES_KEY,
            (ArrayList<? extends Parcelable>) addresses);
        startActivity(intent);
      }
    });
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putParcelableArrayList(HistoryActivity.ADDRESSES_KEY,
        (ArrayList<? extends Parcelable>) addresses);
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    addresses = savedInstanceState.getParcelableArrayList(HistoryActivity.ADDRESSES_KEY);
  }

  @Override
  public void onSuccess(Address address) {
    this.addresses.add(address);
    addressText.setText(getString(R.string.address, address.getCep(), address.getTipoDeLogradouro(),
        address.getLogradouro(), address.getBairro(), address.getCidade(), address.getEstado()));
  }

  @Override
  public void onFailure(Call<Address> call) {
    Toast.makeText(this, "Erro na requisição", Toast.LENGTH_LONG).show();
  }
}
