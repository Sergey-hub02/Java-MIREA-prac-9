package ru.mirea.classes;

public class StudentNotFoundException extends Exception {
  public StudentNotFoundException(String errMsg) {
    super(errMsg);
  }
}
