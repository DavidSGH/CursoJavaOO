package ar.com.centro8.curso.java.jsp;

public class JSPGenerator {
    public static String getHead(){
        String head = 
            "<head>\n" +
"               <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"               <title>Sistema de Colegio</title>\n" +
"               <link href=\"css/default.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"           </head>";
        return head;
    }
    
    public static String getBack(){
        String back = 
            "<form action=\"index.jsp\">\n" +
"               <input type=\"submit\" value=\"Volver\">\n" +
"           </form>";
        
        return back;
    }
}
