package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.util.Box;
import ar.com.centro8.curso.java.util.Stream;
import ar.com.centro8.curso.java.util.StreamBuffer;
import ar.com.centro8.curso.java.util.X;
import java.util.List;

public class TestClase01 {

    public static void main(String[] args) {
        // Clase X
//        X.print("Hola Mundo!!!");
//        String nombre=X.input("Ingrese su nombre:");
//        int edad=X.inputInt("Ingrese su edad:");
//        X.line();
//        X.print("Hola "+nombre+" su edad es "+edad);

        // Clase Box
//        Box.msg("Hola mundo!!!");
//        String nombre=Box.input("Ingrese su nombre:");
//        int edad=Box.inputInt("Ingrese su edad:");
//        if(Box.question("Le gusta este curso?")){
//            Box.msg("Gracias "+nombre);
//        }else{
//            Box.msg("Muchas Gracias Igualmente!!!");
//        }
        //Box.error("Ocurrio un error Gravisimo!!!!!!");
        //Clase Stream
        String file = "texto.txt";
        Stream.setText(file, "Curso de Java.\n");
        Stream.append(file, "Martes\n");
        Stream.append(file, "Jueves\n");
        Stream.append(file, "Viernes\n");

        //X.print(Stream.getText(file));
        //List<String> lista = StreamBuffer.getLines(file);

//        for (int a = 0; a < lista.size(); a++) {
//            X.print(lista.get(a));
//        }

//        for(String item:lista) X.print(item);
        
    // Solo java 8 o superior
    //lista.forEach(item->X.print(item));
    
    StreamBuffer.getLines(file).forEach(X::print);
    
    

    }
}
