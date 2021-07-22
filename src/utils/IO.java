package utils;

import java.util.Scanner;
import java.util.function.Consumer;

public class IO
{
  public static Consumer<String> output = System.out::println;
  public static Scanner input = new Scanner(System.in);
  
  private IO() {  }  
}