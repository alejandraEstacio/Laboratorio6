package Exception;

public class ParticipanteNoExisteException extends Exception {
	
	public ParticipanteNoExisteException(long id) {
		super("No se encontr� el participante con el id: "+id);
	}

}
