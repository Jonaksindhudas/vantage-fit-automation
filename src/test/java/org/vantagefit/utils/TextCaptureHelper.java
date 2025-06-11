package org.vantagefit.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextCaptureHelper {
    private static final Logger logger = LoggerFactory.getLogger(TextCaptureHelper.class);
    private final AndroidDriver driver;

    public TextCaptureHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     * Captures all visible text from elements on the current screen
     * @return List of captured text strings
     */
    public List<String> getAllVisibleText() {
        List<String> texts = new ArrayList<>();
        try {
            // Find all text elements
            List<WebElement> elements = driver.findElements(By.xpath("//*[@text]"));
            
            // Extract text from each element
            for (WebElement element : elements) {
                String text = element.getText();
                if (text != null && !text.trim().isEmpty()) {
                    texts.add(text.trim());
                }
            }
        } catch (Exception e) {
            logger.error("Error capturing text from UI", e);
        }
        return texts;
    }

    /**
     * Saves captured text to a file
     * @param texts List of text strings to save
     * @param filename Name of the file to save to
     */
    public void saveTextToFile(List<String> texts, String filename) {
        try {
            // Create directory if it doesn't exist
            Files.createDirectories(Paths.get("localization_logs"));
            
            // Write texts to file
            try (FileWriter writer = new FileWriter("localization_logs/" + filename)) {
                for (String text : texts) {
                    writer.write(text + "\n");
                }
            }
        } catch (IOException e) {
            logger.error("Error saving text to file: " + filename, e);
        }
    }

    /**
     * Checks if a string contains ellipsis characters
     * @param text Text to check
     * @return true if text contains ellipsis
     */
    public boolean containsEllipsis(String text) {
        return text != null && (text.contains("...") || text.contains("…"));
    }
} 