package de.ausy.bufs.javahappen;

/**
 * 
 */
public class TemperatureOutOfRangeException extends Exception {

   TemperatureOutOfRangeException(String message) {
       super(message);
   } 
   
   TemperatureOutOfRangeException(Throwable ex, String message) {
       super(message, ex);
   }   
    
}
