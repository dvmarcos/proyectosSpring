package prueba.validador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import prueba.entidad.PruebaEntity;


public class PruebaValidador implements Validator {

	 private static final int A�O_ACTUAL = 
		        Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));   
	 
	public boolean supports(Class<?> clazz) {
		return PruebaEntity.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		PruebaEntity prueba = (PruebaEntity) target;
        
        // el campo1 es obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "columna1", "field.campo1.required", 
                "el campo columna1 es obligatorio");
        
        
         
//        // debe tener un formato correcto del tipo: 1111-BBB o B-2222-MM
//        validarFormatoMatricula(datosCoche.getMatricula(), errors); // valida la matricula por expresi�n regular
//         
//        // la matr�cula es obligatoria
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "field.modelo.required", 
//            "El modelo es obligatorio");
//            
//        
//        // el a�o debe ser v�lido no puede ser mayor que el actual
//        if ( datosCoche.getAnho() < 1900 || datosCoche.getAnho() > A�O_ACTUAL ) {
//            errors.rejectValue("anho", "field.anho.invalid", "El anho es incorrecto");
//        }   
//         
//        // si no hay errores relacionados con el campo a�o
//        if ( ! errors.hasFieldErrors("anho")) {
//         
//            // para los coches de a�o distinto al actual, validamos que no tengan m�s de 100.000 km
//            if ( datosCoche.getAnho() < A�O_ACTUAL ) {
//                 
//                if ( datosCoche.getKilometros() < 0 ) {
//                    errors.rejectValue("kilometros", "field.kilometros.invalid", 
//                            "Los kil�metros son incorrectos");
//                }
//                 
//                if ( datosCoche.getKilometros() > 100000 ) {
//                    errors.rejectValue("kilometros", "field.kilometros.toomany", 
//                            "No se aceptan coches de m�s de 100000 km");
//                }
//             
//            }       
//        }       
         
    }
	
	 private void validarFormatoMatricula (String matricula, Errors errors) {
	        // valida la matr�cula por expresi�n regular, si hay error lo a�ade a errors
	    }

}
