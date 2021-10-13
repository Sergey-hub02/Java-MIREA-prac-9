package ru.mirea.classes;

public class Student implements Comparable<Student> {
  private final int id;
  private final double gpa;
  private final String name;

  /**
   * Конструктор не по умолчанию
   * @param id            id студента
   * @param gpa           итоговый балл
   * @param name          имя студента
   */
  public Student(int id, double gpa, String name) {
    this.id = id;
    this.gpa = gpa;
    this.name = name;
  }

  /**
   * Геттер для поля id
   * @return        id студента
   */
  public int getId() {
    return this.id;
  }

  /**
   * Геттер для поля gpa
   * @return      итоговый балл
   */
  public double getGpa() {
    return this.gpa;
  }

  /**
   * Геттер для поля name
   * @return        имя студента
   */
  public String getName() {
    return this.name;
  }

  /**
   * Возвращает число:
   *      < 0, если средний балл текущего студента < среднего балла другого студента
   *      = 0, если средний балл текущего студента = среднему баллу другого студента
   *      > 0, если средний балл текущего студента > среднего балла другого студента
   * @param other   другой объект класса Student
   */
  public int compareTo(Student other) {
    return Double.compare(this.gpa, other.getGpa());
  }

  /**
   * Объединяет всю информацию о студенте в одну строку
   * @return          информация о студенте
   */
  @Override
  public String toString() {
    return "Student {" + "\n"
                       + "  " + "Номер: " + this.id + "\n"
                       + "  " + "ФИО: " + this.name + "\n"
                       + "  " + "Средний балл: " + this.gpa + "\n"
                       + "}";
  }
}
