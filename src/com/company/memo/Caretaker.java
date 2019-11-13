package com.company.memo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Caretaker<T> {

  private List<T> memento;

  public Caretaker() {
    memento = new LinkedList<>();
  }

  public void push(T item) {
    memento.add(item);
  }

  public Optional<T> pop() {
    if (memento.size() > 0) {
      return Optional.of(memento.remove(memento.size() - 1));
    } else {
      return Optional.empty();
    }
  }

  void clear() {
    memento.clear();
  }
}
