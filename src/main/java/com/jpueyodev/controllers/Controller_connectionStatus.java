package com.jpueyodev.controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_connectionStatus {

	private final DataSource datasource;
	
	public Controller_connectionStatus(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@GetMapping("/connectionStatus")
	public String comprobarConexion(Model model) {
		
		boolean ok = false;
		String dbProduct = null;
		String jdbcUrl = null;
		String error = null;
		long started = System.nanoTime();
		
		try(Connection cn = datasource.getConnection()){
			DatabaseMetaData md = cn.getMetaData();
			dbProduct = md.getDatabaseProductName()+" "+md.getDatabaseProductVersion();
			jdbcUrl = md.getURL();
			
			try(PreparedStatement ps = cn.prepareStatement("SELECT 1")){
				ps.execute();
			}
			ok=true;
		}catch(Exception e) {
			error = e.getClass().getSimpleName()+": "+e.getLocalizedMessage();
		}
		
		long elapsedMs = Math.round((System.nanoTime() - started) / 1_000_000.0);
		
		model.addAttribute("ok", ok);
        model.addAttribute("dbProduct", dbProduct);
        model.addAttribute("jdbcUrl", jdbcUrl);
        model.addAttribute("elapsedMs", elapsedMs);
        model.addAttribute("timestamp", LocalDateTime.now());
		return "connectionStatus";
	}
	
}
