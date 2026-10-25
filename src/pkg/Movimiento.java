package pkg;

public class Movimiento {

	private double importe;
	public enum SIGNO {D, H}
	private SIGNO signo;
	private String detalle;
	
	public Movimiento(double importe, String detalle) {
		super();
		this.importe = importe;
		this.detalle = detalle;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public SIGNO getSigno() {
		return signo;
	}
	
	public void setSigno(Movimiento.SIGNO signo) {
		this.signo = signo;
	}
	
	
	
}
