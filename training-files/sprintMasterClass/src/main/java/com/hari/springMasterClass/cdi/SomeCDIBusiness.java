package com.hari.springMasterClass.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {

	@Inject
	SomeCDIBusinessDAO someCDIBusinessDAO;

	public SomeCDIBusinessDAO getSomeCDIBusinessDAO() {
		return someCDIBusinessDAO;
	}

	public void setSomeCDIBusinessDAO(SomeCDIBusinessDAO someCDIBusinessDAO) {
		this.someCDIBusinessDAO = someCDIBusinessDAO;
	}

}
