package UseCases.CalculateAge;

import exceptions.InvalidDateError;
import exceptions.EmptyFieldsError;
import providers.interfaces.IDateProvider;

public class CalculateAgeUseCase
{
  private static CalculateAgeUseCase INSTANCE;
  private IDateProvider dateProvider;

  private CalculateAgeUseCase(IDateProvider dateProvider)
  {
    this.dateProvider = dateProvider;
  }

  String execute(String dateString, String name)
  {
    var emptyFields = dateString.isEmpty() || name.isEmpty();
    if(emptyFields) throw new EmptyFieldsError(); 

    var isValidDateFormat = this.dateProvider.verifyDateFormat(dateString);
    if(!isValidDateFormat) throw new InvalidDateError();
    
    var birthDate = this.dateProvider.stringToDate(dateString);
    var years = this.dateProvider.getAgeInYears(birthDate);

    var negativeAge = years < 0;
    if(negativeAge) throw new InvalidDateError();

    return "Hi " + name + ", your age is " + years + " years\n";
  } 

  public static CalculateAgeUseCase getInstance(IDateProvider dateProvider)
  {
    if(!(CalculateAgeUseCase.INSTANCE instanceof CalculateAgeUseCase))
      CalculateAgeUseCase.INSTANCE = new CalculateAgeUseCase(dateProvider);
  
    return CalculateAgeUseCase.INSTANCE;
  }
}
