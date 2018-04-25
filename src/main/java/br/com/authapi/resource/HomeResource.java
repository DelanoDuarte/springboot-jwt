/**
 * 
 */
package br.com.authapi.resource;

import java.io.Serializable;

import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Delano Jr
 *
 */
@RestController
@RequestMapping(value = "/home")
public class HomeResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> index() {
		String json = "Home Resource";
		return ResponseEntity.ok(json);
	}

}
