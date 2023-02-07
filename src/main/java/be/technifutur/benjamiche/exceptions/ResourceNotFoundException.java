package be.technifutur.benjamiche.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("the requested resource was not found");
    }

    public ResourceNotFoundException(Throwable cause){
        super("the requested resource was not found", cause);
    }

    public ResourceNotFoundException(long id){
        super("the requested resource was not found "+ id);
    }



}
