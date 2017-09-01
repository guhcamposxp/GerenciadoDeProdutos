package br.senac.tads.gerenciador.ServiceUtils;

import br.senac.tads.gerenciador.utils.ConnectionUtils;
import java.sql.Connection;

public class ServiceUtils {
    public static boolean checkConnection() {
        boolean validConnection = false;
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            if (connection != null && connection.isValid(1000)) {
                validConnection = true;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return validConnection;
    }
}
