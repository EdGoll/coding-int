import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import sun.util.resources.TimeZoneNames;

public class DateTest {

   public static void main(final String[] args) throws Exception {
      // XMLGregorianCalendar date = FechaUtil.asXMLGregorianCalendar(new Date()) ;


      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
String date = sdf.format(new Date());
XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
System.out.println(xmlCal);
   }

}