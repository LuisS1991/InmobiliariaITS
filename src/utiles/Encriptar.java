package utiles;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;



public class Encriptar {

	private  PasswordEncryptor encryptor;
    
    
	public Encriptar() {
		encryptor = new BasicPasswordEncryptor();
	}

	public  void EncriptarPass(String pass) {
		 
   
        String encryptedPassword = this.encryptor.encryptPassword(pass);
        System.out.println("Password encriptado"+ "("+pass+") : " + encryptedPassword );
	}

	public  void VerificarPass(String userPass,String encryptedPassword) {
		
        if (this.encryptor.checkPassword(userPass, encryptedPassword )) {
            System.out.println("Bienvenido!!!");
        } else {
            System.out.println("Acceso Denegado!!!");
        }
	}

}
