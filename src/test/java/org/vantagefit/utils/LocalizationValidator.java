package org.vantagefit.utils;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalizationValidator {
    private static final Logger logger = LoggerFactory.getLogger(LocalizationValidator.class);
    private final LanguageDetector languageDetector;
    private final TextObjectFactory textObjectFactory;

    public LocalizationValidator() {
        try {
            List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
            languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(languageProfiles)
                    .build();
            textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize language detector", e);
        }
    }

    /**
     * Validates text against expected language
     * @param text Text to validate
     * @param expectedLanguage Expected language code (e.g., "en", "fr")
     * @return List of validation issues found
     */
    public List<String> validateText(String text, String expectedLanguage) {
        List<String> issues = new ArrayList<>();
        
        if (text == null || text.trim().isEmpty()) {
            return issues;
        }

        try {
            TextObject textObject = textObjectFactory.forText(text);
            com.google.common.base.Optional<LdLocale> detectedOptional = languageDetector.detect(textObject);
            LdLocale detectedLocale = detectedOptional.isPresent() ? detectedOptional.get() : null;
            
            if (detectedLocale == null) {
                issues.add("Could not detect language for text: " + text);
                return issues;
            }

            String detectedLanguage = detectedLocale.getLanguage();
            if (!detectedLanguage.equalsIgnoreCase(expectedLanguage)) {
                issues.add(String.format("Expected language %s but detected %s for text: %s",
                        expectedLanguage, detectedLanguage, text));
            }

            if (containsEllipsis(text)) {
                issues.add("Text contains ellipsis which may indicate truncation: " + text);
            }
        } catch (Exception e) {
            logger.error("Error validating text: " + text, e);
            issues.add("Error validating text: " + e.getMessage());
        }

        return issues;
    }

    /**
     * Validates a list of texts against expected language
     * @param texts List of texts to validate
     * @param expectedLanguage Expected language code
     * @return List of all validation issues found
     */
    public List<String> validateTexts(List<String> texts, String expectedLanguage) {
        List<String> allIssues = new ArrayList<>();
        
        for (String text : texts) {
            List<String> issues = validateText(text, expectedLanguage);
            allIssues.addAll(issues);
        }
        
        return allIssues;
    }

    private boolean containsEllipsis(String text) {
        return text.contains("...") || text.contains("…");
    }
} 