package europcar.project.exceptions;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String message){
        //super é RunTimeException
        //como é que sabe
        super(message);
    }
}
