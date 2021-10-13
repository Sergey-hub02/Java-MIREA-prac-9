package ru.mirea.interfaces;

import ru.mirea.classes.Student;
import ru.mirea.classes.StudentNotFoundException;


public interface IStudent {
  /**
   * Сортирует массив студентов по среднему баллу
   */
  static void sort(Student[] students) {}

  /**
   * Выполняет поиск студента по его ФИО
   * @param name                                ФИО студента
   * @return                                    индекс первого вхождения студента в массив
   * @throws StudentNotFoundException           студент не был найден в массиве
   */
  static int find(Student[] students, String name) throws StudentNotFoundException {
    return 1;
  }
}
