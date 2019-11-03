package com.company.memo;

public class Memento<T> {

  private T memo;

  public Memento(T memo) {
    this.memo = memo;
  }

  public T getMemo() {
    return memo;
  }

  public void setMemo(T memo) {
    this.memo = memo;
  }
}
