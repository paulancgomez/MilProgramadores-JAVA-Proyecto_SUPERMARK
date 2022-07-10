package supermark;

import java.sql.SQLException;

public class AppMenu {

	public static void main(String[] args) throws SQLException {
		
		//PRUEBA MENU ADMIN
		//MenuAdmin menuAdmin = new MenuAdmin();
		
		//PRUEBA MENU CLIENTE
		Cliente cliente = new Cliente(1, 1, "pepe", "perez", "pepe@gmail.com"); 
		MenuCliente menuCliente = new MenuCliente(cliente);

	}

}
