/**
 * 
 */
package app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author SONGCE
 *
 */
public class test {
	public static void main(String[] args) {
		int t = 0;
		String password = "123456";
		System.out.println(password + " -> ");
		for (t = 1 ;t <= 10; t++) {
		      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		     String hashedPassword = passwordEncoder.encode(password);
		      System.out.println(hashedPassword);
		}
	}
}
