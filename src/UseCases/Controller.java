package UseCases;

import exceptions.AppError;
import lambdas.Executor;

public class Controller
{
  protected void tryCatch(Executor executor)
  {
    try {
      executor.exe();
    } catch (AppError error) {
      System.out.println(error.getMessage());
    }
  }  
}
