package prueba.validador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import prueba.entidad.PruebaEntity;


public class PruebaValidador implements Validator {

	 private static final int AÑO_ACTUAL = 
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
//        validarFormatoMatricula(datosCoche.getMatricula(), errors); // valida la matricula por expresión regular
//         
//        // la matrícula es obligatoria
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "field.modelo.required", 
//            "El modelo es obligatorio");
//            
//        
//        // el año debe ser válido no puede ser mayor que el actual
//        if ( datosCoche.getAnho() < 1900 || datosCoche.getAnho() > AÑO_ACTUAL ) {
//            errors.rejectValue("anho", "field.anho.invalid", "El anho es incorrecto");
//        }   
//         
//        // si no hay errores relacionados con el campo año
//        if ( ! errors.hasFieldErrors("anho")) {
//         
//            // para los coches de año distinto al actual, validamos que no tengan más de 100.000 km
//            if ( datosCoche.getAnho() < AÑO_ACTUAL ) {
//                 
//                if ( datosCoche.getKilometros() < 0 ) {
//                    errors.rejectValue("kilometros", "field.kilometros.invalid", 
//                            "Los kilómetros son incorrectos");
//                }
//                 
//                if ( datosCoche.getKilometros() > 100000 ) {
//                    errors.rejectValue("kilometros", "field.kilometros.toomany", 
//                            "No se aceptan coches de más de 100000 km");
//                }
//             
//            }       
//        }       
         
    }
	
	 private void validarFormatoMatricula (String matricula, Errors errors) {
	        // valida la matrícula por expresión regular, si hay error lo añade a errors
	    }

}
