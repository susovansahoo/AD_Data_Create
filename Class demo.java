@Parameters({"runReporting"})
@BeforeClass(alwaysRun = true)
public void setup(ITestContext context, String runReporting) {

authenticationApis = new AuthenticationApis(properties.getProperty("BROWSER"));
userDetailsApis = new UserDetailsApis(properties.getProperty("BROWSER"));
taskApis = new TaskApis(properties.getProperty("BROWSER"));
filesApis = new FilesApis(properties.getProperty("BROWSER"));
jiraReporting = new JiraReporting(properties.getProperty("BROWSER"));

authenticationApis.authenticate(properties.getProperty("KEY"), true);
userDetailsApis.getTestSessionDetails();
taskApis.getTimerCurrentValue();


setupDriver();
terminateSessionPage = new TerminateSessionPage();
solutionHistoryDialog = new TestPage.SolutionHistoryDialog();
welcomePage = new WelcomePage();
additionalInfoPage = new AdditionalInfoPage();
startTestDialog = new AdditionalInfoPage.StartTestDialog();
scoreCriteriaModal = new WelcomePage.ScoreCriteriaModal();
baseUtil = new BaseUtil();
javaUtil = new JavaUtil();
userDetailsDTO = new UserDetailsDTO();
sessionDetailsDTO = new SessionDetailsDTO();
testHeader = new TestPage.Header();
browserName = context.getName();
submissionAnswerModal = new TestPage.SubmissionAnswerModal();

className = this.getClass().getSimpleName();

//Hit APIs

terminateSessionPage.terminateTestSessionIfActive();

//JiraReporting
if (runReporting.equals("true")) {
jiraReporting.openFile(className);
}

//Setup
if (baseUtil.isElementDisplayed(welcomePage.welcomePageLoc)) {
baseUtil.click(welcomePage.takeTheTestButton);
baseUtil.waitForInvisibilityOfElement(additionalInfoPage.startTestButton);
baseUtil.click(additionalInfoPage.startTestButton);
}
}