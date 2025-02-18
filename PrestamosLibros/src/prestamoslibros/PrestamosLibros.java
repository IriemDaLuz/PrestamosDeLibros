package prestamoslibros;

public class PrestamosLibros {

    public static int NUMERO_LIBROS = 5;
    public static int NUMERO_ESTUDIANTES = 4;

    public static void main(String[] args) {
    Libro libros[] = new Libro[NUMERO_LIBROS];
    libros[0] = new Libro("1", "La Biblia");
    libros[1] = new Libro("2", "Mates");
    libros[2] = new Libro("3", "Lengua");
    libros[3] = new Libro("4", "Diccionario");
    libros[4] = new Libro("5", "Ciencias");

    Thread estudiantes[] = new Thread[NUMERO_ESTUDIANTES];
    estudiantes[0] = new Thread(new Estudiante("Fer", libros));
    estudiantes[1] = new Thread(new Estudiante("Fabio", libros));
    estudiantes[2] = new Thread(new Estudiante("Simon", libros)); 

    for (Thread estudiante : estudiantes) {
        if (estudiante != null) {
            estudiante.start(); 
        }
    }

    for (Thread estudiante : estudiantes) {
        try {
            if (estudiante != null) {
                estudiante.join(); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println("Todos los estudiantes han terminado de leer al menos 2 libros.");
}

}
