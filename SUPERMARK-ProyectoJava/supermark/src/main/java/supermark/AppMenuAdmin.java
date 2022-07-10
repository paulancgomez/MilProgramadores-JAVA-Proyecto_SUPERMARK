package supermark;

import java.sql.SQLException;

public class AppMenuAdmin {

	public static void main(String[] args) throws SQLException {
		
		Administrador admin = new Administrador("pepe","perez","pepe@gmail.com"); //PEPE es admin
		MenuAdmin menuAdmin = new MenuAdmin(admin);

	}

}
