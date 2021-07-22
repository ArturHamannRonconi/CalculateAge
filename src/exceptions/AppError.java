package exceptions;

public class AppError extends RuntimeException
{
  AppError(String message)
  {
    super(message);
  }
}
