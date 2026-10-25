package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	// void historialmov
	// void añadirmov
	
	private String mNumero;
	private String nTitular;
	private double mSaldo;
	private List<Movimiento> mMovimientos = new ArrayList<>();
	
	public Cuenta(String mNumero, String nTitular, double saldo) {
		super();
		this.mNumero = mNumero;
		this.nTitular = nTitular;
		this.mSaldo = saldo;
	}

	public String getmNumero() {
		return mNumero;
	}

	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}

	public String getnTitular() {
		return nTitular;
	}

	public void setnTitular(String nTitular) {
		this.nTitular = nTitular;
	}

	public double getSaldo() {
		return mSaldo;
	}

	public void setSaldo(double saldo) {
		this.mSaldo = saldo;
	}

	public List<Movimiento> historialMovimientos() {	//	Es el getter de movimientos
		return mMovimientos;
	}

	public void setmMovimientos(List<Movimiento> mMovimientos) {
		this.mMovimientos = mMovimientos;
	}
	
	public void añadirMovimiento(double importe, Movimiento.SIGNO signo, String detalle) {
		Movimiento m = new Movimiento(importe, detalle);
		m.setSigno(signo);
		mMovimientos.add(m);
	}
	
	public void ingresar(double x) {
		mSaldo += x;
		añadirMovimiento(x, Movimiento.SIGNO.H, "Ingreso");
	}
	
	public void retirar(double x) {
		mSaldo -= x;
		añadirMovimiento(x, Movimiento.SIGNO.D, "Reintegro");
	}

	
}
