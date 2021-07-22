import UseCases.CalculateAge.CalculateAgeController;
import UseCases.CalculateAge.CalculateAgeUseCase;
import providers.DateProvider.JavaDateProvider;
import utils.IO;
 
public class Start
{
  public static void main(String[] args)
  {
    var dateProvider = JavaDateProvider.getInstance();
    var calculateAgeUseCase = CalculateAgeUseCase.getInstance(dateProvider);
    var calculateAgeController = CalculateAgeController.getInstance(calculateAgeUseCase);
    
    calculateAgeController.handle(
      IO.input,
      IO.output
    );
  }
}