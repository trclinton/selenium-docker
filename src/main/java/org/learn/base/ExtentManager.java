package org.learn.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String baseDir = System.getProperty("user.dir");
            Path dataPath = Paths.get(baseDir, "reports");  // <-- "reports" must be a string literal
            File reportDir = dataPath.toFile();

            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            String reportPath = reportDir.toPath().resolve("ExtentReport.html").toString();
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Selenium Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Gradle + TestNG + Selenium");
            extent.setSystemInfo("Tester", "Reynold");
        }
        return extent;
    }

}
