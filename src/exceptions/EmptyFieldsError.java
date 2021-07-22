package exceptions;

public class EmptyFieldsError extends AppError
{
  public EmptyFieldsError()
  {
    super("Fields are empty!");
  }
}
