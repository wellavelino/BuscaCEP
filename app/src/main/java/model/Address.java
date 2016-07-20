package model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

public class Address implements Parcelable{

  @Expose private String bairro;
  @Expose private String cep;
  @Expose private String cidade;
  @Expose private String estado;
  @Expose private String logradouro;
  @Expose private String tipoDeLogradouro;

  public Address() {
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getTipoDeLogradouro() {
    return tipoDeLogradouro;
  }

  public void setTipoDeLogradouro(String tipoDeLogradouro) {
    this.tipoDeLogradouro = tipoDeLogradouro;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.bairro);
    dest.writeString(this.cep);
    dest.writeString(this.cidade);
    dest.writeString(this.estado);
    dest.writeString(this.logradouro);
    dest.writeString(this.tipoDeLogradouro);
  }

  protected Address(Parcel in) {
    this.bairro = in.readString();
    this.cep = in.readString();
    this.cidade = in.readString();
    this.estado = in.readString();
    this.logradouro = in.readString();
    this.tipoDeLogradouro = in.readString();
  }

  public static final Creator<Address> CREATOR = new Creator<Address>() {
    @Override
    public Address createFromParcel(Parcel source) {
      return new Address(source);
    }

    @Override
    public Address[] newArray(int size) {
      return new Address[size];
    }
  };
}
