package ru.mirea;

import java.util.Scanner;

import ru.mirea.classes.Student;
import ru.mirea.classes.StudentNotFoundException;

import ru.mirea.interfaces.IStudent;

public class StudentTest implements IStudent {
  private static final Scanner IN = new Scanner(System.in);

  /**
   * Запускает приложение
   * @param args                         аргументы командной строки
   */
  public static void main(String[] args) throws StudentNotFoundException {
    System.out.print("Введите количество студентов: ");
    int length = IN.nextInt();

    Student[] studs = new Student[length];

    for (int i = 0; i < length; ++i) {
      System.out.println("----------------------------------------");
      System.out.println("Студент №" + (i + 1) + ":");
      System.out.println();

      System.out.print("Введите ФИО студента: ");
      IN.nextLine();
      String fio = IN.nextLine();

      System.out.print("Введите средний балл студента: ");
      double gpa = IN.nextDouble();

      studs[i] = new Student(i, gpa, fio);
    }

    System.out.println("========================================");

    while (true) {
      System.out.println("Что вы хотите сделать?");
      System.out.println("  1) Получить информацию о студенте;");
      System.out.println("  2) Вывести список студентов;");
      System.out.println("  3) Отсортировать список студентов;");
      System.out.println("  4) Завершить работу.");

      System.out.print("Ваш выбор (1-4): ");
      int choice = IN.nextInt();

      IN.nextLine();
      System.out.println();

      switch (choice) {
        case 1:
          getInfo(studs);
          System.out.println();
          break;

        case 2:
          printStudents(studs);
          System.out.println();
          break;

        case 3:
          sort(studs);
          printStudents(studs);

          System.out.println();
          break;

        case 4:
          return;
      }
    }
  }

  /**
   * Выводит информацию о студенте с заданными ФИО
   * @param students          список студентов
   */
  private static void getInfo(Student[] students) throws StudentNotFoundException {
    System.out.print("Введите ФИО студента: ");
    String name = IN.nextLine();
    System.out.println(students[find(students, name)]);
  }

  /**
   * Выводит список студентов
   * @param students          массив студентов
   */
  private static void printStudents(Student[] students) {
    System.out.printf("%3s|%50s|%14s\n", "ID", "ФИО", "Средний балл");
    System.out.println("---------------------------------------------------------------------");

    for (Student stud : students) {
      System.out.printf("%3d|%50s|%14f\n", stud.getId(), stud.getName(), stud.getGpa());
    }
  }

  /**
   * Меняет местами два элемента массива
   * @param array                        массив
   * @param i                            индекс первого элемента
   * @param j                            индекс второго элемента
   */
  private static void swap(Comparable<Student>[] array, int i, int j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /**
   * Сортирует массив студентов по среднему баллу
   */
  public static void sort(Student[] students) {
    final int len = students.length;

    for (int i = 0; i < len - 1; ++i) {
      for (int j = i + 1; j < len; ++j) {
        if (students[i].compareTo(students[j]) > 0)
          swap(students, i, j);
      }
    }
  }

  /**
   * Выполняет поиск студента по его ФИО
   * @param name                         ФИО студента
   * @return                             индекс первого вхождения студента в массив
   * @throws StudentNotFoundException    студент не был найден в массиве
   */
  public static int find(Student[] students, String name) throws StudentNotFoundException {
    for (int i = 0; i < students.length; ++i) {
      if (students[i].getName().equals(name))
        return i;
    }

    throw new StudentNotFoundException("[ERROR]: Студента с ФИО " + name + " нет в списке!");
  }
}
