package com.qaworld.lib;

import org.openqa.selenium.WebDriver;

public class AppLib {
	
	
	//base class
	private WebDriver driver;
	private PageLib page;
	private FlowLib flow;

	public AppLib(WebDriver driver) {
		this.driver = driver;
		page = new PageLib(this.driver);
		flow = new FlowLib(this.driver);
	}

	public PageLib pages() {
		return page;
	}

	public FlowLib flow() {
		return flow;
	}
}
