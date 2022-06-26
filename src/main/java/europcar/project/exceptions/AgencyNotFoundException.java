package europcar.project.exceptions;

public class AgencyNotFoundException extends RuntimeException {
    public AgencyNotFoundException(String message) {
        super(message);
        //A RuntimeException recebe uma mensagem no construtor para a mostrar na consola/FE quando a Exception é lançada
    }
}
