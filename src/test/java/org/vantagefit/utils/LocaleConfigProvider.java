package org.vantagefit.utils;

import org.testng.annotations.DataProvider;
import java.util.HashMap;
import java.util.Map;

public class LocaleConfigProvider {
    
    @DataProvider(name = "localizationData")
    public static Object[][] getLocalizationData() {
        return new Object[][] {
            // Language, Country, Language Name
            { "en", "US", "English" },
            { "ar", "SA", "Arabic" },
            { "zh", "CN", "Chinese Simplified" },
            { "nl", "NL", "Dutch" },
            { "fr", "FR", "French" },
            { "fr", "CA", "French Canada" },
            { "de", "DE", "German" },
            { "it", "IT", "Italian" },
            { "ko", "KR", "Korean" },
            { "pt", "PT", "Portuguese" },
            { "ru", "RU", "Russian" },
            { "es", "ES", "Spanish" },
            { "vi", "VN", "Vietnamese" },
            { "in", "ID", "Bahasa Indonesian" },
            { "hu", "HU", "Hungarian" },
            { "hi", "IN", "Hindi" },
            { "id", "ID", "Indonesian" },
            { "ja", "JP", "Japanese" },
            { "pt", "BR", "Portuguese" },
            { "th", "TH", "Thai" },
            { "tr", "TR", "Turkish" }
        };
    }

    /**
     * Returns a map of capabilities for the specified language and country
     */
    public static Map<String, String> getCapabilitiesForLocale(String language, String country) {
        Map<String, String> capabilities = new HashMap<>();
        capabilities.put("language", language);
        capabilities.put("locale", country);
        return capabilities;
    }
} 