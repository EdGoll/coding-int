
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class FechaUtil {
    public final static String FORMATO_FECHA= "dd/MM/yyyy";
    public final static String FORMATO_FECHAMESDIA= "MM/dd/yyyy";
    public final static String FORMATO_FECHA_PROCEDIMIENTO = "ddMMyyyy";
    public final static String FORMATO_FECHA_SQL_DATE_ORACLE    = "yyyy-MM-dd";
    public final static String FORMATO_HORA_MINUTO    = "HH:mm";
    public final static String FORMATO_FECHA_HORA_GESTION_PLANTA_CORP = "dd/MM/yyyy HH:mm";
    
    /**
     * @return
     */
    public static java.util.Date getFechaActual() {
    	
        return new Date();
        
    }

    /**
     * @return
     */
    public static java.sql.Date getFechaActualBD() {
        return new java.sql.Date(getFechaActual().getTime());
    }

    /**
     * @param fechaBD
     * @param formato
     * @return
     */
    public static String formatFechaBD(java.sql.Date fechaBD) {
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(FORMATO_FECHA);
        if (fechaBD == null) {
            return "";
        } else {
            return patronParaFecha.format(fechaBD);
        }
    }

/**
     * @param fechaBD
     * @param formato
     * @return
     */
    public static String formatFechaToProc(java.sql.Date fechaBD) {
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(FORMATO_FECHA_PROCEDIMIENTO);
        if (fechaBD == null) {
            return "";
        } else {
            return patronParaFecha.format(fechaBD);
        }
    }

    /**
     * @param valor
     * @param formato
     * @throws ParseException
     */
    public static java.sql.Date parseToFechaBD(String valor) throws ParseException {
        if ((valor == null) || (valor.length()==0)) return null;   
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(FORMATO_FECHA);
        patronParaFecha.setLenient(false);        
        java.sql.Date fechaSQL = new java.sql.Date(patronParaFecha.parse(valor).getTime());
        return fechaSQL;
    }



    /**
     * @param fechaBD
     * @param formato
     * @return
     */
    public static String formatFecha(java.sql.Date fechaBD, String formato) {
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(formato);
        if (fechaBD == null) {
            return "";
        } else {
            return patronParaFecha.format(fechaBD);
        }
    }

    /**
     * @param valor
     * @param formato
     * @throws ParseException
     */
    public static java.sql.Date parseFecha(String valor, String formato) throws ParseException {
        if ((valor == null) || (valor.length()==0)) return null;   
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(formato);
        patronParaFecha.setLenient(false);        
        java.sql.Date fechaSQL = new java.sql.Date(patronParaFecha.parse(valor).getTime());
        return fechaSQL;

    }

    /**
     * @param valor
     * @param formato
     * @throws ParseException
     */
    public static String parseToFechaMESDIA(String valor) throws ParseException {
        if ((valor == null) || (valor.length()==0)) return null;   
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(FORMATO_FECHAMESDIA);
        patronParaFecha.setLenient(false);        
        java.sql.Date fechaSQL = new java.sql.Date(patronParaFecha.parse(valor).getTime());
        return fechaSQL.toString();
    }
    
    public static String parseFechaToPattern(String valor, String pattern) throws ParseException {
        if ((valor == null) || (valor.length()==0)) return null;   
        SimpleDateFormat patronParaFecha = new SimpleDateFormat(pattern);
        patronParaFecha.setLenient(false);        
        java.sql.Date fechaSQL = new java.sql.Date(patronParaFecha.parse(valor).getTime());
        return fechaSQL.toString();
    }

    public static java.sql.Date getFechaHoy() throws ParseException 
        {
            java.util.Date fechaA= new java.util.Date();
            java.sql.Date fechaActual = new java.sql.Date(fechaA.getTime());
            return fechaActual;                    
        }
    public static void main(String[] args) {

    }

    // DatatypeFactory creates new javax.xml.datatype Objects that map XML to/from Java Objects.
    private static DatatypeFactory df = null;

	static {
		 try {
			 df = DatatypeFactory.newInstance();
		 } catch(DatatypeConfigurationException e) {
			 throw new IllegalStateException("Error while trying to obtain a new instance of DatatypeFactory", e);
		 }
	}
	
	//Converts a java.util.Date into an instance of XMLGregorianCalendar
    public static XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) {
	    if(date == null) {
	    	return null;
	    } else {
	    	GregorianCalendar gc = new GregorianCalendar(); 
	    	gc.setTimeInMillis(date.getTime());
	    	return df.newXMLGregorianCalendar(gc);
	    }
    }
 
    public static XMLGregorianCalendar asXMLGregorianCalendarFormat(java.util.Date date) {
	    if(date == null) {
	    	return null;
	    } else {
	    	String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";			
			DateFormat format = new SimpleDateFormat(dateFormat);	    	
	    	GregorianCalendar gc = new GregorianCalendar(); 
	    	gc.setTimeInMillis(date.getTime());
	    	return df.newXMLGregorianCalendar(format.format(gc));
	    }
    }
    
    // Converts an XMLGregorianCalendar to an instance of java.util.Date
    public static java.util.Date asDate(XMLGregorianCalendar xmlGC) { 
	    if(xmlGC == null) {
	    	return null;
	    } else { 
	    	return xmlGC.toGregorianCalendar().getTime();    
	    }    
    }
    
    public static java.util.Date stringDateTimeAsDate(String xmlStringDataTime) { 
    	Date date = null; 
    	try {
    		Calendar mPublishDate;
			df = DatatypeFactory.newInstance();
			mPublishDate=df.newXMLGregorianCalendar(xmlStringDataTime).toGregorianCalendar();
			date = mPublishDate.getTime();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null; 
		}
    	return date; 
    }    
    
	public static String formatISO8601(Date fecha) {
    	if(fecha == null) return null;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return sdf.format(fecha);
    }
	
	public static Date parseFormatISO8601(String fecha) {
    	if(fecha == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        //sdf.setLenient(false);
        try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
    }
	
//	public static String getFechaOrigenDocAR(String fechaOrigDoc) {
//		if(fechaOrigDoc == null) return null;
//    	Date fechaEmision = new Date (Long.parseLong(fechaOrigDoc));
//    	return DateUtils.normalizarFechaXML(fechaEmision);
//    }
}