package TestLinkIntegration;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class testlinkIntegration {

	public static final String DEVKEY="56197a49ba79f5119b6ba781a1f763e0";
	public static final String URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String testProject="TestLink";
	public static final String testPlan="FirstPlan";
	public static final String build="Version1.0";
	
	public static void reportResult(String Testcase,String expection,String Result) throws TestLinkAPIException {

			TestLinkAPIClient testlink=new TestLinkAPIClient(DEVKEY, URL);
			testlink.reportTestCaseResult(testProject, testPlan, Testcase, build, expection, Result);
	}
	
}

