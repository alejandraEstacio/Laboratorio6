package Exception;

public class EspectadorNoExisteException extends Exception {

	public EspectadorNoExisteException(long id) {
		super("No se encontr� el espctador con el id: "+id);
	}
}
