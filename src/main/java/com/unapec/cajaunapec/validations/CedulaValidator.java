package com.unapec.cajaunapec.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CedulaValidator implements ConstraintValidator<Cedula, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        int vnTotal = 0;
        String vcCedula = value.replace("-", "");
        int pLongCed = vcCedula.trim().length();
        int[] digitMulti = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};

        if (pLongCed != 11)
            return false;


        for (int vDig = 1; vDig <= pLongCed; vDig++) {
            int vCalculo = Integer.parseInt(vcCedula.substring(vDig - 1, vDig)) * digitMulti[vDig - 1];
            if (vCalculo < 10)
                vnTotal += vCalculo;
            else
                vnTotal += Integer.parseInt(String.valueOf(vCalculo).substring(0, 1)) + Integer.parseInt(String.valueOf(vCalculo).substring(1, 2));
        }

        return vnTotal % 10 == 0;

    }
}
