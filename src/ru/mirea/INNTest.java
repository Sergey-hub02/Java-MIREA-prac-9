package ru.mirea;

import java.util.Scanner;
import java.util.HashMap;

import ru.mirea.classes.InvalidINNException;

public class INNTest {
  private static final Scanner IN = new Scanner(System.in);

  public static void main(String[] args) {
    var base = new HashMap<String, String>(5);

    base.put("5367687281", "Иванов Иван Иванович");
    base.put("0567475944", "Пупкин Василий Петрович");
    base.put("7992222888", "Птицин Алексей Андреевич");
    base.put("3401662695", "Андронов Евгений Сергеевич");
    base.put("0204012893", "Иванов Сергей Тихонович");

    System.out.print("Введите ФИО: ");
    String name = IN.nextLine();

    System.out.print("Введите ИНН: ");
    String inn = IN.next();

    try {
      String baseName = base.get(inn);

      if (!name.equals(baseName)) {
        throw new InvalidINNException("[ERROR]: ИНН \"" + inn + "\" не действителен для пользователя " + name);
      }

      System.out.println("ИНН \"" + inn + "\" действителен для пользователя " + name);
    }
    catch (InvalidINNException exc) {
      System.err.println(exc.getMessage());
    }
  }
}
