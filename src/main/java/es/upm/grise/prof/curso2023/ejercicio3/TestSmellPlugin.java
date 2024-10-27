package es.upm.grise.prof.curso2023.ejercicio3;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

@Mojo(name = "detect-test-smells", defaultPhase = LifecyclePhase.TEST)
public class TestSmellPlugin extends AbstractMojo {

    @Parameter(property = "appName", required = true)
    private String appName;

    @Parameter(property = "pathToTestFile", required = true)
    private String pathToTestFile;

    @Parameter(property = "pathToProductionFile", required = true)
    private String pathToProductionFile;

    @Parameter(defaultValue = "${project.basedir}")
    private String projectDir;

    public void execute() throws MojoExecutionException {
        // Build the path to the TestSmellDetector.jar
        String jarPath = new File(projectDir, "path/to/TestSmellDetector.jar").getAbsolutePath();

        // Build the command with parameters
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, appName, pathToTestFile, pathToProductionFile);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                getLog().info(line);
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new MojoExecutionException("tsDetect exited with error code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            throw new MojoExecutionException("Error executing tsDetect", e);
        }
    }
}
