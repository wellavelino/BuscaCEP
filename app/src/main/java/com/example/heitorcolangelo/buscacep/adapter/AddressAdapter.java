package com.example.heitorcolangelo.buscacep.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.heitorcolangelo.buscacep.R;
import java.util.List;
import model.Address;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

  private List<Address> addresses;
  private Context context;

  public AddressAdapter(Context context, List<Address> addresses) {
    this.addresses = addresses;
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_view, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Address address = addresses.get(position);
    holder.mTextView.setText(
        context.getString(R.string.address, address.getCep(), address.getTipoDeLogradouro(),
            address.getLogradouro(), address.getBairro(), address.getCidade(),
            address.getEstado()));
  }

  @Override
  public int getItemCount() {
    return addresses.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;

    public ViewHolder(View v) {
      super(v);
      mTextView = (TextView) v.findViewById(R.id.address);
    }
  }
}
