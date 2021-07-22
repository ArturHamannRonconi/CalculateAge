package providers.interfaces;

import java.util.Date;

public interface IDateProvider
{
  Date now();
  Boolean verifyDateFormat(String dateString);
  Date stringToDate(String dateString);
  Long getAgeInYears(Date birthDate);
}
