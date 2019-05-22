package Exception;

public class EspectadorNoExisteException extends Exception {

	public EspectadorNoExisteException(long id) {
		super("No se encontró el espctador con el id: "+id);
	}
}
