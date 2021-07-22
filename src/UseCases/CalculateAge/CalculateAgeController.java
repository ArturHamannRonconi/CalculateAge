package UseCases.CalculateAge;

import java.util.Scanner;
import java.util.function.Consumer;

import UseCases.Controller;
import lambdas.Executor;

public class CalculateAgeController extends Controller
{
  private static CalculateAgeController INSTANCE;
  private CalculateAgeUseCase calculateAgeUseCase;

  private CalculateAgeController(CalculateAgeUseCase calculateAgeUseCase)
  {
    this.calculateAgeUseCase = calculateAgeUseCase;
  }

  public void handle(Scanner input, Consumer<String> output)
  {
    Executor executor = () -> {
      output.accept("Enter your name:\n");
      String name = input.nextLine();
      
      output.accept("Enter your birth date (in this format dd/MM/YY):\n");
      String birthDate = input.nextLine();

      String response = this.calculateAgeUseCase.execute(birthDate, name);
      output.accept(response);
    };

    super.tryCatch(executor);
    input.close();
  } 

  public static CalculateAgeController getInstance(CalculateAgeUseCase calculateAgeUseCase)
  {
    if(!(CalculateAgeController.INSTANCE instanceof CalculateAgeController))
      CalculateAgeController.INSTANCE = new CalculateAgeController(calculateAgeUseCase);
  
    return CalculateAgeController.INSTANCE;
  }
}
