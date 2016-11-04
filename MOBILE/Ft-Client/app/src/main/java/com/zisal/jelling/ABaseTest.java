package com.zisal.jelling;

import java.util.Date;

/**
 * 
 * @author Nongky
 * @since 28 apr 2015
 * @param <TEST_ID>
 */
public abstract class ABaseTest<TEST_ID> implements ITest<TEST_ID> {

	private TEST_ID m_testId;
	private String m_testName;

	private Date m_startTestTime;
	private Date m_endTestTime;

	@Override
	public void setTestId(TEST_ID _testId) {
		m_testId = _testId;
	}

	@Override
	public TEST_ID getTestId() {
		return m_testId;
	}

	@Override
	public void setTestName(String _name) {
		m_testName = _name;
	}

	@Override
	public String getTestName() {
		return m_testName;
	}

	@Override
	public void setStartTestTime(Date _time) {
		m_startTestTime = _time;
	}

	@Override
	public Date getStartTestTime() {
		return m_startTestTime;
	}

	@Override
	public void setEndTestTime(Date _time) {
		m_endTestTime = _time;

	}

	public Date getEndTestTime() {
		return m_endTestTime;
	};

	protected void beforeTestProcess() {
		setStartTestTime(new Date());
	}

	@Override
	public void doTest() {
		beforeTestProcess();
		testingProcess();
		afterTestProcess();
	}

	protected abstract void testingProcess();

	protected void afterTestProcess() {
		setEndTestTime(new Date());
	}

}
