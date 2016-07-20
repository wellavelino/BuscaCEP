package com.example.heitorcolangelo.buscacep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.heitorcolangelo.buscacep.adapter.AddressAdapter;
import java.util.List;
import model.Address;

public class HistoryActivity extends AppCompatActivity {

  private RecyclerView recycler;

  public static final String ADDRESSES_KEY = "HistoryActivity.addresses";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_history);

    List<Address> addresses = getIntent().getParcelableArrayListExtra(ADDRESSES_KEY);

    recycler = (RecyclerView) findViewById(R.id.recycler);
    recycler.setLayoutManager(new LinearLayoutManager(this));
    recycler.setAdapter(new AddressAdapter(this, addresses));
  }
}
