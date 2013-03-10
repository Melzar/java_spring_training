package net.raven.core.rest;

import org.apache.log4j.Logger;

public class Test
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(Test.class);
		logger.error("Error test");
		logger.debug("Debug test");
		logger.info("Info test");
	}

}
