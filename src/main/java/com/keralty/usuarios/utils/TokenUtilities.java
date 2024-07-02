package com.keralty.usuarios.utils;

import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TokenUtilities {

	private JsonWebToken jwt;
	
	private static final TokenUtilities _instance = new TokenUtilities();
	
	public static TokenUtilities getInstance() {
		return _instance;
	}
	
	public void setJsonWebToken(JsonWebToken jwt) {
		this.jwt = jwt;
	}

	public static String getToken4ae() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4usuarios() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4configuraciones() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4reportes() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4firmas() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4personas_afiliados_contratantes() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4solicitudes() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4novedades() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}

	public static String getToken4generasolicitud() {
		if (TokenUtilities.getInstance().jwt != null)
			return TokenUtilities.getInstance().jwt.getRawToken();
		return "";
	}
}
