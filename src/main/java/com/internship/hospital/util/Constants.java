package com.internship.hospital.util;

public  final  class Constants {

	public static final String NORMAL_LOG_DIR="Normal/";
	public static final String FAILED_CONNEXION_LOG_DIR="Connexion/";
	public static final String ACCESS_DENIED_LOG_DIR="Access/";
	public static final String EXCEPTION_LOG_DIR="Exception/";
    public static final String ROOT_LOOG_DIR="/var/log/hospital/";
    public static final String COOKIE_LANGUAGE_NAME="hospitalLanguage";
    
    public static final int FIRST_YEAR_DEPLOY=2021;
    
    
    /**
     * LES DIFFERENTS ROLES
     */
    
    public static final String ROLE_ADMIN="ROLE_ADMIN";
    public static final String ROLE_MANAGE_USER="ROLE_MANAGE_USER";
    public static final String ROLE_VIEW_USER="ROLE_VIEW_USER";

    public static final String SECURITY_TOKEN="310ec4e6213b134f6c2813bed00192195a756ee0"; // (sha1 notification)
}