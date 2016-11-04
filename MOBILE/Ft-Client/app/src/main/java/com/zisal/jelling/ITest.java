package com.zisal.jelling;

import java.util.Date;

/**
 * 
 * @author Nongky
 * @since 28 apr 2015
 * 
 * @param <TEST_ID>
 */
public interface ITest<TEST_ID> {

	public void setTestId(TEST_ID _testId);

	public TEST_ID getTestId();

	public void setTestName(String _name);

	public String getTestName();

	public void doTest();
	
	public void setStartTestTime(Date _time);

	public Date getStartTestTime();

	public void setEndTestTime(Date _time);

	public Date getEndTestTime();
}
