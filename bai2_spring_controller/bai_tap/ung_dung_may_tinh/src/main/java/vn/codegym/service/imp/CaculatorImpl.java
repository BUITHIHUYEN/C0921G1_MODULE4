package vn.codegym.service.imp;

import org.springframework.stereotype.Service;
import vn.codegym.service.ICaculator;

@Service
public class CaculatorImpl implements ICaculator {

    @Override
    public double caculation(String display,double number1, double number2) {
        double result =0;
            switch(display) {
                case "Addition (+)":
                    result= number1 + number2;
                    break;
                case "Subtraction (-)":
                    result= number1 -number2;
                    break;
                case "Multiplication (*)":
                    result=number1 * number2;
                    break;
                case  "Division (/)":
                    if (number2!=0)
                    result= number1 / number2;
                    else throw new RuntimeException("Làm gì chia được cho 0 ba >.<");
                    break;
                default:
                    break;
            }
        return result ;
        }

}
