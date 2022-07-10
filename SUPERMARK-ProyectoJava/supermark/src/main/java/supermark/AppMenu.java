package supermark;

import java.sql.SQLException;

public class AppMenu {

	public static void main(String[] args) throws SQLException {
		
		Cliente cliente = new Cliente(1, 1, "pepe", "perez", "pepe@gmail.com"); 
		
		//PRUEBA MENU CLIENTE
		//MenuCliente menuCliente = new MenuCliente(cliente);
		
		//PRUEBA MENU ADMIN
		MenuAdmin menuAdmin = new MenuAdmin(cliente);

	}

}
