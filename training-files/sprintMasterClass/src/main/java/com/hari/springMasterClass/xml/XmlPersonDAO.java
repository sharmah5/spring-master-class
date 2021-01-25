package com.hari.springMasterClass.xml;

//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XmlPersonDAO {
	//@Autowired
	XmlJdbcConnection jdbcConnection;

	public XmlJdbcConnection getXmlJdbcConnection() {
		return jdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
}
