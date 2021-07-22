package providers.DateProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import providers.interfaces.IDateProvider;

public class JavaDateProvider implements IDateProvider
{
  private static JavaDateProvider INSTANCE;

  private JavaDateProvider() {  }

  public Date now()
  {
    return new Date();
  }
  public Boolean verifyDateFormat(String dateString)
  {
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      formatter.setLenient(false);
      formatter.parse(dateString);
      return true;
    } catch (ParseException ex) {
      return false;
    }
  }
  public Date stringToDate(String dateString)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    try { return formatter.parse(dateString); }
    catch(ParseException e) { System.out.println(e.getMessage()); }

    return new Date();
  }
  public Long getAgeInYears(Date birthDate)
  {
    Long lifeTimeInMilliseconds = this.now().getTime() - birthDate.getTime();
    long millisecondsInYears = (long) 1000 * 60 * 60 * 24 * 365;
    Long lifeTimeInYears = lifeTimeInMilliseconds / millisecondsInYears;  

    return lifeTimeInYears;
  }

  public static JavaDateProvider getInstance()
  {
    if(!(JavaDateProvider.INSTANCE instanceof JavaDateProvider))
      JavaDateProvider.INSTANCE = new JavaDateProvider();
  
    return JavaDateProvider.INSTANCE;
  }
}
