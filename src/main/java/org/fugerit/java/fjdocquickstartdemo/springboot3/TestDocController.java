package org.fugerit.java.fjdocquickstartdemo.springboot3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TestDocController {

	private final static Logger logger = LoggerFactory.getLogger( TestDocController.class );

	@GetMapping( value = "/pdftest", produces = MediaType.APPLICATION_PDF_VALUE )
    public ResponseEntity<InputStreamResource> pdftest() {
		try {
	        var headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=pdftest.pdf");
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        FreemarkerDocSample.generateCharacterListPdf( baos );
	        ByteArrayInputStream bis = new ByteArrayInputStream( baos.toByteArray() );
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));			
		} catch (Exception e) {
			logger.error( "Error : "+e, e );
	        return ResponseEntity
	                .status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
    }

}
