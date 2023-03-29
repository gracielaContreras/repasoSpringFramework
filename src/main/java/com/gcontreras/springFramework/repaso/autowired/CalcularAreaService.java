package com.gcontreras.springFramework.repaso.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CalcularAreaService {
    @Autowired
    private List<Figure> figures;

    // programación funcional con Streams y método de referencia (::)
    public double getTotalAreas(){
        return figures.stream()
                .mapToDouble(Figure::calcularArea).sum();
    }

// programación imperativa
//    public double getTotalAreas(){
//        double sumArea = 0;
//        for(Figure figure : figures){
//            sumArea+=figure.calcularArea();
//        }
//        return sumArea;
//    }
}
