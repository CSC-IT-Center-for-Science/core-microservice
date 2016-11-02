package eu.crg.ega.microservice.constant;

/*
 * Please remember that theses constant paramnames can be used in a pathvariable and in a
 * requestparam at the same time so all strings must be lowercase
 */
public class ParamName {

  public static final String LOGIN_TYPE = "loginType";

  public static final String PASSWORD = "password";

  public static final String USERNAME = "username";

  public static final String LOGIN_ENDPOINT = "/login";

  //TODO, at this point the servlet name (v1) cannot be retrieved, spring still not loaded
  //TODO remove the final and test like corecontants?
  //TODO If a microservice goes to v2 but login is still v1 this will break things
  //TODO or if a portal talks to another microservice
  //WARN Do not user this for specifying the login point in a call!!
  public static final String LOGIN_FULL_ENDPOINT = "/v1" + LOGIN_ENDPOINT;
  
  public static final String SECONDARY_LOGIN_ENDPOINT = "/users/login";
  public static final String SECONDARY_LOGIN_FULL_ENDPOINT = "/v1" + SECONDARY_LOGIN_ENDPOINT;

  public static final String LOGOUT_ENDPOINT = "/logout";

  //TODO, at this point the servlet name (v1) cannot be retrieved, spring still not loaded
  public static final String LOGOUT_FULL_ENDPOINT = "/v1" + LOGOUT_ENDPOINT;

  public static final String LIMIT = "limit";

  public static final String SKIP = "skip";

  public static final String NOTIFICATION_TYPE = "notificationtype";

  public static final String USER_ID = "userid";

  public static final String STATUS = "status";

  public static final String SESSION_ID = "sessionid";

  public static final String LEVEL = "level";

  public static final String PARAMS = "params";
  
  public static final String SORT = "sort";

  public static final String VALUE = "value";

  public static final String CACHE_TYPE = "cachetype";

  public static final String MESSAGE = "message";

  public static final String TYPE = "type";

  public static final String VERSION = "version";

  public static final String SERVICE_ID = "serviceid";

  public static final String AUTH_PROVIDER_ID = "authproviderid";

  public static final String SOURCE_TYPE = "sourcetype";
  
  public static final String ID_TYPE = "idtype";
  
  // Beacon
  public static final String BEACON_DATASET_IDS = "datasetids";
  public static final String BEACON_ALTERNATE_BASES = "alternatebases";
  public static final String BEACON_REFERENCE_BASES = "referencebases";
  public static final String BEACON_CHROMOSOME = "referencename";
  public static final String BEACON_START = "start";
  public static final String BEACON_REFERENCE_GENOME = "assemblyid";
  public static final String BEACON_INCLUDE_DATASET_RESPONSES = "includedatasetresponses";

  // Authorization
  public static final String RESOURCE_TYPE = "resourcetype";
  public static final String RESOURCE_ID = "resourceid";
  public static final String HTTP_METHOD = "httpmethod";
  
  public static final String SUBMITTER_ID = "submitterid";
  public static final String SUBMITTER_BOX = "submitterbox";
  public static final String SUBMISSION_ID = "submissionid";
  
  // Queries 4 All
  public static final String QUERY_BY = "queryby";
  public static final String QUERY_ID = "queryid";
  
}
